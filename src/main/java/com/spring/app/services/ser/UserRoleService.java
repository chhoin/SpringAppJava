package com.spring.app.services.ser;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public interface UserRoleService {
	
	public boolean insert(Long userId, Long roleId);
	public boolean checkRole(Long userId, Long roleId);
}
