package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.Cliente;

public class Gestor {
	static Cliente micliente = new Cliente();
	
	public String nextTurn() {
		micliente.nextTurn();
		
		if(micliente.getState() == micliente.getPlayerOneState()) {
			return "Player one turn";
		}else if(micliente.getState() == micliente.getPlayerTwoState()) {
			return "Player two turn";
		}
		
		return "estoy mamando";
	}
}
