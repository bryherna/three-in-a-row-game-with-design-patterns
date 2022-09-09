package Modelo;

/**
 * 
 * @author bryam herna loja
 */
public class FichasCreador extends FichasFactory {

    Fichas ficha; //una referencia a una ficha para retornarlo segun la eleccion
                    //de un jugador dado

    /**
     * 
     * @param tipo se recibe la eleccion la ficha de tipo char de un jugador dado
     * @return la ficha creada para que la utilize el patron builder para crear al
     * jugador
     */
    @Override
    public Fichas crearFicha(char tipo) {
        if (tipo == 'X') {
            this.ficha = new Ficha_X();
        } else {
            if (tipo == 'O') {
                this.ficha = new Ficha_O();
            }
        }
        return ficha;

    }
    /**
     * 
     * @param ficha se recibe la ficha del jugador 1 para luego devolver la ficha
     *              que utilizara el jugador 2 en el resto de la partida
     * @return la ficha creada en base en la ficha elejida del primer jugador
     */

    @Override
    public Fichas evaluarCrearFichaJugador2(Fichas ficha) {
        if(ficha.getMostrarTipoFicha()=='X'){
            ficha=crearFicha('O');
        }else{
            if(ficha.getMostrarTipoFicha()=='O'){
                ficha=crearFicha('X');
                
            }
        }
        return ficha;
    }

}
