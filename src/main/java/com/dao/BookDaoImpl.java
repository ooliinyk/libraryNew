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

    public List<Book> findByName(String name) {
        Criteria criteria = createEntityCriteria();

        criteria.add((Restrictions.eq("name", name)));
        return (List<Book>) criteria.list();
    }

    public List<Book> findByStyle(String style) {
        Criteria criteria = createEntityCriteria();

        criteria.add(Restrictions.eq("style", style));
        return (List<Book>) criteria.list();
    }

    public List<Book> findByAuthor(String author) {
        Criteria criteria = createEntityCriteria();
        criteria.add((Restrictions.eq("author", author)));
        return (List<Book>) criteria.list();
    }

    public void deleteById(int id) {
        Book book =  getByKey(id);
        delete(book);
    }


}
