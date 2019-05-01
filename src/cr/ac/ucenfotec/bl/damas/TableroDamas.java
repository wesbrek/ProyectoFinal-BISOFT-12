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
	    boolean valExist = validarPieza(x,y,xFinal,yFinal);
        boolean valCapture = false;
        boolean valNormalMov = false;
        if(getPieza(x,y) != null){
            valNormalMov = getPieza(x,y).validarMovimiento(x,y,xFinal,yFinal,cliente);
        }

        boolean valCrowned = false;
        boolean normalMoveCrowned = false;
        boolean normalCaptureCrowned = false;
        boolean val = false;

        if(getPieza(x,y) != null) {
            if (getPieza(x, y).getMejora() == true && valExist == false) {
                normalMoveCrowned = validarNormalMoveCrowned(x, y, xFinal, yFinal);
                if (normalMoveCrowned == false) {
                    valCrowned = moveCrowned(x, y, xFinal, yFinal, cliente);
                }
            }

            if(getPieza(x,y).getMejora() == true && valCrowned == false && normalMoveCrowned ==false && valExist == false){
                normalCaptureCrowned = normalCaptureCrowned(x,y,xFinal,yFinal, cliente);
                if(normalCaptureCrowned == true){
                    val = true;
                }
            }
        }


        if (valNormalMov == true && valCrowned == false && valExist == false || normalMoveCrowned == true && valExist == false) {
            val = true;
        }else if(valNormalMov == false && valCrowned == false && normalMoveCrowned == false && valExist == false){
            valCapture = validarCapture(x, y, xFinal, yFinal, cliente);
        }

        if(valCapture == true && valCrowned == false && valExist == false){
            val = true;

        }
        if(valCrowned == true && valExist == false){
           val = true;
        }
            if(val == true){
                movimientos.add(new Movimiento(""+(x+1+10*y),""+(xFinal+1+10*yFinal)));
                IPieza temp = casillas[x][y].getPieza();
                casillas[x][y] = new Casilla();
                casillas[xFinal][yFinal].setPieza(temp);
                if(valCapture == true && valCrowned == false){
                    validarContinuacion( xFinal,  yFinal,  cliente);
                }

                if(getPieza(xFinal, yFinal).getMejora() == false){
                    checkCrowned(xFinal, yFinal);
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

    public boolean validarNormalMoveCrowned(int posX, int posY, int posXFinal, int posYFinal) {


                if (posX - 1 == posXFinal && posY + 1 == posYFinal) {
                    return true;
                } else if (posX + 1 == posXFinal && posY + 1 == posYFinal) {
                    return true;
                }else if(posX +1 == posXFinal && posY - 1 == posYFinal){
                    return true;
                }else if(posX - 1 == posXFinal && posY - 1 == posYFinal){
                    return true;
                }

        return false;
    }

    public boolean normalCaptureCrowned(int x,int y,int xFinal, int yFinal, Cliente cliente){
	    boolean capture = false;

        boolean color = colorPieza(x,y);
        boolean captureUpLeft = normalCaptureCrownedUpLeft(x,y,xFinal,yFinal, color, cliente);
        boolean captureUpRight = normalCaptureCrownedUpRight(x,y,xFinal,yFinal,color, cliente);
        boolean captureDownLeft = normalCaptureCrownedDownLeft(x,y,xFinal,yFinal,color, cliente);
        boolean captureDownRight = normalCaptureCrownedDownRight(x,y,xFinal,yFinal,color, cliente);

        if(captureDownLeft == true || captureDownRight == true || captureUpLeft == true || captureUpRight == true){
            capture = true;
            return capture;
        }


	    return capture;
    }

    public boolean normalCaptureCrownedUpLeft(int x, int y, int xFinal, int yFinal, boolean color, Cliente cliente){
	    boolean capture = false;

	    if(color == true && cliente.getState() == cliente.getPlayerOneState()) {

            if(getPieza(x - 1, y + 1) == null)
                return capture;

            if(getPieza(x - 1, y + 1).isColor() != ColorPieza.NEGRO.valueOf()){
                return capture;
            }

            if(x - 2 == xFinal && y + 2 == yFinal){
                casillas[x - 1][y + 1] = new Casilla();
                capture = true;
                return capture;
            }

            return capture;
        }else if(color == false && cliente.getState() == cliente.getPlayerTwoState()){
            if(getPieza(x - 1, y + 1) == null)
                return capture;

            if(getPieza(x - 1, y + 1).isColor() != ColorPieza.BLANCO.valueOf()){
                return capture;
            }

            if(x - 2 == xFinal && y + 2 == yFinal){
                casillas[x - 1][y + 1] = new Casilla();
                capture = true;
                return capture;
            }

            return capture;

        }
        return capture;
    }

    public boolean normalCaptureCrownedUpRight(int x, int y, int xFinal, int yFinal, boolean color, Cliente cliente){
        boolean capture = false;

        if(color == true && cliente.getState() == cliente.getPlayerOneState()) {

            if(getPieza(x + 1, y + 1) == null)
                return capture;

            if(getPieza(x + 1, y + 1).isColor() != ColorPieza.NEGRO.valueOf()){
                return capture;
            }

            if(x + 2 == xFinal && y + 2 == yFinal){
                casillas[x + 1][y + 1] = new Casilla();
                capture = true;
                return capture;
            }

            return capture;
        }else if(color == false && cliente.getState() == cliente.getPlayerTwoState()){
            if(getPieza(x + 1, y + 1) == null)
                return capture;

            if(getPieza(x + 1, y + 1).isColor() != ColorPieza.BLANCO.valueOf()){
                return capture;
            }

            if(x + 2 == xFinal && y + 2 == yFinal){
                casillas[x + 1][y + 1] = new Casilla();
                capture = true;
                return capture;
            }

            return capture;

        }
        return capture;
    }

    public boolean normalCaptureCrownedDownLeft(int x, int y, int xFinal, int yFinal, boolean color, Cliente cliente){
        boolean capture = false;

        if(color == true && cliente.getState() == cliente.getPlayerOneState()) {

            if(getPieza(x - 1, y - 1) == null)
                return capture;

            if(getPieza(x - 1, y - 1).isColor() != ColorPieza.NEGRO.valueOf()){
                return capture;
            }

            if(x - 2 == xFinal && y - 2 == yFinal){
                casillas[x - 1][y - 1] = new Casilla();
                capture = true;
                return capture;
            }

            return capture;
        }else if(color == false && cliente.getState() == cliente.getPlayerTwoState()){
            if(getPieza(x - 1, y - 1) == null)
                return capture;

            if(getPieza(x - 1, y - 1).isColor() != ColorPieza.BLANCO.valueOf()){
                return capture;
            }

            if(x - 2 == xFinal && y - 2 == yFinal){
                casillas[x - 1][y - 1] = new Casilla();
                capture = true;
                return capture;
            }

            return capture;

        }
        return capture;
    }

    public boolean normalCaptureCrownedDownRight(int x, int y, int xFinal, int yFinal, boolean color, Cliente cliente){
        boolean capture = false;

        if(color == true && cliente.getState() == cliente.getPlayerOneState()) {

            if(getPieza(x + 1, y - 1) == null)
                return capture;

            if(getPieza(x + 1, y - 1).isColor() != ColorPieza.NEGRO.valueOf()){
                return capture;
            }

            if(x + 2 == xFinal && y - 2 == yFinal){
                casillas[x + 1][y - 1] = new Casilla();
                capture = true;
                return capture;
            }

            return capture;
        }else if(color == false && cliente.getState() == cliente.getPlayerTwoState()){
            if(getPieza(x + 1, y - 1) == null)
                return capture;

            if(getPieza(x + 1, y - 1).isColor() != ColorPieza.BLANCO.valueOf()){
                return capture;
            }

            if(x + 2 == xFinal && y - 2 == yFinal){
                casillas[x + 1][y - 1] = new Casilla();
                capture = true;
                return capture;
            }

            return capture;

        }
        return capture;
    }


    private boolean colorPieza(int x, int y){
	    boolean color = false;

	    if(getPieza(x,y).isColor() == ColorPieza.BLANCO.valueOf()){
	        color = true;
	        return color;
        }

	    return color;
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

        if(x - 1 < 0 || y + 1 >= 10){
            return capture;
        }


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

        if(x + 1 >= 10 || y + 1 >= 10){
            return capture;
        }

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

        if(x - 1 < 0 || y - 1 < 0){
            return capture;
        }

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

        if(x + 1 >= 10 || y - 1 < 0){
            return capture;
        }

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

	    if(xFinal + 1 >= 10 || yFinal + 1 >= 10){
	        return contin;
        }

	    if(xFinal + 2 >= 10 || yFinal + 2 >= 10){
	        return contin;
        }

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

        if(xFinal - 1 < 0 || yFinal + 1 >= 10){
            return contin;
        }

        if(xFinal - 2 < 0 || yFinal + 2 >= 10){
            return contin;
        }

        if(getPieza(xFinal - 1, yFinal + 1) == null){
            return contin;
        }

        if(getPieza(xFinal - 1, yFinal + 1).isColor() != ColorPieza.NEGRO.valueOf()){
            return contin;
        }

        if(getPieza(xFinal,yFinal).isColor() != ColorPieza.BLANCO.valueOf()){
            return contin;
        }

        if(getPieza(xFinal - 2, yFinal + 2) != null){
            return contin;
        }

        contin = true;
        return contin;
    }

    private boolean blackContinueRight(int xFinal, int yFinal){
	    boolean contin = false;

        if(xFinal + 1 >= 10 || yFinal - 1 < 0){
            return contin;
        }

        if(xFinal + 2 >= 10 || yFinal - 2 < 0){
            return contin;
        }

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

        if(xFinal - 1 < 0 || yFinal - 1 < 0){
            return contin;
        }

        if(xFinal - 2 < 0 || yFinal - 2 < 0){
            return contin;
        }

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

    private void checkCrowned(int xFinal, int yFinal){
	    if(yFinal == 0 || yFinal == 9){
	        getPieza(xFinal,yFinal).setMejora(true);
        }
    }

    private boolean moveCrowned(int x,int y,int xFinal, int yFinal, Cliente cliente){
	    boolean move = false;

        ArrayList<Integer> checkCasillas = checkImprovementMove(x,y,xFinal,yFinal, cliente);

	    if(cliente.getState() == cliente.getPlayerOneState() && checkCasillas != null){
            boolean crownedWhiteMove = false;
            crownedWhiteMove = validarImproveCapture(checkCasillas.get(0),checkCasillas.get(1),xFinal,yFinal,cliente, x,y);
	        if(crownedWhiteMove == true){
	            move = true;
	            return move;
            }
        }

	    if(cliente.getState() == cliente.getPlayerTwoState()){
            boolean crownedBlackMove = false;
            crownedBlackMove = validarImproveCapture(checkCasillas.get(0),checkCasillas.get(1),xFinal,yFinal,cliente, x,y);
            if(crownedBlackMove == true){
                move = true;
                return move;
            }
        }

	    return move;
    }

    private ArrayList checkImprovementMove(int x, int y, int xFinal, int yFinal, Cliente cliente){
        ArrayList moves = null;
        ArrayList checkMoveUpRight = improvedMovementUpRight(x,y,xFinal,yFinal);
        ArrayList checkMoveUpLeft = improvedMovementUpLeft(x,y,xFinal,yFinal);
        ArrayList checkMoveDownRight = improvedMovementDownRight(x,y,xFinal,yFinal);
        ArrayList checkMoveDownLeft = improvedMovementDownLeft(x,y,xFinal,yFinal);

        if(checkMoveUpRight.isEmpty() == false){
            moves = checkMoveUpRight;
        }

        if(checkMoveUpLeft.isEmpty() == false){
            moves = checkMoveUpLeft;
        }

        if(checkMoveDownRight.isEmpty() == false){
            moves = checkMoveDownRight;
        }

        if(checkMoveDownLeft.isEmpty() == false){
            moves = checkMoveDownLeft;
        }

        return moves;

    }

    private ArrayList improvedMovementUpRight(int x, int y, int xFinal, int yFinal) {
        ArrayList move = new ArrayList();

        int contx = x + 1;
        int conty = y + 1;

        if (contx == 10 || conty == 10) {
            return move;
        }

        if (x == xFinal - 2 && y == yFinal - 2) {
            move.add(x);
            move.add(y);
            return move;
        }else if(getPieza(x + 1, y + 1) == null) {
            move = improvedMovementUpRight(x + 1, y + 1, xFinal, yFinal);
        }

        return move;

    }


    private ArrayList improvedMovementUpLeft(int x, int y, int xFinal, int yFinal){
        ArrayList move = new ArrayList();

        int contx = x - 1;
        int conty = y + 1;

        if(contx < 0 || conty == 10){
            return move;
        }

        if(x == xFinal + 2 && y == yFinal - 2){
            move.add(x);
            move.add(y);
            return move;
        }else if(getPieza(x - 1, y + 1) == null){
            move = improvedMovementUpLeft(x - 1, y + 1, xFinal, yFinal);
        }

        return move;

    }

    private ArrayList improvedMovementDownRight(int x, int y, int xFinal, int yFinal){
        ArrayList move = new ArrayList();

        int contx = x + 1;
        int conty = y - 1;

        if(contx == 10 || conty < 0){
            return move;
        }

        if(x == xFinal - 2 && y == yFinal + 2){
            move.add(x);
            move.add(y);
            return move;
        }else if(getPieza(x + 1, y - 1) == null){
            move = improvedMovementDownRight(x + 1, y - 1, xFinal, yFinal);
        }

        return move;

    }

    private ArrayList improvedMovementDownLeft(int x, int y, int xFinal, int yFinal){
        ArrayList move = new ArrayList();

        int contx = x - 1;
        int conty = y - 1;

        if(contx < 0 || conty < 0){
            return move;
        }

        if(x == xFinal + 2 && y == yFinal + 2){
            move.add(x);
            move.add(y);
            return move;
        }else if(getPieza(x - 1, y - 1) == null){
             move = improvedMovementDownLeft(x - 1, y - 1, xFinal, yFinal);
        }



        return move;
    }


    public boolean validarImproveCapture(int x, int y, int xFinal, int yFinal, Cliente cliente, int xOriginal, int yOriginal){
	    boolean capture = false;

	    if(cliente.getState() == cliente.getPlayerOneState()){
	        capture = whiteCrownedMove(x,y,xFinal,yFinal, xOriginal, yOriginal);
	        return capture;
        }else if(cliente.getState() == cliente.getPlayerTwoState()){
	        capture = blackCrownedMove(x,y,xFinal,yFinal, xOriginal, yOriginal);
        }

	    return capture;
    }


    public boolean whiteCrownedMove(int x, int y, int xFinal, int yFinal, int xOriginal, int yOriginal){
	    boolean move = false;
        if(xFinal + 1 <= 10 && yFinal + 1 < 10 && getPieza(xFinal + 1, yFinal + 1) != null && x - 2 == xFinal && y - 2 == yFinal){
            //Abajo izquierda
            if(getPieza(xOriginal,yOriginal).isColor() == ColorPieza.BLANCO.valueOf() && getPieza(xFinal + 1 ,yFinal + 1).isColor() == ColorPieza.NEGRO.valueOf()){
                casillas[xFinal + 1][yFinal + 1] = new Casilla();
                move = true;
                return move;
            }
        }else if(xFinal - 1 > 0 && yFinal - 1 > 0 && getPieza(xFinal - 1, yFinal - 1) != null && x + 2 == xFinal && y + 2 == yFinal){
            //Arriba derecha
            if(getPieza(xOriginal,yOriginal).isColor() == ColorPieza.BLANCO.valueOf() && getPieza(xFinal - 1 ,yFinal - 1).isColor() == ColorPieza.NEGRO.valueOf()){
                casillas[xFinal - 1][yFinal - 1] = new Casilla();
                move = true;
                return move;
            }
            //Arriba izquierda
        }else if(xFinal + 1 < 10 && yFinal - 1 > 0 && getPieza(xFinal + 1, yFinal - 1) != null && x - 2 == xFinal && y + 2 == yFinal){
            if(getPieza(xOriginal,yOriginal).isColor() == ColorPieza.BLANCO.valueOf() && getPieza(xFinal + 1 ,yFinal - 1).isColor() == ColorPieza.NEGRO.valueOf()){
                casillas[xFinal + 1][yFinal - 1] = new Casilla();
                move = true;
                return move;
            }
        }else if(xFinal - 1 > 0 && yFinal + 1 < 10 && getPieza(xFinal - 1, yFinal + 1) != null && x + 2 == xFinal && y - 2 == yFinal){
            //Abajo derecha
            if(getPieza(xOriginal,yOriginal).isColor() == ColorPieza.BLANCO.valueOf() && getPieza(xFinal - 1 ,yFinal + 1).isColor() == ColorPieza.NEGRO.valueOf()){
                casillas[xFinal - 1][yFinal + 1] = new Casilla();
                move = true;
                return move;
            }

        }
        return move;
    }

    public boolean blackCrownedMove(int x, int y, int xFinal, int yFinal, int xOriginal, int yOriginal){
        boolean move = false;
        if(xFinal + 1 < 10 && yFinal + 1 < 10 && getPieza(xFinal + 1, yFinal + 1) != null && x - 2 == xFinal && y - 2 == yFinal){
            //Abajo izquierda
            if(getPieza(xOriginal,yOriginal).isColor() == ColorPieza.NEGRO.valueOf() && getPieza(xFinal + 1 ,yFinal + 1).isColor() == ColorPieza.BLANCO.valueOf()){
                casillas[xFinal + 1][yFinal + 1] = new Casilla();
                move = true;
                return move;
            }
        }else if(xFinal - 1 > 0 && yFinal - 1 > 0 && getPieza(xFinal - 1, yFinal - 1) != null && x + 2 == xFinal && y + 2 == yFinal){
            //Arriba derecha
            if(getPieza(xOriginal,yOriginal).isColor() == ColorPieza.NEGRO.valueOf() && getPieza(xFinal - 1 ,yFinal - 1).isColor() == ColorPieza.BLANCO.valueOf()){
                casillas[xFinal - 1][yFinal - 1] = new Casilla();
                move = true;
                return move;
            }
            //Arriba izquierda
        }else if(xFinal + 1 < 10 && yFinal - 1 > 0 && getPieza(xFinal + 1, yFinal - 1) != null && x - 2 == xFinal && y + 2 == yFinal){
            if(getPieza(xOriginal,yOriginal).isColor() == ColorPieza.NEGRO.valueOf() && getPieza(xFinal + 1 ,yFinal - 1).isColor() == ColorPieza.BLANCO.valueOf()){
                casillas[xFinal + 1][yFinal - 1] = new Casilla();
                move = true;
                return move;
            }
        }else if(xFinal - 1 > 0 && yFinal + 1 < 10 && getPieza(xFinal - 1, yFinal + 1) != null && x + 2 == xFinal && y - 2 == yFinal){
            //Abajo derecha
            if(getPieza(xOriginal,yOriginal).isColor() == ColorPieza.NEGRO.valueOf() && getPieza(xFinal - 1 ,yFinal + 1).isColor() == ColorPieza.BLANCO.valueOf()){
                casillas[xFinal - 1][yFinal + 1] = new Casilla();
                move = true;
                return move;
            }

        }
        return move;
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

    @Override
    public int checkWinner() {

	    int j1 = 0;
	    int j2 = 0;
	    int noWinner = 0;

	    for(int x = 0; x < casillas.length; x++){
	        for(int y = 0; y < casillas.length; y++){
	            if(casillas[x][y].getPieza() != null){
                    if(casillas[x][y].getPieza().isColor() == ColorPieza.BLANCO.valueOf()){
                        j1++;
                    }else if(casillas[x][y].getPieza().isColor() == ColorPieza.NEGRO.valueOf()){
                        j2++;
                    }
                }

            }
        }

	    if(j1 > 0 && j2 == 0){
	        j1 = 1;
	       return j1;
        }

	    if(j1 == 0 && j2 > 0){
	        j2 = 2;
	        return j2;
        }

        return noWinner;
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
