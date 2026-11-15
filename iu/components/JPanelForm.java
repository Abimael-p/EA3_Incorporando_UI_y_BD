package EA3_Incorporando_UI_y_BD.iu.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPanelForm extends JPanel {

    private final JTextField txtUrl;
    private final JTextField txtUser;
    private final JPasswordField txtPassword;
    private final JButton btnConnect;

    public JPanelForm() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Panel del formulario
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));

        txtUrl = new JTextField();
        txtUser = new JTextField();
        txtPassword = new JPasswordField();
        btnConnect = new JButton("Probar conexión");

        // Estilo visual del botón
        btnConnect.setBackground(new Color(41, 128, 185));
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
    }

    public void addProbarConexionListener(ActionListener listener) {
        btnConnect.addActionListener(listener);
    }

    public String getUrl() {
        return txtUrl.getText();
    }

    public String getUsuario() {
        return txtUser.getText();
    }

    public char[] getPassword() {
        return txtPassword.getPassword();
    }

    public void setCamposHabilitados(boolean habilitados) {
        txtUrl.setEnabled(habilitados);
        txtUser.setEnabled(habilitados);
        txtPassword.setEnabled(habilitados);
        btnConnect.setEnabled(habilitados);
    }

    public void limpiarPassword() {
        txtPassword.setText("");
    }
}
