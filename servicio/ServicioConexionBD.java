package servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import modelo.ConfiguracionBD;
import modelo.ResultadoConexion;

/**
 * Servicio encargado de validar la conexión JDBC y gestionar el cierre seguro de recursos.
 */
public class ServicioConexionBD {

    /**
     * Valida la conexión a la base de datos usando try-with-resources.
     *
     * @param configuracion Datos ingresados por el usuario en la interfaz.
     * @return ResultadoConexion con el estado (verde/rojo) y el detalle técnico.
     */
    public ResultadoConexion probarConexion(ConfiguracionBD configuracion) {
        if (configuracion == null || configuracion.url() == null || configuracion.url().isBlank()) {
            return ResultadoConexion.error("La URL de conexión no puede estar vacía.");
        }

        String urlLimpia = configuracion.url().trim();

        try {
            // Verificación explícita del controlador para cumplir el requisito de ClassNotFoundException
            cargarControladorSegunUrl(urlLimpia);

            // Cierre automático garantizado (exitoso o con error) mediante try-with-resources
            try (Connection conexion = obtenerConexion(configuracion, urlLimpia)) {
                if (conexion != null && !conexion.isClosed()) {
                    String motor = conexion.getMetaData().getDatabaseProductName();
                    return ResultadoConexion.exito("Conectado correctamente a: " + motor);
                }
                return ResultadoConexion.error("No se pudo abrir una sesión activa con la base de datos.");
            }

        } catch (ClassNotFoundException excepcion) {
            return ResultadoConexion.error(
                    "Controlador JDBC no encontrado (" + excepcion.getMessage() + "). Verifica que el .jar esté en el proyecto."
            );
        } catch (SQLException excepcion) {
            return ResultadoConexion.error(excepcion.getMessage());
        }
    }

    private void cargarControladorSegunUrl(String url) throws ClassNotFoundException {
        String urlMinuscula = url.toLowerCase();
        if (urlMinuscula.startsWith("jdbc:sqlite:")) {
            Class.forName("org.sqlite.JDBC");
        } else if (urlMinuscula.startsWith("jdbc:mysql:")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } else if (urlMinuscula.startsWith("jdbc:postgresql:")) {
            Class.forName("org.postgresql.Driver");
        }
    }

    private Connection obtenerConexion(ConfiguracionBD configuracion, String url) throws SQLException {
        boolean sinUsuario = configuracion.usuario() == null || configuracion.usuario().isBlank();
        if (configuracion.esSQLite() || sinUsuario) {
            return DriverManager.getConnection(url);
        }
        return DriverManager.getConnection(url, configuracion.usuario().trim(), configuracion.contrasena());
    }
}