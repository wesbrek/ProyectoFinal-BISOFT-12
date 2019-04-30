package cr.ac.ucenfotec.tl;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.Jugador;
import cr.ac.ucenfotec.bl.Jugador.JugadorBuilder;
import cr.ac.ucenfotec.bl.Movimiento;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.tablero.PosicionTablero;
import cr.ac.ucenfotec.bl.tablero.TableroFactory;
import cr.ac.ucenfotec.bl.tablero.TipoJuego;
import cr.ac.ucenfotec.dl.TextFileStorage;

public class Gestor {
	static Cliente micliente = Cliente.getInstance();
	
	public void addPlayers(String name1, String pass1, String name2, String pass2) {
		ArrayList<Jugador> mijugadores = new ArrayList<Jugador>();
		Jugador j1;
		Jugador j2;
		JugadorBuilder builder1 = new JugadorBuilder();
		builder1.withName(name1)
                .withPassword(pass1)
                .withTurn(true);
		JugadorBuilder builder2 = new JugadorBuilder();
		builder2.withName(name2)
                .withPassword(pass2)
                .withTurn(false);
		j1 = builder1.build();
		j2 = builder2.build();
		mijugadores.add(j1);
		mijugadores.add(j2);
		micliente.setJugadores(mijugadores);
	}

	public boolean validarJugador(String pass){
		return micliente.validarJugador(pass);
	}

	public void crearTablero(TipoJuego tipoJuego){
	    micliente.iniciarPartida(tipoJuego);
    }

	public ITablero getTablero(TipoJuego juego){
		ITablero tablero = TableroFactory.getTablero(juego);
		return tablero;
	}

	public boolean moverPieza(String command){
		command.replaceAll("\\s+","");
		String xInicial = "";
		String  xFinal = "";
		int yInicial = 0;
		int yFinal = 0;
		String total = "";
		boolean isNumeric1 = isNumeric(command.charAt(2));
		boolean isNumeric2 = isNumeric(command.charAt(3));
		if(command.length() == 4){
			 xInicial = String.valueOf(command.charAt(0));
			 yInicial = Integer.parseInt(String.valueOf(command.charAt(1))) - 1;
			 xFinal = String.valueOf(command.charAt(2));
			 yFinal = Integer.parseInt(String.valueOf(command.charAt(3))) - 1;
		}else if(command.length() == 5){
			xInicial = String.valueOf(command.charAt(0));
			 if(isNumeric1 == true){
			 	total = String.valueOf(command.charAt(1)) + String.valueOf(command.charAt(2));
				 xFinal = String.valueOf(command.charAt(3));
				 yInicial = Integer.parseInt(total) - 1;
				 yFinal = Integer.parseInt(String.valueOf(command.charAt(4))) - 1;
			 }else if(isNumeric2 == true){
			 	total = String.valueOf(command.charAt(3)) + String.valueOf(command.charAt(4));
				 yInicial = Integer.parseInt(String.valueOf(command.charAt(1))) - 1;
				 xFinal = String.valueOf(command.charAt(2));
				 yFinal = Integer.parseInt(total) - 1;
			 }
		}else if(command.length() == 6){
			 xInicial = String.valueOf(command.charAt(0));
			 yInicial = Integer.parseInt(String.valueOf(command.charAt(1))) + Integer.parseInt(String.valueOf(command.charAt(2))) - 1;
			 xFinal = String.valueOf(command.charAt(3));
			 yFinal = Integer.parseInt(String.valueOf(command.charAt(4))) + Integer.parseInt(String.valueOf(command.charAt(5))) - 1;
		}


        return micliente.moverPieza(toEnum(xInicial).intValueOf(), yInicial, toEnum(xFinal).intValueOf(), yFinal, micliente);
	}

	private boolean isNumeric(char command){
		boolean resultado;

		try {
			Integer.parseInt(String.valueOf(command));
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

	private PosicionTablero toEnum(String pos){
	    return PosicionTablero.valueOf(pos);
    }

    public String imprimirTablero(){
	    return micliente.imprimirTablero();
    }

	public String nextTurn(){
		return micliente.nextTurn();
	}

	public void restartState(){
		micliente.setState(micliente.getPlayerTwoState());
	}

	public void saveGame(){
        TextFileStorage tfe = new TextFileStorage();
        switch (micliente.getTipoJuego()){
            case AJEDREZ:
                tfe.saveAjedrez(micliente.serializeMovements());
                break;
            case GO:
                tfe.saveGo(micliente.serializeMovements());
                break;
            case DAMAS:
                tfe.saveDamas(micliente.serializeMovements());
                break;
        }
    }

    public String loadGame(TipoJuego tipo){
	    String output = "";

	    crearTablero(tipo);
	    output += imprimirTablero() + '\n';

        int contadorTurnos = 1;

        TextFileStorage tfe = new TextFileStorage();
        String partida = "";

        switch (tipo){
            case AJEDREZ:
                partida = tfe.loadAjedrez();
                break;
            case GO:
                partida = tfe.loadGo();
                break;
            case DAMAS:
                partida = tfe.loadDamas();
                break;
        }

        ArrayList<Movimiento> movimientos = micliente.loadGame(tipo, partida);

        for (Movimiento e : movimientos) {
            nextTurn();
            moverPieza(e.toString());
            if(contadorTurnos % 2 != 0)
                output += "Jugador blanco: " + e;
            else
                output += "Jugador negro: " + e;
            contadorTurnos++;
            output += imprimirTablero() + '\n';
        }

        return output;
    }

    public String checkWinner(){
		int winner = micliente.getTablero().checkWinner();
        String winnerName = "";

        if (winner == 1) {
            winnerName = micliente.getJugadores().get(0).getName();
        } else if (winner == 2) {
            winnerName = micliente.getJugadores().get(1).getName();
        }

		return winnerName;
	}

}
