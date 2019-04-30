package cr.ac.ucenfotec.bl.methodTemplate;

import cr.ac.ucenfotec.bl.Casilla;
import cr.ac.ucenfotec.bl.Cliente;

public class ReinaMovementComponent extends PieceMovementComponent {
    public ReinaMovementComponent(int xInicial, int yInicial, int xFinal, int yFinal, Casilla[][] casillas, Cliente cliente) {
        super(xInicial, yInicial, xFinal, yFinal, casillas, cliente);
    }

    @Override
    protected boolean validarPieza() {
        boolean valido = true;

        if (piezaInicio.isColor()) {
            // Arriba
            if (xInicial == xFinal && yFinal > yInicial) {
                for (int i = (yInicial+1); i <= yFinal; i++) {
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
                for (int i = (yInicial-1); i >= yFinal; i--) {
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
                for (int i = (xInicial+1); i <= xFinal; i++) {
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
                for (int i = (xInicial-1); i >= xFinal; i--) {
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
                for (int i = (yInicial+1); i <= yFinal; i++) {
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
                for (int i = (yInicial-1); i >= yFinal; i--) {
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
                for (int i = (xInicial+1); i <= xFinal; i++) {
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
                for (int i = (xInicial-1); i >= xFinal; i--) {
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

        // Blanco
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
