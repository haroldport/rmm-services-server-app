package com.ninjaone.rmm.controller.health_check;

import com.ninjaone.rmm.controller.RequestTestCase;
import org.junit.jupiter.api.Test;

final class HealthCheckGetControllerShould extends RequestTestCase {
    @Test
    void check_health_check_is_working() throws Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }
}
