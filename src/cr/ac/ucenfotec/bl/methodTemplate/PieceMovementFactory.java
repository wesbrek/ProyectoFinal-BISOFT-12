package cr.ac.ucenfotec.bl.methodTemplate;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.piezas.TipoPieza;

public class PieceMovementFactory {
    public static PieceMovementComponent getPieceType(TipoPieza tipo, Casilla[][] casillas, int x, int y,
                                                      int xFinal, int yFinal, Cliente cliente){
        switch (tipo){
            case PEON:
                return new PeonMovementComponent(x, y, xFinal, yFinal, casillas, cliente);
            case ALFIL:
                return new AlfilMovementComponent(x, y, xFinal, yFinal, casillas, cliente);
            case TORRE:
                return new TorreMovementComponent(x, y, xFinal, yFinal, casillas, cliente);
            case CABALLO:
                return new CaballoMovementComponent(x, y, xFinal, yFinal, casillas, cliente);
            case REINA:
                return new ReinaMovementComponent(x, y, xFinal, yFinal, casillas, cliente);
            case REY:
                return new ReyMovementComponent(x, y, xFinal, yFinal, casillas, cliente);
            default:
                throw new RuntimeException("Not implemented");
        }
    }
}
