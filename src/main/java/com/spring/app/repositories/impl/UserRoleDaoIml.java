package com.spring.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.app.entities.User;
import com.spring.app.entities.UserRole;
import com.spring.app.repositories.dao.UserRoleDao;
import com.spring.app.utilities.MyDateUtils;

/**
 * 
 * @author sok.kimchhoin
 *
 */
@Repository("UserRoleDaoIml")
public class UserRoleDaoIml implements UserRoleDao{
	
	@Autowired
	DataSource dataSource;
	Connection con;

	public boolean insert(Long userId, Long roleId) {
		String sql = "INSERT INTO tbl_user_role (user_id, role_id)"
					+" VALUES(?,?) ";

		try {
			//con = com.spring.app.test.testDataBase.Connection.getConnection();
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, userId);
			ps.setLong(2, roleId);

			if (ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean checkRole(Long userId, Long roleId) {
		String sql = "SELECT *"
					+" FROM tbl_user_role WHERE user_id=? AND role_id=?";
		try {
			//con = com.spring.app.test.testDataBase.Connection.getConnection();
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setLong(1, userId);
			ps.setLong(2, roleId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


}
