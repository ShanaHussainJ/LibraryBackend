package com.example.BookApp.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Carts {
    private Date date;
    private String checkoutBookId;
}
