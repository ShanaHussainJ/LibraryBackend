package com.example.BookApp.services;

import java.util.List;

import com.example.BookApp.model.Book;

interface BookInterface {
    public abstract Book addBook(Book bookDetails);

    public abstract Book editBook(String bookId, Book bookDetails);

    public abstract Boolean deleteBook(String bookId); // return type boolean

    public abstract List<Book> viewAllBooks();

    public abstract Book getBook(String bookId);

}
