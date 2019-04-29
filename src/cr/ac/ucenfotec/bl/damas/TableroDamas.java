package cr.ac.ucenfotec.bl.damas;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.Movimiento;
import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.PiezaFactory;
import cr.ac.ucenfotec.bl.piezas.TipoPieza;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.piezas.IPieza;
import cr.ac.ucenfotec.bl.tablero.PosicionTablero;
import cr.ac.ucenfotec.state.State;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

public class TableroDamas implements ITablero {
    Casilla[][] casillas;
    private ArrayList<IPieza> piezas;
    private boolean continuacion;
    private Queue<Movimiento> movimientos;
	
	public TableroDamas() {
        this.casillas = new Casilla[10][10];
		this.piezas = new ArrayList<IPieza>();
        this.movimientos = new ArrayDeque<Movimiento>();

        iniciarCasillas();
        iniciarTablero();
	}

    public TableroDamas(ArrayList<IPieza> piezas) {
	    this.casillas = new Casilla[10][10];
        this.piezas = piezas;
        this.continuacion = false;
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
    public boolean moverPieza(int x, int y, int xFinal, int yFinal, Cliente cliente) {
	    boolean valExist = true;
        boolean valCapture = false;
	    boolean valNormalMov = getPieza(x,y).validarMovimiento(x,y,xFinal,yFinal,cliente);

        movimientos.add(new Movimiento(""+(x+1+10*y),""+(xFinal+1+10*yFinal)));

        if (valNormalMov == true) {
            valExist = validarPieza(x, y, xFinal, yFinal);
        }else if(valNormalMov == false){
            valCapture = validarCapture(x, y, xFinal, yFinal, cliente);
        }

        if(valCapture == true){
            valExist = validarPieza(x, y, xFinal ,yFinal);
        }
            if(valExist == false){
                IPieza temp = casillas[x][y].getPieza();
                casillas[x][y] = new Casilla();
                casillas[xFinal][yFinal].setPieza(temp);
                if(valCapture == true){
                    validarContinuacion( xFinal,  yFinal,  cliente);
                }

                return true;
            }

        return false;
    }

    public boolean validarPieza(int x, int y, int xFinal, int yFinal) {
        if(getPieza(xFinal, yFinal) != null){
            return true;
        }
        return false;
    }

    public boolean validarCapture(int x, int y, int xFinal, int yFinal, Cliente cliente){
        boolean capture = false;

        if(cliente.getState() == cliente.getPlayerOneState()) {
            boolean whiteCaptureLeft = whiteCaptureLeft(x,y,xFinal,yFinal);
            boolean whiteCaptureRight = whiteCaptureRight(x,y,xFinal,yFinal);
            if(whiteCaptureLeft || whiteCaptureRight){
                capture = true;
                return capture;
            }


        }else if(cliente.getState() == cliente.getPlayerTwoState()){
	        boolean blackCaptureLeft = blackCaptureLeft(x,y,xFinal,yFinal);
	        boolean blackCaptureRight = blackCaptureRight(x,y,xFinal,yFinal);
	        if(blackCaptureLeft || blackCaptureRight){
                capture = true;
                return capture;
            }
	    }
	    return capture;
    }

    public boolean whiteCaptureLeft(int x, int y, int xFinal, int yFinal){

        boolean capture = false;

        if(getPieza(x - 1, y + 1) == null){
            return capture;
        }

        if(getPieza(x, y).isColor() != ColorPieza.BLANCO.valueOf()){
            return capture;
        }

        if(getPieza(x - 1, y + 1).isColor() != ColorPieza.NEGRO.valueOf()){
            return capture;
        }

        if(x - 2 == xFinal && y + 2 == yFinal){
            casillas[x - 1][y + 1] = new Casilla();
            capture = true;
            return capture;
        }

        return capture;
    }

    private boolean whiteCaptureRight(int x, int y, int xFinal, int yFinal){
	    boolean capture = false;

        if (getPieza(x + 1, y + 1) == null){
            return capture;
        }

        if(getPieza(x + 1, y + 1).isColor() != ColorPieza.NEGRO.valueOf()){
            return capture;
        }

        if(getPieza(x, y).isColor() != ColorPieza.BLANCO.valueOf()){
            return capture;
        }

        if(x + 2 == xFinal && y + 2 == yFinal){
            casillas[x + 1][y + 1] = new Casilla();
            capture = true;
            return capture;
        }

        return capture;
    }

    private boolean blackCaptureLeft(int x, int y, int xFinal, int yFinal){
	    boolean capture = false;

	    if(getPieza(x - 1, y - 1) == null){
	        return capture;
        }

	    if(getPieza(x - 1, y - 1).isColor() != ColorPieza.BLANCO.valueOf()){
	        return capture;
        }

	    if(getPieza(x,y).isColor() != ColorPieza.NEGRO.valueOf()){
	        return capture;
        }

        if (x - 2 == xFinal && y - 2 == yFinal){
            casillas[x - 1][y - 1] = new Casilla();
            capture = true;
            return capture;
        }

	    return capture;
    }

    private boolean blackCaptureRight(int x, int y, int xFinal, int yFinal){

	    boolean capture = false;

	    if(getPieza(x + 1, y - 1) == null ){
	        return capture;
        }

	    if(getPieza(x + 1, y - 1).isColor() != ColorPieza.BLANCO.valueOf()){
	        return capture;
        }

	    if(getPieza(x,y).isColor() != ColorPieza.NEGRO.valueOf()){
	        return capture;
        }

	    if(x + 2 == xFinal && y - 2 == yFinal){
            casillas[x + 1][y - 1] = new Casilla();
            capture = true;
            return capture;
        }

	    return capture;
    }


    public boolean validarContinuacion(int xFinal, int yFinal, Cliente cliente){

	    boolean contin = false;
        if(cliente.getState() == cliente.getPlayerOneState()){
                boolean continueWhiteLeft = whiteContinueLeft(xFinal,yFinal);
                boolean continueWhiteRight = whiteContinueRight(xFinal, yFinal);
                if(continueWhiteLeft || continueWhiteRight){
                    cliente.nextTurn();
                    contin = true;
                    return contin;
            }
        }else if(cliente.getState() == cliente.getPlayerTwoState()){
            boolean continueBlackRight = blackContinueRight(xFinal,yFinal);
            boolean continueBlackLeft = blackContinueLeft(xFinal, yFinal);
            if(continueBlackRight || continueBlackLeft){
                cliente.nextTurn();
                contin = true;
                return contin;
            }
        }
        return contin;
    }

    public boolean whiteContinueRight(int xFinal, int yFinal){

	    boolean contin = false;

	    if(getPieza(xFinal + 1, yFinal + 1) == null){
	        return contin;
        }

	    if(getPieza(xFinal + 1, yFinal + 1).isColor() != ColorPieza.NEGRO.valueOf()){
	        return contin;
        }

	    if(getPieza(xFinal, yFinal).isColor() != ColorPieza.BLANCO.valueOf()){
	        return contin;
        }

	    if(getPieza( xFinal + 2, yFinal + 2) != null){
	        return contin;
        }

	    contin = true;

	    return contin;

    }

    private boolean whiteContinueLeft(int xFinal, int yFinal){
        boolean contin = false;

        if(getPieza(xFinal - 1, yFinal + 1) == null){
            return contin;
        }

        if(getPieza(xFinal - 1, yFinal + 1).isColor() != ColorPieza.NEGRO.valueOf()){
            return contin;
        }

        if(getPieza(xFinal,yFinal).isColor() != ColorPieza.BLANCO.valueOf()){
            return contin;
        }

        if(getPieza(xFinal + 2, yFinal + 2) != null){
            return contin;
        }

        contin = true;
        return contin;
    }

    private boolean blackContinueRight(int xFinal, int yFinal){
	    boolean contin = false;

        if(getPieza(xFinal + 1, yFinal - 1) == null){
            return contin;
        }

        if(getPieza(xFinal + 1, yFinal - 1).isColor() != ColorPieza.BLANCO.valueOf()){
            return contin;
        }

        if(getPieza(xFinal,yFinal).isColor() != ColorPieza.NEGRO.valueOf()){
            return contin;
        }

        if(getPieza(xFinal + 2, yFinal - 2) != null){
            return contin;
        }

	    contin = true;
	    return contin;
    }

    private boolean blackContinueLeft(int xFinal, int yFinal){
        boolean contin = false;

        if(getPieza(xFinal - 1, yFinal - 1) == null){
            return contin;
        }

        if(getPieza(xFinal - 1, yFinal - 1).isColor() != ColorPieza.BLANCO.valueOf()){
            return contin;
        }

        if(getPieza(xFinal,yFinal).isColor() != ColorPieza.NEGRO.valueOf()){
            return contin;
        }

        if(getPieza(xFinal - 2, yFinal - 2) != null){
            return contin;
        }

        contin = true;
        return contin;
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
