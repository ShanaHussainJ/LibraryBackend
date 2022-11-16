package com.example.BookApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.BookApp.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
    public Book findByBookName(String bookName);

}
