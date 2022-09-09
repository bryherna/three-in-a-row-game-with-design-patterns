package Modelo;
/**
 * 
 * 
 * @author bryam herna loja
 */

public class VistaMovimiento implements Iobservador {

    protected Movimiento movimiento; // una referencia al objeto movimiento observable
    protected String texto = "";    //se inicializara con el final de la partida
                                    //GANADOR o EMPATE
    
    /**
     * 
     * 
     * @param m  recive a al objeto movimiento a observar si existe ganador o se empato
     */

    //se agrega sujeto movimiento para observarlo
    // y movimiento agrega a su observador
    public VistaMovimiento(Movimiento m) {
        this.movimiento = m;          
        movimiento.addObservador(this);
        actualizaTexto();
    }

    //se inicializa con el final de partida (GANADOR O EMPATE)
    public void actualizaTexto() {
        if (movimiento.getGanador()) {
            texto = "----FICHA GANADORA ---" + movimiento.getFichaGanador();
        } else {
            if (movimiento.getEmpate()) {
                texto = "EMPATE";
            }

        }

    }

    //metodo utilizado cuando se notifica a los observadores un cambio 
    //en el final de la partida GANADOR o EMPATE
    @Override
    public void actualiza() {
        actualizaTexto();    
        this.reImprimir();
    }
    
    //metodo que imprime en consola GANADOR -> ficha ganadora o EMPATE
    public void reImprimir() {
        System.out.println(texto);
    }

}
