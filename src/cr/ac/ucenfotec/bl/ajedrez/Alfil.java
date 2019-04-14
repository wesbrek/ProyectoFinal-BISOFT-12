package cr.ac.ucenfotec.bl.ajedrez;

import cr.ac.ucenfotec.bl.piezas.IPieza;

public class Alfil implements IPieza {
	int posX;
	int posY;
	boolean color;

	public Alfil() {
	}

    public Alfil(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Alfil(int posX, int posY, boolean color) {
		this.posX = posX;
		this.posY = posY;
		this.color = color;
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
		return false;
	}
}
