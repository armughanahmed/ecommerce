package com.armughanahmed.ecommerce.ecommerce.service;

import com.armughanahmed.ecommerce.ecommerce.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
