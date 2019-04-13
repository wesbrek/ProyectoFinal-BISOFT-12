package cr.ac.ucenfotec.tl;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.Jugador;

public class Gestor {
	static Cliente micliente = new Cliente();
	static ArrayList<Jugador> mijugadores = new ArrayList<Jugador>();
	
	public String nextTurn() {
		micliente.setJugadores(mijugadores);
		micliente.nextTurn();
		
		System.out.println(mijugadores.get(0).getTurn());
		System.out.println(mijugadores.get(1).getTurn());
		
		if(micliente.getState() == micliente.getPlayerOneState()) {
			return "Player one turn";
		}else if(micliente.getState() == micliente.getPlayerTwoState()) {
			return "Player two turn";
		}
		
		return "estoy mamando";
	}
	
	public void addPlayers(String name1, String pass1, String name2, String pass2) {
		Jugador j1 = new Jugador(name1, pass1);
		Jugador j2 = new Jugador(name2, pass2);
		
		mijugadores.add(j1);
		mijugadores.add(j2);
		
		
	}
}
