package com.ninjaone.app.rmm.controller.util;

import com.ninjaone.rmm.services.application.ServiceResponse;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static HashMap<String, List<HashMap<String, Object>>> getServiceResponse(List<ServiceResponse> services) {
        return new HashMap<String, List<HashMap<String, Object>>>() {{
            put("data",
                services.stream().map(response -> new HashMap<String, Object>() {{
                    put("id", response.id());
                    put("name", response.name());
                    put("costs",
                        response.costs().stream().map(cost -> new HashMap<String, Object>() {{
                            put("platform", cost.platform());
                            put("price", cost.price());
                        }}).collect(Collectors.toList())
                    );
                }}).collect(Collectors.toList()));
        }};
    }
}
