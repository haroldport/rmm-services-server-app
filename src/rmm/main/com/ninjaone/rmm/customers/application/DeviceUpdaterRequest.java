package com.ninjaone.rmm.customers.application;

import java.util.Optional;

public final class DeviceUpdaterRequest {

    private final String id;
    private final Optional<String> systemName;
    private final Optional<String> type;

    public DeviceUpdaterRequest(String id, Optional<String> systemName, Optional<String> type) {
        this.id = id;
        this.systemName = systemName;
        this.type = type;
    }

    public String id() {
        return id;
    }

    public Optional<String> systemName() {
        return systemName;
    }

    public Optional<String> type() {
        return type;
    }
}
