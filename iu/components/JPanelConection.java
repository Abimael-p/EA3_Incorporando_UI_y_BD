package EA3_Incorporando_UI_y_BD.iu.components;

import javax.swing.*;
import java.awt.*;

public class JPanelConection extends JPanel {

    private final ButtonCircle btnDesconected;

    public JPanelConection() {

        setLayout(new FlowLayout(FlowLayout.CENTER));

        btnDesconected = new ButtonCircle("Desconectar");

        btnDesconected.setPreferredSize(new Dimension(150, 150));
        btnDesconected.setFont(new Font("Arial", Font.BOLD, 16));
        btnDesconected.setForeground(Color.BLACK);

        // Añadimos el Button
        add(btnDesconected);
    }
}
