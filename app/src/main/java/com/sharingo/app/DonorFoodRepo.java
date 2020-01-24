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

public class DonorFoodRepo {

	DBConnect dbConnect = new DBConnect();
	public DonorFoodRepo(){
		
	}
	
	public List<DonorFood> Fetch(){
		
		PreparedStatement preparedStmt= null;
		Connection conn = dbConnect.getConnection();
		List<DonorFood> foodList = new ArrayList<DonorFood>();
		
		if(conn != null){
			System.out.println("Connection was established sucessfully!");
		} else {
			System.out.println("Connection failed..");
		}
		
		try{
			String getQuery = "call getFoodCallRecords()";
			preparedStmt = conn.prepareStatement(getQuery);
			ResultSet rs = preparedStmt.executeQuery();
			
			while(rs.next()){
				DonorFood donorFood = new DonorFood();
				donorFood.setId(rs.getInt("ID"));
				donorFood.setName(rs.getString("Name"));
				donorFood.setFoodCount(rs.getInt("FoodCount"));
				donorFood.setFoodItems(rs.getString("FoodItems"));
				donorFood.setServiceCharge(rs.getString("ServiceCharge"));
				donorFood.setOperatorName(rs.getString("OperatorName"));
				donorFood.setCompleted(rs.getInt("Completed"));
				
				
				
				foodList.add(donorFood);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return foodList;
	}
	
	public void saveDonorFood(JsonObject inputData){
		
		CallableStatement callableStatement,callableStatement2 = null;
		Connection conn = dbConnect.getConnection();
		int donorID = 0;
		
		try {
			
			String queryStatement = "call addDonor(?,?,?,?)";
			callableStatement = conn.prepareCall(queryStatement);
			callableStatement.setString(1, inputData.getString("name"));
			callableStatement.setString(2, inputData.getString("address"));
			callableStatement.setString(3, inputData.getString("contactNumber"));
			callableStatement.registerOutParameter(4, Types.INTEGER);
			
			callableStatement.executeUpdate();
			donorID = callableStatement.getInt(4);
			
			String queryStatement2 = "call addFoodCalls(?,?,?,?,?)";
			callableStatement2 = conn.prepareCall(queryStatement2);
			callableStatement2.setInt(1, donorID);
			callableStatement2.setInt(2, inputData.getInt("foodCount"));
			callableStatement2.setString(3, inputData.getString("foodItems"));
			callableStatement2.setString(4, inputData.getString("serviceCharge"));
			callableStatement2.setString(5, inputData.getString("operator"));
			
			callableStatement2.executeUpdate();
			
			System.out.println("The donor food details have been saved successfully!");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
