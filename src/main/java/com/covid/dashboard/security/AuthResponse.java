package com.covid.dashboard.security;

public class AuthResponse {
    public String accessToken;
    public String tokenExpiryTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenExpiryTime() {
        return tokenExpiryTime;
    }

    public void setTokenExpiryTime(String tokenExpiryTime) {
        this.tokenExpiryTime = tokenExpiryTime;
    }
}
