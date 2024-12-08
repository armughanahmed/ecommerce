package com.armughanahmed.ecommerce.ecommerce.service;

import com.armughanahmed.ecommerce.ecommerce.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}