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

public class CollectionRepo {

	DBConnect dbConnect = new DBConnect();
	public CollectionRepo(){
		
	}
	
	public void saveCollection(JsonObject inputData){
		
		CallableStatement callableStatement = null;
		Connection conn = dbConnect.getConnection();
		int out = 0;
		int completed = 1;
		
		try {
			
			String queryStatement = "call addCollection(?,?,?,?,?,?,?,?)";
			callableStatement = conn.prepareCall(queryStatement);
			callableStatement.setInt(1, inputData.getInt("donorID"));
			callableStatement.setString(2, inputData.getString("deliveredTime"));
			callableStatement.setString(3, inputData.getString("pickupTime"));
			callableStatement.setInt(4, inputData.getInt("servingTemp"));
			callableStatement.setInt(5, inputData.getInt("storageTemp"));
			callableStatement.setString(6, inputData.getString("operator"));
			callableStatement.setInt(7, completed);
			callableStatement.registerOutParameter(8, Types.INTEGER);
			
			callableStatement.executeUpdate();
			
			out = callableStatement.getInt(8);
			
			System.out.println("The Collection details have been saved successfully!");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
