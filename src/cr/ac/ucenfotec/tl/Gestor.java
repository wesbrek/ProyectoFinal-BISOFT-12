package cr.ac.ucenfotec.tl;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.Jugador;
import cr.ac.ucenfotec.bl.Jugador.JugadorBuilder;
import cr.ac.ucenfotec.bl.tablero.ITablero;
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
		ArrayList <Jugador> jugadores = micliente.getJugadores();
		for(int i = 0; i < jugadores.size(); i++){
			if(jugadores.get(i).getPassword().equals(pass)) {
				return true;
			}
		}

		return false;
	}

	public ITablero getTablero(TipoJuego juego){
		ITablero tablero = TableroFactory.getTablero(juego);
		return tablero;
	}

	public String nextTurn(){
		ArrayList <Jugador> jugadores = micliente.getJugadores();
		micliente.nextTurn();
		if(micliente.getState() == micliente.getPlayerOneState()){
			return jugadores.get(0).getName();
		}else if(micliente.getState() == micliente.getPlayerTwoState()){
			return jugadores.get(1).getName();
		}

		return "";

	}

	public void restartState(){
		micliente.setState(micliente.getPlayerTwoState());
	}
}
