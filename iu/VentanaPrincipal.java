package EA3_Incorporando_IU_y_BD.iu;

import EA3_Incorporando_IU_y_BD.iu.componentes.PanelConexion;
import EA3_Incorporando_IU_y_BD.iu.componentes.PanelFormulario;
import EA3_Incorporando_IU_y_BD.iu.componentes.PanelResultado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private static final String FORMULARIO = "formulario";
    private static final String PANEL_CONEXION = "panelConexion";

    private final CardLayout vistas = new CardLayout();
    private final JPanel panelCentral = new JPanel(vistas);
    private final PanelFormulario formulario = new PanelFormulario();
    private final PanelConexion panelConexion = new PanelConexion();
    private final PanelResultado resultado = new PanelResultado();

    public VentanaPrincipal() {
        setTitle("Vista de conexión");
        setSize(600, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        inicializarComponentes();
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());

        JLabel etiquetaTitulo = new JLabel("Conexión a la base de datos", JLabel.CENTER);
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaTitulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(etiquetaTitulo, BorderLayout.NORTH);

        panelCentral.add(formulario, FORMULARIO);
        panelCentral.add(panelConexion, PANEL_CONEXION);
        add(panelCentral, BorderLayout.CENTER);

        add(resultado, BorderLayout.SOUTH);
    }

    PanelFormulario obtenerFormulario() {
        return formulario;
    }

    PanelResultado obtenerResultado() {
        return resultado;
    }

    void registrarAccionDesconectar(ActionListener accion) {
        panelConexion.registrarAccionDesconectar(accion);
    }

    void mostrarPanelConexion() {
        vistas.show(panelCentral, PANEL_CONEXION);
    }

    void mostrarFormulario() {
        resultado.limpiar();
        vistas.show(panelCentral, FORMULARIO);
    }
}
