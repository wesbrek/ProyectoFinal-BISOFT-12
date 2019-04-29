package cr.ac.ucenfotec.bl.go;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.Movimiento;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.piezas.IPieza;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;

public class TableroGo implements ITablero {
    Casilla[][] casillas;
    private ArrayList<IPieza> piezas;
	
	public TableroGo() {
        this.casillas = new Casilla[19][19];
        this.piezas = new ArrayList<IPieza>();

        iniciarCasillas();
	}

    public TableroGo(ArrayList<IPieza> piezas) {
        this.casillas = new Casilla[19][19];
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

    private void iniciarCasillas() {
        for(int i = 0; i < casillas.length; i++){
            for(int j = 0; j < casillas.length; j++){
                casillas[i][j] = new Casilla();
            }
        }
    }

    public void validarUnidades() {

    }

    @Override
	public boolean moverPieza(int x, int y, int xFinal, int yFinal, Cliente cliente) {
		return false;
	}

    @Override
    public boolean validarPieza(int x, int y, int xFinal, int yFinal) {
        return false;
    }

    @Override
    public IPieza getPieza(int x, int y) {
        return null;
    }

    @Override
    public ArrayList<Movimiento> getMovimientos() {
        return null;
    }

    @Override
	public String toString() {
        String salida = "";
        for(int i = casillas.length-1; i >= 0; i--){
            salida += "\n   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   \n";
            for(int j = 0; j < casillas.length; j++){
                IPieza tmp = casillas[j][i].getPieza();
                String p = (casillas[j][i].getPieza() == null) ? "*" : (tmp.isColor()) ? tmp.getSimbolo() : tmp.getSimbolo();
                //salida += (j == 0) ? "  " + /*(i+1) +*/ " |" + p + "|": "" + p +"|";
                salida += (j == 0) ? "A--" + p + "---": p + "---";
            }
        }
        salida += "\n   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   ";
        salida += "\n   a   b   c   d   e   f   g   h   i   j   k   l   m   n   o   p   q   r   s   ";

        return salida;
	}

    @Override
    public int checkWinner() {
        return 0;
    }

    public static class Builder {
        private ArrayList<IPieza> piezas = new ArrayList<IPieza>();

        public Builder(){

        }

        public Builder withPiece(IPieza nuevaPieza){
            piezas.add(nuevaPieza);

            return this;
        }

        public TableroGo build(){
            TableroGo go = new TableroGo(piezas);

            return go;
        }
    }
}
