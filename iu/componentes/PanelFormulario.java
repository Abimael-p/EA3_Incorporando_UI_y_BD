package iu.componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelFormulario extends JPanel {

    private final JTextField campoUrl;
    private final JTextField campoUsuario;
    private final JPasswordField campoContrasena;
    private final JButton botonProbarConexion;

    public PanelFormulario() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Panel del formulario
        JPanel panelCampos = new JPanel(new GridLayout(4, 2, 10, 10));

        campoUrl = new JTextField();
        campoUsuario = new JTextField();
        campoContrasena = new JPasswordField();
        botonProbarConexion = new JButton("Probar conexión");

        // Estilo visual del botón
        botonProbarConexion.setBackground(new Color(41, 128, 185));
        botonProbarConexion.setFocusPainted(false);
        botonProbarConexion.setFont(new Font("Arial", Font.BOLD, 12));
        botonProbarConexion.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelCampos.add(new JLabel("URL de la Base de Datos:"));
        panelCampos.add(campoUrl);

        panelCampos.add(new JLabel("Nombre de Usuario:"));
        panelCampos.add(campoUsuario);

        panelCampos.add(new JLabel("Contraseña:"));
        panelCampos.add(campoContrasena);

        panelCampos.add(new JLabel(""));
        panelCampos.add(botonProbarConexion);

        add(panelCampos, BorderLayout.NORTH);
    }

    public void registrarAccionProbarConexion(ActionListener accion) {
        botonProbarConexion.addActionListener(accion);
    }

    public String obtenerUrl() {
        return campoUrl.getText();
    }

    public String obtenerUsuario() {
        return campoUsuario.getText();
    }

    public char[] obtenerContrasena() {
        return campoContrasena.getPassword();
    }

    public void habilitarCampos(boolean habilitados) {
        campoUrl.setEnabled(habilitados);
        campoUsuario.setEnabled(habilitados);
        campoContrasena.setEnabled(habilitados);
        botonProbarConexion.setEnabled(habilitados);
    }

    public void limpiarContrasena() {
        campoContrasena.setText("");
    }
}
