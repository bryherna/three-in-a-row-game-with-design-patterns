package Modelo;
/**
 * 
 * @author bryam herna loja
 */
public abstract class FichasFactory {

    //crea la ficha segun el parametro recibido de tipo char X o O
    public abstract Fichas crearFicha(char tipo);
    //se evalua la ficha del jugador dos mediante la ficha elijida
    //por el jugador uno para construir la ficha el cual no elijio el jugador uno
    public abstract Fichas evaluarCrearFichaJugador2(Fichas ficha);

}
