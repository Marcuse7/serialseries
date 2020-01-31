/**
 * Created by AEr on 30.01.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.config;

public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {

        return permission;
    }

}
