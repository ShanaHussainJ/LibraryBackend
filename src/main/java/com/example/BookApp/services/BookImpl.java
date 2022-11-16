package com.example.BookApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BookApp.model.Book;
import com.example.BookApp.model.PreId;
import com.example.BookApp.repository.BookRepository;
import com.example.BookApp.repository.PreIdRepository;

@Component
public class BookImpl implements BookInterface {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PreIdRepository preIdRepository;

    // add book
    @Override
    public Book addBook(Book bookDetails) {
        Book bookName = bookRepository.findByBookName(bookDetails.getBookName());

        if (bookName != null) {
            return null;

        }
        PreId prevIdModel = preIdRepository.findByType("book");
        Integer prevId = prevIdModel.getPreviousId();
        if (prevId > 9) {
            bookDetails.setId("BN0" + ++prevId);
        } else {
            bookDetails.setId("BN00" + ++prevId);
        }

        prevIdModel.setPreviousId(prevId);
        preIdRepository.save(prevIdModel);
        return bookRepository.save(bookDetails);
    }

    // edit book
    public Book editBook(String bookId, Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (!optionalBook.isPresent()) {
            return null; // if book is not there can't edit
        }

        Book book = optionalBook.get();

        book.setBookName(bookDetails.getBookName());
        book.setAuthor(bookDetails.getAuthor());
        book.setGenres(bookDetails.getGenres());
        book.setIsbnNumber(bookDetails.getIsbnNumber());
        book.setImage(bookDetails.getImage());
        book.setTotalCopies(bookDetails.getTotalCopies());
        book.setCopiesForCheckout(bookDetails.getCopiesForCheckout());
        return bookRepository.save(book);
    }

    // delete book
    public Boolean deleteBook(String bookId) {
        if (!bookRepository.existsById(bookId))
            return false;

        bookRepository.deleteById(bookId);
        return true;
    }

    @Override
    public List<Book> viewAllBooks() {
        return bookRepository.findAll();
    }

    // get Single Book
    @Override
    public Book getBook(String bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (!optionalBook.isPresent()) {
            return null; // if book is not there can't edit
        }
        return optionalBook.get();
    }

}
