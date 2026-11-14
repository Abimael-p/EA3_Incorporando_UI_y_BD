package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.ConfiguracionBD;
import model.ResultadoConexion;

/**
 * Servicio encargado de validar la conexión JDBC y gestionar el cierre seguro de recursos.
 */
public class ConexionBDService {

    /**
     * Valida la conexión a la base de datos usando try-with-resources.
     *
     * @param config Datos ingresados por el usuario en la interfaz.
     * @return ResultadoConexion con el estado (verde/rojo) y el detalle técnico.
     */
    public ResultadoConexion probarConexion(ConfiguracionBD config) {
        if (config == null || config.url() == null || config.url().isBlank()) {
            return ResultadoConexion.error("La URL de conexión no puede estar vacía.");
        }

        String urlLimpia = config.url().trim();

        try {
            // Verificación explícita del driver para cumplir el requisito de ClassNotFoundException
            cargarDriverSegunUrl(urlLimpia);

            // Cierre automático garantizado (exitoso o con error) mediante try-with-resources
            try (Connection conexion = obtenerConexion(config, urlLimpia)) {
                if (conexion != null && !conexion.isClosed()) {
                    String motor = conexion.getMetaData().getDatabaseProductName();
                    return ResultadoConexion.exito("Conectado correctamente a: " + motor);
                }
                return ResultadoConexion.error("No se pudo abrir una sesión activa con la base de datos.");
            }

        } catch (ClassNotFoundException e) {
            return ResultadoConexion.error(
                    "Driver JDBC no encontrado (" + e.getMessage() + "). Verifica que el .jar esté en el proyecto."
            );
        } catch (SQLException e) {
            return ResultadoConexion.error(e.getMessage());
        }
    }

    private void cargarDriverSegunUrl(String url) throws ClassNotFoundException {
        String urlMinuscula = url.toLowerCase();
        if (urlMinuscula.startsWith("jdbc:sqlite:")) {
            Class.forName("org.sqlite.JDBC");
        } else if (urlMinuscula.startsWith("jdbc:mysql:")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } else if (urlMinuscula.startsWith("jdbc:postgresql:")) {
            Class.forName("org.postgresql.Driver");
        }
    }

    private Connection obtenerConexion(ConfiguracionBD config, String url) throws SQLException {
        boolean sinUsuario = config.usuario() == null || config.usuario().isBlank();
        if (config.esSQLite() || sinUsuario) {
            return DriverManager.getConnection(url);
        }
        return DriverManager.getConnection(url, config.usuario().trim(), config.password());
    }
}