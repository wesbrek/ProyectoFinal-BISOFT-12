package cr.ac.ucenfotec.bl.methodTemplate;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;

public class CaballoMovementComponent extends PieceMovementComponent {
    public CaballoMovementComponent(int xInicial, int yInicial, int xFinal, int yFinal, Casilla[][] casillas, Cliente cliente) {
        super(xInicial, yInicial, xFinal, yFinal, casillas, cliente);
    }

    @Override
    protected boolean validarPieza() {
        boolean valido = true;

        if (piezaInicio.isColor() && ( (piezaFin != null) ? (piezaFin.isColor() ? true : false) : false)) {
            valido = false;
        }
        // Negro
        if (!piezaInicio.isColor() && ( (piezaFin != null) ? (!piezaFin.isColor() ? true : false) : false)) {
            valido = false;
        }

        return valido;
    }
}
