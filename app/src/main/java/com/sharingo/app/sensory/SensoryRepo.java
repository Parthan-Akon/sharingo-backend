package com.sharingo.app.sensory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonObject;

import com.sharingo.app.DBConnect;

public class SensoryRepo {

	DBConnect dbConnect = new DBConnect();
	private fetchType _fetchType;
	enum fetchType {ALL, ID};
	private int id = 0;
	
	public SensoryRepo(){
		
	}
	
	public List<Sensory> getSensoryByID(int foodRecordID){
		this._fetchType = fetchType.ID;
		this.id = foodRecordID;
		return fetch();
		
		
	}
	
	public List<Sensory> fetch(){
		
		CallableStatement callableStatement = null;
		Connection conn = dbConnect.getConnection();
		String getQueryStatement;
		
		List<Sensory> sensoryList = new ArrayList<Sensory>();
		
		try{
			
			switch(_fetchType){
			
			case ID: getQueryStatement = "call getSensoryByID(?)";
					 callableStatement = conn.prepareCall(getQueryStatement);
					 callableStatement.setInt(1, id);
					 break;
			}
			
			ResultSet rs = callableStatement.executeQuery();
			
			while(rs.next()){
				Sensory sensory = new Sensory();
				sensory.setRecipeName(rs.getString("RecipeName"));
				sensory.setFoodCallRecordId(rs.getInt("FoodCallRecordID"));
				sensory.setAppearance(rs.getInt("Appearance"));
				sensory.setAroma(rs.getInt("Aroma"));
				sensory.setTaste(rs.getInt("Taste"));
				sensory.setTemperature(rs.getInt("Temperature"));
				sensory.setFitStatus(rs.getString("FitStatus"));
				sensory.setAcceptability("Acceptability");
				
				sensoryList.add(sensory);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sensoryList;
		
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
