package com.example.BookApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookApp.model.User;
import com.example.BookApp.services.UserImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserImpl userServiceImpl;

    // Post userdetails in Mongodb and connect to service class using return
    // userserviceImpl
    @PostMapping("/signup")
    public User signUp(@RequestBody User userDetails) {
        return userServiceImpl.signUp(userDetails);
    }

    @PostMapping("/login")
    public User logIn(@RequestBody User userDetails) {
        return userServiceImpl.logIn(userDetails);
    }

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable("id") String userId) {
        return userServiceImpl.getUser(userId);
    }

    @PutMapping("/checkout/{id}/{bookId}")
    public User CheckoutBook(@PathVariable("id") String userId, @PathVariable("bookId") String bookId) {
        return userServiceImpl.CheckoutBook(userId, bookId);
    }

    @PutMapping("/returnbook/{id}/{bookId}")
    public User returnBook(@PathVariable("id") String userId, @PathVariable("bookId") String bookId) {
        return userServiceImpl.returnBook(userId, bookId);

    }
}