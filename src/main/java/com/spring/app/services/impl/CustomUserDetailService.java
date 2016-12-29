package com.spring.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.spring.app.entities.User;
import com.spring.app.repositories.dao.UserDao;

/**
 * 
 * @author sok.kimchhoin
 *
 */
@Service
public class CustomUserDetailService  implements UserDetailsService{

	@Autowired
	UserDao userDaoImpl;
	
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		User user = userDaoImpl.findUserByUserEmail(userEmail);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}

}
