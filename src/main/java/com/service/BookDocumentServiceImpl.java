package com.service;

import com.dao.BookDocumentDao;
import com.entity.BookDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 19.03.2016.
 */

@Service("bookDocumentService")
@Transactional
public class BookDocumentServiceImpl implements BookDocumentService {

    @Autowired
    BookDocumentDao dao;

    public BookDocument findById(int id) {
        return dao.findById(id);
    }

    public List<BookDocument> findAll() {
        return dao.findAll();
    }

    public List<BookDocument> findAllByUserId(int userId) {
        return dao.findAllByUserId(userId);
    }

    public void saveDocument(BookDocument bookDocument){
        dao.save(bookDocument);
    }

    public void deleteById(int id){
        dao.deleteById(id);
    }
}
