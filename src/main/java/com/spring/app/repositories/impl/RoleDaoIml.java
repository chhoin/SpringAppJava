package com.spring.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.app.entities.Role;
import com.spring.app.repositories.dao.RoleDao;

/**
 * 
 * @author sok.kimchhoin
 *
 */
@Repository("RoleDaoIml")
public class RoleDaoIml implements RoleDao{
	
	@Autowired
	DataSource dataSource;
	Connection con;

	public ArrayList<Role> all() {

		ArrayList<Role> roles =new ArrayList<Role>();
		String sql = "SELECT * FROM tbl_role ";
		
		try {
			//con = com.spring.app.test.testDataBase.Connection.getConnection();
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Role r = new Role();
				r.setId(	rs.getInt("id") 		);
				r.setName(	rs.getString("role_name"));
				roles.add(r);
			}
			return roles;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
