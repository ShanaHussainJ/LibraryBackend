package com.example.BookApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.BookApp.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    public Book findByBookName(String bookName);
    public boolean existsById(String bookId);
    public List<Book> findAll();
    public Optional<Book> findById(String bookId);

}
