package cr.ac.ucenfotec.bl.ajedrez;

import cr.ac.ucenfotec.bl.Pieza;

public class Alfil extends Pieza {

	public Alfil() {
		this.name = "A";
	}
	
	public Alfil(int posX, int posY) {
		this.name = "A";
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public void move(int x, int y) {
		//Movimiento 1:  X = n, Y = z.
		//Movimiento 2:  X = z, Y = n.
	}

	@Override
	public int getPosX() {
		return this.posX;
	}

	@Override
	public int getPosY() {
		return this.posY;
	}
}
