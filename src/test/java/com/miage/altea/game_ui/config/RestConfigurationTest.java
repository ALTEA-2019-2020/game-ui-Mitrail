package com.miage.altea.game_ui.config;

import org.junit.jupiter.api.Test;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

import static org.junit.jupiter.api.Assertions.*;

class RestConfigurationTest {

    @Test
    void restTemplate_shouldExist() {
        var restConfig = new RestConfiguration();
        restConfig.setUsername("User");
        restConfig.setPassword("Password");
        var restTemplate = restConfig.trainerApiRestTemplate();
        assertNotNull(restTemplate);
    }

    @Test
    void trainerApiRestTemplate_shouldHaveBasicAuth() {
        // add setters in restconf
        var restConfig = new RestConfiguration();
        restConfig.setPassword("user");
        restConfig.setUsername("password");
        var restTemplate = restConfig.trainerApiRestTemplate();

        assertNotNull(restTemplate);

        var interceptors = restTemplate.getInterceptors();
        assertNotNull(interceptors);
        assertEquals(1, interceptors.size());

        var interceptor = interceptors.get(0);
        assertNotNull(interceptor);

        assertEquals(BasicAuthenticationInterceptor.class, interceptor.getClass());
    }
}