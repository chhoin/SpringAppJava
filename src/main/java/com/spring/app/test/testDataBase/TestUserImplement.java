package com.spring.app.test.testDataBase;

import java.util.ArrayList;

import com.spring.app.entities.Pagination;
import com.spring.app.entities.User;
import com.spring.app.repositories.impl.UserDaoIml;

public class TestUserImplement {

	public static void main(String[] args) {
		//con = com.spring.app.test.Connection.getConnection();
		UserDaoIml user = new UserDaoIml();
		
		
		/**
		 * insert 
		 */
		/*User userDTO = new User();
		userDTO.setUsername("uc");
		userDTO.setEmail("uc@gmail.com");
		userDTO.setPassword(new BCryptPasswordEncoder().encode("123456"));
		userDTO.setGender("MALE");
		userDTO.setThumnail("default.png");
		userDTO.setStatus("1");
		
		if(user.insert(userDTO)) {
			System.out.println("was insert");
		} else {
			System.out.println("Error insert");
		}*/
		
		/**
		 * Update
		 */
		/*User userDTO = new User();
		userDTO.setId(6L);		
		userDTO.setUsername("uc1");
		userDTO.setEmail("uc1@gmail.com");
		userDTO.setPassword(new BCryptPasswordEncoder().encode("123456"));
		userDTO.setPhone("012333999");
		userDTO.setGender("FEMALE");
		userDTO.setDob(MyDateUtils.today());
		userDTO.setThumnail("1default.png");
		userDTO.setStatus("1");
		
		if(user.update(userDTO)) {
			System.out.println("was update");
		} else {
			System.out.println("Error update");
		}*/
		
		/**
		 * delete
		 */
		/*if(user.delete(6L)) {
			System.out.println("was delete");
		} else {
			System.out.println("Error delete");
		}*/
		
		/**
		 * count
		 */
		//System.out.println(user.countSearch("a"));
		
		/**
		 * list with pagination
		 */
		Pagination page = new Pagination();
		page.setTotalRecord(2D);
		page.setItem(1D);
		page.setPage(3L);
		
		ArrayList<User> result = new ArrayList<User>();
		result = user.searchUser("a", page);
		System.out.println(result.size());
		
	
		 

	}

}
