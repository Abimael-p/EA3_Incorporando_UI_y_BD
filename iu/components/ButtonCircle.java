package EA3_Incorporando_UI_y_BD.iu.components;

import javax.swing.*;
import java.awt.*;

public class ButtonCircle extends JButton {

    public ButtonCircle(String texto) {
        super(texto);

        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        // Habilitar el suavizado de bordes
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar el fondo circular del botón
        g2.setColor(getBackground());
        g2.fillOval(0, 0, getWidth(), getHeight());

        // Dibujar el texto del botón
        super.paintComponent(g);

        // Borde del botón
        g2.setColor(Color.GREEN);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(1, 1, getWidth() - 2, getHeight() - 2);
    }

    @Override
    public boolean contains(int x, int y) {
        int radio = Math.min(getWidth(), getHeight()) / 2;

        double distancia = Math.pow(x - getWidth() / 2.0, 2)
                + Math.pow(y - getHeight() / 2.0, 2);

        return distancia <= Math.pow(radio, 2);
    }
}