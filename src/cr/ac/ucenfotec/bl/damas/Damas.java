package cr.ac.ucenfotec.bl.damas;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.Pieza;
import cr.ac.ucenfotec.bl.Tablero;

public class Damas extends Tablero{
	
	private ArrayList<Pieza> black;
	private ArrayList<Pieza> white;
	
	public Damas() {
		super(8);
		black = new ArrayList<Pieza>(16);
		white = new ArrayList<Pieza>(16);
		
		//Agregar cada pieza a su array respectivo.
	}
}
