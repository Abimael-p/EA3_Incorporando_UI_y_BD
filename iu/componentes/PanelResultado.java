package iu.componentes;

import javax.swing.*;
import java.awt.*;

public class PanelResultado extends JPanel {
    private static final Color VERDE = new Color(0, 112, 0);
    private static final Color ROJO = new Color(175, 0, 0);

    private final JTextArea texto = new JTextArea(3, 0);

    public PanelResultado() {
        super(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        texto.setEditable(false);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);

        add(new JLabel("Resultado de la conexión:"), BorderLayout.NORTH);
        add(new JScrollPane(texto), BorderLayout.CENTER);
    }

    public void mostrarPruebaEnCurso() {
        mostrarMensaje("Probando conexión…", UIManager.getColor("TextArea.foreground"));
    }

    public void mostrarResultado(String mensaje, boolean exitoso) {
        mostrarMensaje(mensaje, exitoso ? VERDE : ROJO);
    }

    public void limpiar() {
        texto.setText("");
    }

    private void mostrarMensaje(String mensaje, Color color) {
        texto.setForeground(color);
        texto.setText(mensaje);
        texto.setCaretPosition(0);
    }
}
