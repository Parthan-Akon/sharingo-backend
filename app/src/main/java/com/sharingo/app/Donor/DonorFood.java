package com.sharingo.app.Donor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DonorFood {

	private int foodCallrecordID;
	private int donorId;
	private String name;		
	private int foodCount;
	private String foodItems;
	private String serviceCharge;
	private int operatorID;
	private String operatorName;
	private int completed;
	private int sensCompleted;
	
	
	
	
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	public int getSensCompleted() {
		return sensCompleted;
	}
	public void setSensCompleted(int sensCompleted) {
		this.sensCompleted = sensCompleted;
	}
	public int getfoodCallRecordId() {
		return foodCallrecordID;
	}
	public void setfoodCallRecordId(int id) {
		this.foodCallrecordID = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int id) {
		this.donorId = id;
	}
	
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	public String getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}
	public String getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public int getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	
}
