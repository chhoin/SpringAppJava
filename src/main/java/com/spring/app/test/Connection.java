package com.spring.app.test;

import java.sql.*;

public class Connection {
	
	private static final String 	URL			=	"jdbc:postgresql://localhost:5432/SpringAppJava";
	private static final String		DRIVER		=	"org.postgresql.Driver";
	private static final String 	USERNAME	=	"postgres";
	private static final String		PASSWORD	=	"123456";
	private static java.sql.Connection con 		= 	null;
	
	public static java.sql.Connection getConnection(){
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
