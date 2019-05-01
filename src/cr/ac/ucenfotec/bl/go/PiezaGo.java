package cr.ac.ucenfotec.bl.go;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.IPieza;
import cr.ac.ucenfotec.state.State;

public class PiezaGo implements IPieza {
    int posX;
    int posY;
    boolean color;

    public PiezaGo() {
    }

    public PiezaGo(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public PiezaGo(int posX, int posY, ColorPieza color) {
        this.posX = posX;
        this.posY = posY;
        this.color = color.valueOf();
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

    public String getSimbolo() { return (isColor()) ? "B" : "N"; }

    @Override
    public boolean validarMovimiento(int posX, int posY, int posXFinal, int posYFinal, Cliente cliente) {
        return false;
    }

    @Override
    public void setMejora(boolean mejora) {

    }

    @Override
    public boolean getMejora() {
        return false;
    }
}
