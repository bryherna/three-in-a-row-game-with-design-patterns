package Vista;

import java.awt.BorderLayout;
import javax.swing.*;
/**
 * 
 * @author bryam herna loja
 */

public class DatosJugadores extends JFrame {
    //LABELS

    private JPanel panelDatos;

    private JLabel labelNombre1;
    private JLabel labelNombre2;

    //LABEL FICHAS
    private JLabel labelFicha1;
    private JLabel labelFicha2;
    //TEXT FIELDS
    public JTextField txt_Nombrejugador1;
    public JTextField txt_Nombrejugador2;

    //BOTONES
    public JButton btn_guardar;

    //JCOMBOBOX
    public JComboBox cbx_fichas1;
    public JComboBox cbx_fichas2;

    public DatosJugadores() {
        setBounds(300, 20, 400, 200);
        setTitle("INGRESO DE DATOS DE LOS JUGADORES");

        panelDatos = new JPanel();

        

        //TEXT NOMBRES DE JUGADORES
        txt_Nombrejugador1 = new JTextField(15);
        txt_Nombrejugador2 = new JTextField(15);

        
        
        //COMBO BOX
        cbx_fichas1 = new JComboBox();
        cbx_fichas2 = new JComboBox();
        
        //LABELS
        labelFicha2 = new JLabel("Jugador 2 su ficha");
        labelFicha1 = new JLabel("Jugador 1 su ficha(elija):");
        labelNombre1 = new JLabel("Nombre Jugador 1:");
        labelNombre2 = new JLabel("Nombre Jugador 2:");
        //BOTON
        btn_guardar = new JButton("GUARDAR");
        
        cbx_fichas1.addItem('X');
        cbx_fichas1.addItem('O');
        
        cbx_fichas2.addItem('X');
        cbx_fichas2.addItem('O');
        cbx_fichas1.setSelectedIndex(0);
        cbx_fichas2.setEnabled(false);
        cbx_fichas2.setSelectedIndex(0);


        panelDatos.add(labelNombre1);
        panelDatos.add(txt_Nombrejugador1);
        panelDatos.add(labelNombre2);
        panelDatos.add(txt_Nombrejugador2);
        panelDatos.add(labelFicha1);
        panelDatos.add(cbx_fichas1);
        panelDatos.add(labelFicha2);
        panelDatos.add(cbx_fichas2);
        panelDatos.add(btn_guardar);

        add(panelDatos, BorderLayout.CENTER);

    }
}
