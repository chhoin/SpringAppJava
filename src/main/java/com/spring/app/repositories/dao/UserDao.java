package com.spring.app.repositories.dao;

import java.util.ArrayList;

import com.spring.app.entities.Pagination;
import com.spring.app.entities.User;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public interface UserDao {
	public User findUserByUserEmail(String userEmail);
	public ArrayList<User> getUser(Pagination pagin);
	public User detail(Long id);
	public boolean insert(User user);
	public boolean update(User user);
	public boolean delete(Long id);
	public ArrayList<User> searchUser(String kesearch, Pagination pagin);
	public Long count();
	public Long countSearch(String keyword);
	public boolean resetUserPassByAdmin(Long id, String pass);
}
