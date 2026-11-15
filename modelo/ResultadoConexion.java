package modelo;

/**
 * Modelo inmutable que representa el resultado de validar la conexión JDBC.
 */
public record ResultadoConexion(
        boolean exitosa,
        String mensajePrincipal,
        String detalleTecnico
) {
    public static ResultadoConexion exito(String detalle) {
        return new ResultadoConexion(true, "Conexión exitosa", detalle);
    }

    public static ResultadoConexion error(String detalle) {
        return new ResultadoConexion(false, "Fallo de conexión", detalle);
    }
}