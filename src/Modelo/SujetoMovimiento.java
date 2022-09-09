
package Modelo;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 
 * @author bryam herna loja
 */

public abstract class SujetoMovimiento {
    protected List<Iobservador> observadores=  //observadores que tendra la clase Movimiento
                                               
            new ArrayList<Iobservador>();
    
    /**
     * 
     * @param o se recibe un observador cuando Movimiento muestre un cambio en 
     *          el final de partida GANADOR o EMPATE
     */
    public void addObservador(Iobservador o){
        observadores.add(o);
    }
    /**
     * 
     * 
     * @param o se recibe un observador para no observar a un objeto de la clase
     *          Movimiento
     */
    public void remove(Iobservador o){
        observadores.remove(o);
    }

    //se notifica de los cambios ocurridos establecidos por la clase Movimiento
    public void notifica(){
        for(Iobservador observador:observadores)
            observador.actualiza();
    }
    
}
