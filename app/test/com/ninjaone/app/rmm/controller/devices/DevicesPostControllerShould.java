package com.ninjaone.app.rmm.controller.devices;

import com.ninjaone.app.rmm.controller.RequestTestCase;
import org.junit.jupiter.api.Test;

final class DevicesPostControllerShould extends RequestTestCase {
    @Test
    void create_a_valid_non_existing_device() throws Exception {
        this.assertRequestWithBody(
            "POST",
            "/devices",
            "{\"systemName\": \"Dell\", \"type\": \"Windows Workstation\"}",
            201
        );
    }
}
