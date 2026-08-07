package com.jpop.bookService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpop.bookService.model.Book;

public interface BookServiceRepository extends JpaRepository<Book, Long>{

}
