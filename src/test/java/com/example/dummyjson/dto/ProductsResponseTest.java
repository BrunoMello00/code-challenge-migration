package com.example.dummyjson.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductsResponseTest {

    @Test
    void testGetAndSetter() {
        ProductsResponse response = new ProductsResponse();
        response.setProducts(List.of(new Product()));
        response.setTotal(100);
        response.setSkip(0);
        response.setLimit(10);

        assertEquals(1, response.getProducts().size());
        assertEquals(100, response.getTotal());
        assertEquals(0, response.getSkip());
        assertEquals(10, response.getLimit());
    }
}