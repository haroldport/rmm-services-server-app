package com.ninjaone.rmm.devices.domain;

import java.util.Objects;

public final class Device {
    private final String id;
    private final String systemName;
    private final String type;

    public Device(String id, String systemName, String type) {
        this.id = id;
        this.systemName = systemName;
        this.type = type;
    }

    public String id() {
        return id;
    }

    public String systemName() {
        return systemName;
    }

    public String type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(id, device.id)
            && Objects.equals(systemName, device.systemName)
            && Objects.equals(type, device.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, systemName, type);
    }
}
