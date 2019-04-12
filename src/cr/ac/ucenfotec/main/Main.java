package cr.ac.ucenfotec.main;

import cr.ac.ucenfotec.tl.Gestor;

public class Main {
	static Gestor controller = new Gestor();
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.println(controller.nextTurn());
		}
	
	}

}
