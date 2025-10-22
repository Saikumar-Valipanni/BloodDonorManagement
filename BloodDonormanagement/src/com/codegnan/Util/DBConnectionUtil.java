package com.codegnan.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	static final String jdbc_url="jdbc:mysql://localhost:3306/saijdbc";
	static final String username = "root";
	static final String password = "Saikumar@1234";
	
	public static Connection getconnection() throws SQLException {
		return DriverManager.getConnection(jdbc_url,username,password);
	}

}


