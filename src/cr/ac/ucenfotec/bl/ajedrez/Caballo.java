package cr.ac.ucenfotec.bl.ajedrez;

import cr.ac.ucenfotec.bl.Pieza;

public class Caballo extends Pieza{

	public Caballo() {
		this.name = "C";
	}
	
	public Caballo(int posX, int posY) {
		this.name = "C";
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public void move(int x, int y) {
		//Movimiento 1:  X = 1 o -1, Y = 3 0 -3.
		//Movimiento 2:  X = 3 o -3, Y = 1 0 -1.
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
