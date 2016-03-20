package com.dao;

import com.entity.BookDocument;

import java.util.List;

/**
 * Created by user on 19.03.2016.
 */
public interface BookDocumentDao {

    List<BookDocument> findAll();

    BookDocument findById(int id);

    void save(BookDocument document);

    List<BookDocument> findAllByUserId(int userId);

    void deleteById(int id);
}
