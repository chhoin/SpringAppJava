package com.spring.app.repositories.dao;

import com.spring.app.entities.Role;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public interface UserRoleDao {
	
	public boolean insert(Role userRole);
	public boolean checkRole(Long userId, Long roleId);
}
