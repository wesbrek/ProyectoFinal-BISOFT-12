package cr.ac.ucenfotec.bl.methodTemplate;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.piezas.TipoPieza;

public class PieceMovementFactory {
    public static PieceMovementComponent getPieceType(TipoPieza tipo, Casilla[][] casillas, int x, int y,
                                                      int xFinal, int yFinal, Cliente cliente){
        switch (tipo){
            case PEON:
                return new PeonValidator(x, y, xFinal, yFinal, casillas, cliente);
            case ALFIL:
                return new AlfilValidator(x, y, xFinal, yFinal, casillas, cliente);
            case TORRE:
                return new TorreValidator(x, y, xFinal, yFinal, casillas, cliente);
            case CABALLO:
                return new CaballoValidator(x, y, xFinal, yFinal, casillas, cliente);
            case REINA:
                return new ReinaValidator(x, y, xFinal, yFinal, casillas, cliente);
            case REY:
                return new ReyValidator(x, y, xFinal, yFinal, casillas, cliente);
            default:
                throw new RuntimeException("Not implemented");
        }
    }
}
