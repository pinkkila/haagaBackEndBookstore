package com.packt.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title, author, isbn;
    @Column(name = "publishing_year")
    private int year;

    public Book() {
        this.id = null;
        this.title = null;
        this.author = null;
        this.isbn = null;
        this.year = 0;
    }

    public Book(String title, String author, String isbn, int year) {
        super();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    } 

    public Book(Long id, String title, String author, String isbn, int year) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
