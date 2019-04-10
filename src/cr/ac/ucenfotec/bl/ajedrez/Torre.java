package cr.ac.ucenfotec.bl.ajedrez;

import cr.ac.ucenfotec.bl.Pieza;

public class Torre extends Pieza{

	public Torre() {
		this.name = "T";
	}
	
	public Torre(int posX, int posY) {
		this.name = "T";
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public void move(int x, int y) {
		//Movimiento 1:  X = 0, Y = n.
		//Movimiento 2:  X = n, Y = 0.
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
