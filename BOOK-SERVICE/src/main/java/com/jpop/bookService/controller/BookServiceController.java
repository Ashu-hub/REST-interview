package com.jpop.bookService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpop.bookService.model.Book;
import com.jpop.bookService.serviceImpl.BookServiceImpl;

@RestController
@RequestMapping("/books")
public class BookServiceController {

	@Autowired
	BookServiceImpl bookServiceImpl;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Book> getAllBooks() {
		return bookServiceImpl.getAllBooks();
	}

	@GetMapping(value = "/{bookid}")
	public ResponseEntity<Book> getById(@PathVariable Long bookid) {
		Optional<Book> book = bookServiceImpl.getBookbyId(bookid);
		if (!book.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().body(book.get());
	}

	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookServiceImpl.save(book));
	}

	@PutMapping(value = "/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book book) {
		Optional<Book> bookbyId = bookServiceImpl.getBookbyId(bookId);
		if (!bookbyId.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().body(bookServiceImpl.save(book));
	}

	@DeleteMapping(value = "/{bookId}")
	public ResponseEntity<Book> deleteBook( @PathVariable("bookId") long bookId) {
		Optional<Book> bookToBeDeleted = bookServiceImpl.getBookbyId(bookId);
		if (!bookToBeDeleted.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		bookServiceImpl.deletebyId(bookId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
