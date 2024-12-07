package com.armughanahmed.ecommerce.ecommerce.repository;

import com.armughanahmed.ecommerce.ecommerce.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String category);
}
