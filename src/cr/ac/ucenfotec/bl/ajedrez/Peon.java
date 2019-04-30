package cr.ac.ucenfotec.bl.ajedrez;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.IPieza;

public class Peon implements IPieza {
    int posX;
    int posY;
    boolean color;
    IPieza mejora;
    String simbolo = "P";

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

    public String getSimbolo() { return simbolo; }

    public void setSimbolo(String simbolo) { this.simbolo = simbolo; }

    @Override
    public boolean validarMovimiento(int posX, int posY, int posXFinal, int posYFinal, Cliente cliente) {
        boolean valido = false;

        if(mejora != null){
            return mejora.validarMovimiento(posX, posY, posXFinal, posYFinal, cliente);
        }

        // Blanco
        if (this.color == ColorPieza.BLANCO.valueOf() && cliente.getState() == cliente.getPlayerOneState()) {
            // 1 Adelante
            if (posY+1 == posYFinal) {
                valido = true;
            }
            // 2 Adelante
            if (posY == 1 && posY+2 == posYFinal) {
                valido = true;
            }
            // Diagonal
            if (posX + 1 == posXFinal && posY + 1 == posYFinal ||
                posX - 1 == posXFinal && posY + 1 == posYFinal) {
                valido = true;
            }

        // Negro
        } else if (this.color == ColorPieza.NEGRO.valueOf() && cliente.getState() == cliente.getPlayerTwoState()) {
            // 1 Adelante
            if (posY-1 == posYFinal) {
                valido = true;
            }
            // 2 Adelante
            if (posY == 6 && posY-2 == posYFinal) {
                valido = true;
            }
            // Diagonal
            if (posX + 1 == posXFinal && posY - 1 == posYFinal ||
                posX - 1 == posXFinal && posY - 1 == posYFinal) {
                valido = true;
            }
        }

        return valido;
    }

    @Override
    public void setMejora(boolean mejora) {

    }

    @Override
    public boolean getMejora() {
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
