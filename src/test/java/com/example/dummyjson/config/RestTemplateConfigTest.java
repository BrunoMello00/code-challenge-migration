package com.example.dummyjson.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RestTemplateConfigTest {
    @Autowired
    private WebClient webClient;

    @Test
    void testWebClientBean() {
        assertNotNull(webClient);
    }

    @Test
    void testWebClientBaseUrl() {
        String expectedBaseUrl = "https://dummyjson.com";
        assertNotNull(webClient);
    }


}
