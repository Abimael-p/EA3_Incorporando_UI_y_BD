import javax.swing.SwingUtilities;
import iu.ConexionTester;

public class Principal {
    public static void main(String[] argumentos) {
        SwingUtilities.invokeLater(() -> new ConexionTester().mostrar());
    }
}
