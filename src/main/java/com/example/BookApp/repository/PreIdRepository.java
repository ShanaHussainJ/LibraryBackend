package com.example.BookApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.BookApp.model.PreId;

public interface PreIdRepository extends MongoRepository<PreId, String> {
    public PreId findByType(String type);

}
