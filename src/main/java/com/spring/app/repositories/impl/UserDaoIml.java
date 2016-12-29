package com.spring.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.app.entities.Pagination;
import com.spring.app.entities.User;
import com.spring.app.entities.UserRole;
import com.spring.app.repositories.dao.UserDao;

/**
 * 
 * @author sok.kimchhoin
 *
 */
@Repository("UserDaoImpl")
public class UserDaoIml implements UserDao{
	
	@Autowired
	DataSource dataSource;
	Connection con;

	/**
	 * Login with email
	 */
	public User findUserByUserEmail(String userEmail) {
		User user = new User();
		String sql = "SELECT id, user_name, email, password, status, approved_date, created_date, updated_date"
				   + " FROM tbl_user WHERE email=?";
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userEmail);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString((2)));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString((4)));
				user.setStatus(rs.getString((5)));
				user.setApprovedDate((rs.getDate(6)));
				user.setCreatedDate((rs.getDate(7)));
				user.setUpdatedDate((rs.getDate(8)));
				user.setRoles(this.findUserRoleByUserId(user.getId()));
				return user;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * when login find all user role
	 * @param id
	 * @return
	 */
	public List<UserRole> findUserRoleByUserId(int id) {
		List<UserRole> roles = new ArrayList<UserRole>();
		String sql = "SELECT tbl_role.id , tbl_role.role_name FROM tbl_user "
				+ "LEFT JOIN tbl_user_role ON tbl_user.id = tbl_user_role.user_id "
				+ "LEFT JOIN tbl_role ON tbl_role.id = tbl_user_role.role_id WHERE tbl_user.id = ?";
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserRole role = new UserRole();
				role.setId(rs.getInt("id"));
				role.setName("ROLE_" + rs.getString("role_name"));
				roles.add(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return roles;
	}


	public ArrayList<User> getUser(Pagination pagin) {
		// TODO Auto-generated method stub
		return null;
	}

	public User detail(int id) {
		User user = new User();
		String sql = "SELECT id, user_name, email, password, status, approved_date, created_date, updated_date"
					+" FROM tbl_user WHERE id=?";
		try{
			con = dataSource.getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString((2)));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString((4)));
				user.setStatus(rs.getString((5)));
				user.setApprovedDate((rs.getDate(6)));
				user.setCreatedDate((rs.getDate(7)));
				user.setUpdatedDate((rs.getDate(8)));
				return user;
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean insert(User product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(User product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<User> searchUser(String kesearch, Pagination pagin) {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int countSearch(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
