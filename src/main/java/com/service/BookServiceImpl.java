package com.service;

import com.dao.BookDao;
import com.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 18.03.2016.
 */

@Service("BookService")
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    BookDao dao;
    public void save(Book book){
        dao.save(book);
    }
    public List<Book> findAll() {
        return dao.findAll();
    }

    public Book findById(int id) {
        return dao.findById(id);
    }

    public Book findByName(String name) {
        return dao.findByName(name);
    }

    public Book findByStyle(String style) {
        return dao.findByStyle(style);
    }

    public Book findByAuthor(String author) {
        return findByAuthor(author);
    }
}
