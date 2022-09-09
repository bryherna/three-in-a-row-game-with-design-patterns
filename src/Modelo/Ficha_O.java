package Modelo;
/**
 * 
 * @author bryam herna loja
 */

public class Ficha_O extends Fichas {

    public final char FICHA_O = 'O';//definido como la ficha O

    public Ficha_O() {
    }
    /**
     * 
     * @return esta ficha para se utilizado durante toda la partida
     */

    @Override
    public char getMostrarTipoFicha() {
        return this.FICHA_O;
    }

}
