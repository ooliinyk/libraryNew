package com.dao;

import com.entity.Book;
import com.entity.Role;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 18.03.2016.
 */
@Repository("BookDao")
public class BookDaoImpl extends AbstractDao<Integer, Book> implements BookDao{

    public List<Book> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("name"));
        return (List<Book>)criteria.list();
    }





    public void save(Book book) {
        persist(book);

    }

    public Book findById(int id) {
                return getByKey(id);
    }

    public Book findByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add((Restrictions.eq("name", name)));
        return (Book) criteria.uniqueResult();
    }
}
