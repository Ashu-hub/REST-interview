package com.jpop.bookService.service;

import java.util.List;
import java.util.Optional;

import com.jpop.bookService.model.Book;


public interface BookService {
	
	public List<Book> getAllBooks();
	
	public Optional<Book> getBookbyId(Long id);
	
	public Book save(Book book); 
	
	public void deletebyId(Long id);
	
}
