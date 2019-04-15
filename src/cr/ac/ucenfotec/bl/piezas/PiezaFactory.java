package cr.ac.ucenfotec.bl.piezas;

import cr.ac.ucenfotec.bl.ajedrez.*;
import cr.ac.ucenfotec.bl.damas.PiezaDama;
import cr.ac.ucenfotec.bl.go.PiezaGo;

public class PiezaFactory {
    public static IPieza getPieza(TipoPieza tipo, int posX, int posY, ColorPieza color) {
        switch (tipo){
            case ALFIL:
                return new Alfil(posX, posY, color);
            case CABALLO:
                return new Caballo(posX, posY, color);
            case PEON:
                return new Peon(posX, posY, color);
            case REINA:
                return new Reina(posX, posY, color);
            case REY:
                return new Rey(posX, posY, color);
            case TORRE:
                return new Torre(posX, posY, color);
            case GO:
                return new PiezaGo(posX, posY, color);
            case DAMA:
                return new PiezaDama(posX, posY, color);
            default:
                throw new RuntimeException("Error!");
        }
    }
}
