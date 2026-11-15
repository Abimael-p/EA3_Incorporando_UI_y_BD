package EA3_Incorporando_UI_y_BD.iu;

import EA3_Incorporando_UI_y_BD.iu.components.JPanelConection;
import EA3_Incorporando_UI_y_BD.iu.components.JPanelForm;
import EA3_Incorporando_UI_y_BD.iu.components.JPanelResultado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JFrameMain extends JFrame {
    private static final String FORMULARIO = "formulario";
    private static final String PANEL_CONEXION = "panelConexion";

    private final CardLayout vistas = new CardLayout();
    private final JPanel panelCentral = new JPanel(vistas);
    private final JPanelForm formulario = new JPanelForm();
    private final JPanelConection panelConexion = new JPanelConection();
    private final JPanelResultado resultado = new JPanelResultado();

    public JFrameMain() {
        setTitle("Vista de conexión");
        setSize(600, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Conexión a la base de datos", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(lblTitulo, BorderLayout.NORTH);

        panelCentral.add(formulario, FORMULARIO);
        panelCentral.add(panelConexion, PANEL_CONEXION);
        add(panelCentral, BorderLayout.CENTER);

        add(resultado, BorderLayout.SOUTH);
    }

    JPanelForm getFormulario() {
        return formulario;
    }

    JPanelResultado getResultado() {
        return resultado;
    }

    void addDesconectarListener(ActionListener listener) {
        panelConexion.addDesconectarListener(listener);
    }

    void mostrarPanelConexion() {
        vistas.show(panelCentral, PANEL_CONEXION);
    }

    void mostrarFormulario() {
        resultado.limpiar();
        vistas.show(panelCentral, FORMULARIO);
    }
}
