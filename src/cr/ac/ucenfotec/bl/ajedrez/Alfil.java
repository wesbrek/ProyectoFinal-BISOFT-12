package cr.ac.ucenfotec.bl.ajedrez;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.IPieza;

public class Alfil implements IPieza {
	int posX;
	int posY;
	boolean color;
	String simbolo = "B";

	public Alfil() {
	}

    public Alfil(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Alfil(int posX, int posY, ColorPieza color) {
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

		// Diagonal
		if (Math.abs(posX - posXFinal) == Math.abs(posY - posYFinal)) {
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
        return "Alfil{}";
    }
}
