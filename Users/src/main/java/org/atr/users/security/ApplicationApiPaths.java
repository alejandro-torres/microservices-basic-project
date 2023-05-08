package org.atr.users.security;

public enum ApplicationApiPaths {

    USER_MANAGER("/user/manager/**"),
    USER_VALIDATE("/user/validate/**")
    ;

    private final String path;

    ApplicationApiPaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
