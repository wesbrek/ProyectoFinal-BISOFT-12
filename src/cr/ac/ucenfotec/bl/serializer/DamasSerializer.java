package cr.ac.ucenfotec.bl.serializer;

import cr.ac.ucenfotec.bl.Movimiento;

import java.util.ArrayList;

public class DamasSerializer implements ISerializer {
    @Override
    public String serialize(ArrayList<Movimiento> movimientos) {
        StringBuilder output = new StringBuilder();
        int contador = 1;
        int jugada = 1;

        for (Movimiento e : movimientos) {
            if(contador % 2 != 0) {
                output.append(jugada++);
                output.append(". ");
            }
            output.append(e.getMoveFrom());
            output.append("-");
            output.append(e.getMoveTo());
            output.append(" ");
            contador++;
        }
        return output.toString();
    }
}
