package com.armughanahmed.ecommerce.ecommerce.repository;

import com.armughanahmed.ecommerce.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User findByEmail(String email);
}
