package com.jpop.bookService.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpop.bookService.model.Book;
import com.jpop.bookService.repo.BookServiceRepository;
import com.jpop.bookService.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookServiceRepository bookServiceRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookServiceRepository.findAll();
	}

	@Override
	public Optional<Book> getBookbyId(Long id) {
		return bookServiceRepository.findById(id);
	}

	@Override
	public Book save(Book book) {
		return bookServiceRepository.save(book);
	}

	@Override
	public void deletebyId(Long id) {
		bookServiceRepository.deleteById(id);
	}

}
