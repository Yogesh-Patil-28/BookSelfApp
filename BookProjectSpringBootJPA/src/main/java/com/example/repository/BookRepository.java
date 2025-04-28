package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Book;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {
	public List<Book> findByType(String type);
}
