package cr.ac.ucenfotec.bl;

import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.tablero.TableroFactory;
import cr.ac.ucenfotec.bl.tablero.TipoJuego;

public class Juego {
    private ITablero tablero;
	private Jugador blanco;
	private Jugador negro;
	
	public Juego(Jugador blanco, Jugador negro, TipoJuego tipoJuego) {
        this.tablero = TableroFactory.getTablero(tipoJuego);
		this.blanco = blanco;
		this.negro = negro;
	}

	public void iniciarJuego() {
		//Validar el tipo de juego.

		//Si tipo Juego == "TableroAjedrez", crear un tablero de tipo TableroAjedrez.
		//Si tipo Juego == "TableroDamas", crear un tablero de tipo TableroDamas.
		//Si tipo TableroGo == "TableroGo", crear un tablero de tipo TableroGo.
	}
}
