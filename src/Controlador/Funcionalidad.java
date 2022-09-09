package Controlador;

import Modelo.Fichas;
import Modelo.FichasCreador;
import Modelo.FichasFactory;
import Modelo.Jugada;
import Modelo.Jugador;
import Modelo.JugadorBuilder;
import Modelo.PartidaFacade;
import Modelo.Turno;
import Vista.Pantalla;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.*;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
/**
 * 
 * @author bryam herna loja
 */

public class Funcionalidad implements ActionListener, MouseListener {

    private Pantalla vista;
    //USO DE CLASES DE PAQUETE MODELO
    private JugadorBuilder buildJugador;
    private FichasFactory factoriaFichas;
    private Jugador jugador1, jugador2;

    private PartidaFacade partidaFacade;

    public Funcionalidad(Pantalla vista) {
        this.vista = vista;
        buildJugador = new JugadorBuilder();
        factoriaFichas = new FichasCreador();
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        partidaFacade = new PartidaFacade();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();

        switch (opcion) {
            case "EMPEZAR":
                vista.datoJugadores.setVisible(true);

                break;

            case "GUARDAR":
                Fichas ficha = null;
                buildJugador.withNombre(vista.datoJugadores.txt_Nombrejugador1.getText().toUpperCase());
                ficha = factoriaFichas.crearFicha((char) vista.datoJugadores.cbx_fichas1.getSelectedItem());
                buildJugador.withFicha(ficha);
                buildJugador.withTurno(new Turno(true));
                buildJugador.withJugada(new Jugada());
                this.jugador1 = buildJugador.build();
                buildJugador.withNombre(vista.datoJugadores.txt_Nombrejugador2.getText().toUpperCase());
                buildJugador.withFicha(factoriaFichas.evaluarCrearFichaJugador2(ficha));
                buildJugador.withTurno(new Turno(false));
                buildJugador.withJugada(new Jugada());
                this.jugador2 = buildJugador.build();

                vista.datoJugadores.cbx_fichas2.setSelectedItem((char) jugador2.getFicha().getMostrarTipoFicha());

                //SE MUESTRA LOS DATOS POR CONSOLA DE LOS JUGADORES REGISTRADOS 
                //SI EN CASO DE DESEA SABER
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("NOMBRE JUGADOR *-1-* ->" + jugador1.getNombre());
                System.out.println("FICHA JUGADOR  *-1-* ->" + jugador1.getFicha().getMostrarTipoFicha());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("NOMBRE JUGADOR *-2-* ->" + jugador2.getNombre());
                System.out.println("FICHA JUGADOR  *-2-* ->" + jugador2.getFicha().getMostrarTipoFicha());

                //SE ESTABLECE A JUGADOR 1 COMO EL PRIMERO EN JUGAR
                vista.txtTurnoJugador.setText(jugador1.getNombre());
                vista.txtFichaJugador.setText(String.valueOf(jugador1.getFicha().getMostrarTipoFicha()));
                //CUANDO COMIENZE LA PARTIDA Y SE GUARDE LOS DATOS SE DESABILITA EL BOTON
                //EMPEZAR PARTIDA Y SE HABILITA EL BOTON TERMINAR PARA CERRAR LA APLICACION
                vista.btnEmpezarPartida.setEnabled(false);
                vista.btnTerminar.setEnabled(true);
                vista.datoJugadores.dispose();

                break;
            case "TERMINAR":
                //CON ESTA OPCION TERMINAR SE -
                //CIERRA LA APLICACION JUEGO TRES EN RAYA
                System.exit(0);
                break;
            case "JUGAR DE NUEVO":
                partidaFacade.jugarNuevamente();
                vista.btnTerminar.setEnabled(true);
                limpiarTableroVista();

                break;
        }

    }
    //se almacena las jugadas que un jugador dado elije, claro esta
    //debe ser el turno el cual presione la casilla de tipo JLabel
    //al iniciar la partida el primer jugador empezara primero
    private void jugadaCoordenadas(int fila, int columna) {
        jugador1.getJugada().setJugada(fila, columna);
        jugador2.getJugada().setJugada(fila, columna);

        boolean juegaJ1 = partidaFacade.tablero.datosDeJugada(jugador1);

        boolean juegaJ2 = partidaFacade.tablero.datosDeJugada(jugador2);

        if (juegaJ1) {
            vista.casillas[fila][columna].setText(String.valueOf(jugador1.getFicha().getMostrarTipoFicha()));
            jugador1.getTurno().setTurno(false);
            jugador2.getTurno().setTurno(true);
        }
        if (juegaJ2) {
            vista.casillas[fila][columna].setText(String.valueOf(jugador2.getFicha().getMostrarTipoFicha()));
            jugador2.getTurno().setTurno(false);
            jugador1.getTurno().setTurno(true);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        

        if (e.getButton() == BUTTON1) {

            if (e.getSource() == vista.casillas[0][0]) {
                jugadaCoordenadas(0, 0);

            }
            if (e.getSource() == vista.casillas[0][1]) {
                jugadaCoordenadas(0, 1);

            }
            if (e.getSource() == vista.casillas[0][2]) {
                jugadaCoordenadas(0, 2);

            }

            if (e.getSource() == vista.casillas[1][0]) {
                jugadaCoordenadas(1, 0);

            }
            if (e.getSource() == vista.casillas[1][1]) {
                jugadaCoordenadas(1, 1);

            }
            if (e.getSource() == vista.casillas[1][2]) {
                jugadaCoordenadas(1, 2);

            }
            if (e.getSource() == vista.casillas[2][0]) {
                jugadaCoordenadas(2, 0);

            }
            if (e.getSource() == vista.casillas[2][1]) {
                jugadaCoordenadas(2, 1);

            }
            if (e.getSource() == vista.casillas[2][2]) {
                jugadaCoordenadas(2, 2);

            }

        }
        //se almacena el nombre del jugador y su ficha en la pantalla para saber de 
        //quien es su turno, si no es su turno no aparecera en la parte derecha centro
        //de la pantalla del paquete VISTA

        if (jugador1.getTurno().getBoolTurno()) {
            vista.txtTurnoJugador.setText(jugador1.getNombre());
            vista.txtFichaJugador.setText(String.valueOf(jugador1.getFicha().getMostrarTipoFicha()));
        } else {
            if (jugador2.getTurno().getBoolTurno()) {
                vista.txtTurnoJugador.setText(jugador2.getNombre());
                vista.txtFichaJugador.setText(String.valueOf(jugador2.getFicha().getMostrarTipoFicha()));
            }
        }
        //SE DEFINE EL FINAL DEL JUEGO SI HAY GANADOR O EMPATE

        if (partidaFacade.tablero.HayGanador()) {
            dibujarLinea(partidaFacade.tablero.dibujarLinea()); //SEGUN EL ID DE MOVIMIENTO TRES EN RAYA 
            vista.btnJugarDeNuevo.setEnabled(true);
            //SE PROCEDE A RELLENAR SUS CASILLAS
            Jugador Jr = null;
            Jr = partidaFacade.tablero.JugadorGanador(jugador1, jugador2);

            JOptionPane.showMessageDialog(null, "__FELICITADES__"
                    + "NOMBRE->" + Jr.getNombre().toUpperCase() + "-----------"
                    + "FICHA->___" + Jr.getFicha().getMostrarTipoFicha() + "___");

        } else {
            if (partidaFacade.tablero.HayEmpate()) {
                JOptionPane.showMessageDialog(null, "--EMPATE--");
                vista.btnJugarDeNuevo.setEnabled(true);
            }
        }

    }

    public void dibujarLinea(String idMovimiento) {
        switch (idMovimiento) {
            //SE PROCEDE POR UN CODIGO GENERADO EN EL MODELO
            //A REALIZAR TRES EN RAYA AL GANADOR
            // MC1 = MOVIMIENTO EN COLUMNA 1
            // MC2 = MOVIMIENTO EN COLUMNA 2
            // MC3 = MOIMIENTO EN COLUMNA 3
            //LINEA EN MOVIMIENTO COLUMNAS
            case "MC1":
                vista.casillas[0][0].setBackground(Color.red);
                vista.casillas[1][0].setBackground(Color.red);
                vista.casillas[2][0].setBackground(Color.red);
                break;
            case "MC2":
                vista.casillas[0][1].setBackground(Color.red);
                vista.casillas[1][1].setBackground(Color.red);
                vista.casillas[2][1].setBackground(Color.red);

                break;
            case "MC3":
                vista.casillas[0][2].setBackground(Color.red);
                vista.casillas[1][2].setBackground(Color.red);
                vista.casillas[2][2].setBackground(Color.red);

                break;
            //LINEA EN MOVIMIENTO FILAS
            //SE RECUERDA QUE EL CODIGO DE LOS MOVIMIENTOS SE AUTOGENERA
            //EN EL MODELO MAS ESPECIFICO EN LA CLASE MOVIMIENTO
            // MF0= MOVIMIENTO FILA 0
            // MF1 =MOVIMIENTO FILA 1
            // MF2 = MOVIMIENTO FILA 2
            case "MF0":
                vista.casillas[0][0].setBackground(Color.red);
                vista.casillas[0][1].setBackground(Color.red);
                vista.casillas[0][2].setBackground(Color.red);

                break;
            case "MF1":
                vista.casillas[1][0].setBackground(Color.red);
                vista.casillas[1][1].setBackground(Color.red);
                vista.casillas[1][2].setBackground(Color.red);
                break;
            case "MF2":
                vista.casillas[2][0].setBackground(Color.red);
                vista.casillas[2][1].setBackground(Color.red);
                vista.casillas[2][2].setBackground(Color.red);
                break;
            //LINEA EN MOVIMIENTO DIAGONAL
            //MDI = MOVIMIENTO EN DIAGONAL IZQUIERDA "\"
            //MDD = MOVIMIENTO EN DIAGONAL DERECHA   "/"
            case "MDI":
                vista.casillas[0][0].setBackground(Color.red);
                vista.casillas[1][1].setBackground(Color.red);
                vista.casillas[2][2].setBackground(Color.red);
                break;
            case "MDD":
                vista.casillas[0][2].setBackground(Color.red);
                vista.casillas[1][1].setBackground(Color.red);
                vista.casillas[2][0].setBackground(Color.red);
                break;
        }

    }

    //limpia el tablero de casillas de tipo JLabel cuando
    //los jugadores desean jugar nuevamente
    private void limpiarTableroVista() {
        for (int i = 0; i < vista.casillas.length; i++) {
            for (int j = 0; j < vista.casillas[0].length; j++) {
                vista.casillas[i][j].setText(" ");
                vista.casillas[i][j].setBackground(Color.white);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
