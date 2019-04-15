package cr.ac.ucenfotec.main;

import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.tablero.TableroFactory;
import cr.ac.ucenfotec.bl.tablero.TipoJuego;
import cr.ac.ucenfotec.tl.Gestor;

public class Main {
	static Gestor controller = new Gestor();
	
	public static void main(String[] args) {
		ITablero tablero = TableroFactory.getTablero(TipoJuego.AJEDREZ);
        System.out.println(tablero.toString());
	}

}
