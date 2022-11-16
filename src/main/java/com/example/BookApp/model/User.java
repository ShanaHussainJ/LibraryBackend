package com.example.BookApp.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

// Mapping POJO class to document
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String userName;
    private String email;
    private String dob;
    private String password;
    private String role;
    private List<Carts> order = new ArrayList<Carts>();
}
