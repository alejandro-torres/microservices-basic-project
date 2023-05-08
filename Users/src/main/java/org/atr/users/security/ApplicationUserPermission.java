package org.atr.users.security;

public enum ApplicationUserPermission {
    API_READ("api:read"),
    API_WRITE("api:write"),
    API_EXECUTE("api:execute");

    private final String permission;
    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
