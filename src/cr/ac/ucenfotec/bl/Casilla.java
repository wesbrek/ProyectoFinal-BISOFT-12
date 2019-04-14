package cr.ac.ucenfotec.bl;

import cr.ac.ucenfotec.bl.piezas.IPieza;

public class Casilla {
    private IPieza pieza;
    private int posX;
    private int posY;
    //private boolean color;

    public Casilla(IPieza pieza, int posX, int posY) {
        this.pieza = pieza;
        this.posX = posX;
        this.posY = posY;
    }

    public IPieza getPieza() {
        return pieza;
    }

    public void setPieza(IPieza pieza) {
        this.pieza = pieza;
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
}
