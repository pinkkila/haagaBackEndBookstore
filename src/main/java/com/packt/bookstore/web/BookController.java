package com.packt.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.packt.bookstore.domain.Book;
import com.packt.bookstore.domain.BookRepository;
import com.packt.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
    
    @Autowired
    BookRepository repository;

    @Autowired
    CategoryRepository crepository;

    @GetMapping("/allbooks")
    public String getCars2(Model model) {
        List<Book> books =  (List<Book>) repository.findAll();
        model.addAttribute("books", books);
        return "booklist";  
    }

    @GetMapping("/newbook")
    public String getNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
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

    @GetMapping("/editbook/{id}")
    public String geteditBook(@PathVariable("id") Book book, Model model) {
        model.addAttribute("book", book);
        return "edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/allbooks";
    }

    // REST 

    @GetMapping("/books")
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    } 

    @GetMapping("/book/{id}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

}
