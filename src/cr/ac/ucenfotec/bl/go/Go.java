package cr.ac.ucenfotec.bl.go;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.Pieza;
import cr.ac.ucenfotec.bl.Tablero;

public class Go extends Tablero{
	
	private ArrayList<Pieza> black;
	private ArrayList<Pieza> white;
	
	public Go() {
		super(19);
		black = new ArrayList<Pieza>();
		white = new ArrayList<Pieza>();
		
		//Agregar cada pieza a su array respectivo.
	}
}
