package com.changs.kelly.campus.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
	public static Connection mConn;
	
	public static Connection getConn(){
		if (mConn != null) {
			return mConn;
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/campus?useUnicode=true&characterEncoding=utf-8";
			String user = "root";
			String password = "123456";
			mConn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mConn;
	}
}
