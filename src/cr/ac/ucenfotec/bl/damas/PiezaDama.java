package cr.ac.ucenfotec.bl.damas;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.IPieza;


public class PiezaDama implements IPieza {
    int posX;
    int posY;
    boolean color;
    IPieza mejora;
    boolean capture;
    String simbolo = "D";
    public PiezaDama() {
    }

    public PiezaDama(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public PiezaDama(int posX, int posY, ColorPieza color) {
        this.posX = posX;
        this.posY = posY;
        this.color = color.valueOf();
        this.mejora = null;
        this.capture = false;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public String getSimbolo() { return this.simbolo; }


    public boolean getCapture() { return this.capture; }

    public void setCapture(boolean capture){ this.capture = capture; }

    @Override
    public boolean validarMovimiento(int posX, int posY, int posXFinal, int posYFinal, Cliente cliente) {

        if(this.mejora != null) {
           //Movimiento mejorado
        }else if(this.mejora == null){

            if(this.color == ColorPieza.BLANCO.valueOf() && cliente.getState() == cliente.getPlayerOneState()){
                if(posX -1 == posXFinal && posY + 1 == posYFinal){
                    return true;
                }else if(posX + 1 == posXFinal && posY + 1 == posYFinal){
                    return true;
                }
            }else if(this.color == ColorPieza.NEGRO.valueOf() && cliente.getState() == cliente.getPlayerTwoState()){
                if(posX +1 == posXFinal && posY - 1 == posYFinal){
                    return true;
                }else if(posX - 1 == posXFinal && posY - 1 == posYFinal){
                    return true;
                }
            }
        }
        return false;
    }



    @Override
    public String toString() {
        return "PiezaDama{}";
    }

    public void mejorar(IPieza mitipoPieza){
        this.mejora = mitipoPieza;
    }
}
