package com.ninjaone.rmm.controller.devices;

import com.ninjaone.rmm.controller.RequestTestCase;
import org.junit.jupiter.api.Test;

public class DevicesPostControllerShould extends RequestTestCase {
    @Test
    void create_a_valid_device() throws Exception {
        assertRequestWithBody(
            "POST",
            "/devices",
            "{\"systemName\": \"Macbook Pro\", \"type\": \"Windows Workstation\"}",
            201
        );
    }
}
