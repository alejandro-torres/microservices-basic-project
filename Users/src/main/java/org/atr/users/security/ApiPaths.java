package org.atr.users.security;

public enum ApiPaths {

    USER_MANAGER_CREATE("/user/manager/create/**"),
    USER_MANAGER_READ("/user/manager/read/**"),
    USER_MANAGER_UPDATE("/user/manager/update/**"),
    USER_MANAGER_DELETE("/user/manager/delete/**"),
    USER_VALIDATE("/user/validate/**")
    ;

    private final String path;

    ApiPaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
