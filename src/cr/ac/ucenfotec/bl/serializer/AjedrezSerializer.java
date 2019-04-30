package cr.ac.ucenfotec.bl.serializer;

import cr.ac.ucenfotec.bl.Movimiento;

import java.util.ArrayList;

public class AjedrezSerializer implements ISerializer{
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
            output.append(e.getMoveTo());
            output.append(" ");
            contador++;
        }
        return output.toString();
    }

    @Override
    public ArrayList<Movimiento> deserialize(String partida) {
        String[] temp = partida.split(" ");
        ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
        for (String e: temp) {
            if(!e.contains(".")) {
                movimientos.add(stringToMovimiento(e));
            }
        }

        return movimientos;
    }

    private Movimiento stringToMovimiento(String e) {
        String moveFrom = "";
        String moveTo = "";

        moveFrom = e.substring(1, 3);
        moveTo = e.substring(3, 5);

        return new Movimiento(moveFrom, moveTo);
    }
}
