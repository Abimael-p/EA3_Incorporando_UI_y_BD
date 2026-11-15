package EA3_Incorporando_IU_y_BD.iu.componentes;

import javax.swing.*;
import java.awt.*;

public class BotonCircular extends JButton {

    public BotonCircular(String texto) {
        super(texto);

        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics graficos) {
        Graphics2D graficos2D = (Graphics2D) graficos.create();
        // Habilitar el suavizado de bordes
        graficos2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar el fondo circular del botón
        graficos2D.setColor(getBackground());
        graficos2D.fillOval(0, 0, getWidth(), getHeight());

        // Dibujar el texto del botón
        super.paintComponent(graficos);

        // Borde del botón
        graficos2D.setColor(Color.GREEN);
        graficos2D.setStroke(new BasicStroke(2));
        graficos2D.drawOval(1, 1, getWidth() - 2, getHeight() - 2);
    }

    @Override
    public boolean contains(int x, int y) {
        int radio = Math.min(getWidth(), getHeight()) / 2;

        double distancia = Math.pow(x - getWidth() / 2.0, 2)
                + Math.pow(y - getHeight() / 2.0, 2);

        return distancia <= Math.pow(radio, 2);
    }
}