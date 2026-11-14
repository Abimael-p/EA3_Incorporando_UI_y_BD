
package EA3_Incorporando_UI_y_BD.iu.components;

import javax.swing.*;
import java.awt.*;

public class JPanelForm extends JPanel {

    private final JTextField txtUrl;
    private final JTextField txtUser;
    private final JPasswordField txtPassword;
    private final JButton btnConnect;
    private final JLabel txtAreaResolver;

    public JPanelForm() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Panel del formulario
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));

        txtUrl = new JTextField();
        txtUser = new JTextField();
        txtPassword = new JPasswordField();
        btnConnect = new JButton("Probar Conexión");

        // Estilo visual del botón
        btnConnect.setBackground(new Color(41, 128, 185));
        btnConnect.setForeground(Color.WHITE);
        btnConnect.setFocusPainted(false);
        btnConnect.setFont(new Font("Arial", Font.BOLD, 12));
        btnConnect.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelForm.add(new JLabel("URL de la Base de Datos:"));
        panelForm.add(txtUrl);

        panelForm.add(new JLabel("Nombre de Usuario:"));
        panelForm.add(txtUser);

        panelForm.add(new JLabel("Contraseña:"));
        panelForm.add(txtPassword);

        panelForm.add(new JLabel(""));
        panelForm.add(btnConnect);

        add(panelForm, BorderLayout.NORTH);

        // Panel del área de resolución (Asi ban los mensajes por si un error ocurre)
        txtAreaResolver = new JLabel("Resultado de la conexión:");
        txtAreaResolver.setForeground(Color.BLUE);
        txtAreaResolver.setHorizontalAlignment(SwingConstants.CENTER);
        add(txtAreaResolver, BorderLayout.SOUTH);

    }

}
