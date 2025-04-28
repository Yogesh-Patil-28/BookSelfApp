package com.example.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.example.models.Book;
import com.example.models.User;
import com.example.repository.BookRepository;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	
	
	@Autowired
	UserRepository repo;
	
	public void addUser(User user) {
		repo.save(user);
	}
	
	public User getUser(String username, String password) {
	 User user =repo.findByUsernameAndPassword(username,password);
	 
		 return user;
	 
	}
}
