package cr.ac.ucenfotec.bl;

public class Movimiento {
    private String inicio;
    private String fin;

    public Movimiento(String inicio, String fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return inicio + "-" + fin;
    }
}
