package com.spring.app.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.app.common.UserStatus;
import com.spring.app.entities.Pagination;
import com.spring.app.entities.User;
import com.spring.app.entities.Role;
import com.spring.app.repositories.dao.UserDao;
import com.spring.app.utilities.MyDateUtils;

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
	
	@Autowired
	private UserRoleDaoIml userRole;

	/**
	 * Login with email
	 */
	public User findUserByUserEmail(String userEmail) {
		User user = new User();
		String sql = "SELECT id, user_name, email, password, phone, gender, dob, thumnail,  status, approved_date, created_date, updated_date"
				   + " FROM tbl_user WHERE email=?";
		
		try {
			//con = com.spring.app.test.Connection.getConnection();
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userEmail);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(				rs.getLong("id")				);
				user.setUsername(		rs.getString("user_name")		);
				user.setEmail(			rs.getString("email")			);
				user.setPassword(		rs.getString("password")		);
				user.setPhone(			rs.getString("phone")			);
				user.setGender(			rs.getString("gender")			);
				user.setDob(			rs.getString("dob")				);
				user.setThumnail(		rs.getString("thumnail")		);
				user.setStatus(			rs.getString("status")			);
				user.setApprovedDate(	rs.getString("approved_date")		);
				user.setCreatedDate(	rs.getString("created_date")		);
				user.setUpdatedDate(	rs.getString("updated_date")		);
				user.setRoles(this.findUserRoleByUserId(user.getId())	);
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
	public List<Role> findUserRoleByUserId(Long id) {
		List<Role> roles = new ArrayList<Role>();
		String sql = "SELECT tbl_role.id , tbl_role.role_name FROM tbl_user "
				+ "LEFT JOIN tbl_user_role ON tbl_user.id = tbl_user_role.user_id "
				+ "LEFT JOIN tbl_role ON tbl_role.id = tbl_user_role.role_id WHERE tbl_user.id = ?";
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Role role = new Role();
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
		
		ArrayList<User> users =new ArrayList<User>();
		String sql = "SELECT id, user_name, email, password, phone, gender, dob, thumnail, status, approved_date, created_date, updated_date"
				   + " FROM tbl_user ORDER BY id DESC"
				   + " OFFSET ? LIMIT ? ";
		
		try {
			//con = com.spring.app.test.Connection.getConnection();
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, new Double(pagin.getBegin()).longValue());
			ps.setLong(2,  new Double(pagin.getItem()).longValue());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setId(			rs.getLong("id")			);
				u.setUsername(		rs.getString("user_name")	);
				u.setEmail(			rs.getString("email")		);
				u.setPassword(		rs.getString("password")	);
				u.setPhone(			rs.getString("phone")		);
				u.setGender(		rs.getString("gender")		);
				u.setDob(			rs.getString("dob")			);
				u.setThumnail(		rs.getString("thumnail")	);
				u.setStatus(		rs.getString("status")		);
				u.setApprovedDate(	rs.getString("approved_date")	);
				u.setCreatedDate(	rs.getString("created_date")	);
				u.setUpdatedDate(	rs.getString("updated_date")	);
				users.add(u);
			}
			return users;
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

	public User detail(Long id) {
		User user = new User();
		String sql = "SELECT id, user_name, email, password, phone, gender, dob, thumnail, status, approved_date, created_date, updated_date"
					+" FROM tbl_user WHERE id=?";
		try {
			//con = com.spring.app.test.Connection.getConnection();
			con = dataSource.getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				user.setId(				rs.getLong("id")				);
				user.setUsername(		rs.getString("user_name")		);
				user.setEmail(			rs.getString("email")			);
				user.setPassword(		rs.getString("password")		);
				user.setPhone(			rs.getString("phone")			);
				user.setGender(			rs.getString("gender")			);
				user.setDob(			rs.getString("dob")				);
				user.setThumnail(		rs.getString("thumnail")		);
				user.setStatus(			rs.getString("status")			);
				user.setApprovedDate(	rs.getString("approved_date")	);
				user.setCreatedDate(	rs.getString("created_date")	);
				user.setUpdatedDate(	rs.getString("updated_date")	);
				user.setDobDate(	    rs.getDate("dob")		);
				return user;
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
		return null;
	}

	public boolean insert(User user) {
		
		String sql = "INSERT INTO tbl_user (user_name, email, password, phone , gender, dob , thumnail, status, created_date)"
				+" VALUES(?,?,?,?,?,?,?,?,?) ";

		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getGender());
			ps.setTimestamp(6, new java.sql.Timestamp(MyDateUtils.convertStringToDate(user.getDob()).getTime()));
			ps.setString(7, user.getThumnail());
			ps.setString(8, user.getStatus());
			ps.setTimestamp(9, new java.sql.Timestamp(MyDateUtils.today().getTime()));
			
			if (ps.executeUpdate() > 0) {
				User u = this.getLastRecord();
				if (userRole.insert(u.getId(), Long.valueOf(user.getUserRole()))) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
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
	
	/**
	 * This function use when create user then 
	 * we need user id last record to insert to table user role
	 * @return
	 */
	public User getLastRecord() {
		User user = new User();
		String sql = "SELECT id, user_name, email, password, phone, gender, dob, thumnail, status, approved_date, created_date, updated_date"
					+" FROM tbl_user ORDER BY id DESC LIMIT 1";
		try {
			//con = com.spring.app.test.Connection.getConnection();
			con = dataSource.getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				user.setId(				rs.getLong("id")				);
				user.setUsername(		rs.getString("user_name")		);
				user.setEmail(			rs.getString("email")			);
				user.setPassword(		rs.getString("password")		);
				user.setPhone(			rs.getString("phone")			);
				user.setGender(			rs.getString("gender")			);
				user.setDob(			rs.getString("dob")				);
				user.setThumnail(		rs.getString("thumnail")		);
				user.setStatus(			rs.getString("status")			);
				user.setApprovedDate(	rs.getString("approved_date")	);
				user.setCreatedDate(	rs.getString("created_date")	);
				user.setUpdatedDate(	rs.getString("updated_date")	);
				user.setDobDate(	    rs.getDate("dob")		);
				return user;
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
		return null;
	}

	public boolean update(User user) {
		String sql = "UPDATE tbl_user SET user_name=?, email=? , phone=?, gender=?, dob=?, thumnail=?, status=?, updated_date=? "
					+" WHERE id=? ";

		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getGender());
			ps.setTimestamp(5, new java.sql.Timestamp(MyDateUtils.convertStringToDate(user.getDob()).getTime()));
			ps.setString(6, user.getThumnail());
			ps.setString(7, user.getStatus());
			ps.setTimestamp(8, new java.sql.Timestamp(MyDateUtils.today().getTime()));
			ps.setLong(9, user.getId());

			if (ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
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

	public boolean delete(Long id) {
		String sql = "UPDATE tbl_user SET status=?, updated_date=? WHERE id=? ";

		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, UserStatus.DELETE);
			ps.setTimestamp(2, new java.sql.Timestamp(MyDateUtils.today().getTime()));
			ps.setLong(3, id);

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

	public ArrayList<User> searchUser(String kesearch, Pagination pagin) {

		ArrayList<User> users =new ArrayList<User>();
		String sql = "SELECT id, user_name, email, password, phone, gender, dob, thumnail, status, approved_date, created_date, updated_date"
				   + " FROM tbl_user"
				   +" WHERE LOWER(user_name) LIKE LOWER(?)"
				   +" OR LOWER(email) LIKE LOWER(?)"
				   +" OR LOWER(phone) LIKE LOWER(?)"
				   + " ORDER BY id DESC"
				   + " OFFSET ? LIMIT ? ";
		
		try {
			//con = com.spring.app.test.testDataBase.Connection.getConnection();
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, "%"+kesearch+"%");
			ps.setString(2, "%"+kesearch+"%");
			ps.setString(3, "%"+kesearch+"%");
			ps.setLong(4, new Double(pagin.getBegin()).longValue());
			ps.setLong(5,  new Double(pagin.getItem()).longValue());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				User u = new User();
				u.setId(			rs.getLong("id")			);
				u.setUsername(		rs.getString("user_name")	);
				u.setEmail(			rs.getString("email")		);
				u.setPassword(		rs.getString("password")	);
				u.setPhone(			rs.getString("phone")		);
				u.setGender(		rs.getString("gender")		);
				u.setDob(			rs.getString("dob")			);
				u.setThumnail(		rs.getString("thumnail")	);
				u.setStatus(		rs.getString("status")		);
				u.setApprovedDate(	rs.getString("approved_date")	);
				u.setCreatedDate(	rs.getString("created_date")	);
				u.setUpdatedDate(	rs.getString("updated_date")	);
				users.add(u);
			}
			return users;
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

	public Long count() {
		Long count = 0L;
		String sql = "SELECT COUNT(id) FROM tbl_user ";

		try {
			// con = com.spring.app.test.Connection.getConnection();
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getLong(1);
				return count;
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
		return count;
	}

	public Long countSearch(String keyword) {
		Long count = 0L;
		String sql = "SELECT COUNT(id) FROM tbl_user" 
					 +" WHERE LOWER(user_name) LIKE LOWER(?)"
					 +" OR LOWER(email) LIKE LOWER(?)"
					 +" OR LOWER(phone) LIKE LOWER(?)";

		try {
			// con = com.spring.app.test.Connection.getConnection();
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ps.setString(3, "%" + keyword + "%");

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getLong(1);
				return count;
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
		return count;
	}

	public boolean resetUserPassByAdmin(Long id, String pass) {
		String sql = "UPDATE tbl_user SET password=?, updated_date=? "
				+" WHERE id=? ";

		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, pass);
			ps.setTimestamp(2, new java.sql.Timestamp(MyDateUtils.today().getTime()));
			ps.setLong(3, id);
	
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

}