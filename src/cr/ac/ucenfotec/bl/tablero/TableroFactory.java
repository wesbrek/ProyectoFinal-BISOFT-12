package cr.ac.ucenfotec.bl.tablero;

import cr.ac.ucenfotec.bl.ajedrez.TableroAjedrez;
import cr.ac.ucenfotec.bl.damas.TableroDamas;
import cr.ac.ucenfotec.bl.go.TableroGo;

public class TableroFactory {
    public static ITablero getTablero(TipoJuego tipo){
        switch (tipo){
            case AJEDREZ:
                return new TableroAjedrez();
            case GO:
                return new TableroGo();
            case DAMAS:
                return new TableroDamas();
            default:
                throw new RuntimeException("Error!");
        }
    }
}
