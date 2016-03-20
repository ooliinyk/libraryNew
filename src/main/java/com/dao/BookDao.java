package com.dao;


import com.entity.Book;

import java.util.List;

/**
 * Created by user on 18.03.2016.
 */
public interface BookDao {

    void save(Book book);

    List<Book> findAll();

    Book findById(int id);

    Book findByName(String name);

    Book findByStyle(String name);

    Book findByAuthor(String name);

    public void deleteById(int id);
}
