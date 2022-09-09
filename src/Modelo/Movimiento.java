package Modelo;

/**
 * 
 * 
 * @author bryam herna loja
 */
public class Movimiento extends SujetoMovimiento {

    private boolean ganador;   //se definira si hay ganador en el analisis del
                               //array de casillas enviada por la clase Tablero
    
    private boolean empate;   //se definira si hay empate en el analisis del
                               //array de casillas enviada por la clase Tablero
    
    private String idMovimiento; //almacenara un idMov autogenerado en el analisis 
                                   //de las casillas
    
    private char fichaGanadora;  //almacena la ficha ganadora, ya que en el proceso
                                //de analisis de las casillas se evalua el valor
                                //de la ficha que es de tipo char, es asi como se definio

    //se inicializa en el constructor de movimiento los atributos que intervendran 
    //en el proceso de analisis de las casillas de 3 por 3 .
    public Movimiento() {
        this.ganador = false;
        this.empate = false;
        idMovimiento = " ";
        fichaGanadora = ' ';
    }
    //inicializar un prototipo de constructor que inicializa sus atributos
    //esto es con el objetivo de cuando el jugador desea jugar de nuevo
    //en ves de crear nuevamente al objeto de la clase Movimiento
    //se inicializa sus atributos
    //pues durante toda la partida se mantendra solo un objeto de tipo
    //Movimiento.
    public void inicializarMovimientos() {
        this.ganador = false;
        this.empate = false;
        idMovimiento = " ";
        fichaGanadora = ' ';
    }
    
    //se define si un cambio en el final de partida
    //GANADOR o EMPATE se notifica a los observadores para 
    //desplegar a la ficha ganadora
    public void finalPartida(){
        if(this.empate || this.ganador){
         this.notifica();  //notifica a los observadores
        }
    }
    
    /**
     * 
     * 
     * @param ganador se recibe que cambia el valor de ganador a true
     *                 
     * @param f se recibe la ficha ganadora que se repitio tres veces o sea se
     *          logro tres en raya
     */
    public void setGanador(boolean ganador, char f) {
        this.ganador = ganador;
        this.fichaGanadora = f;
    }
    /**
     * 
     * @return el idmov autogeneredo que en el cual se logro tres en raya
     *          hay 8 tipos de movimientos que logran tres en raya
     *          tres verticales
     *          tres horizontales
     *          dos verticalmente
     */

    public String getidMovimiento() {
        return this.idMovimiento;
    }

    /**
     * 
     * @return la ficha ganadora sea 'X' o 'O'
     */
    public char getFichaGanador() {
        return this.fichaGanadora;
    }
    /**
     * 
     * @param empate se recibe que cambia el valor de empate a true
     */

    public void setEmpate(boolean empate) {
        this.empate = empate;
    }

    /**
     * 
     * @return el valor del atributo ganador de tipo boolean
     */
    public boolean getGanador() {
        return this.ganador;
    }
    /**
     * 
     * @return el valor del atributo empate de tipo boolean
     */

    public boolean getEmpate() {
        return this.empate;
    }
    /**
     * 
     * @param casillas se recibe las casillas para verificar 
     * si todas las casillas estan llenas y si el atributo ganador 
     * de movimiento sigue siendo falso; por lo tanto hay empate
     */

