package cr.ac.ucenfotec.bl.piezas;

public interface IPieza {

    int getPosX();
    int getPosY();
    boolean isColor();
    boolean validarMovimiento(int posX, int posY, int posXFinal, int posYFinal);
    //boolean clavada();
}
