package com.paypal.user_service.dto;

public class SignUpRequest {
    private String name;
    private String email;
    private String password;
    private String adminkey;

    public SignUpRequest() {
    }

    public SignUpRequest(String name, String email, String password, String adminkey) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.adminkey = adminkey;
    }

    public String getAdminkey() {
        return adminkey;
    }

    public void setAdminkey(String adminkey) {
        this.adminkey = adminkey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
