package com.armughanahmed.ecommerce.ecommerce.repository;

import com.armughanahmed.ecommerce.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Find all products by category
    List<Product> findByCategoryId(Long categoryId);

    // Search products by name (case-insensitive)
    List<Product> findByNameContainingIgnoreCase(String name);
}
