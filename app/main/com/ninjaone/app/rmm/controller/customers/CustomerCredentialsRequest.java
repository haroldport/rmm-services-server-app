package com.ninjaone.app.rmm.controller.customers;

public final class CustomerCredentialsRequest {
    private String username;
    private String password;

    String username() {
        return username;
    }

    String password() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
