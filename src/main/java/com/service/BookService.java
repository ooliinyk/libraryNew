package com.service;

import com.entity.Book;

import java.util.List;

/**
 * Created by user on 18.03.2016.
 */
public interface BookService {

    void save(Book book);

    List<Book> findAll();

    Book findById(int id);

    Book findByName(String name);

    Book findByStyle(String style);

    Book findByAuthor(String author);


}
