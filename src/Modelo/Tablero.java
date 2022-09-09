package Modelo;

/**
 * 
 * 
 * @author bryam herna loja
 */

public class Tablero {

    private static Tablero tableroUnico = null; //se inicializa a tablero como nulo
                                                //segun las indicaciones del patron singleton
    private Casilla casillas[][];  //se obtiene un array de 3 por 3 de casillas que
                                   //almacenara fichas X o O, siendo en primera instancia
                                   //las casillas vacias y ficha en null de una casilla del array
    
    
    private Movimiento movimiento; //una referencia al movimiento para luego ser observado por la clase
                                   //VistaMovimiento por su objeto de referencia observarM
    
    private VistaMovimiento observarM; //observara los cambios sufridos del objeto movimiento en cada partida
                                       //de los jugadores, y desplegara un mensaje GANADOR o EMPATE segun sea
                                       //el caso

    //se inicializa las casillas.
    //se asigna a la referencia de la clase Movimiento para ser observado por una rederencia de la
    //clase VistaMovimiento observarM.
    private Tablero() {  
        casillas = new Casilla[3][3];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        movimiento = new Movimiento();
        observarM = new VistaMovimiento(movimiento);

    }

    /**
     * 
     * 
     * @return un objeto tablero unico para ser utilizado durante la partida
     *         se crea solo una vez cuando se inicia la aplicacion, segun el patron
     *          singleton demanda
     */
    public static Tablero getInstancia() {
        if (tableroUnico == null) {
            tableroUnico = new Tablero();
        }
        return tableroUnico;

    }


    //inicializa las casillas para ser utlizados nuevamente cuando el jugador 
    //desea jugar nuevamente
    public void inicializarCasillas() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                casillas[i][j].inicializarCasillas(); // llama al metodo de cada casillas
                                                      //para inicializar las fichas en null
                                                      //ya que el jugador es el otorga la ficha
                                                      //y la ficha no actua independientemente del
                                                      //jugador
            }
        }
    }

    /**
     * 
     * 
     * @return para averiguar si hay ganador despues del analisis de movimientos
     *         del objeto movimiento de la clase Movimiento creada en la clase Tablero
     */
    public boolean HayGanador() {
        return movimiento.getGanador();
    }
    
    /**
     * 
     * @return para averiguar si la partida llego a su fin con todas las 9 casillas
     *          llenas y no hay ganador
     */

    public boolean HayEmpate() {
        movimiento.HayEmpate(casillas); //se "envia" a las casillas para analizar el final de 
                                        //partida en caso no hay ganador y todas las casillas 
                                        //del array fueron llenadas
                                        
        return movimiento.getEmpate(); //luego se envia si verdaderamente al empate 
                                       //de las jugadas de los jugadores

    }
 
    //se juega nuevamente sea el caso de eleccion del jugador cuando se haya ganado o empatado
    //se procede a inicializar las casillas y igualmente con la referencia de movimiento
    //ya que no se puede crear otro objeto de Tablero, porque seria desperdicio de recursos
    //y mas conveniente es un tablero segun lo desea el jugador y finaliza cuando los
    //jugadores ya no desee jugar
    public void jugarDeNuevo() {
        this.inicializarCasillas(); 
        this.movimiento.inicializarMovimientos();
    }
    
