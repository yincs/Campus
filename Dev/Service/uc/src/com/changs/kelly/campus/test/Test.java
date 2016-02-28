package com.changs.kelly.campus.test;

import java.sql.SQLException;

import com.changs.kelly.campus.db.DbConn;

public class Test {

	public static void main(String[] args) {
		try {
			String url = DbConn.getConn().getMetaData().getURL();
			System.out.println(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
