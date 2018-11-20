package com.formcontact.security;

public class AccountCredentials {

    private String username;
    private String password;

    AccountCredentials(){};

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
