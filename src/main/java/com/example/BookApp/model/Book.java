package com.example.BookApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Books")
public class Book {
    @Id
    private String id;
    private String bookName;
    private String isbnNumber;
    private String author;
    private String genres;
    private Integer totalCopies;
    private Integer copiesForCheckout;
    private String image;
}
