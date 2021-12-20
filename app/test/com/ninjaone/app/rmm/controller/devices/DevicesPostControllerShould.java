package com.ninjaone.app.rmm.controller.devices;

import com.ninjaone.app.rmm.controller.RequestTestCase;
import org.junit.jupiter.api.Test;

final class DevicesPostControllerShould extends RequestTestCase {
    @Test
    void create_a_valid_non_existing_device() throws Exception {
        this.assertRequestWithBody(
            "POST",
            "/devices",
            "{\"systemName\": \"Dell\", \"type\": \"WINDOWS_WORKSTATION\"}",
            201
        );
    }

    @Test
    void create_a_device_with_invalid_type() throws Exception {
        String body = "{\"error_code\": \"device_type_invalid\", \"message\": \"The device type Whatever is invalid\"}";
        this.assertRequestWithBody(
            "POST",
            "/devices",
            "{\"systemName\": \"Dell\", \"type\": \"Whatever\"}",
            400,
            body
        );
    }
}
