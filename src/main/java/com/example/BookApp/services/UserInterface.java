package com.example.BookApp.services;

import com.example.BookApp.model.User;

interface UserInterface {

    public abstract User signUp(User userDetails);

    public abstract User logIn(User userDetails);

    public abstract User getUser(String userId);

    public abstract User CheckoutBook(String userId, String bookId);

    public abstract User returnBook(String userId, String bookId);

}
