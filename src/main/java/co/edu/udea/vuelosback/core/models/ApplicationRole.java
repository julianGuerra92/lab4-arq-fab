package co.edu.udea.vuelosback.core.models;

public enum ApplicationRole {
    ADMIN("ADMIN"),
    USER("USER"),
    INVITED("INVITED");

    private final String rol;

    ApplicationRole(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public static ApplicationRole fromString(String rol) {
        for (ApplicationRole role : ApplicationRole.values()) {
            if (role.getRol().equalsIgnoreCase(rol)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Rol no válido: " + rol + ". Los roles permitidos son ADMIN y USER.");
    }
}
