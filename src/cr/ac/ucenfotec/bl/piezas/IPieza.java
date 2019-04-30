package cr.ac.ucenfotec.bl.piezas;

import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.state.State;

public interface IPieza {

    int getPosX();
    int getPosY();
    boolean isColor();
    String getSimbolo();
    boolean validarMovimiento(int posX, int posY, int posXFinal, int posYFinal, Cliente cliente);
    void setMejora(boolean mejora);
    boolean getMejora();
}
