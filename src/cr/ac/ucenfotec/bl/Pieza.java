package cr.ac.ucenfotec.bl;

public abstract class Pieza {
	public String name;
	public int posX;
	public int posY;
	//comportamiento
	
	public abstract void move(int x, int y);
	public abstract int getPosX();
	public abstract int getPosY();
}
