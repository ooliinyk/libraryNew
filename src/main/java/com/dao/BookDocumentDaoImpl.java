package com.dao;


import com.entity.BookDocument;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 19.03.2016.
 */

@Repository("bookDocumentDao")
public class BookDocumentDaoImpl extends AbstractDao<Integer,BookDocument> implements BookDocumentDao{

    @SuppressWarnings("unchecked")
    public List<BookDocument> findAll() {
        Criteria crit = createEntityCriteria();
        return (List<BookDocument>)crit.list();
    }

    public void save(BookDocument document) {
        persist(document);
    }


    public BookDocument findById(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<BookDocument> findAllByUserId(int userId){
        Criteria crit = createEntityCriteria();
        Criteria userCriteria = crit.createCriteria("user");
        userCriteria.add(Restrictions.eq("id", userId));
        return (List<BookDocument>)crit.list();
    }


    public void deleteById(int id) {
        BookDocument document =  getByKey(id);
        delete(document);
    }
}
