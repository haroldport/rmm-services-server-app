package com.ninjaone.rmm.devices.domain;

import java.util.Objects;

public final class Device {

    private final DeviceId id;
    private final DeviceSystemName systemName;
    private final DeviceType type;

    public Device(DeviceId id, DeviceSystemName systemName, DeviceType type) {
        this.id = id;
        this.systemName = systemName;
        this.type = type;
    }

    public Device() {
        id = null;
        systemName = null;
        type = null;
    }

    public DeviceId id() {
        return id;
    }

    public DeviceSystemName systemName() {
        return systemName;
    }

    public DeviceType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return id.equals(device.id) && systemName.equals(device.systemName) && type.equals(device.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, systemName, type);
    }
}
