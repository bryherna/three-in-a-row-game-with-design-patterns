
package Controlador;

import Vista.*;
/**
 * 
 * @author bryam herna loja
 */

public class run {

    public static void main(String[] args) {

        Pantalla pantalla = new Pantalla();
        Funcionalidad f = new Funcionalidad(pantalla);
        pantalla.conectarFuncionalidad(f);


    }

}
