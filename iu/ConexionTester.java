package EA3_Incorporando_UI_y_BD.iu;

import EA3_Incorporando_UI_y_BD.iu.components.JPanelForm;
import EA3_Incorporando_UI_y_BD.iu.components.JPanelResultado;
import model.ConfiguracionBD;
import model.ResultadoConexion;
import service.ConexionBDService;

import javax.swing.SwingWorker;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class ConexionTester {
    private final ConexionBDService servicio = new ConexionBDService();
    private final JFrameMain ventana = new JFrameMain();
    private final JPanelForm formulario = ventana.getFormulario();
    private final JPanelResultado resultado = ventana.getResultado();

    public ConexionTester() {
        formulario.addProbarConexionListener(evento -> probarConexion());
        ventana.addDesconectarListener(evento -> ventana.mostrarFormulario());
    }

    public void mostrar() {
        ventana.setVisible(true);
    }

    private void probarConexion() {
        ConfiguracionBD configuracion = leerConfiguracion();
        formulario.setCamposHabilitados(false);
        resultado.mostrarPruebaEnCurso();

        new SwingWorker<ResultadoConexion, Void>() {
            @Override
            protected ResultadoConexion doInBackground() {
                return servicio.probarConexion(configuracion);
            }

            @Override
            protected void done() {
                try {
                    mostrarResultado(get());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    mostrarResultado(ResultadoConexion.error("Se interrumpió la prueba de conexión."));
                } catch (ExecutionException e) {
                    mostrarResultado(ResultadoConexion.error(e.getCause().toString()));
                } finally {
                    formulario.setCamposHabilitados(true);
                }
            }
        }.execute();
    }

    private ConfiguracionBD leerConfiguracion() {
        char[] password = formulario.getPassword();
        try {
            return new ConfiguracionBD(formulario.getUrl(), formulario.getUsuario(), new String(password));
        } finally {
            Arrays.fill(password, '\0');
        }
    }

    private void mostrarResultado(ResultadoConexion prueba) {
        String mensaje = prueba.mensajePrincipal();
        if (prueba.detalleTecnico() != null && !prueba.detalleTecnico().isBlank()) {
            mensaje += "\n" + prueba.detalleTecnico();
        }
        resultado.mostrarResultado(mensaje, prueba.exitosa());
        if (prueba.exitosa()) {
            formulario.limpiarPassword();
            ventana.mostrarPanelConexion();
        }
    }
}
