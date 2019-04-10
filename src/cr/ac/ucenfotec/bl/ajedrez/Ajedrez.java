package cr.ac.ucenfotec.bl.ajedrez;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.Pieza;
import cr.ac.ucenfotec.bl.Tablero;

public class Ajedrez extends Tablero{
	
	private ArrayList<Pieza> black;
	private ArrayList<Pieza> white;
	
	public Ajedrez() {
		super(8);
		black = new ArrayList<Pieza>(16);
		white = new ArrayList<Pieza>(16);
		
		//Agregar cada pieza a su array respectivo.
	}
}
