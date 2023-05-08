package org.atr.users.security;



import com.google.common.collect.Sets;

import java.util.Set;
import static org.atr.users.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(API_READ,API_WRITE,API_EXECUTE)),
    USER(Sets.newHashSet(API_READ));

    private final Set<ApplicationUserPermission> permission;

    ApplicationUserRole(Set<ApplicationUserPermission> permission) {
        this.permission = permission;
    }

    public Set<ApplicationUserPermission> getPermission() {
        return permission;
    }
}
