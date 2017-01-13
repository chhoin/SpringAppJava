package com.spring.app.repositories.impl;

import org.springframework.stereotype.Repository;
import com.spring.app.entities.Role;
import com.spring.app.repositories.dao.UserRoleDao;

/**
 * 
 * @author sok.kimchhoin
 *
 */
@Repository("UserRoleDaoIml")
public class UserRoleDaoIml implements UserRoleDao{

	public boolean insert(Role userRole) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkRole(Long userId, Long roleId) {
		// TODO Auto-generated method stub
		return false;
	}

}
