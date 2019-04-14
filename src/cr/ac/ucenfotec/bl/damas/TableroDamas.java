package cr.ac.ucenfotec.bl.damas;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.piezas.IPieza;

public class TableroDamas implements ITablero {
    Casilla[][] casillas;
	
	public TableroDamas() {
        this.casillas = new Casilla[8][8];
		//Agregar cada pieza a su array respectivo.
	}

	@Override
	public boolean moverPieza(IPieza pieza, int x, int y) {
		return false;
	}

	@Override
	public String toString() {
		return "TableroDamas{}";
	}
}
