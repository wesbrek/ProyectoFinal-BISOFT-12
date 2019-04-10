package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

public class Cliente {
	private Tablero juego;
	private ArrayList<Jugador> jugadores;
	
	public Cliente() {
		jugadores = new ArrayList<Jugador>();
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
}
