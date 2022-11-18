package com.example.BookApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.BookApp.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    public Book findByBookName(String bookName);

}
