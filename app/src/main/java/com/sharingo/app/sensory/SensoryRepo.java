package com.sharingo.app.sensory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.json.JsonObject;

import com.sharingo.app.DBConnect;

public class SensoryRepo {

	DBConnect dbConnect = new DBConnect();
	
	public SensoryRepo(){
		
	}
	
	public void saveSensory(JsonObject inputData){
		
		CallableStatement callableStatement, updateStatement = null;
		
		Connection conn = dbConnect.getConnection();
		
		try {
			
			String queryStatement = "call addSensory(?,?,?,?,?,?,?,?)";
			callableStatement = conn.prepareCall(queryStatement);
			callableStatement.setInt(1, inputData.getInt("foodCallRecordId"));
			callableStatement.setString(2, inputData.getString("recipeName"));
			callableStatement.setInt(3, inputData.getInt("appearance"));
			callableStatement.setInt(4, inputData.getInt("aroma"));
			callableStatement.setInt(5, inputData.getInt("taste"));
			callableStatement.setInt(6, inputData.getInt("temperature"));
			callableStatement.setString(7, inputData.getString("fitStatus"));
			callableStatement.setString(8, inputData.getString("acceptability"));
			
			callableStatement.executeQuery();
			
			String updateQueryStatement = "UPDATE foodcallrecord SET SensCompleted = 1 WHERE ID = " + inputData.getInt("foodCallRecordId");
			updateStatement = conn.prepareCall(updateQueryStatement);
			updateStatement.executeUpdate();
			
			
			
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	
		
	}
	
}
