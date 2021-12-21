package com.ninjaone.rmm.customers.application;

public final class CreateCustomerRequest {
    private final String id;
    private final String username;
    private final String password;

    public CreateCustomerRequest(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String id() {
        return id;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }
}
