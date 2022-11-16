package com.example.BookApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.BookApp.model.User;


public interface UserRepository extends MongoRepository<User, String> {
    public User findByEmail(String email);
    public User findOneByEmailAndPassword(String email, String password);

}
