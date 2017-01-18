package com.spring.app.repositories.dao;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public interface UserRoleDao {
	
	public boolean insert(Long userId, Long roleId);
	public boolean checkRole(Long userId, Long roleId);
}
