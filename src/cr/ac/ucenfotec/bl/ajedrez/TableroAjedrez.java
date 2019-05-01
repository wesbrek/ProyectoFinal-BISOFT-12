package cr.ac.ucenfotec.bl.ajedrez;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.Movimiento;
import cr.ac.ucenfotec.bl.methodTemplate.PieceMovementComponent;
import cr.ac.ucenfotec.bl.methodTemplate.PieceMovementFactory;
import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.PiezaFactory;
import cr.ac.ucenfotec.bl.piezas.TipoPieza;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.piezas.IPieza;
import cr.ac.ucenfotec.bl.tablero.PosicionTablero;

import static cr.ac.ucenfotec.bl.piezas.TipoPieza.PEON;

public class TableroAjedrez implements ITablero {
    Casilla[][] casillas;
    private ArrayList<IPieza> piezas;
    private Queue<Movimiento> movimientos;
	
	public TableroAjedrez() {
	    this.casillas = new Casilla[8][8];
	    this.piezas = new ArrayList<IPieza>();
        this.movimientos = new ArrayDeque<Movimiento>();

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
            casillas[x][1].setPieza(PiezaFactory.getPieza(PEON, x, 1, ColorPieza.BLANCO));
        }

        casillas[0][0].setPieza(PiezaFactory.getPieza(TipoPieza.TORRE, 0, 0, ColorPieza.BLANCO));
        casillas[7][0].setPieza(PiezaFactory.getPieza(TipoPieza.TORRE, 7, 0, ColorPieza.BLANCO));

        casillas[1][0].setPieza(PiezaFactory.getPieza(TipoPieza.CABALLO, 1, 0, ColorPieza.BLANCO));
        casillas[6][0].setPieza(PiezaFactory.getPieza(TipoPieza.CABALLO, 6, 0, ColorPieza.BLANCO));

        casillas[2][0].setPieza(PiezaFactory.getPieza(TipoPieza.ALFIL, 2, 0, ColorPieza.BLANCO));
        casillas[5][0].setPieza(PiezaFactory.getPieza(TipoPieza.ALFIL, 5, 0, ColorPieza.BLANCO));

        casillas[4][0].setPieza(PiezaFactory.getPieza(TipoPieza.REINA, 4, 0, ColorPieza.BLANCO));
        casillas[3][0].setPieza(PiezaFactory.getPieza(TipoPieza.REY, 3, 0, ColorPieza.BLANCO));

        //Fichas Negras

        for(int x = 0; x < casillas.length; x++){
            casillas[x][6].setPieza(PiezaFactory.getPieza(PEON, x, 1, ColorPieza.NEGRO));
        }
        casillas[0][7].setPieza(PiezaFactory.getPieza(TipoPieza.TORRE, 0, 7, ColorPieza.NEGRO));
        casillas[7][7].setPieza(PiezaFactory.getPieza(TipoPieza.TORRE, 7, 7, ColorPieza.NEGRO));

        casillas[1][7].setPieza(PiezaFactory.getPieza(TipoPieza.CABALLO, 1, 7, ColorPieza.NEGRO));
        casillas[6][7].setPieza(PiezaFactory.getPieza(TipoPieza.CABALLO, 6, 7, ColorPieza.NEGRO));

        casillas[2][7].setPieza(PiezaFactory.getPieza(TipoPieza.ALFIL, 2, 7, ColorPieza.NEGRO));
        casillas[5][7].setPieza(PiezaFactory.getPieza(TipoPieza.ALFIL, 5, 7, ColorPieza.NEGRO));

