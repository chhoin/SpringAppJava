package com.spring.app.services.ser;

import com.spring.app.entities.Role;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public interface UserRoleService {
	
	public boolean insert(Role userRole);
	public boolean checkRole(Long userId, Long roleId);
}
