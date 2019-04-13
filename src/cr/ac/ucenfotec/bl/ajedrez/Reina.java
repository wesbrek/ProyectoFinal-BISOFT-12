package cr.ac.ucenfotec.bl.ajedrez;

import cr.ac.ucenfotec.bl.Pieza;

public class Reina extends Pieza {

	public Reina() {
		this.name = "Q";
	}
	
	public Reina(int posX, int posY) {
		this.name = "Q";
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public void move(int x, int y) {
		//Verificar movimiento: n casillas en cualquier direccion.
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
