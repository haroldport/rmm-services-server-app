package com.ninjaone.shared.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class Identifier {
    private final String value;

    public Identifier(String value) {
        ensureIsValidUUID(value);

        this.value = value;
    }

    private void ensureIsValidUUID(String value) {
        UUID.fromString(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
