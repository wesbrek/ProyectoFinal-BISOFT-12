package cr.ac.ucenfotec.bl.serializer;

import cr.ac.ucenfotec.bl.tablero.TipoJuego;

public class SerializerFactory {
    public static ISerializer getSerializer(TipoJuego tipo){
        switch (tipo){
            case AJEDREZ:
                return new AjedrezSerializer();
            case GO:
                return new GoSerializer();
            case DAMAS:
                return new DamasSerializer();
            default:
                throw new RuntimeException("Unknown option");
        }
    }
}
