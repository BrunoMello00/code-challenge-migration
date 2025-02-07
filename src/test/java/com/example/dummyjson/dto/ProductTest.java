package com.example.dummyjson.dto;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {

    @Test
    void testGetAndSetter() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Test Product");
        product.setDescription("Test Description");
        product.setPrice(99.99);
        product.setCategory("Test Category");

        assertEquals(1L, product.getId());
        assertEquals("Test Product", product.getTitle());
        assertEquals("Test Description", product.getDescription());
        assertEquals(99.99, product.getPrice());
        assertEquals("Test Category", product.getCategory());
    }
}
