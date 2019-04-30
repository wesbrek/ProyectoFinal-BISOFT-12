package cr.ac.ucenfotec.state;

import cr.ac.ucenfotec.bl.Cliente;

public class TurnPlayerTwo implements State {
	private Cliente micliente;
	
	public TurnPlayerTwo(Cliente aThis) {
		micliente = aThis;
	}

	@Override
	public void nextTurn() {
		micliente.setState(micliente.getPlayerOneState());
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}
}
