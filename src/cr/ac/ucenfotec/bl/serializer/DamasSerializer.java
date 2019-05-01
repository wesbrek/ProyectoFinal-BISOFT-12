package cr.ac.ucenfotec.bl.serializer;

import cr.ac.ucenfotec.bl.Movimiento;
import cr.ac.ucenfotec.bl.tablero.PosicionTablero;

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
        String[] temp = e.split("-");
        String moveFrom = "";
        String moveTo = "";

        moveFrom = temp[0];
        int from = Integer.parseInt(moveFrom);
        moveFrom = casillaToMovimiento(from);

        moveTo = temp[1];
        int to = Integer.parseInt(moveTo);
        moveTo = casillaToMovimiento(to);

        return new Movimiento(moveFrom, moveTo);
    }

    public String casillaToMovimiento(int casilla){
        String output = "";

        if((casilla%10)-1 != -1) {
            output += PosicionTablero.values()[(casilla % 10) - 1];
            output += (casilla / 10) + 1;
        }
        else {
            output += PosicionTablero.values()[9];
            output += (casilla / 10);
        }

        return output;
    }
}
