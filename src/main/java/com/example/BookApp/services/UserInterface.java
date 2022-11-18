package com.example.BookApp.services;

import org.springframework.stereotype.Component;

import com.example.BookApp.model.User;

@Component
interface UserInterface {

    public abstract User signUp(User userDetails);

    public abstract User logIn(User userDetails);

    public abstract User getUser(String userId);

    public abstract User CheckoutBook(String userId, String bookId);

    public abstract User returnBook(String userId, String bookId);

}
