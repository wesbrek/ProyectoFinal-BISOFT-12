package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

import cr.ac.ucenfotec.state.State;
import cr.ac.ucenfotec.state.TurnPlayerOne;
import cr.ac.ucenfotec.state.TurnPlayerTwo;

public class Cliente {
	private Tablero juego;
	private ArrayList<Jugador> jugadores;
	private State playerOneState;
	private State playerTwoState;
	
	private State activePlayer = new TurnPlayerOne(this);
	
	public Cliente() {
		jugadores = new ArrayList<Jugador>();
		playerOneState = new TurnPlayerOne(this);
		playerTwoState = new TurnPlayerTwo(this);
	}

	public void iniciarPartida(String tipoJuego) {
		//Validar el tipo de juego.
		
		//Si tipo Juego == "Ajedrez", crear un tablero de tipo Ajedrez.
		//Si tipo Juego == "Damas", crear un tablero de tipo Damas.
		//Si tipo Go == "Go", crear un tablero de tipo Go.
	}
	
	public void registrarJugador(String name, String password) {
		//Validar que el jugador no exista
		Jugador tmpJugador = new Jugador(name, password);
		jugadores.add(tmpJugador);
	}
	
	public boolean autenticarJugador(String name) {
		for(Jugador x : jugadores) {
			if(x.getName() == name)
				return true;
		}
		return false;
	}
	
	public void nextTurn() {
		activePlayer.nextTurn();
	}
	
	public State getPlayerOneState() {
		return playerOneState;
	}
	
	public State getPlayerTwoState() {
		return playerTwoState;
	}
	
	public void setState(State _state) {
		this.activePlayer = _state;
	}
	
	public State getState() {
		return this.activePlayer;
	}
}
