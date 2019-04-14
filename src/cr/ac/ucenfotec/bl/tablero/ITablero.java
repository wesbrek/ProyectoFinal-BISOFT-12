package cr.ac.ucenfotec.bl.tablero;

import cr.ac.ucenfotec.bl.piezas.IPieza;

public interface ITablero {

    boolean moverPieza(IPieza pieza, int x, int y);
    String toString();

}
