package cr.ac.ucenfotec.bl.tablero;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.piezas.IPieza;

public interface ITablero {

    boolean moverPieza(int x, int y, int xFinal, int yFinal, Cliente cliente);
    boolean validarPieza(int x, int y, int xFinal, int yFinal);
    IPieza getPieza(int x, int y);
    String toString();

}
