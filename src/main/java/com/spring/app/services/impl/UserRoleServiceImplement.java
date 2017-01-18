package com.spring.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.app.repositories.dao.UserRoleDao;
import com.spring.app.services.ser.UserRoleService;

/**
 * 
 * @author sok.kimchhoin
 *
 */
@Service
public class UserRoleServiceImplement implements UserRoleService{
	
	@Autowired
	@Qualifier("UserRoleDaoIml")
	private UserRoleDao userRole;

	public boolean insert(Long userId, Long roleId) {
		return userRole.insert(userId, roleId);
	}

	public boolean checkRole(Long userId, Long roleId) {
		return userRole.checkRole(userId, roleId);
	}



}
