package cr.ac.ucenfotec.state;

import cr.ac.ucenfotec.bl.Cliente;

public class TurnPlayerOne implements State {
	private Cliente micliente;
	
	public TurnPlayerOne(Cliente aThis) {
		micliente = aThis;
	}

	@Override
	public void nextTurn() {
		micliente.setState(micliente.getPlayerTwoState());
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}
}
