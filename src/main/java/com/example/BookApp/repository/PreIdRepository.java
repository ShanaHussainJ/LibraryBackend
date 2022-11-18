package com.example.BookApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.BookApp.model.PreId;
@Repository
public interface PreIdRepository extends MongoRepository<PreId, String> {
    public PreId findByType(String type);

}
