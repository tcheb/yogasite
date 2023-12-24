package com.sylviealiceyoga.app.auth.pojo;

public class AuthResponse {
    private String email;
    private String accessToken;
    private String status;

    public AuthResponse(String email, String accessToken) {
        this.email = email;
        this.accessToken = accessToken;
        this.status = "success";
    }

    public AuthResponse() { }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}