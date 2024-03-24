package com.packt.bookstore;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.bookstore.domain.AppUser;
import com.packt.bookstore.domain.AppUserRepository;
import com.packt.bookstore.domain.Book;
import com.packt.bookstore.domain.BookRepository;
import com.packt.bookstore.domain.Category;
import com.packt.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(BookstoreApplication.class);
	private final BookRepository repository;
	private final CategoryRepository crepository;
	private final AppUserRepository appUserRepository;

	public BookstoreApplication(BookRepository repository, CategoryRepository crepository, AppUserRepository appUserRepository) {
		this.repository = repository;
		this.crepository = crepository;
		this.appUserRepository = appUserRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		logger.info("Application started"); // Should I log something else??
	}

	@SuppressWarnings("null")
	@Override
    public void run(String... args) throws Exception {
		Category category1 = new Category("Education");
		Category category2 = new Category("Fiction");
		crepository.saveAll(Arrays.asList(category1, category2));

		Book book1 = new Book("Miten periä veljoka", "Jack Daniels", "12345-6", 2001, category1);
		Book book2 = new Book("Talouden hoitaminen", "Lolli Lollerson", "12312-3", 2023, category2);
		Book book3 = new Book("Velalla voittoihin", "Lolli Lollerson", "87698-2", 1998, category1);
		repository.saveAll(Arrays.asList(book1, book2, book3));
		
		for (Book book : repository.findAll()) {
			logger.info("title: {}", book.getTitle());
		}

		appUserRepository.save(new AppUser("user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "USER"));
		appUserRepository.save(new AppUser("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
	}

}
