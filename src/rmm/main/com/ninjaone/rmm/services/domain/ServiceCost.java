package com.ninjaone.rmm.services.domain;

import java.io.Serializable;
import java.util.Objects;

public final class ServiceCost implements Serializable {
    private String platform;
    private Double price;

    public ServiceCost(String platform, Double price) {
        this.platform = platform;
        this.price = price;
    }

    public ServiceCost() {
    }

    public String getPlatform() {
        return platform;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceCost that = (ServiceCost) o;
        return platform.equals(that.platform) && price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platform, price);
    }
}
