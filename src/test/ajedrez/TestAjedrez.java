package test.ajedrez;

import cr.ac.ucenfotec.bl.tablero.TipoJuego;
import cr.ac.ucenfotec.tl.Gestor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAjedrez {
    static Gestor controller = new Gestor();

    @Test
    public void testPeonBlanco() {
        String c = "A2A3";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        boolean res = controller.moverPieza(c);

        assertTrue(res);
    }

    @Test
    public void testPeon2Blanco() {
        String c = "A2A4";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        boolean res = controller.moverPieza(c);

        assertTrue(res);
    }

    @Test
    public void testPeonComerBlanco() {
        String c = "C2C4";
        String c2 = "B7B5";
        String c3 = "C4B5";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        controller.moverPieza(c);
        controller.nextTurn();
        controller.moverPieza(c2);
        controller.nextTurn();
        boolean res = controller.moverPieza(c3);

        assertTrue(res);
    }

    @Test
    public void testCaballoBlanco() {
        String c = "B1A3";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        boolean res = controller.moverPieza(c);

        assertTrue(res);
    }

    @Test
    public void testCaballoComerBlanco() {
        String c = "B1C3";
        String c2 = "B7B5";
        String c3 = "C3B5";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        controller.moverPieza(c);
        controller.nextTurn();
        controller.moverPieza(c2);
        controller.nextTurn();
        boolean res = controller.moverPieza(c3);

        assertTrue(res);
    }

    @Test
    public void testTorreBlanco() {
        String c = "A2A4";
        String c2 = "A1A3";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        controller.moverPieza(c);
        controller.nextTurn();
        boolean res = controller.moverPieza(c2);

        assertTrue(res);
    }

    @Test
    public void testTorreComerBlanco() {
        String c = "A2A4";
        String c2 = "B7B5";
        String c3 = "A1A3";
        String c4 = "A3B3";
        String c5 = "B3B5";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        controller.moverPieza(c);
        controller.nextTurn();
        controller.moverPieza(c2);
        controller.nextTurn();
        controller.moverPieza(c3);
        controller.nextTurn();
        controller.nextTurn();
        controller.moverPieza(c4);
        controller.nextTurn();
        controller.nextTurn();
        boolean res = controller.moverPieza(c5);

        assertTrue(res);
    }

    @Test
    public void testAlfilBlanco() {
        String c = "B2B4";
        String c2 = "C1A3";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        controller.moverPieza(c);
        controller.nextTurn();
        boolean res = controller.moverPieza(c2);

        assertTrue(res);
    }

    @Test
    public void testAlfilComerBlanco() {
        String c = "D2D4";
        String c2 = "C1G5";
        String c3 = "G5E7";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        controller.moverPieza(c);
        controller.nextTurn();
        controller.nextTurn();
        controller.moverPieza(c2);
        controller.nextTurn();
        controller.nextTurn();
        boolean res = controller.moverPieza(c3);

        assertTrue(res);
    }


    @Test
    public void testReinaBlanco() {
        String c = "E2E4";
        String c2 = "E1E3";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        controller.moverPieza(c);
        controller.nextTurn();
        boolean res = controller.moverPieza(c2);

        assertTrue(res);
    }

    @Test
    public void testReinaDiagonalBlanco() {
        String c = "F2F4";
        String c2 = "E1H4";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        controller.moverPieza(c);
        controller.nextTurn();
        boolean res = controller.moverPieza(c2);

        assertTrue(res);
    }

    @Test
    public void testReyBlanco() {
        String c = "D2D3";
        String c2 = "D1D2";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        controller.moverPieza(c);
        controller.nextTurn();
        boolean res = controller.moverPieza(c2);

        assertTrue(res);
    }

    @Test
    public void testReyDiagonalBlanco() {
        String c = "C2C4";
        String c2 = "D1C2";

        controller.crearTablero(TipoJuego.AJEDREZ);
        controller.nextTurn();
        controller.moverPieza(c);
        controller.nextTurn();
        boolean res = controller.moverPieza(c2);

        assertTrue(res);
    }
}
