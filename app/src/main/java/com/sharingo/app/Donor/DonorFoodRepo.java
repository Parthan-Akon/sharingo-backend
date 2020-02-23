package com.sharingo.app.Donor;

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

public class DonorFoodRepo {

	DBConnect dbConnect = new DBConnect();
	Connection conn = dbConnect.getConnection();

	public DonorFoodRepo() {

	}

	public Dashboard FetchDashboardCount() {

		CallableStatement callableStatement = null;
		Dashboard dashboard = new Dashboard();

		String getQuery = "call getFoodCallRecordsCount()";
		try {
			callableStatement = conn.prepareCall(getQuery);
			ResultSet rs = callableStatement.executeQuery();
			
			while (rs.next()) {
				dashboard.setFoodCallRecords(rs.getInt("FoodCallRecord"));
				dashboard.setCompleted(rs.getInt("Completed"));
				dashboard.setPlates(rs.getInt("TotalPlates"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dashboard;

	}

	public List<DonorFood> Fetch() {

		PreparedStatement preparedStmt = null;

		List<DonorFood> foodList = new ArrayList<DonorFood>();

		if (conn != null) {
			System.out.println("Connection was established sucessfully!");
		} else {
			System.out.println("Connection failed..");
		}

		try {
			String getQuery = "call getFoodCallRecords()";
			preparedStmt = conn.prepareStatement(getQuery);
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				DonorFood donorFood = new DonorFood();
				donorFood.setfoodCallRecordId(rs.getInt("FoodCallRecordID"));
				donorFood.setDonorId(rs.getInt("DonorID"));
				donorFood.setName(rs.getString("Name"));
				donorFood.setFoodCount(rs.getInt("FoodCount"));
				donorFood.setFoodItems(rs.getString("FoodItems"));
				donorFood.setServiceCharge(rs.getString("ServiceCharge"));
				donorFood.setOperatorName(rs.getString("OperatorName"));
				donorFood.setOperatorID(rs.getInt("OperatorID"));
				donorFood.setCompleted(rs.getInt("Completed"));
				donorFood.setSensCompleted(rs.getInt("SensCompleted"));

				foodList.add(donorFood);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return foodList;
	}

	public void saveDonorFood(JsonObject inputData) {

		CallableStatement callableStatement, callableStatement2 = null;
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
			callableStatement2.setInt(5, inputData.getInt("operatorID"));

			callableStatement2.executeUpdate();

			System.out.println("The donor food details have been saved successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
