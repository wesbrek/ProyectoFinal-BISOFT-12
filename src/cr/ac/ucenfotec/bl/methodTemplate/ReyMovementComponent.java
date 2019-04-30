package cr.ac.ucenfotec.bl.methodTemplate;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;

public class ReyMovementComponent extends PieceMovementComponent {
    public ReyMovementComponent(int xInicial, int yInicial, int xFinal, int yFinal, Casilla[][] casillas, Cliente cliente) {
        super(xInicial, yInicial, xFinal, yFinal, casillas, cliente);
    }

    @Override
    protected boolean validarPieza() {
        boolean valido =  true;

        // Blanco
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
