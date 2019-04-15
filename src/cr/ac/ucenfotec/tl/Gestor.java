package cr.ac.ucenfotec.tl;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.Jugador;
import cr.ac.ucenfotec.bl.Jugador.JugadorBuilder;

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
		Jugador j1;
		Jugador j2;
		JugadorBuilder builder1 = new JugadorBuilder();
		builder1.name(name1).password(pass1);
		JugadorBuilder builder2 = new JugadorBuilder();
		builder2.name(name2).password(pass2);
		j1 = builder1.build();
		j2 = builder2.build();
		mijugadores.add(j1);
		mijugadores.add(j2);
		
		
	}
}
