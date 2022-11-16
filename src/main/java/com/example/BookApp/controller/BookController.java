package com.example.BookApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.BookApp.model.Book;
import com.example.BookApp.services.BookImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    public BookImpl bookImpl;

    @PostMapping("/addbooks")
    public Book addBook(@RequestBody Book bookDetails) {
        return bookImpl.addBook(bookDetails);
    }

    @PutMapping("/editbooks/{id}")
    public Book editBook(@PathVariable("id") String bookId, @RequestBody Book editBookDetails) {
        return bookImpl.editBook(bookId, editBookDetails);
    }

    @DeleteMapping("/deletebook/{id}")
    public Boolean deleteBook(@PathVariable("id") String bookId) {
        return bookImpl.deleteBook(bookId);
    }

    @GetMapping("/viewallbooks")
    public List<Book> viewAllBooks() {
        return bookImpl.viewAllBooks();
    }

    @GetMapping("/getbook/{id}")
    public Book getBook(@PathVariable("id") String bookId) {
        return bookImpl.getBook(bookId);
    }

}
