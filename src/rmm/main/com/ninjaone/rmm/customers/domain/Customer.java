package com.ninjaone.rmm.customers.domain;

import java.util.Objects;

public final class Customer {
    private final CustomerId id;
    private final CustomerUserName username;
    private final CustomerPassword password;

    public Customer(CustomerId id, CustomerUserName username, CustomerPassword password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Customer() {
        this.id = null;
        this.username = null;
        this.password = null;
    }

    public CustomerId id() {
        return id;
    }

    public CustomerUserName username() {
        return username;
    }

    public CustomerPassword password() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) && username.equals(customer.username) && password.equals(customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}
