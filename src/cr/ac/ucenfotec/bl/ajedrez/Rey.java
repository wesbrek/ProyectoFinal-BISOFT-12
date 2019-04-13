package cr.ac.ucenfotec.bl.ajedrez;

import cr.ac.ucenfotec.bl.Pieza;

public class Rey extends Pieza{

	public Rey() {
		this.name = "K";
	}
	
	public Rey(int posX, int posY) {
		this.name = "K";
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public void move(int x, int y) {
		//Verificar movimiento: 1 casilla en cualquier direcci�n
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
