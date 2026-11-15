package iu;

import iu.componentes.PanelFormulario;
import iu.componentes.PanelResultado;
import modelo.ConfiguracionBD;
import modelo.ResultadoConexion;
import servicio.ServicioConexionBD;

import javax.swing.SwingWorker;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class ConexionTester {
    private final ServicioConexionBD servicio = new ServicioConexionBD();
    private final VentanaPrincipal ventana = new VentanaPrincipal();
    private final PanelFormulario formulario = ventana.obtenerFormulario();
    private final PanelResultado resultado = ventana.obtenerResultado();

    public ConexionTester() {
        formulario.registrarAccionProbarConexion(evento -> probarConexion());
        ventana.registrarAccionDesconectar(evento -> ventana.mostrarFormulario());
    }

    public void mostrar() {
        ventana.setVisible(true);
    }

    private void probarConexion() {
        ConfiguracionBD configuracion = leerConfiguracion();
        formulario.habilitarCampos(false);
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
                } catch (InterruptedException excepcion) {
                    Thread.currentThread().interrupt();
                    mostrarResultado(ResultadoConexion.error("Se interrumpió la prueba de conexión."));
                } catch (ExecutionException excepcion) {
                    mostrarResultado(ResultadoConexion.error(excepcion.getCause().toString()));
                } finally {
                    formulario.habilitarCampos(true);
                }
            }
        }.execute();
    }

    private ConfiguracionBD leerConfiguracion() {
        char[] contrasena = formulario.obtenerContrasena();
        try {
            return new ConfiguracionBD(formulario.obtenerUrl(), formulario.obtenerUsuario(), new String(contrasena));
        } finally {
            Arrays.fill(contrasena, '\0');
        }
    }

    private void mostrarResultado(ResultadoConexion prueba) {
        String mensaje = prueba.mensajePrincipal();
        if (prueba.detalleTecnico() != null && !prueba.detalleTecnico().isBlank()) {
            mensaje += "\n" + prueba.detalleTecnico();
        }
        resultado.mostrarResultado(mensaje, prueba.exitosa());
        if (prueba.exitosa()) {
            formulario.limpiarContrasena();
            ventana.mostrarPanelConexion();
        }
    }
}
