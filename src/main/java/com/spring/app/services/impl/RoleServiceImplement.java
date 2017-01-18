package com.spring.app.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.app.entities.Role;
import com.spring.app.repositories.dao.RoleDao;
import com.spring.app.services.ser.RoleService;

/**
 * 
 * @author sok.kimchhoin
 *
 */
@Service
public class RoleServiceImplement implements RoleService{

	@Autowired
	@Qualifier("RoleDaoIml")
	private RoleDao roleDao;
	
	public ArrayList<Role> all() {
		return roleDao.all();
	}

}
