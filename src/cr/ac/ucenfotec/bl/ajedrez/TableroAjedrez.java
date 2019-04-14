package cr.ac.ucenfotec.bl.ajedrez;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.tablero.ITablero;import cr.ac.ucenfotec.bl.piezas.IPieza;

public class TableroAjedrez implements ITablero {
    Casilla[][] casillas;
    private ArrayList<IPieza> piezas;
	
	public TableroAjedrez() {
	    this.casillas = new Casilla[8][8];
	    this.piezas = new ArrayList<IPieza>();
		
		//Agregar cada pieza a su array respectivo.
	}

	@Override
	public boolean moverPieza(IPieza pieza, int x, int y) {
		return false;
	}

	@Override
	public String toString() {
		return "TableroAjedrez{}" + this.piezas.toString();
	}

	/*public static class Builder {
        private ArrayList<IPieza> piezas = new ArrayList<IPieza>();

        public Builder(){

        }

        public Builder withPiece(IPieza nuevaPieza){
            piezas.add(nuevaPieza);

            return this;
        }

        public TableroAjedrez build(){
            TableroAjedrez ajedrez = new TableroAjedrez();
            ajedrez.piezas = this.piezas;

            return ajedrez;
        }
    }*/
}
