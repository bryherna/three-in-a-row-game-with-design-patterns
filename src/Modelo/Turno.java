
package Modelo;
/**
 * 
 * 
 * @author bryam herna loja
 */

public class Turno {
    private boolean turno;  //atributo que fija si un jugador es su turno o del otro
                            //jugador
    
    /**
     * 
     * 
     * @param t significa que inicializara al atributo turno del jugador
     */
    public Turno(boolean t){
        this.turno=t;
    }
    /**
     * 
     * 
     * @param t fija el nuevo turno durante la partida cambia para el primer
     *          jugador o el segundo jugador
     */
    public void setTurno(boolean t){
        this.turno=t;
    }
    /**
     * 
     * 
     * @return el estado del turno actual del primer jugador o el segundo jugador
     */

    public boolean getBoolTurno(){
        return this.turno;
    }
    
}
