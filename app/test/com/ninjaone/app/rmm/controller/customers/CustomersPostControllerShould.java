package com.ninjaone.app.rmm.controller.customers;

import com.ninjaone.app.rmm.controller.RequestTestCase;
import com.ninjaone.shared.domain.MotherCreator;
import org.junit.jupiter.api.Test;

final class CustomersPostControllerShould extends RequestTestCase {
    @Test
    void create_a_valid_non_existing_customer() throws Exception {
        this.assertRequestWithBody(
            "POST",
            "/customers",
            String.format("{\"username\": \"%s\", \"password\": \"Test1234\"}", MotherCreator.random().funnyName().name()),
            201
        );
    }

    @Test
    void create_a_customer_with_invalid_password() throws Exception {
        String body = "{\"error_code\": \"customer_password_invalid\", \"message\": \"Password <some> doesn't meet criteria [8 chars min].\"}";
        this.assertRequestWithBody(
            "POST",
            "/customers",
            "{\"username\": \"haroldporto\", \"password\": \"some\"}",
            400,
            body
        );
    }
}
