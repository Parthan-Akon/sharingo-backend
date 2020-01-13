package com.sharingo.app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonObject;

public class DonorRepo {

	DBConnect dbConnect = new DBConnect();
	
	
	public DonorRepo(){
		
	}
	
	public List<Donor> Fetch(){
		String name = null;
		PreparedStatement preparedStmt= null;
		Connection conn = dbConnect.getConnection();
		List<Donor> donorList = new ArrayList<Donor>();
		
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
				Donor donor = new Donor();
				donor.setId(rs.getInt("ID"));
				donor.setName(rs.getString("Name"));
				donor.setAddress(rs.getString("Address"));
				donor.setContactNumber(rs.getString("Contact"));
				donor.setInActive(rs.getInt("Inactive"));
				donorList.add(donor);
				
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return donorList;
	}
	
	public void save(JsonObject inputData){
		
		CallableStatement preparedStatement = null;
		Connection conn = dbConnect.getConnection();
		int out = 0;
		
		try {
			String getQueryStatement = "call addDonor(?,?,?,?)";
			preparedStatement = conn.prepareCall(getQueryStatement);
			preparedStatement.setString(1, inputData.getString("name"));
			preparedStatement.setString(2, inputData.getString("address"));
			preparedStatement.setString(3, inputData.getString("contactNumber"));
			preparedStatement.registerOutParameter(4, Types.INTEGER);
			
			preparedStatement.executeUpdate();
			out = preparedStatement.getInt(4);
			System.out.println(out);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