        casillas[4][7].setPieza(PiezaFactory.getPieza(TipoPieza.REINA, 4, 7, ColorPieza.NEGRO));
        casillas[3][7].setPieza(PiezaFactory.getPieza(TipoPieza.REY, 3, 7, ColorPieza.NEGRO));
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
    public boolean moverPieza(int x, int y, int xFinal, int yFinal, Cliente cliente) {
        IPieza pieza = getPieza(x, y);
        TipoPieza tipoPieza = TipoPieza.valueOf(pieza.getClass().getSimpleName().toUpperCase());

        PieceMovementComponent controller = PieceMovementFactory.getPieceType(tipoPieza, casillas, x, y,
                xFinal, yFinal, cliente);

	    if(!checkCheck(cliente)) {
            if (controller.moverPieza()) {
                movimientos.add(new Movimiento(casillas[x][y].getSimbolo() + PosicionTablero.values()[x] + (y + 1),
                        "" + PosicionTablero.values()[xFinal] + (yFinal + 1)));
                IPieza temp = casillas[x][y].getPieza();
                casillas[x][y] = new Casilla();
                casillas[xFinal][yFinal].setPieza(temp);
                return true;
            }
        }
        else{
            if(controller.moverPieza()){
                IPieza origen = casillas[x][y].getPieza();
                IPieza destino = casillas[xFinal][yFinal].getPieza();

                movimientos.add(new Movimiento(casillas[x][y].getSimbolo() + PosicionTablero.values()[x] + (y + 1),
                        "" + PosicionTablero.values()[xFinal] + (yFinal + 1)));
                casillas[x][y] = new Casilla();
                casillas[xFinal][yFinal].setPieza(origen);

                if(checkCheck(cliente)){
                    movimientos.poll();

                    casillas[x][y].setPieza(origen);
                    if(destino == null)
                        casillas[xFinal][yFinal] = new Casilla();
                    else
                        casillas[xFinal][yFinal].setPieza(destino);
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean validarPieza(int x, int y, int xFinal, int yFinal) {
        return false;
    }

    @Override
    public IPieza getPieza(int x, int y) {
        return casillas[x][y].getPieza();
    }

    @Override
    public ArrayList<Movimiento> getMovimientos() {
        return new ArrayList<>(movimientos);
    }

    @Override
	public String toString() {
	    String salida = "";
        for(int i = casillas.length-1; i >= 0; i--){
            salida += "\n---+---+---+---+---+---+---+---+---+\n";
            for(int j = 0; j < casillas.length; j++){
                IPieza tmp = casillas[j][i].getPieza();
                String p = (casillas[j][i].getPieza() == null) ? "   " : (tmp.isColor()) ? "*" + tmp.getSimbolo() + "*" : " " + tmp.getSimbolo() + " ";
                salida += (j == 0) ? " " + (i+1) + " |" + p + "|": "" + p +"|";
            }
        }
        salida += "\n---+---+---+---+---+---+---+---+---+";
        salida += "\n   | a | b | c | d | e | f | g | h |";

        return salida;
	}

    @Override
    public int checkWinner() {
	    // No Winner = 0
	    // J1 = 1
        // J2 = 2

        int winner = 0;
        boolean whiteKing = false;
        boolean blackKing = false;

        for (int x = 0; x < casillas.length; x++) {
            for (int y = 0; y < casillas.length; y++) {
                if (casillas[x][y].getPieza() != null) {
                    if (getPieza(x, y).getSimbolo().equalsIgnoreCase("K") && getPieza(x, y).isColor()) {
                        whiteKing = true;
                    } else if (getPieza(x, y).getSimbolo().equalsIgnoreCase("K") && !getPieza(x, y).isColor()){
                        blackKing = true;
                    }
                }

            }
        }

        if (!whiteKing) {
            winner = 2;
        } else if (!blackKing) {
            winner = 1;
        }

        return winner;
    }

    public boolean checkCheck(Cliente cliente){
	    int xReyB = 0, yReyB = 0;
	    int xReyN = 0, yReyN = 0;

        for (int i = 0; i < casillas.length; i++){
            for (int j = 0; j < casillas.length; j++){
                if(casillas[i][j].getPieza() != null){
                    if(casillas[i][j].getSimbolo().equalsIgnoreCase("K")) {
                        if (casillas[i][j].getPieza().isColor()) {
                            xReyB = i;
                            yReyB = j;
                        } else {
                            xReyN = i;
                            yReyN = j;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < casillas.length; i++){
            for (int j = 0; j < casillas.length; j++) {
                if(casillas[i][j].getPieza() != null){

                    IPieza pieza = getPieza(i, j);
                    TipoPieza tipoPieza = TipoPieza.valueOf(pieza.getClass().getSimpleName().toUpperCase());

                    if(casillas[i][j].getPieza().isColor()) {
                        PieceMovementComponent controller = PieceMovementFactory.getPieceType(tipoPieza, casillas, i, j,
                                xReyN, yReyN, cliente);
                        if(controller.moverPieza())
                            return true;
                    }
                    if(!casillas[i][j].getPieza().isColor()) {
                        PieceMovementComponent controller = PieceMovementFactory.getPieceType(tipoPieza, casillas, i, j,
                                xReyB, yReyB, cliente);
                        if(controller.moverPieza())
                            return true;
                    }
                }
            }
        }
        return false;
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
