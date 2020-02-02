package com.sharingo.app.Donor;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonObject;

import com.sharingo.app.DBConnect;

public class DonorRepo {

	private int id = 0;
	private fetchType _fetchType;
	DBConnect dbConnect = new DBConnect();
	
	enum fetchType {ALL, ID};

	
	public DonorRepo(){
		
	}
	
	public List<Donor> getDonorByID(int id){
		this.id = id;
		this._fetchType = fetchType.ID;
		return fetch();
	}
	
	public List<Donor> getDonorList(){
		this._fetchType = fetchType.ALL;
		return fetch();
	}
	
	public byte[] getfeedback(){
		CallableStatement callableStatement = null;
		Connection conn = dbConnect.getConnection();
		String getQueryStatement = "SELECT * FROM sharingo.feedback";
		 byte[] imgData = null;
		 Blob img = null;
		
		try {
			
			callableStatement = conn.prepareCall(getQueryStatement);
			
			ResultSet rs = callableStatement.executeQuery();
			while(rs.next()){
				
				img = rs.getBlob("Signature");
				imgData = img.getBytes(1, (int) img.length());
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return imgData;
		
	}
	
	public List<Donor> fetch(){
		String name = null;
		PreparedStatement preparedStmt= null;
		CallableStatement callableStatement = null;
		Connection conn = dbConnect.getConnection();
		String getQueryStatement;
		
		List<Donor> donorList = new ArrayList<Donor>();
		
		if(conn != null){
			System.out.println("Connection was established sucessfully!");
		} else {
			System.out.println("Connection failed..");
		}
		
		try {
			
			
			
			switch(_fetchType){
			case ID : getQueryStatement = "call sharingo.getDonorByID(?)";
					callableStatement = conn.prepareCall(getQueryStatement);
					callableStatement.setInt(1, this.id);
					break;
					
			case ALL : getQueryStatement = "Select * from donor";
					callableStatement = conn.prepareCall(getQueryStatement);
					break;
			}
			
			ResultSet rs =  callableStatement.executeQuery();
			
			while(rs.next()){
				Donor donor = new Donor();
				donor.setId(rs.getInt("ID"));
				donor.setName(rs.getString("Name"));
				donor.setAddress(rs.getString("Address"));
				donor.setContactNumber(rs.getString("Contact"));
				donor.setInActive(rs.getInt("Inactive"));
				donor.setDateOfRegis(rs.getString("DOR"));
				
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
