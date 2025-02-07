package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductsResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(properties = {
        "dummyjson.base-url=http://localhost:9091"
})
public class ProductServiceTest {

    private MockWebServer mockWebServer;

    @Autowired
    private ProductService productService;

    @BeforeEach
    void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start(9091);
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void testGetAllProducts() {
        String mockResponse = """
            {
                "products": [
                    {"id": 1, "title": "Produto 1"},
                    {"id": 2, "title": "Produto 2"}
                ],
                "total": 2,
                "skip": 0,
                "limit": 30
            }
            """;
        mockWebServer.enqueue(new MockResponse()
                .setBody(mockResponse)
                .addHeader("Content-Type", "application/json"));

        ProductsResponse response = productService.getAllProducts();

        assertNotNull(response);
        assertEquals(2, response.getProducts().size());
    }

    @Test
    void testGetProductById() {
        String mockResponse = """
            {"id": 1, "title": "Produto 1"}
            """;
        mockWebServer.enqueue(new MockResponse()
                .setBody(mockResponse)
                .addHeader("Content-Type", "application/json"));

        Product product = productService.getProductById(1L).block();

        assertNotNull(product);
        assertEquals("Produto 1", product.getTitle());
    }
}