    public void HayEmpate(Casilla[][] casillas){
        int numJugadas=0;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                if(casillas[i][j].getTipoFicha() !=' '){
                    numJugadas++;
                }
            }
        }
        if((numJugadas==9)&&(this.ganador==false)){
            this.setEmpate(true);
            this.finalPartida();
        }
    }
    
    /**
     * 
     * @param jugador se recibe un jugador para verificar su jugada en una casillas
     *                que elijio por medio de mouse listener
     * @param casillas se recibe las casillas para verificar si hay una ficha en una
     *                  de las casillas con la jugada del jugador en una 
     *                 
     * @return 
     */
    public boolean verificarJugada(Jugador jugador, Casilla[][] casillas) {
        boolean hayFicha = false;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                if (casillas[jugador.getJugada().getfila()][jugador.getJugada().getColumna()].getTipoFicha() != ' ') {
                    hayFicha = true;

                }
            }
        }

        return hayFicha;

    }

    /**
     * 
     * @param casillas se recibe para repartirlo por todas los movimientos 
     *                  posibles del tablero tres en raya
     *                  para luego ser evaluadas
     */
    public void verificarMovimiento(Casilla[][] casillas) {
        movimientoEnFilas(casillas);
        movimientosEncolumnas(casillas);
        movimientosEnDiagonalI(casillas);
        movimientosEnDiagonalD(casillas);
    }
    
    /**
     * 
     * @param casillas se recibe para analizar las casillas en filas
     *                  para luego enviarlas en un array de tipo char
     *                  para saber si hay tres fichas iguales y por lo tanto
     *                  esa ficha es ganadora porque hizo tres en raya 
     */
    private void movimientoEnFilas(Casilla[][] casillas) {
        char matriz[] = new char[casillas.length];
        String idMov = "MF";
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                matriz[j] = casillas[i][j].getTipoFicha();
            }
            analizarValoresMatriz(matriz, (idMov + i));
        }

    }
    /**
     * 
     * @param casillas se recibe para analizar las casillas en columnas
     *                  para luego enviarlas en un array de tipo char
     *                  para saber si hay tres fichas iguales y por lo tanto
     *                  esa ficha es ganadora porque hizo tres en raya 
     * este metodo invierte los papeles de como actua las filas y columnas
     * en el tablero, el trabajo de las columnas sera la ser filas,
     * y la de filas su trabajo sera de ser las columnas.
     * 
     */

    private void movimientosEncolumnas(Casilla[][] casillas) {
        char matriz[] = new char[casillas.length];
        String idMov = "MC"; //MOVIMIENTO EN COLUMNAS
        int columna = 0, fila = 0;
        while ((columna + 1) != (casillas.length + 1)) {
            matriz[fila] = casillas[fila][columna].getTipoFicha();
            if ((fila + 1) == casillas.length) {
                fila = 0;
                columna++;
                analizarValoresMatriz(matriz, (idMov + columna));
                fila--;
            }
            fila++;
        }

    }
    /**
     * 
     * @param casillas se recibe para analizar las casillas en diagonal izquierda
     *                  para luego enviarlas en un array de tipo char
     *                  para saber si hay tres fichas iguales y por lo tanto
     *                  esa ficha es ganadora porque hizo tres en raya 
     */

    private void movimientosEnDiagonalI(Casilla[][] casillas) {
        char matriz[] = new char[casillas.length];
        String idMov = "MDI"; //MOVIMIENTO DIAGONAL IZQUIERDO

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                if (i == j) {
                    matriz[j] = casillas[i][j].getTipoFicha();
                    
                }
            }
        }
        analizarValoresMatriz(matriz, idMov);

    }
    /**
     * 
     * @param casillas se recibe para analizar las casillas en diagonal derecha
     *                  para luego enviarlas en un array de tipo char
     *                  para saber si hay tres fichas iguales y por lo tanto
     *                  esa ficha es ganadora porque hizo tres en raya 
     */

    private void movimientosEnDiagonalD(Casilla[][] casillas) {
        char matriz[] = new char[casillas.length];
        String idMov = "MDD";//MOVIMIENTO DIAGONAL DERECHO

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                if ((i + j) == 2) {
                    matriz[i] = casillas[i][j].getTipoFicha();
                }
            }
        }
        analizarValoresMatriz(matriz, idMov);

    }
    
    /**
     * 
     * @param matriz se recibe una matiz de tres valores de tipo char 
     *                para verificar si las tres fichas son iguales
     *                 y por lo tanto esa ficha es la ganadora
     * @param idMov se recibe el codigo del movimiento que envio tal matriz
     *              para luego almacenarlo en el atributo de esta clase
     *              en caso el array matriz hizo tres en raya.
     * en este metodo recae la responsabilidad de saber quien gano
     * los otros movimientos solo almacenan los movimientos y los envian
     *              
     */

    private void analizarValoresMatriz(char matriz[], String idMov) {
        String idM;
        idM = idMov; //SE GUARDA EL ID DE MOVIMIENTO QUE SE ANALIZARÁ -MDI
        boolean igual = false;
        int contCasillasVacias = 0;
        int contFicha = 0;
        char auxChar = ' ';
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] == ' ') {
                contCasillasVacias++;
            } else {
                contFicha++;
            }
        }
        if (contFicha == 3) {
            auxChar = matriz[0];
            for (int i = 1; i < matriz.length; i++) {
                if (matriz[i] == auxChar) {
                    auxChar = matriz[i];
                    igual = true;
                } else {
                    igual = false;
                    idMov = " ";  //SE INICIALIZA IDMOV EN CASO NO SEA EL MOVIMIENTO TRES EN RAYA
                    break;
                }
            }

        }
        //si en caso hay tres fichas iguales en la matriz enviada por uno de los tipos
        //de movimiento, es el ganador y se almacena el idMov del movimiento que envio
        //la matriz que tuvo tres fichas iguales
        if (igual && (auxChar != ' ')) {
            this.idMovimiento = idM;
            setGanador(true, auxChar); //SE CAMBIA A TRUE JUGADOR GANADOR   
            this.finalPartida();
        }
    }

}
