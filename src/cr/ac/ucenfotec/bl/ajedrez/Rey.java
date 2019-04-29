package cr.ac.ucenfotec.bl.ajedrez;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.IPieza;

public class Rey implements IPieza {
	int posX;
	int posY;
	boolean color;
	String simbolo = "K";

    public Rey() {
    }

    public Rey(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Rey(int posX, int posY, ColorPieza color) {
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

    public String getSimbolo() { return simbolo; }

    public void setSimbolo(String simbolo) { this.simbolo = simbolo; }

    @Override
	public boolean validarMovimiento(int posX, int posY, int posXFinal, int posYFinal, Cliente cliente) {
		boolean valido = false;

		// 1 arriba
        if (posY+1 == posYFinal && posX == posXFinal) {
            valido = true;
        }
		// 1 arriba-derecha
        if (posY+1 == posYFinal && posX+1 == posXFinal) {
            valido = true;
        }
        // 1 derecha
        if (posX+1 == posXFinal && posY == posYFinal) {
            valido = true;
        }
        // 1 derecha-abajo
        if (posX+1 == posXFinal && posY-1 == posYFinal) {
            valido = true;
        }
        // 1 abajo
        if (posY-1 == posYFinal && posX == posXFinal) {
            valido = true;
        }
        // 1 abajo-izquierda
        if (posY-1 == posYFinal && posX-1 == posXFinal) {
            valido = true;
        }
        // 1 izquierda
        if (posX-1 == posXFinal && posY == posYFinal) {
            valido = true;
        }
        // izquierda-arriba
        if (posX-1 == posXFinal && posY+1 == posYFinal) {
            valido = true;
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

    @Override
    public String toString() {
        return "Rey{}";
    }
}
