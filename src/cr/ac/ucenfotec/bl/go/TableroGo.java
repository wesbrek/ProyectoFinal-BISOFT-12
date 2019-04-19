package cr.ac.ucenfotec.bl.go;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.piezas.IPieza;
import cr.ac.ucenfotec.bl.tablero.PosicionTablero;

public class TableroGo implements ITablero {
    Casilla[][] casillas;
	
	public TableroGo() {
        this.casillas = new Casilla[19][19];
		//Agregar cada pieza a su array respectivo.
	}

	@Override
	public boolean moverPieza(int x, int y, int xFinal, int yFinal) {
		return false;
	}

	@Override
    public IPieza getPieza(int x, int y) {
        return null;
    }

    @Override
	public String toString() {
		return "TableroGo{}";
	}
}
