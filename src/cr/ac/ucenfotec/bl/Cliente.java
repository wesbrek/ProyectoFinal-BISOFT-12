package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

import cr.ac.ucenfotec.bl.serializer.ISerializer;
import cr.ac.ucenfotec.bl.serializer.SerializerFactory;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.tablero.TableroFactory;
import cr.ac.ucenfotec.bl.tablero.TipoJuego;
import cr.ac.ucenfotec.dl.TextFileStorage;
import cr.ac.ucenfotec.state.State;
import cr.ac.ucenfotec.state.TurnPlayerOne;
import cr.ac.ucenfotec.state.TurnPlayerTwo;

public class Cliente {
	private ITablero juego;
	private ArrayList<Jugador> jugadores;
	private State playerOneState;
	private State playerTwoState;
	private static Cliente instanciaUnica;
	private TipoJuego tipoJuego;


	private State activePlayer = new TurnPlayerTwo(this);
	
	private Cliente() {
		this.jugadores = new ArrayList<Jugador>();
		this.playerOneState = new TurnPlayerOne(this);
		this.playerTwoState = new TurnPlayerTwo(this);
        tipoJuego = null;
	}

	public static Cliente getInstance(){
		if(instanciaUnica == null){
			instanciaUnica = new Cliente();
		}
		return instanciaUnica;
	}

	public void iniciarPartida(TipoJuego tipoJuego) {
        juego = TableroFactory.getTablero(tipoJuego);
        this.tipoJuego = tipoJuego;
	}

	public boolean validarJugador(String pass) {
		for(Jugador x : jugadores) {
			if(x.getPassword().equals(pass))
				return true;
		}
		return false;
	}
	
	public String nextTurn() {
		activePlayer.nextTurn();

		for(int i = 0; i < jugadores.size(); i++) {
			if(i == 0 && this.activePlayer == getPlayerOneState()) {
				jugadores.get(i).setTurn(true);
				jugadores.get(i + 1).setTurn(false);
				return jugadores.get(i).getName();
			}else if(i == 1 && this.activePlayer == getPlayerTwoState()) {
				jugadores.get(i).setTurn(true);
				jugadores.get(i - 1).setTurn(false);
				return jugadores.get(i).getName();
			}
		}
		return "";
	}

	public boolean moverPieza(int xInicial, int yInicial, int xFinal, int yFinal, Cliente micliente) {
		return juego.moverPieza(xInicial, yInicial, xFinal, yFinal, micliente);
	}
	
	public State getPlayerOneState() {
		return playerOneState;
	}
	
	public State getPlayerTwoState() {
		return playerTwoState;
	}
	
	public void setState(State _state) {
		this.activePlayer = _state;
	}
	
	public State getState() {
		return this.activePlayer;
	}
	
	public void setJugadores(ArrayList<Jugador> _jugadores) {
		this.jugadores = _jugadores;
	}

	public ArrayList<Jugador> getJugadores(){
		return this.jugadores;
	}

    public String imprimirTablero() {
        return juego.toString();
    }

    public String serializeMovements(){
        ISerializer serializer = SerializerFactory.getSerializer(tipoJuego);

        return serializer.serialize(juego.getMovimientos());
    }

    public TipoJuego getTipoJuego(){
	    return this.tipoJuego;
    }

    public ArrayList<Movimiento> loadGame(TipoJuego tipo, String partida) {
	    ISerializer serializer = SerializerFactory.getSerializer(tipo);
        return serializer.deserialize(partida);
    }
  
    public ITablero getTablero(){
		return this.juego;
	}

}
