package cr.ac.ucenfotec.bl;

public class Jugador {
	
	private final String name;
	private final String password;
	private boolean turn;


	private Jugador(String nombre, String contrasenna, boolean turn) {
		this.turn = turn;
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

	public String getPassword(){
		return this.password;
	}



	@Override
	public String toString() {
		return "Jugador [nombre=" + name + ", contrasenna=" + password + "]";
	}


	public static class JugadorBuilder{
		private String name;
		private String password;
		private boolean turn;


		public JugadorBuilder(){

		}

		public JugadorBuilder withName(String _name){
			this.name = _name;
			return this;
		}

		public JugadorBuilder withPassword(String _pass){
			this.password = _pass;
			return this;
		}

		public JugadorBuilder withTurn(boolean turn){
			this.turn = turn;
			return this;
		}

		public Jugador build(){
			return new Jugador(name, password, turn);
		}
	}

}
