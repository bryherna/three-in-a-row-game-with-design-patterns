package Vista;

import Controlador.Funcionalidad;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
/**
 * 
 * @author bryam herna loja
 */

public class Pantalla extends JFrame {

    public DatosJugadores datoJugadores;

    //CONTENEDOR PRINCIPAL
    private JPanel contenedorGeneral;
    private JPanel contenedorTablero;
    private JPanel contenedorBotones;
    private JPanel contenedorLabels;
    //BOTONES
    public JButton btnEmpezarPartida;
    public JButton btnTerminar;
    
    public JButton btnJugarDeNuevo;
    //LABELS
    private JLabel labelTurno;
    private JLabel labelFicha;

    //TEXT FIELDS
    public JTextField txtTurnoJugador;
    public JTextField txtFichaJugador;

    //COMBOBOX
    private JComboBox cbx_fichasEli;

    //CASILLAS DE JLABELS
    public JLabel casillas[][];

    public Pantalla() {
        setBounds(300, 20, 400, 400);

        setTitle("JUEGO TRES EN RAYA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        datoJugadores = new DatosJugadores();

        contenedorGeneral = new JPanel();
        contenedorGeneral.setLayout(new GridLayout());
        

        contenedorTablero = new JPanel();
        
        contenedorBotones = new JPanel();
        contenedorLabels = new JPanel();
        contenedorBotones.setLayout(new BorderLayout()); 

        contenedorTablero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contenedorBotones.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contenedorGeneral.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contenedorLabels.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        contenedorTablero.setLayout(new GridLayout(3, 3, 3, 3));
        contenedorTablero.setOpaque(true);
        contenedorTablero.setBackground(Color.blue);

        //casiilas de tipo JLabel para ser utilizado por el array de casillas
        //del paquete modelo
        casillas = new JLabel[3][3];

        //se inicializa con todos los diseños y aspectos que tendra cada casilla
        //de tipo JLabel en el paquete Vista
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                casillas[i][j] = new JLabel("");
                casillas[i][j].setOpaque(true);
                casillas[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                casillas[i][j].setFont(new Font("arial", Font.PLAIN, 38));
                casillas[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                casillas[i][j].setBackground(Color.white);

                contenedorTablero.add(casillas[i][j]);
            }

        }
        

        //BOTONES
        btnEmpezarPartida = new JButton("Empezar Partida");
        btnTerminar = new JButton("Terminar");
        btnJugarDeNuevo= new JButton("Jugar De Nuevo");
        btnJugarDeNuevo.setEnabled(false);
        btnTerminar.setEnabled(false);


        //LABELS
        labelTurno = new JLabel("Turno:");
        labelFicha = new JLabel("Ficha:");
        //TXT FIELDS
        txtTurnoJugador = new JTextField(10);
        txtTurnoJugador.setEnabled(false);
        txtTurnoJugador.setFont(new Font("arial", Font.BOLD, 13));
        txtTurnoJugador.setHorizontalAlignment(SwingConstants.CENTER);
        txtFichaJugador = new JTextField(10);
        txtFichaJugador.setEnabled(false);
        txtFichaJugador.setFont(new Font("arial", Font.BOLD, 13));
        txtFichaJugador.setHorizontalAlignment(SwingConstants.CENTER);

        contenedorLabels.add(labelTurno);
        contenedorLabels.add(txtTurnoJugador);
        contenedorLabels.add(labelFicha);
        contenedorLabels.add(txtFichaJugador);
        contenedorLabels.add(btnJugarDeNuevo); 

        //AGREGAR A CONTENEDOR BOTONES
        contenedorBotones.add(btnEmpezarPartida, BorderLayout.NORTH);
        contenedorBotones.add(contenedorLabels, BorderLayout.CENTER);
        contenedorBotones.add(btnTerminar, BorderLayout.SOUTH);

        //contenedorBotones.add(labelFicha);
        contenedorGeneral.add(contenedorTablero);
        contenedorGeneral.add(contenedorBotones);
        getContentPane().add(contenedorGeneral);

        setVisible(true);

    }

    public void conectarFuncionalidad(Funcionalidad f) {
        //BOTONES
        btnEmpezarPartida.addActionListener(f);
        btnEmpezarPartida.setActionCommand("EMPEZAR");

        btnTerminar.addActionListener(f);
        btnTerminar.setActionCommand("TERMINAR");

        datoJugadores.btn_guardar.addActionListener(f);
        datoJugadores.btn_guardar.setActionCommand("GUARDAR");
        
        btnJugarDeNuevo.addActionListener(f);
        btnJugarDeNuevo.setActionCommand("JUGAR DE NUEVO");

        //a cada casilla de tipo JLabel se le atribuye un mouse listener
        //para cuando el jugador presione en una casilla de tipo JLabel
        //se pueda operar y guardar la ficha del jugador
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                casillas[i][j].addMouseListener(f);
            }
        }

    }

}
