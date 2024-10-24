package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.net.URI;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private WebClient.Builder webClientBuilder;

    @Mock
    private WebClient webClient;

    @Mock
    private RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private RequestHeadersSpec requestHeadersSpec;

    @Mock
    private ResponseSpec responseSpec;

    @BeforeEach
    public void setUp() {
        // Mockando o WebClient.Builder para garantir que ele não seja nulo
        when(webClientBuilder.build()).thenReturn(webClient);
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(any(URI.class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    public void testGetAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Product 1");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Product 2");

        Product[] products = {product1, product2};

        when(responseSpec.bodyToFlux(Product.class)).thenReturn(Flux.just(products));

        Flux<Product> result = productService.getAllProducts();

        result.collectList()
            .doOnNext(productList -> {
                assertEquals(2, productList.size());
                assertEquals("Product 1", productList.get(0).getTitle());
            })
            .subscribe();
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Product 1");

        when(responseSpec.bodyToMono(Product.class)).thenReturn(Mono.just(product));

        Mono<Product> result = productService.getProductById(1L);

        result.doOnNext(resultProduct -> assertEquals("Product 1", resultProduct.getTitle()))
              .subscribe();
    }
}
