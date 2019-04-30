package cr.ac.ucenfotec.bl;

public class Movimiento {
    private String moveFrom;
    private String moveTo;

    public Movimiento(String moveFrom, String moveTo) {
        this.moveFrom = moveFrom;
        this.moveTo = moveTo;
    }

    public String getMoveFrom() {
        return moveFrom;
    }

    public void setMoveFrom(String moveFrom) {
        this.moveFrom = moveFrom;
    }

    public String getMoveTo() {
        return moveTo;
    }

    public void setMoveTo(String moveTo) {
        this.moveTo = moveTo;
    }

    @Override
    public String toString() {
        return moveFrom + moveTo;
    }
}
