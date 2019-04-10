package cr.ac.ucenfotec.bl.ajedrez;

import cr.ac.ucenfotec.bl.Pieza;

public class Peon extends Pieza{
	
	public Peon() {
		this.name = "P";
	}
	
	public Peon(int posX, int posY) {
		this.name = "P";
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public void move(int x, int y) {
		//Verificar si es la primera vez que se mueve, en cuyo caso X puede sumar 2, Y se mantiene.
		//Verificar que X sea mayor por 1 a la posicion actual, Y se mantiene.
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
