package com.service;


import com.dao.UserDao;
import com.entity.Book;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	public void save(User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public void addToBookList(String login, Book book) {
		User entity=dao.findByLogin(login);
		Set<Book> books=entity.getBooks();
		books.add(book);
		if (entity!=null){
			entity.setBooks(books);
		}
	}

}
