package EA3_Incorporando_UI_y_BD;

import javax.swing.SwingUtilities;
import EA3_Incorporando_UI_y_BD.iu.JFrameMain;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JFrameMain().setVisible(true);
        });
    }
}