package cr.ac.ucenfotec.bl;

import cr.ac.ucenfotec.bl.piezas.IPieza;

public class Casilla {
    private IPieza pieza;
    private int posX;
    private int posY;
    private String simbolo;

    public Casilla() {
        this.pieza = null;
        this.posX = 0;
        this.posY = 0;
    }

    public Casilla(IPieza pieza, int posX, int posY) {
        this.pieza = pieza;
        this.posX = posX;
        this.posY = posY;
        this.simbolo = pieza.getSimbolo();
    }

    public IPieza getPieza() {
        return pieza;
    }

    public void setPieza(IPieza pieza) {
        this.pieza = pieza;
        this.posX = pieza.getPosX();
        this.posY = pieza.getPosY();
        this.simbolo = pieza.getSimbolo();
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

    public String getSimbolo() { return simbolo; }

    public void setSimbolo(String simbolo) { this.simbolo = simbolo; }

    @Override
    public String toString() {
        String color = "null";
        if(getPieza()!= null) {
            if (pieza.isColor())
                color = "blanco";
            else
                color = "negro";
        }
        return pieza + " " + color + "[" + posX + "]" + "[" + posY + "]  ";
    }
}
