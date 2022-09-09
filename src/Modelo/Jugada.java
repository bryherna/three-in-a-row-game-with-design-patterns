package Modelo;
/**
 * 
 * @author bryam herna loja
 */

public class Jugada {

    private int fila;  //fila para el cual el jugador establece donde mover su ficha
    private int columna;//columna para el cual el jugador establece donde mover su ficha

    //se inicializa fila en -1 y columna en -1 por defecto
    public Jugada() {
        this.fila = -1;
        this.columna = -1;

    }
    
    /**
     * 
     * @return la fila de la jugada del jugador
     */

    public int getfila() {
        return this.fila;
    }
    /**
     * 
     * @return la fila de la jugada del jugador
     */

    public int getColumna() {
        return this.columna;
    }
    /**
     * 
     * @param fila se setea la fila donde el cual el jugador elijio y se almacena
     *              en el atributo fila del jugador
     * @param columna se setea la columna donde el cual el jugador elijio y se almacena
     *              en el atributo columna del jugador
     */

    public void setJugada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    /**
     * 
     * @param fila se setea solo la fila
     */

    public void setFila(int fila) {
        this.fila = fila;
    }
    /**
     * 
     * @param columna se setea solo la columna
     */

    public void setColumna(int columna) {
        this.columna = columna;
    }

}
