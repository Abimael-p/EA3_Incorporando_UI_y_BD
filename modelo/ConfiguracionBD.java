package modelo;

/**
 * Modelo inmutable con los parámetros de conexión ingresados en la interfaz.
 */
public record ConfiguracionBD(
        String url,
        String usuario,
        String contrasena
) {
    public boolean esSQLite() {
        return url != null && url.trim().toLowerCase().startsWith("jdbc:sqlite:");
    }
}