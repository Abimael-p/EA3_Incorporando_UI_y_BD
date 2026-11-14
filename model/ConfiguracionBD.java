package model;

/**
 * Modelo inmutable con los parámetros de conexión ingresados en la UI.
 */
public record ConfiguracionBD(
        String url,
        String usuario,
        String password
) {
    public boolean esSQLite() {
        return url != null && url.trim().toLowerCase().startsWith("jdbc:sqlite:");
    }
}