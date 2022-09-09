package Modelo;
/**
 * 
 * @author bryam herna loja
 */

public class Jugador {

    //atrinutos de un jugador al comenzar la partida
    private String nombre; 
    private Turno turno; 
    private Jugada jugada;
    private Fichas ficha;

    public Jugador() { 
    }
    /**
     * 
     * @param nom recibe su nombre
     */

    public Jugador(String nom) {
        this.nombre = nom;
    }
    
    //-----SETERS DE JUGADOR-------
    /**
     * 
     * @param nombre se cambia su nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @param turno se cambia su turno
     */

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    /**
     * 
     * @param jugada se recibe una jugada de un jugador
     */

    public void setJugada(Jugada jugada) {
        this.jugada = jugada;
    }
    /**
     * 
     * @param ficha se recibe la ficha que el jugador tendra en toda la partida
     */

    public void setFicha(Fichas ficha) {
        this.ficha = ficha;
    }
    
    //------GETTERS DE JUGADOR-------
    /**
     * 
     * @return nombre de jugador
     */

    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @return turno de jugador
     */

    public Turno getTurno() {
        return turno;
    }
    /**
     * 
     * @return jugada de jugador
     */

    public Jugada getJugada() {
        return jugada;
    }
    /**
     * 
     * @return la ficha del jugador
     */

    public Fichas getFicha() {
        return ficha;
    }
    
    
    
    
    
    
    
    
    
    
    
}
