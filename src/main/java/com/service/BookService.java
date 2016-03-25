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

    List<Book> findByName(String name);

    List<Book> findByStyle(String style);

    List<Book> findByAuthor(String author);

     void updateBook(Book book);

     void deleteBookById(int id);

      int findBookDocumentId(int id);


}
