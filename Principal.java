package EA3_Incorporando_IU_y_BD;

import javax.swing.SwingUtilities;
import EA3_Incorporando_IU_y_BD.iu.ConexionTester;

public class Principal {
    public static void main(String[] argumentos) {
        SwingUtilities.invokeLater(() -> new ConexionTester().mostrar());
    }
}
