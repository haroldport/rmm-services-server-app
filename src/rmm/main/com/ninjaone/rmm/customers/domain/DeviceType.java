package com.ninjaone.rmm.customers.domain;

import java.util.HashMap;
import java.util.Objects;

public class DeviceType {
    private String value;

    private static final HashMap<String, String> types = new HashMap<String, String>() {{
        put("WINDOWS_WORKSTATION", "Windows Workstation");
        put("WINDOWS_SERVER", "Windows Server");
        put("MAC", "Mac");
    }};

    public DeviceType(String value) {
        ensureIsValidDeviceType(value);
        this.value = value;
    }

    public DeviceType() {
    }

    public String value() {
        return value;
    }

    public static HashMap<String, String> getValidDeviceTypes() {
        return types;
    }

    private void ensureIsValidDeviceType(String value) {
        if (!types.containsKey(value)) {
            throw new DeviceTypeInvalid(value);
        }
    }

    @Override
    public String toString() {
        return this.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeviceType)) {
            return false;
        }
        DeviceType that = (DeviceType) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
