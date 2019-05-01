package cr.ac.ucenfotec.bl.methodTemplate;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;

public class AlfilMovementComponent extends PieceMovementComponent {
    public AlfilMovementComponent(int xInicial, int yInicial, int xFinal, int yFinal, Casilla[][] casillas, Cliente cliente) {
        super(xInicial, yInicial, xFinal, yFinal, casillas, cliente);
    }

    @Override
    protected boolean validarPieza() {
        boolean valido = true;

        if (piezaInicio.isColor()) {
            // Arriba-Izquierda
            if (xFinal < xInicial && yFinal > yInicial) {
                for (int i = (xInicial-1), j = (yInicial+1); i >= xFinal; i--, j++) {
                    if (casillas[i][j].getPieza() != null) {
                        if (casillas[i][j].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != xFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }

            // Arriba-Derecha
            if (xFinal > xInicial && yFinal > yInicial) {
                for (int i = (xInicial+1), j = (yInicial+1); i <= xFinal; i++, j++) {
                    if (casillas[i][j].getPieza() != null) {
                        if (casillas[i][j].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != xFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }

            // Abajo-Izquierda
            if (xFinal < xInicial && yFinal < yInicial) {
                for (int i = (xInicial-1), j = (yInicial-1); i >= xFinal; i--, j--) {
                    if (casillas[i][j].getPieza() != null) {
                        if (casillas[i][j].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != xFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }

            // Abajo-Derecha
            if (xFinal > xInicial && yFinal < yInicial) {
                for (int i = (xInicial+1), j = (yInicial-1); i <= xFinal; i++, j--) {
                    if (casillas[i][j].getPieza() != null) {
                        if (casillas[i][j].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != xFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }
        }

        // Negro
        if (!piezaInicio.isColor()) {
            // Arriba-Izquierda
            if (xFinal < xInicial && yFinal > yInicial) {
                for (int i = (xInicial-1), j = (yInicial+1); i >= xFinal; i--, j++) {
                    if (casillas[i][j].getPieza() != null) {
                        if (!casillas[i][j].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != xFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }

            // Arriba-Derecha
            if (xFinal > xInicial && yFinal > yInicial) {
                for (int i = (xInicial+1), j = (yInicial+1); i <= xFinal; i++, j++) {
                    if (casillas[i][j].getPieza() != null) {
                        if (!casillas[i][j].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != xFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }

            // Abajo-Izquierda
            if (xFinal < xInicial && yFinal < yInicial) {
                for (int i = (xInicial-1), j = (yInicial-1); i >= xFinal; i--, j--) {
                    if (casillas[i][j].getPieza() != null) {
                        if (!casillas[i][j].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != xFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }

            // Abajo-Derecha
            if (xFinal > xInicial && yFinal < yInicial) {
                for (int i = (xInicial+1), j = (yInicial-1); i <= xFinal; i++, j--) {
                    if (casillas[i][j].getPieza() != null) {
                        if (!casillas[i][j].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != xFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }
        }
        return valido;
    }
}
