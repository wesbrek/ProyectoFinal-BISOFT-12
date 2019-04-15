package cr.ac.ucenfotec.bl.piezas;

public enum ColorPieza {
    BLANCO(true),
    NEGRO(false);

    private boolean color;

    ColorPieza(boolean color) {
        this.color = color;
    }

    public boolean valueOf(){
        return this.color;
    }
}
