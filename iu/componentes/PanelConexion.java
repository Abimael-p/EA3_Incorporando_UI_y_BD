package EA3_Incorporando_IU_y_BD.iu.componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelConexion extends JPanel {

    private final BotonCircular botonDesconectar;

    public PanelConexion() {

        setLayout(new FlowLayout(FlowLayout.CENTER));

        botonDesconectar = new BotonCircular("Desconectar");

        botonDesconectar.setPreferredSize(new Dimension(150, 150));
        botonDesconectar.setFont(new Font("Arial", Font.BOLD, 16));
        botonDesconectar.setForeground(Color.BLACK);

        // Añadimos el botón
        add(botonDesconectar);
    }

    public void registrarAccionDesconectar(ActionListener accion) {
        botonDesconectar.addActionListener(accion);
    }
}
