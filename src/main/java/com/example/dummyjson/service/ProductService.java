package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProductService {

    private static final String BASE_URL = "https://dummyjson.com/products";

    private final WebClient webClient;

    @Autowired
    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    public List<Product> getAllProducts() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList()
                .block();
    }

    public Product getProductById(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }
}
