package com.ninjaone.rmm.devices.domain;

import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public final class DeviceTypeMother {
    static Random R = new Random();

    public static DeviceType create(String value) {
        return new DeviceType(value);
    }

    public static DeviceType randomValidValues() {
        String randomValue = randomKey();
        return create(randomValue);
    }

    public static DeviceType randomInvalidValues() {
        return create(com.ninjaone.shared.domain.WordMother.random());
    }

    private static String randomKey() {
        HashMap<String, String> validDeviceTypes = DeviceType.getValidDeviceTypes();
        List<String> keys = new ArrayList<>(validDeviceTypes.keySet());
        return keys.get(R.nextInt(keys.size()));
    }
}
