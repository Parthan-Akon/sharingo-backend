package com.sharingo.app.collection;

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

public class CollectionRepo {
	

	DBConnect dbConnect = new DBConnect();
	private fetchType _fetchType;
	private int id = 0;
	enum fetchType {ALL, ID};	
	
	
	public CollectionRepo(){		
	}
	
	public List<Collection> getCollectionByID(int collectionId){
		this._fetchType = fetchType.ID;
		this.id = collectionId;
		return fetch();
	}
	
	public List<Collection> getCollections(){
		this._fetchType = fetchType.ALL;
		return fetch();
	}
	
	
	public List<Collection> fetch(){
		
		CallableStatement callableStatement = null;
		Connection conn = dbConnect.getConnection();
		String getQueryStatement;
		
		List<Collection> collectionList = new ArrayList<Collection>();
		
		try {
			switch(_fetchType){
			
			case ID: getQueryStatement = "call getCollectionByDonorID(?)";
						callableStatement = conn.prepareCall(getQueryStatement);
						callableStatement.setInt(1, id);
						break;
						
			case ALL: getQueryStatement = "call getCollections()";
						callableStatement = conn.prepareCall(getQueryStatement);
						break;			
			}
			
			ResultSet rs = callableStatement.executeQuery();
			
			while(rs.next()){
				Collection collection = new Collection();
				collection.setFoodRecordId(rs.getInt("FoodRecordID"));
				collection.setFoodDonorId(rs.getInt("FoodDonorID"));
				collection.setDonorName(rs.getString("DonorName"));
				collection.setDonorAddress(rs.getString("DonorAddress"));
				collection.setDonorContact(rs.getString("DonorContact"));
				collection.setDonatedDate(rs.getString("DonatedDate"));
				collection.setFoodCount(rs.getInt("FoodCount"));
				collection.setFoodItems(rs.getString("FoodItems"));
				collection.setServiceCharge(rs.getString("ServiceCharge"));
				collection.setDeliveredTime(rs.getString("DeliveredTime"));
				collection.setPickUpTime(rs.getString("PickupTime"));
				collection.setServingTemp(rs.getInt("ServingTemp"));
				collection.setStorageTemp(rs.getInt("StorageTemp"));
				collection.setOperatorName(rs.getString("OperatorName"));
				collection.setCollectionDate(rs.getString("CollectionDate"));
				
				collectionList.add(collection);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return collectionList;
		
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
			callableStatement.setInt(2, inputData.getInt("foodCallRecordId"));
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
