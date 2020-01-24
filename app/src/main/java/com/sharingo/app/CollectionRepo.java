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
			
			String queryStatement = "call addCollection(?,?,?,?,?,?,?,?,?)";
			callableStatement = conn.prepareCall(queryStatement);
			callableStatement.setInt(1, inputData.getInt("donorID"));
			callableStatement.setInt(2, inputData.getInt("id"));
			callableStatement.setString(3, inputData.getString("deliveredTime"));
			callableStatement.setString(4, inputData.getString("pickupTime"));
			callableStatement.setInt(5, inputData.getInt("servingTemp"));
			callableStatement.setInt(6, inputData.getInt("storageTemp"));
			callableStatement.setInt(7, inputData.getInt("operatorID"));
			callableStatement.setInt(8, completed);
			callableStatement.registerOutParameter(9, Types.INTEGER);
			
			callableStatement.executeUpdate();
			
			out = callableStatement.getInt(9);
			
			System.out.println("The Collection details have been saved successfully!");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
