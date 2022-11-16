package com.example.BookApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "customid")
public class PreId {
    @Id
    private String id;
    private String type;
    private Integer previousId;
}
