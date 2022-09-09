package Modelo;
/**
 * 
 * @author bryam herna loja
 */

public class Casilla {

    private Fichas ficha;   //referencia a una ficha que tendra un casilla
    private char casillaVacia = ' ';//referencia para determinar que la casilla esa vacia

    //se inicializa cada casilla con una ficha en null
    public Casilla() {
        this.ficha = null;
    }
    /**
     * 
     * @return una ficha de una casilla elejida del array de casillas 3 por 3 
     */
    public Fichas getFicha() {
        return ficha;
    }
    //es un metodo prototipo tipo constructor casilla
    //para inicializar la ficha de cada casilla
    //cuando el jugador presione el boton comenzar de nuevo
    // y asi nos evitamos de crear nuevas casillas con NEW
    public void inicializarCasillas(){
        this.ficha=null;
    }
            
    /**
     * 
     * @param ficha  se recibe una ficha para almacenarlo en una casilla dada
     * elejida del array de casillas
     */
    public void setFicha(Fichas ficha) {
        this.ficha = ficha;
    }
    /**
     * 
     * @return una ficha si no esta inicializada en null
     * si esta en nulo la ficha se envia la casilla vacia
     */

    public char getTipoFicha() {

        if (ficha != null) {
            return ficha.getMostrarTipoFicha();
        } else {
            return this.casillaVacia;
        }

    }

}
