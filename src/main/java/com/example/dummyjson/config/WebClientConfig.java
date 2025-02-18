package com.example.dummyjson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

    /**
    Migração do uso de RestTemplate para WebClient, 
    que é mais adequado para aplicações reativas e assíncronas.
    */

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}