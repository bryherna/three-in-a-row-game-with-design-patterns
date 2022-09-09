package Modelo;
/**
 * 
 * @author bryam herna loja
 */

public class JugadorBuilder implements IBuilderPersona {

    private Turno turno;   //turno que se recibira para crear el atributo del jugador
    private Jugada jugada;//jugada que se recibira para crear el atributo del jugador
    private Fichas ficha;//ficha que se recibira para crear el atributo del jugador
    private String nombre;//String nombre jugador que se recibira para crear el atributo del jugador

    public JugadorBuilder() {
    }
    /**
     * 
     * @param t se recibe el turno de jugador que tendra al inicio de la partida
     * @return a esta clase para crear al jugador por partes empezando por turno
     * en este caso
     */

    public JugadorBuilder withTurno(Turno t) {
        this.turno = t;
        return this;
    }
    /**
     * 
     * @param j se recibe el jugada de jugador que tendra al inicio de la partida
     * @return a esta clase para crear al jugador por partes empezando por jugada
     * en este caso
     */

    public JugadorBuilder withJugada(Jugada j) {
        this.jugada = j;
        return this;
    }
    /**
     * 
     * @param f se recibe fichas 'X' o 'O' de jugador que tendra al inicio de la partida
     * @return a esta clase para crear al jugador por partes empezando por fichas
     * en este caso
     */

    public JugadorBuilder withFicha(Fichas f) {
        this.ficha = f;
        return this;
    }
    /**
     * 
     * @param n se recibe nombre de tipo String de jugador que tendra al inicio de la partida
     * @return a esta clase para crear al jugador por partes empezando por nombre de tipo String
     * en este caso
     */

    public JugadorBuilder withNombre(String n) {
        this.nombre = n;
        return this;
    }
    /**
     * 
     * @return el jugador construido para ser utilizado en la partida
     */

    @Override
    public Jugador build() {
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setTurno(turno);
        jugador.setJugada(jugada);
        jugador.setFicha(ficha);
        return jugador;
    }

}
