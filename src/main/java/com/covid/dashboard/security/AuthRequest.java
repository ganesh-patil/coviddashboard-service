package com.covid.dashboard.security;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class AuthRequest {

    @NotNull
    private String username;
    @NotNull
    private String password;
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
