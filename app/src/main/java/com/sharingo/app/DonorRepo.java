package com.sharingo.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DonorRepo {

	DBConnect dbConnect = new DBConnect();
	
	public DonorRepo(){
		
	}
	
	public String Fetch(){
		String name = null;
		PreparedStatement preparedStmt= null;
		Connection conn = dbConnect.getConnection();
		
		if(conn != null){
			System.out.println("Connection was established sucessfully!");
		} else {
			System.out.println("Connection failed..");
		}
		
		try {
			String getQueryStatement = "Select * from donor";
			preparedStmt = conn.prepareStatement(getQueryStatement);
			
			ResultSet rs = preparedStmt.executeQuery();
			
			while(rs.next()){
				name = rs.getString("Name");
				System.out.println(name);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return name;
	}
}
