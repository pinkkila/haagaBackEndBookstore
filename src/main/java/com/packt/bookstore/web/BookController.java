package com.packt.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.packt.bookstore.domain.Book;
import com.packt.bookstore.domain.BookRepository;

@Controller
public class BookController {
    
    @Autowired
    BookRepository repository;

    @GetMapping("/allbooks")
    public String getCars2(Model model) {
        List<Book> books =  (List<Book>) repository.findAll();
        model.addAttribute("books", books);
        return "booklist";  
    }

    @GetMapping("/newbook")
    public String getNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/allbooks";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        repository.deleteById(bookId);
        return "redirect:/allbooks";
    }

}
