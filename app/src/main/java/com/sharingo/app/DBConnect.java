package com.sharingo.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect {

	public DBConnect(){
		
	}
	
	public Connection getConnection(){
		
		Connection conn = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("test connection ok");
		} catch (ClassNotFoundException e) {
			System.out.println("Error in test connection");
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sharingo", "root", "BlueLine#$45");
			if(conn != null){
				System.out.println("Successfully connected to the database");
			} else {
				System.out.println("Failed to establish a connection");
				
			}
			
		} catch (SQLException e) {
			System.out.println("Mysql Connection failed");
			e.printStackTrace();
		}
		return conn;
	}
	
}
