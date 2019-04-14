package cr.ac.ucenfotec.bl.go;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.piezas.IPieza;

public class TableroGo implements ITablero {
    Casilla[][] casillas;
	
	public TableroGo() {
        this.casillas = new Casilla[19][19];
		//Agregar cada pieza a su array respectivo.
	}

	@Override
	public boolean moverPieza(IPieza pieza, int x, int y) {
		return false;
	}

	@Override
	public String toString() {
		return "TableroGo{}";
	}
}
