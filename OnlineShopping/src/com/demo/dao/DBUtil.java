package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBUtil 
{
	private static Connection conn;
	public static Connection getMyConnection() throws SQLException {
		if(conn == null) {
			DriverManager.registerDriver(new Driver());
			String url="jdbc:mysql://localhost:3306/myshop";
			conn=DriverManager.getConnection(url,"root","root");
		}
		return conn;
	}
	public static void closeMyConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