/**
 * 
 * 
 * @return el idMov, se autogenera el id de cada movimiento  
 *          en los metodos de los analisis de movimientos
 *         de las casillas
 */
    public String dibujarLinea() {
        return movimiento.getidMovimiento();
    }
    
    /**
     * 
     * @param j1 se recibe al primer jugador para comparar con el segundo jugador cual de los dos gano
     * @param j2 se anaiza su ficha para descubrir la ficha ganadora deviuelta por 
     *           la referencia del objeto movimiento
     * @return 
     */

    public Jugador JugadorGanador(Jugador j1, Jugador j2) {

        Jugador jAux = null;  //se inicializa a un jugador para inicializarlo con el jugador ganador
        if (movimiento.getGanador()) {
            if (j1.getFicha().getMostrarTipoFicha() == movimiento.getFichaGanador()) {
                jAux = j1;
            } else {
                if (j2.getFicha().getMostrarTipoFicha() == movimiento.getFichaGanador()) {
                    jAux = j2;
                }
            }

        }
        return jAux; //se devuelve al jugador ganador que si o si debe ser uno de los dos jugadores
    }
    /**
     * 
     * 
     * @param jugador se recibe para analizar su jugada y si es valida se coloca en las casillas 
     *                 de tablero
     * @return      si es la posibilidad de que pueda mover, para luego colocar su ficha
     *              en las casillas de la clase Pantalla
     */

    public boolean datosDeJugada(Jugador jugador) {
        //SE VERIFICA SI HAY CASILLAS ANTES DE DAR PASE A GUARDAR LA FICHA
        boolean juega = false;    //se inicializa con false para saber que no pueda mover su ficha
        if (jugador.getTurno().getBoolTurno()) {
            boolean resp = movimiento.verificarJugada(jugador, casillas);
            if (!resp) {
                casillas[jugador.getJugada().getfila()][jugador.getJugada().getColumna()].setFicha(jugador.getFicha());
                movimiento.verificarMovimiento(casillas);
                juega = true; //se inicializa en true para haci verificar que puede mover en una
                              //de las casillas del paquete Modelo, para haci dar pase para que mueva
                              //en la clase Pantalla casillas de 3 pos 3 hecha de JLabels
            }
        }
        return juega;  
    }
    
    //DE ACA PARA ABAJO SON CLASES PARA EL CASO DE ENTRADA POR CONSOLA

    //METODO EMPEZAR PARTIDA POR CONSOLA
    /*
    public void comenzarPartida(Jugador j1, Jugador j2) {
        while (!(movimiento.getGanador() || movimiento.getEmpate())) {
            datosJugada(j1, j2);
        }
    }
     */
    //METODO LLENADO DE DATOS POR CONSOLA
    /*   
    public void datosJugada(Jugador j1, Jugador j2) {
        boolean seguir = false;
        Jugada jugada1 =new Jugada();
        do {
            System.out.println(j1.getNombre() + "   Ingrese fila:");
            int fila = entrada.nextInt();
            System.out.println(j1.getNombre() + "   Ingrese columna:");
            int columna = entrada.nextInt();
            jugada1.setJugada(fila, columna);
            j1.setJugada(jugada1);
            boolean resp = movimiento.verificarJugada(j1, casillas);
            if (resp) {
                System.out.println("ERROR:---HAY UNA FICHA---elija una ->fila --y ->columna");
            } else {
                seguir = true;
                casillas[j1.getJugada().getfila()][j1.getJugada().getColumna()].setFicha(j1.getFicha());
            }

        } while (!seguir);
        vizualizarTablero();
        movimiento.verificarMovimiento(casillas);
        if (movimiento.getGanador()) {

        } else {
            boolean continuar = false;
            do {
                System.out.println(j2.getNombre() + "   Ingrese fila:");
                int fila2 = entrada.nextInt();
                System.out.println(j2.getNombre() + "   Ingrese Columna:");
                int colum2 = entrada.nextInt();
                boolean resp = movimiento.verificarJugada(j2, casillas);
                if (resp) {
                    System.out.println("ERROR:---HAY UNA FICHA---elija una ->fila --y ->columna");
                } else {
                    continuar = true;
                    casillas[j2.getJugada().getfila()][j2.getJugada().getColumna()].setFicha(j2.getFicha());
                }
            } while (!continuar);
            movimiento.verificarMovimiento(casillas);
        }

    }
     */
    //METODO PARA VIZUALIZAR TABLERO MEDIANTE CONSOLA
    /*
    public void vizualizarTablero() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                System.out.print("|" + casillas[i][j].getTipoFicha() + "|");
            }
            System.out.println("\n");
        }
    }
     */
}
