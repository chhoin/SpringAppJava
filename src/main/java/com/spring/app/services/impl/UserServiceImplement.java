package com.spring.app.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.app.entities.Pagination;
import com.spring.app.entities.User;
import com.spring.app.repositories.dao.UserDao;
import com.spring.app.services.ser.UserService;

/**
 * 
 * @author sok.kimchhoin
 *
 */
@Service
/*
 * Services are the next layer above repositories. Services encapsulate the
 * business logic of the application and consume other services and repositories
 */
public class UserServiceImplement implements UserService{
	
	@Autowired
	@Qualifier("UserDaoImpl")
	UserDao userDao;

	public ArrayList<User> getUser(Pagination pagin) {
		return userDao.getUser(pagin);
	}

	public User detail(int id) {
		return userDao.detail(id);
	}

	public boolean insert(User product) {
		return userDao.insert(product);
	}

	public boolean update(User product) {
		return userDao.update(product);
	}

	public boolean delete(int id) {
		return userDao.delete(id);
	}

	public ArrayList<User> searchUser(String kesearch, Pagination pagin) {
		return userDao.searchUser(kesearch, pagin);
	}

	public int count() {
		return userDao.count();
	}

	public int countSearch(String keyword) {
		return userDao.countSearch(keyword);
	}

}