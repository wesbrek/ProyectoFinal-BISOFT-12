package cr.ac.ucenfotec.main;

import cr.ac.ucenfotec.bl.Jugador.JugadorBuilder;
import cr.ac.ucenfotec.bl.ajedrez.TableroAjedrez;
import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.PiezaFactory;
import cr.ac.ucenfotec.bl.piezas.TipoPieza;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.tablero.TableroFactory;
import cr.ac.ucenfotec.bl.tablero.TipoJuego;
import cr.ac.ucenfotec.tl.Gestor;

public class Main {
	static Gestor controller = new Gestor();
	
	public static void main(String[] args) {
		ITablero tablero = TableroFactory.getTablero(TipoJuego.AJEDREZ);
        //System.out.println(tablero.toString());

        ITablero builder = new TableroAjedrez.Builder()
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 0, 1, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 1, 1, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 2, 1, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 3, 1, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 4, 1, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 5, 1, ColorPieza.NEGRO))
                .build();

        System.out.println(tablero.toString());
        boolean move = tablero.moverPieza(tablero.getPieza(0, 1), 0, 2);
        if (!move) {
            System.out.println("[!] Posición inválida!");
        }
        System.out.println(tablero.toString());


        /*System.out.println(builder.toString());

        ITablero damas = TableroFactory.getTablero(TipoJuego.DAMAS);
        System.out.println(damas.toString());

        ITablero damasBuilder = new TableroAjedrez.Builder()
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 0, 6, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 1, 6, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 2, 6, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 3, 6, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 4, 6, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 5, 6, ColorPieza.NEGRO))
                .build();
        System.out.println(damasBuilder.toString());


        controller.addPlayers("Sergio", "123123", "Abby", "123");

        System.out.println(controller.nextTurn());
*/

	}

}
