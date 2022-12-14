package com.example.BookApp.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.BookApp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User findByEmail(String email);
    public User findOneByEmailAndPassword(String email, String password);
    
    
}
