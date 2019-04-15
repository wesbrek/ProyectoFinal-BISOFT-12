package cr.ac.ucenfotec.bl.ajedrez;

import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.IPieza;
import cr.ac.ucenfotec.bl.piezas.TipoPieza;

public class Peon implements IPieza {
    int posX;
    int posY;
    boolean color;
    IPieza mejora;

    public Peon() {
    }

    public Peon(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Peon(int posX, int posY, ColorPieza color) {
        this.posX = posX;
        this.posY = posY;
        this.color = color.valueOf();
        this.mejora = null;
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

    @Override
    public boolean validarMovimiento(int posX, int posY, int posXFinal, int posYFinal) {

        if(mejora != null){
            return mejora.validarMovimiento(posX, posY, posXFinal, posYFinal);
        }

        return false;
    }

    public void mejorar(IPieza mitipoPieza){
        this.mejora = mitipoPieza;
    }

    @Override
    public String toString() {
        return "Peon{}";
    }
}
