package EA3_Incorporando_UI_y_BD.iu;

import javax.swing.*;
import java.awt.*; 
import EA3_Incorporando_UI_y_BD.iu.components.JPanelForm;

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
        JLabel lblTitulo = new JLabel("Configuracion de la conexión", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(lblTitulo, BorderLayout.NORTH);

        //añadimos el componete JPanel al JFrame
        JPanelForm panelForm = new JPanelForm();
        add(panelForm, BorderLayout.CENTER);
    }

}