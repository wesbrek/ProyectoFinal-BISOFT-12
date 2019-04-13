package cr.ac.ucenfotec.main;

import cr.ac.ucenfotec.tl.Gestor;

public class Main {
	static Gestor controller = new Gestor();
	
	public static void main(String[] args) {
		controller.addPlayers("Sergio", "12345678", "Valeria", "123456789");
		for(int i = 0; i < 2; i++) {
			System.out.println(controller.nextTurn());
		}
	
	}

}
