package cr.ac.ucenfotec.bl.methodTemplate;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;

public class PeonMovementComponent extends PieceMovementComponent {
    public PeonMovementComponent(int xInicial, int yInicial, int xFinal, int yFinal, Casilla[][] casillas, Cliente cliente) {
        super(xInicial, yInicial, xFinal, yFinal, casillas, cliente);
    }

    @Override
    protected boolean validarPieza() {
        boolean valido = true;

        if (piezaInicio.isColor() && xInicial != xFinal && ( (piezaFin == null) ? true : (piezaFin.isColor()) ? true : false) ) {
            valido = false;
        }
        // Blanco - Frente
        if (piezaInicio.isColor() && (xInicial == xFinal && yInicial != yFinal) && ( (piezaFin != null) ? true : false) ) {
            valido = false;
        }

        // Negro - Diagonal
        if (!piezaInicio.isColor() && xInicial != xFinal && ( (piezaFin == null) ? true : (!piezaFin.isColor()) ? true : false) ) {
            valido = false;
        }
        // Negro - Frente
        if (!piezaInicio.isColor() && (xInicial == xFinal && yInicial != yFinal) && ( (piezaFin != null) ? true : false) ) {
            valido = false;
        }
        return valido;
    }
}
