package com.example.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.example.models.Book;
import com.example.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repo;
	
	
	public List<Book> getBooksByType(@PathVariable String type){
		return repo.findByType(type);
	}
	
	public List<Book> getBooks(){
		return repo.findAll();
	}
	
	public void deleteBook(Integer id) {
		repo.deleteById(id);
	}
	
	public void addBook(Book book) {
		repo.saveAndFlush(book);
	}
	
	public Book getBook(Integer id) {
		return repo.getById(id);
	}
	public void updateBook(Book newbook) {
		repo.save(newbook);
	}
	


}
