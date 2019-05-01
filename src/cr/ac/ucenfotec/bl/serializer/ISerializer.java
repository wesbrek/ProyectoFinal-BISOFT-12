package cr.ac.ucenfotec.bl.serializer;

import cr.ac.ucenfotec.bl.Movimiento;

import java.util.ArrayList;

public interface ISerializer {
    String serialize(ArrayList<Movimiento> movimientos);

    ArrayList<Movimiento> deserialize(String partida);
}
