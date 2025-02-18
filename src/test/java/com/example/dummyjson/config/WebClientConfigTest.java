package com.example.dummyjson.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class WebClientConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testWebClientConfig() {
        WebClient.Builder webClientBuilder = applicationContext.getBean(WebClient.Builder.class);
        assertNotNull(webClientBuilder);
    }
}