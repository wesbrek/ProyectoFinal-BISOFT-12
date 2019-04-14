package cr.ac.ucenfotec.bl;

import cr.ac.ucenfotec.bl.piezas.IPieza;
import cr.ac.ucenfotec.bl.piezas.TipoPieza;

import java.util.ArrayList;

public class PiezaFactory {

    private final CreadorPiezas creador;

    public PiezaFactory(CreadorPiezas creador){
        this.creador = creador;
    }

    public void crearPiezasAjedrez(){
        IPieza pieza;
        ArrayList<IPieza> piezas = new ArrayList<IPieza>();

        piezas.add(creador.construirPieza(TipoPieza.CABALLO, 1, 1));
    }
}
