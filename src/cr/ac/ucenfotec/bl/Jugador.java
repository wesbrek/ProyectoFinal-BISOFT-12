package cr.ac.ucenfotec.bl;

public class Jugador {
	
	private String name;
	private String password;
	private boolean turn;
	
	public Jugador() {
		
	}
	
	public Jugador(String nombre, String contrasenna) {
		this.turn = false;
		this.name = nombre;
		this.password = contrasenna;
	}
	
	public boolean validarJugador(String nombre, String contrasenna) {
		if(this.name == nombre && this.password == contrasenna)
			return true;
		return false;
	}

	public boolean getTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + name + ", contrasenna=" + password + "]";
	}
	
}
