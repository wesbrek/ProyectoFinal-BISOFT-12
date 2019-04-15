package cr.ac.ucenfotec.bl;

import cr.ac.ucenfotec.state.State;

public class Jugador {
	
	private final String name;
	private final String password;
	private boolean turn;


	private Jugador(String nombre, String contrasenna) {
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


	public static class JugadorBuilder{
		private String name;
		private String password;



		public JugadorBuilder(){

		}

		public JugadorBuilder name(String _name){
			this.name = _name;
			return this;
		}

		public JugadorBuilder password(String _pass){
			this.password = _pass;
			return this;
		}

		public Jugador build(){
			return new Jugador(name, password);
		}
	}

}
