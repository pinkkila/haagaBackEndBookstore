package com.packt.bookstore.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.bookstore.domain.Book;
import com.packt.bookstore.domain.BookRepository;

@RestController
public class BookController {
    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return repository.findAll();
    }

}
