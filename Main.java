package EA3_Incorporando_UI_y_BD;

import javax.swing.SwingUtilities;
import EA3_Incorporando_UI_y_BD.iu.ConexionTester;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConexionTester().mostrar());
    }
}
