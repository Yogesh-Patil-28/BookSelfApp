package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
 User findByUsernameAndPassword(String username,String password);
}