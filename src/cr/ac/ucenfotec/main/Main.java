package cr.ac.ucenfotec.main;

import cr.ac.ucenfotec.bl.Jugador.JugadorBuilder;
import cr.ac.ucenfotec.bl.ajedrez.TableroAjedrez;
import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.PiezaFactory;
import cr.ac.ucenfotec.bl.piezas.TipoPieza;
import cr.ac.ucenfotec.bl.tablero.ITablero;
import cr.ac.ucenfotec.bl.tablero.TableroFactory;
import cr.ac.ucenfotec.bl.tablero.TipoJuego;
import cr.ac.ucenfotec.tl.Gestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
	static Gestor controller = new Gestor();
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	static ITablero tablero;
	public static void main(String[] args) throws IOException {

          registrarJugadores();
        //mostrarMenu();

































	/*	ITablero tablero = TableroFactory.getTablero(TipoJuego.AJEDREZ);
        //System.out.println(tablero.toString());

        ITablero builder = new TableroAjedrez.Builder()
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 0, 1, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 1, 1, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 2, 1, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 3, 1, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 4, 1, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 5, 1, ColorPieza.NEGRO))
                .build();

        System.out.println(tablero.toString());
        boolean move = tablero.moverPieza(tablero.getPieza(0, 1), 0, 2);
        if (!move) {
            System.out.println("[!] Posición inválida!");
        }
        System.out.println(tablero.toString());


        System.out.println(builder.toString());

        ITablero damas = TableroFactory.getTablero(TipoJuego.DAMAS);
        System.out.println(damas.toString());

        ITablero damasBuilder = new TableroAjedrez.Builder()
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 0, 6, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 1, 6, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 2, 6, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 3, 6, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 4, 6, ColorPieza.NEGRO))
                .withPiece(PiezaFactory.getPieza(TipoPieza.PEON, 5, 6, ColorPieza.NEGRO))
                .build();
        System.out.println(damasBuilder.toString());


        controller.addPlayers("Sergio", "123123", "Abby", "123");

        System.out.println(controller.nextTurn());
*/

	}

	public static void registrarJugadores() throws IOException {
	    out.println("Digite el nickname del primer jugador: ");
	    String nombre1 = in.readLine();
	    out.println("Digite la contrasenna del primer jugador");
	    String pass1 = in.readLine();
	    out.println("Digite el nickname del segundo jugador");
	    String nombre2 = in.readLine();
	    out.println("Digite la contrasenna del segundo jugador");
	    String pass2 = in.readLine();

	    controller.addPlayers(nombre1, pass1, nombre2, pass2);
	    validarJugadores();
    }


    public static void validarJugadores() throws IOException{
	    out.println("Bienvenido");
        boolean validarj1 = false;
        boolean validarj2 = false;
	    do{
            out.println("Digite la contrasenna del primer jugador");
            String valPass1 = in.readLine();

               validarj1 = controller.validarJugador(valPass1);
            if(validarj1 == false)
                out.println("Constrasenna incorrecta");

        }while (validarj1 == false);

        do {
            out.println("Digite la contrasenna del segundo jugador");
            String valPass2 = in.readLine();

               validarj2 = controller.validarJugador(valPass2);
            if(validarj2 == false)
                out.println("Contrasenna incorrecta");

        }while (validarj2 == false);

        if(validarj1 == true && validarj2 == true)
            mostrarMenu();
    }


    public static void mostrarMenu() throws IOException{
	    int opcion = -1;

	    do{

	        out.println("1. Ajedrez");
	        out.println("2. Damas");
	        out.println("3. Go");
	        out.println("0. Salir");
	        out.println("Seleccione un juego");
	        opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);
        }while (opcion != 0);
    }

    public static void procesarOpcion(int pOpcion) throws IOException{
	    switch (pOpcion){
            case 1:
                play(TipoJuego.AJEDREZ);
                break;
            case 2:
               play(TipoJuego.DAMAS);
                break;
            case 3:
                play(TipoJuego.GO);
                break;
            case 0:
                out.println("Gracias por usar la aplicación");
                System.exit(0);
                default:
                    out.println("Opcion incorrecta");
        }
    }

    public static void play(TipoJuego juego) throws IOException{
	    int opcion = -1;
	    do{
	        out.println("1. Jugar " + juego);
	        out.println("2. Reproducir partida");
	        out.println("0. Volver");
	        opcion = Integer.parseInt(in.readLine());
	        if(juego == TipoJuego.AJEDREZ){
                procesarOpcionJugar(opcion, juego);
            }else if(juego == TipoJuego.DAMAS){
                procesarOpcionJugar(opcion, juego);
            }else if(juego == TipoJuego.GO){
                procesarOpcionJugar(opcion, juego);
            }

        }while (opcion != 0);
    }



    public static void procesarOpcionJugar(int pOpcion, TipoJuego juego) throws IOException{
        switch (pOpcion) {
            case 1:
                if(juego == TipoJuego.AJEDREZ){
                    empezarAjerdrez();
                }else if(juego == TipoJuego.DAMAS){
                    empezarDamas();
                }else if(juego == TipoJuego.GO) {
                    empezarGo();
                }
                break;
            case 2:
                // reproducirJuego();
                break;
            case 0:
                controller.restartState();
                mostrarMenu();
                break;
            default:
                out.println("Opción incorrecta.");
        }
    }

    public static void empezarDamas() throws IOException{
        tablero = controller.getTablero(TipoJuego.DAMAS);
        System.out.println(tablero.toString());
        OpcionesJuego(TipoJuego.DAMAS);
    }


    public static void empezarAjerdrez() throws IOException{
	    tablero = controller.getTablero(TipoJuego.AJEDREZ);
        System.out.println(tablero.toString());
        OpcionesJuego(TipoJuego.AJEDREZ);
	}

    public static void empezarGo() throws IOException{
        tablero = controller.getTablero(TipoJuego.GO);
        System.out.println(tablero.toString());
        OpcionesJuego(TipoJuego.GO);
    }

    public static void OpcionesJuego(TipoJuego juego) throws IOException{
	    int opcion = -1;
	    do{
	        out.println("Turno del jugador: " + controller.nextTurn());
            out.println("1. Mover pieza");
            out.println("2. Rendirse");
            out.println("3. Reiniciar");
            out.println("0. Volver");
            out.println("Digite la opcion");
            opcion = Integer.parseInt(in.readLine());
            if(juego == TipoJuego.AJEDREZ){
                procesarOpcionJuego(opcion, juego);
            }else if(juego == TipoJuego.DAMAS){
                procesarOpcionJuego(opcion, juego);
            }else if(juego == TipoJuego.GO){
                procesarOpcionJuego(opcion, juego);
            }

        }while (opcion != 0);
    }

    public static void procesarOpcionJuego(int Popcion, TipoJuego juego) throws IOException{
	    switch (Popcion){
            case 1:
                moverPieza();
                break;
            case 2:
                // rendirse();
                break;
            case 3:
             //   reiniciarTablero();
                break;
            case 0:
                play(juego);
                break;
                default:
                    out.println("Opcion incorrecta");
        }
    }


    public static void moverPieza() throws IOException{
        boolean move = false;

        do{
            out.println("Digite la fila de la pieza que desea mover");
            int filaPieza = Integer.parseInt(in.readLine());
            out.println("Digite la columna de la pieza que desea mover");
            int columnaPieza = Integer.parseInt(in.readLine());
            out.println("Digite la fila donde desea moverse");
            int filaMover = Integer.parseInt(in.readLine());
            out.println("Digite la columna donde desea moverse");
            int columnaMover = Integer.parseInt(in.readLine());

            move = tablero.moverPieza(tablero.getPieza(0, 1), 0, 2);
            if (!move) {
                System.out.println("[!] Posición inválida!");
            }
            System.out.println(tablero.toString());
        }while(move == false);



    }


}
