package com.packt.bookstore;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.bookstore.domain.Book;
import com.packt.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(
			BookstoreApplication.class);

	private final BookRepository repository;

	public BookstoreApplication(BookRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		logger.info("Application started");
	}

	@SuppressWarnings("null")
	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Miten sinne pääsee?", "Lolli", "1234-1", 1999);
		Book book2 = new Book("Ympyrät neliöksi", "Velli", "4567-9", 2003);
		Book book3 = new Book("Viemärissä", "Lolli", "3423-2", 2003);
		repository.saveAll(Arrays.asList(book1, book2, book3));

	}

}
