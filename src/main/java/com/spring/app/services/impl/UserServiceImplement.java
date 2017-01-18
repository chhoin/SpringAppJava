package com.spring.app.services.impl;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.app.entities.Pagination;
import com.spring.app.entities.User;
import com.spring.app.repositories.dao.UserDao;
import com.spring.app.services.ser.UserService;
import com.spring.app.utilities.MyDateUtils;

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
	@Qualifier("UserDaoImpl") //@Qualifier is used to make clear which object that we want to autowired
	private UserDao userDao;

	public ArrayList<User> getUser(Pagination pagin) {
		return userDao.getUser(pagin);
	}

	public User detail(Long id) {
		return userDao.detail(id);
	}

	public boolean insert(User user) {
		
		//Default status 1 is active
		user.setStatus("1");
		user.setDob(user.getDob() + MyDateUtils.getHourMinuteSecond());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		//Default profile
		if(StringUtils.isEmpty(user.getThumnail())) {
			user.setThumnail("default.png");
		}
		
		return userDao.insert(user);
	}

	public boolean update(User user) {
		
		user.setDob(user.getDob() + MyDateUtils.getHourMinuteSecond());
		
		return userDao.update(user);
	}

	public boolean delete(Long id) {
		return userDao.delete(id);
	}

	public ArrayList<User> searchUser(String kesearch, Pagination pagin) {
		return userDao.searchUser(kesearch, pagin);
	}

	public Long count() {
		return userDao.count();
	}

	public Long countSearch(String keyword) {
		return userDao.countSearch(keyword);
	}

}
