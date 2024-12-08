package com.armughanahmed.ecommerce.ecommerce.controller;

import com.armughanahmed.ecommerce.ecommerce.domain.Product;
import com.armughanahmed.ecommerce.ecommerce.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {
    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product(1L, "Test Product", "Description", new BigDecimal("100.0"), 10);
        when(productService.createProduct(any(Product.class))).thenReturn(product);
        ResponseEntity<Product> response = productController.createProduct(product);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).createProduct(any(Product.class));
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = Arrays.asList(
                new Product(1L, "Product 1", "Description", new BigDecimal("100.0"), 10),
                new Product(2L, "Product 2", "Description", new BigDecimal("100.0"), 10)
        );

        when(productService.getAllProducts()).thenReturn(products);
        ResponseEntity<List<Product>> response = productController.getAllProducts();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void testGetProductById() {
        Product product = new Product(1L, "Product 1", "Description 1", new BigDecimal("100.0"), 5);

        when(productService.getProductById(1L)).thenReturn(product);
        ResponseEntity<Product> response = productController.getProductById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).getProductById(1L);
    }

    @Test
    void testUpdateProduct() {
        Product updatedProduct = new Product(1L, "Updated Product", "Updated Description", new BigDecimal("120.0"), 15);

        when(productService.updateProduct(eq(1L), any(Product.class))).thenReturn(updatedProduct);
        ResponseEntity<Product> response = productController.updateProduct(1L, updatedProduct);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProduct, response.getBody());
        verify(productService, times(1)).updateProduct(1L, updatedProduct);
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productService).deleteProduct(1L);
        ResponseEntity<Void> response = productController.deleteProduct(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(productService, times(1)).deleteProduct(1L);
    }
}
