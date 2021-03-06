package com.ninjaone.rmm.customers.application;

public final class CreateCustomerRequest {
    private final String id;
    private final String username;
    private final String password;
    private final String encodedPassword;

    public CreateCustomerRequest(String id, String username, String password,
                                 String encodedPassword) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.encodedPassword = encodedPassword;
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

    public String encodedPassword() {
        return encodedPassword;
    }
}
