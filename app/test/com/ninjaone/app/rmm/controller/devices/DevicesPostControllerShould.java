package com.ninjaone.app.rmm.controller.devices;

import com.ninjaone.app.rmm.controller.RequestTestCase;
import org.junit.jupiter.api.Test;

public class DevicesPostControllerShould extends RequestTestCase {
    @Test
    void create_a_valid_device() throws Exception {
        assertRequestWithBody(
            "POST",
            "/devices",
            "{\"systemName\": \"Dell\", \"type\": \"Windows Workstation\"}",
            201
        );
    }
}
