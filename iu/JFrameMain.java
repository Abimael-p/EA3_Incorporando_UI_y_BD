package EA3_Incorporando_UI_y_BD.iu;

import javax.swing.*;

import EA3_Incorporando_UI_y_BD.iu.components.JPanelConection;
import EA3_Incorporando_UI_y_BD.iu.components.JPanelForm;

import java.awt.*;

public class JFrameMain extends JFrame {
    
    public JFrameMain() {
        setTitle("Vista de conexión");
        setSize(600, 300);
        setDefaultCloseOperation(JFrameMain.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        //titulo superior
        JLabel lblTitulo = new JLabel("Conexión a la base de datos", JLabel.CENTER);
        //Añadimos cuando este conectado a la base de datos
        /*JLabel lblTitulo = new JLabel("Connectado con DB", JLabel.CENTER);*/
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(lblTitulo, BorderLayout.NORTH);

        //añadimos el componete JPanel al JFrame Cuando esta desconectado de la base de datos
        JPanelForm panelForm = new JPanelForm();
        add(panelForm, BorderLayout.CENTER);

        //añadimos el componete JPanelConection al JFrame si esta conectado a la base de datos
        /*JPanelConection panelConection = new JPanelConection();
        add(panelConection);*/
    }

}