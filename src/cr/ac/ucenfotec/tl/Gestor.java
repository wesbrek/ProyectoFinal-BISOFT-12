package cr.ac.ucenfotec.tl;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.Jugador;
import cr.ac.ucenfotec.bl.Jugador.JugadorBuilder;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.tablero.PosicionTablero;
import cr.ac.ucenfotec.bl.tablero.TableroFactory;
import cr.ac.ucenfotec.bl.tablero.TipoJuego;
import cr.ac.ucenfotec.state.State;
import cr.ac.ucenfotec.state.TurnPlayerOne;

public class Gestor {
	static Cliente micliente = new Cliente();

	
	public void addPlayers(String name1, String pass1, String name2, String pass2) {
		ArrayList<Jugador> mijugadores = new ArrayList<Jugador>();
		Jugador j1;
		Jugador j2;
		JugadorBuilder builder1 = new JugadorBuilder();
		builder1.name(name1).password(pass1).turn(true);
		JugadorBuilder builder2 = new JugadorBuilder();
		builder2.name(name2).password(pass2).turn(false);
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
		command.trim();
		String xInicial = String.valueOf(command.charAt(0));
		int yInicial = Integer.parseInt(String.valueOf(command.charAt(1))) - 1;
        String xFinal = String.valueOf(command.charAt(2));
        int yFinal = Integer.parseInt(String.valueOf(command.charAt(3))) - 1;

        return micliente.moverPieza(toEnum(xInicial).intValueOf(), yInicial, toEnum(xFinal).intValueOf(), yFinal, micliente);
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
}
