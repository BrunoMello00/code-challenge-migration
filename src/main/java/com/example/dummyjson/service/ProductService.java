package com.example.dummyjson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dummyjson.dto.Product;

@Service
public class ProductService {

    // Migração do uso de RestTemplate para WebClient
    // URL base agora é configurável externamente, deixando mais fácil de configurar para diferentes ambientes.

    @Value("${dummyjson.api.url}")
    private String baseUrl;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Product> getAllProducts() {
        return webClientBuilder.build()
                .get()
                .uri(baseUrl)
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList()
                .block();
    }

    public Product getProductById(Long id) {
        return webClientBuilder.build()
                .get()
                .uri(baseUrl + "/" + id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }
}