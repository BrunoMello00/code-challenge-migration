package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
public class ProductService {

    private String baseUrl = "https://dummyjson.com/products";

    @Autowired
    private WebClient.Builder webClientBuilder;

    public WebClient getWebClient() {
        return webClientBuilder.build();
    }

    public Flux<Product> getAllProducts() {
        URI uri = URI.create(baseUrl);
        return getWebClient()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Product.class);
    }

    public Mono<Product> getProductById(Long id) {
        URI uri = URI.create(baseUrl + "/" + id);
        return getWebClient()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Product.class);
    }
}
