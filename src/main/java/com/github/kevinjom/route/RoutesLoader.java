package com.github.kevinjom.route;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class RoutesLoader {
    private static final String ROUTES_CONFIG = "routes.json";

    private final ObjectMapper objectMapper;

    @Autowired
    public RoutesLoader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Route> load() throws IOException {
        return objectMapper.readValue(new ClassPathResource(ROUTES_CONFIG).getFile(), new TypeReference<List<Route>>() {
        });
    }
}
