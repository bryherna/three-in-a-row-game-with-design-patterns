package Modelo;
/**
 * 
 * 
 * @author bryam herna loja
 */


public class PartidaFacade {

    public Tablero tablero; //referencia al tablero


    public PartidaFacade() {
        tablero = Tablero.getInstancia(); //una instancia unica de la clase Tablero
    }
    
    
 
    public void jugarNuevamente() { //metodo que llama al metodo de tablero
                                    // que inicializa los objetos que intervienen
                                    //en una partida
        tablero.jugarDeNuevo();
    }
    
    
    
    
    
    
    
    
    

    /*
    METODO INICIAR PARTIDA POR CONSOLA presentacion 2do proyecto
    public void iniciarPartida() {
        presentacion();
         datosJugadores();
        tablero.comenzarPartida(j1, j2);
    }
     */
 /*
    METODO LLENADO DE DATOS POR CONSOLA presentacion 2do proyecto
    private void datosJugadores() {

        System.out.print("Ingrese nombre JUGADOR 1 ->");
        String nombre1 = entrada.next();

        elegirFicha();
        buildJugador.withNombre(nombre1);
        buildJugador.withFicha(ficha);
        this.j1 = buildJugador.build();

        //SE ATRIBUYE LOS MISMOS METODOS PARA CREAR POR EL PATRON
        //BUILDER AL JUGADOR 1, EL UNICO CAMBIO ES EL METODO
        //evaluarFichaJugador2(ficha) QUE VERIFICA LA FICHA
        //DEL JUGADOR 1 PARA ATRIBUIRLE LA SIGUIENTE FICHA
        //AL JUGADOR 2...
        System.out.print("Ingresar Nombre JUGADOR 2 ->");
        String nombre2 = entrada.next();

        buildJugador.withNombre(nombre2);
        buildJugador.withFicha(evaluarFichaJugador2(ficha));
        this.j2 = buildJugador.build();

    }
    
    
    METODO ELEGIR FICHA POR CONSOLA 2da presentacion del proyecto
    private void elegirFicha() {
        char tipoFicha = ' ';
        int op;
        do {
            System.out.println("ELIGE FICHA ");
            System.out.println("1. -> X ");
            System.out.println("2. -> O");
            op = entrada.nextInt();

        } while (op != 1 && op != 2);

        switch (op) {
            case 1:
                System.out.println("ELEGISTE LA FICHA ->" + "X");
                tipoFicha = 'X';
                break;
            case 2:
                System.out.println("ELEGISTE LA FICHA -> " + "O");
                tipoFicha = 'O';
                break;
            default:
                System.out.println("FICHA ELEGIDA INCORRECTA");
        }

        ficha = factoriaFichas.crearFicha(tipoFicha);
    }

    private Fichas evaluarFichaJugador2(Fichas ficha) {

        if (ficha.getMostrarTipoFicha() == 'X') {
            ficha = factoriaFichas.crearFicha('O');
        } else {
            if (ficha.getMostrarTipoFicha() == 'O') {
                ficha = factoriaFichas.crearFicha('X');
            }
        }
        return ficha;
    }

    private void presentacion() {
        System.out.println("*******************************-----VERSION: 2.0----");
        System.out.println("*************__________________*********************");
        System.out.println("***********||JUEGO TRES EN RAYA||********************");
        System.out.println("*************__________________********************");
        System.out.println("***************************************************");
        System.out.println("******************AUTOR: HERNA LOJA, BRYAM ALEXANDER");
    }
     */
}
