package com.ninjaone.rmm.customers.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public final class Customer {
    private final CustomerId id;
    private final CustomerUserName username;
    private final CustomerPassword password;
    private final Set<Device> devices;

    public Customer(CustomerId id, CustomerUserName username, CustomerPassword password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.devices = new HashSet<>();
    }

    public Customer() {
        this.id = null;
        this.username = null;
        this.password = null;
        this.devices = new HashSet<>();
    }

    public void addOrUpdateDevice(Device device) {
        this.devices.add(device);
    }

    public Boolean hasDevices() {
        return devices.size() > 0;
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

    public Set<Device> devices() {
        return devices;
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
