package cr.ac.ucenfotec.bl.piezas;

import cr.ac.ucenfotec.bl.ajedrez.*;
import cr.ac.ucenfotec.bl.damas.PiezaDama;
import cr.ac.ucenfotec.bl.go.PiezaGo;

public class PiezaFactory {
    public static IPieza getPieza(TipoPieza tipo, int posX, int posY) {
        switch (tipo){
            case ALFIL:
                return new Alfil(posX, posY);
            case CABALLO:
                return new Caballo(posX, posY);
            case PEON:
                return new Peon(posX, posY);
            case REINA:
                return new Reina(posX, posY);
            case REY:
                return new Rey(posX, posY);
            case TORRE:
                return new Torre(posX, posY);
            case GO:
                return new PiezaGo(posX, posY);
            case DAMA:
                return new PiezaDama(posX, posY);
            default:
                throw new RuntimeException("Error!");
        }
    }
}
