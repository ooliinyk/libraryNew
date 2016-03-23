package com.service;

import com.entity.Book;
import com.entity.User;

import java.util.Set;

/**
 * Created by user on 17.03.2016.
 */
public interface UserService {
    void save(User user);

    User findById(int id);

    User findByLogin(String login);

    void addToBookList(String login,  Book book);
}
