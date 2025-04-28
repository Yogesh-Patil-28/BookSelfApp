package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.CartItem;
import com.example.models.User;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
}
