
package Modelo;
/**
 * 
 * @author bryam herna loja
 */

public class Ficha_X extends Fichas{
    public final char FICHA_X = 'X'; //definido como la ficha X
    
    Ficha_X(){}
    
    /**
     * 
     * @return esta ficha para se utilizado durante toda la partida
     */
    @Override
    public char getMostrarTipoFicha() {
        return this.FICHA_X;
    }
    
}
