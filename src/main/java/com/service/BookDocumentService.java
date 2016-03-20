package com.service;

import com.entity.BookDocument;

import java.util.List;

/**
 * Created by user on 19.03.2016.
 */
public interface BookDocumentService {

    BookDocument findById(int id);

    List<BookDocument> findAll();

    List<BookDocument> findAllByUserId(int id);

    void saveDocument(BookDocument document);

    void deleteById(int id);
}
