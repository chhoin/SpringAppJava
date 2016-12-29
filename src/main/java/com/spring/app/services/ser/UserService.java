package com.spring.app.services.ser;

import java.util.ArrayList;
import com.spring.app.entities.Pagination;
import com.spring.app.entities.User;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public interface UserService {
	public ArrayList<User> getUser(Pagination pagin);
	public User detail(int id);
	public boolean insert(User product);
	public boolean update(User product);
	public boolean delete(int id);
	public ArrayList<User> searchUser(String kesearch, Pagination pagin);
	public int count();
	public int countSearch(String keyword);
	
}
