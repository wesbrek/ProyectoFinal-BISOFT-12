package cr.ac.ucenfotec.bl.damas;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.PiezaFactory;
import cr.ac.ucenfotec.bl.piezas.TipoPieza;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.piezas.IPieza;
import cr.ac.ucenfotec.bl.tablero.PosicionTablero;
import cr.ac.ucenfotec.state.State;

import java.util.ArrayList;

public class TableroDamas implements ITablero {
    Casilla[][] casillas;
    private ArrayList<IPieza> piezas;
	
	public TableroDamas() {
        this.casillas = new Casilla[10][10];
		this.piezas = new ArrayList<IPieza>();

        iniciarCasillas();
        iniciarTablero();
	}

    public TableroDamas(ArrayList<IPieza> piezas) {
	    this.casillas = new Casilla[10][10];
        this.piezas = piezas;

        iniciarCasillas();
        cargarTablero();
    }

    private void cargarTablero() {
        if(!this.piezas.isEmpty()) {
            for (IPieza pieza:this.piezas) {
                casillas[pieza.getPosX()][pieza.getPosY()].setPieza(pieza);
            }
        }
    }

    private void iniciarTablero() {
	    //Fichas Blancas
        for(int x = 0; x < casillas.length; x++){
            if(x%2 == 0) {
                casillas[x][0].setPieza(PiezaFactory.getPieza(TipoPieza.DAMA, x, 0, ColorPieza.BLANCO));
                casillas[x][2].setPieza(PiezaFactory.getPieza(TipoPieza.DAMA, x, 2, ColorPieza.BLANCO));
            }
        }
        for(int x = 0; x < casillas.length; x++){
            if(x%2 == 1) {
                casillas[x][1].setPieza(PiezaFactory.getPieza(TipoPieza.DAMA, x, 1, ColorPieza.BLANCO));
                casillas[x][3].setPieza(PiezaFactory.getPieza(TipoPieza.DAMA, x, 3, ColorPieza.BLANCO));
            }
        }

        //Fichas Negras
        for(int x = 0; x < casillas.length; x++){
            if(x%2 == 0) {
                casillas[x][6].setPieza(PiezaFactory.getPieza(TipoPieza.DAMA, x, 6, ColorPieza.NEGRO));
                casillas[x][8].setPieza(PiezaFactory.getPieza(TipoPieza.DAMA, x, 8, ColorPieza.NEGRO));
            }
        }
        for(int x = 0; x < casillas.length; x++){
            if(x%2 == 1) {
                casillas[x][7].setPieza(PiezaFactory.getPieza(TipoPieza.DAMA, x, 7, ColorPieza.NEGRO));
                casillas[x][9].setPieza(PiezaFactory.getPieza(TipoPieza.DAMA, x, 9, ColorPieza.NEGRO));
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
    public boolean moverPieza(int x, int y, int xFinal, int yFinal, Cliente micliente) {
        if (getPieza(x, y).validarMovimiento(x, y, xFinal, yFinal, micliente)) {

             boolean valPieza = validarPieza(xFinal,yFinal);

            if(valPieza == false){
                IPieza temp = casillas[x][y].getPieza();
                casillas[x][y] = new Casilla();
                casillas[xFinal][yFinal].setPieza(temp);
                return true;
            }
        }
        return false;
    }


    public boolean validarPieza(int xFinal, int yFinal) {
        if(getPieza(xFinal, yFinal) != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public IPieza getPieza(int x, int y) {
        return casillas[x][y].getPieza();
    }

    @Override
	public String toString() {
        String salida = "";
        for(int i = casillas.length-1; i >= 0; i--){
            salida += "\n---+---+---+---+---+---+---+---+---+---+---+\n";
            for(int j = 0; j < casillas.length; j++){
                IPieza tmp = casillas[j][i].getPieza();
                String p = (casillas[j][i].getPieza() == null) ? "   " : (tmp.isColor()) ? "*" + tmp.getSimbolo() + "*" : " " + tmp.getSimbolo() + " ";
                salida += (j == 0) ? " " + (i+1) + " |" + p + "|": "" + p +"|";
            }
        }
        salida += "\n---+---+---+---+---+---+---+---+---+---+---+";
        salida += "\n   | a | b | c | d | e | f | g | h | i | j |";

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

        public TableroDamas build(){
            TableroDamas damas = new TableroDamas(piezas);

            return damas;
        }
    }
}
