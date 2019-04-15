package cr.ac.ucenfotec.bl.ajedrez;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.PiezaFactory;
import cr.ac.ucenfotec.bl.piezas.TipoPieza;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.piezas.IPieza;

public class TableroAjedrez implements ITablero {
    Casilla[][] casillas;
    private ArrayList<IPieza> piezas;
	
	public TableroAjedrez() {
	    this.casillas = new Casilla[8][8];
	    this.piezas = new ArrayList<IPieza>();

        iniciarCasillas();
        iniciarTablero();
	}

    public TableroAjedrez(ArrayList<IPieza> piezas) {
        this.casillas = new Casilla[8][8];
        this.piezas = piezas;

        iniciarCasillas();
        cargarTablero();
    }


	private void iniciarTablero(){
	    //Fichas Blancas
        for(int x = 0; x < casillas.length; x++){
            casillas[x][1].setPieza(PiezaFactory.getPieza(TipoPieza.PEON, x, 1, ColorPieza.BLANCO));
        }

        casillas[0][0].setPieza(PiezaFactory.getPieza(TipoPieza.TORRE, 0, 0, ColorPieza.BLANCO));
        casillas[7][0].setPieza(PiezaFactory.getPieza(TipoPieza.TORRE, 7, 0, ColorPieza.BLANCO));

        casillas[1][0].setPieza(PiezaFactory.getPieza(TipoPieza.CABALLO, 1, 0, ColorPieza.BLANCO));
        casillas[6][0].setPieza(PiezaFactory.getPieza(TipoPieza.CABALLO, 6, 0, ColorPieza.BLANCO));

        casillas[2][0].setPieza(PiezaFactory.getPieza(TipoPieza.ALFIL, 2, 0, ColorPieza.BLANCO));
        casillas[5][0].setPieza(PiezaFactory.getPieza(TipoPieza.ALFIL, 5, 0, ColorPieza.BLANCO));

        casillas[3][0].setPieza(PiezaFactory.getPieza(TipoPieza.REINA, 3, 0, ColorPieza.BLANCO));
        casillas[4][0].setPieza(PiezaFactory.getPieza(TipoPieza.REY, 4, 0, ColorPieza.BLANCO));

        //Fichas Negras

        for(int x = 0; x < casillas.length; x++){
            casillas[x][6].setPieza(PiezaFactory.getPieza(TipoPieza.PEON, x, 1, ColorPieza.NEGRO));
        }
        casillas[0][7].setPieza(PiezaFactory.getPieza(TipoPieza.TORRE, 0, 0, ColorPieza.NEGRO));
        casillas[7][7].setPieza(PiezaFactory.getPieza(TipoPieza.TORRE, 7, 0, ColorPieza.NEGRO));

        casillas[1][7].setPieza(PiezaFactory.getPieza(TipoPieza.CABALLO, 1, 0, ColorPieza.NEGRO));
        casillas[6][7].setPieza(PiezaFactory.getPieza(TipoPieza.CABALLO, 6, 0, ColorPieza.NEGRO));

        casillas[2][7].setPieza(PiezaFactory.getPieza(TipoPieza.ALFIL, 2, 0, ColorPieza.NEGRO));
        casillas[5][7].setPieza(PiezaFactory.getPieza(TipoPieza.ALFIL, 5, 0, ColorPieza.NEGRO));

        casillas[3][7].setPieza(PiezaFactory.getPieza(TipoPieza.REINA, 3, 0, ColorPieza.NEGRO));
        casillas[4][7].setPieza(PiezaFactory.getPieza(TipoPieza.REY, 4, 0, ColorPieza.NEGRO));
    }

    public void cargarTablero(){
	    if(!this.piezas.isEmpty()) {
            for (IPieza pieza:this.piezas) {
                casillas[pieza.getPosX()][pieza.getPosY()].setPieza(pieza);
            }
        }
    }

    private void iniciarCasillas() {
        for(int i = 0; i < casillas.length; i++){
            for(int j = 0; j < casillas.length; j++){
                casillas[i][j] = new Casilla();
            }
        }
    }

	@Override
	public boolean moverPieza(IPieza pieza, int x, int y) {
		return false;
	}

	@Override
	public String toString() {
	    String salida = "";
        for(int i = 0; i < casillas.length; i++){
            salida += "\n---+---+---+---+---+---+---+---+---+\n";
            for(int j = 0; j < casillas.length; j++){
                IPieza tmp = casillas[j][i].getPieza();
                String p = (casillas[j][i].getPieza() == null) ? "   " : (tmp.isColor()) ? " " + tmp.getSimbolo() + " " : "*" + tmp.getSimbolo() + "*";
                salida += (j == 0) ? " " + i + " |" + p + "|": "" + p +"|";
            }
        }
        salida += "\n---+---+---+---+---+---+---+---+---+";
        salida += "\n   | a | b | c | d | e | f | g | h";

        return salida;
	}

	public static class Builder {
        private ArrayList<IPieza> piezas = new ArrayList<IPieza>();

        public Builder(){

        }

        public Builder withPiece(IPieza nuevaPieza){
            piezas.add(nuevaPieza);

            return this;
        }

        public TableroAjedrez build(){
            TableroAjedrez ajedrez = new TableroAjedrez(piezas);

            return ajedrez;
        }
    }
}
