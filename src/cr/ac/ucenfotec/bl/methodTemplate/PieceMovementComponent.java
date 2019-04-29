package cr.ac.ucenfotec.bl.methodTemplate;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;
import cr.ac.ucenfotec.bl.piezas.IPieza;

public abstract class PieceMovementComponent {
    protected int xInicial, yInicial, xFinal, yFinal;
    protected IPieza piezaInicio, piezaFin;
    protected Cliente cliente;
    protected Casilla[][] casillas;

    public PieceMovementComponent(int xInicial, int yInicial, int xFinal, int yFinal, Casilla[][] casillas,
                                  Cliente cliente) {
        this.xInicial = xInicial;
        this.yInicial = yInicial;
        this.xFinal = xFinal;
        this.yFinal = yFinal;
        this.casillas = casillas;
        this.piezaInicio = casillas[xInicial][yInicial].getPieza();
        this.piezaFin = casillas[xFinal][yFinal].getPieza();
        this.cliente = cliente;
    }

    public final boolean moverPieza(){
        if (validarMovimiento()) {
            if (validarPieza())
                return true;
        }
        return false;
    }

    private final boolean validarMovimiento(){
        return piezaInicio.validarMovimiento(xInicial, yInicial, xFinal, yFinal, cliente);
    }
    protected abstract boolean validarPieza();
}
