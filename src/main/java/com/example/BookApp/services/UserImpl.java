package com.example.BookApp.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BookApp.model.Book;
import com.example.BookApp.model.Carts;
import com.example.BookApp.model.PreId;
import com.example.BookApp.model.User;
import com.example.BookApp.repository.BookRepository;
import com.example.BookApp.repository.PreIdRepository;
import com.example.BookApp.repository.UserRepository;

@Component
public class UserImpl implements UserInterface {
    // Declaring User Repository and creating object using autowired
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PreIdRepository preIdRepository;

    @Autowired
    private BookRepository bookRepository;

    // Creating method for saving userdetails while signup if same email means
    // return null

    @Override
    public User signUp(User userDetails) {
        User user = userRepository.findByEmail(userDetails.getEmail());

        if (user != null) {
            return null;

        }
        PreId preIdModel = preIdRepository.findByType("user");
        Integer preId = preIdModel.getPreviousId();
        if (preId > 9) {
            userDetails.setId("UN0" + ++preId);
            userDetails.setRole("user");
        } else {
            userDetails.setId("UN00" + ++preId);
            userDetails.setRole("user");
        }

        preIdModel.setPreviousId(preId);
        preIdRepository.save(preIdModel);
        return userRepository.save(userDetails);

    }
    // login

    @Override
    public User logIn(User userDetails) {
        User user = userRepository.findOneByEmailAndPassword(userDetails.getEmail(), userDetails.getPassword());
        if (user == null) {
            return null; // login failed
        }
        return user;
    }

    @Override
    public User getUser(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            return null; // if book is not there can't edit
        }
        return optionalUser.get();
    }

    @Override
    public User CheckoutBook(String userId, String bookId) {

        User optionalUser = userRepository.findById(userId).get();

        // System.out.println(optionalUser);

        if (optionalUser == null) {
            return null;
        }

        List<Carts> cart = optionalUser.getOrder();
        // System.out.println(cart);

        if (cart.size() > 1 || null == cart) {
            return null;
        }
        Carts newcart = new Carts();
        newcart.setCheckoutBookId(bookId);
        newcart.setDate(new Date());
        cart.add(newcart);

        optionalUser.setOrder(cart);
        // update copies
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (!optionalBook.isPresent()) // return null if book not present
            return null;

        Book book = optionalBook.get();

        Integer copiesForCheckout = book.getCopiesForCheckout();
        book.setCopiesForCheckout(--copiesForCheckout);

        bookRepository.save(book);

        return userRepository.save(optionalUser);

    }

    @Override
    public User returnBook(String userId, String bookId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (!optionalUser.isPresent()) {
            return null;
        }

        User user = optionalUser.get();

        List<Carts> cart = user.getOrder();

        
        cart.removeIf(book -> book.getCheckoutBookId().equals(bookId));
        // while (size > 0) {
        // if (cart.get(--size).getCheckoutBookId().equals(bookId))
        // cart.removeIf(null)
        // }

        user.setOrder(cart);

        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (!optionalBook.isPresent()) // return null if book not present
            return null;

        Book book = optionalBook.get();

        Integer copiesForCheckout = book.getCopiesForCheckout();
        book.setCopiesForCheckout(copiesForCheckout + 1);

        bookRepository.save(book); // update copies

        return userRepository.save(user);
    }

}
