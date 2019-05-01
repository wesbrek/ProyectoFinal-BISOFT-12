package cr.ac.ucenfotec.bl.methodTemplate;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;

public class TorreMovementComponent extends PieceMovementComponent {
    public TorreMovementComponent(int xInicial, int yInicial, int xFinal, int yFinal, Casilla[][] casillas, Cliente cliente) {
        super(xInicial, yInicial, xFinal, yFinal, casillas, cliente);
    }

    @Override
    protected boolean validarPieza() {
        boolean valido = true;

        if (piezaInicio.isColor()) {
            // Arriba
            if (xInicial == xFinal && yFinal > yInicial) {
                for (int i = (yInicial+1); i < yFinal; i++) {
                    if (casillas[xFinal][i].getPieza() != null) {
                        if (!casillas[xFinal][i].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != yFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }

            // Abajo
            if (xInicial == xFinal && yFinal < yInicial) {
                for (int i = (yInicial-1); i > yFinal; i--) {
                    if (casillas[xFinal][i].getPieza() != null) {
                        if (!casillas[xFinal][i].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != yFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }

            // Derecha
            if (yInicial == yFinal && xFinal > xInicial) {
                for (int i = (xInicial+1); i < xFinal; i++) {
                    if (casillas[i][yFinal].getPieza() != null) {
                        if (!casillas[i][yFinal].getPieza().isColor()) {
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

            // Izquierda
            if (yInicial == yFinal && xFinal < xInicial) {
                for (int i = (xInicial-1); i > xFinal; i--) {
                    if (casillas[i][yFinal].getPieza() != null) {
                        if (!casillas[i][yFinal].getPieza().isColor()) {
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
            // Arriba
            if (xInicial == xFinal && yFinal > yInicial) {
                for (int i = (yInicial+1); i < yFinal; i++) {
                    if (casillas[xFinal][i].getPieza() != null) {
                        if (!casillas[xFinal][i].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != yFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }

            // Abajo
            if (xInicial == xFinal && yFinal < yInicial) {
                for (int i = (yInicial-1); i > yFinal; i--) {
                    if (casillas[xFinal][i].getPieza() != null) {
                        if (!casillas[xFinal][i].getPieza().isColor()) {
                            valido = false;
                            continue;
                        } else {
                            if (i != yFinal) {
                                valido = false;
                                continue;
                            }
                        }
                    }
                }
            }

            // Derecha
            if (yInicial == yFinal && xFinal > xInicial) {
                for (int i = (xInicial+1); i < xFinal; i++) {
                    if (casillas[i][yFinal].getPieza() != null) {
                        if (!casillas[i][yFinal].getPieza().isColor()) {
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

            // Izquierda
            if (yInicial == yFinal && xFinal < xInicial) {
                for (int i = (xInicial-1); i > xFinal; i--) {
                    if (casillas[i][yFinal].getPieza() != null) {
                        if (!casillas[i][yFinal].getPieza().isColor()) {
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
