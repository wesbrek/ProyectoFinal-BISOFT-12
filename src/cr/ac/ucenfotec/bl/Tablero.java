package cr.ac.ucenfotec.bl;

import java.util.Arrays;

public class Tablero { //Abstracto

	private int size;
	private String[][] tablero;
	
	public Tablero() {
		
	}
	
	public Tablero(int size) {
		this.size = size;
		this.tablero = new String[size][size];
	}

	//Mover pieza

	//Capturar pieza

	//Cargar tablero

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Tablero [size=" + size + ", tablero=" + Arrays.toString(tablero) + "]";
	}
	
	
}
