package com.packt.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.packt.bookstore.domain.Category;
import com.packt.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository repository;

    @GetMapping("/allcategories")
    public String getCars2(Model model) {
        List<Category> categories = (List<Category>) repository.findAll();
        model.addAttribute("categories", categories);
        return "categorylist";
    }

    @GetMapping("/newcategory")
    public String getNewBookForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute Category category) {
        repository.save(category);
        return "redirect:/allcategories";
    }

    @GetMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryid) {
        repository.deleteById(categoryid);
        return "redirect:/allcategories";
    }

    @GetMapping("/editcategory/{id}")
    public String geteditBook(@PathVariable("id") Category category, Model model) {
        model.addAttribute("category", category);
        return "edit";
    }

    @PostMapping("/savec")
    public String save(@ModelAttribute Category category) {
        repository.save(category);
        return "redirect:/allcatogories";
    }

}
