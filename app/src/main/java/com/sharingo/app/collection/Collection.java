package com.sharingo.app.collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Collection {

	
	private int foodRecordId;
	private int foodDonorId;
	private String donorName;
	private String donorAddress;
	private String donorContact;
	private String donatedDate;
	private int foodCount;
	private String foodItems;
	private String serviceCharge;
	private String deliveredTime;
	private String pickUpTime;
	private int servingTemp;
	private int storageTemp;
	private String operatorName;
	private String collectionDate;
	
	
	public int getFoodRecordId() {
		return foodRecordId;
	}
	public void setFoodRecordId(int foodRecordId) {
		this.foodRecordId = foodRecordId;
	}
	public int getFoodDonorId() {
		return foodDonorId;
	}
	public void setFoodDonorId(int foodDonorId) {
		this.foodDonorId = foodDonorId;
	}
	public String getDeliveredTime() {
		return deliveredTime;
	}
	public void setDeliveredTime(String deliveredTime) {
		this.deliveredTime = deliveredTime;
	}
	public String getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	public int getServingTemp() {
		return servingTemp;
	}
	public void setServingTemp(int servingTemp) {
		this.servingTemp = servingTemp;
	}
	public int getStorageTemp() {
		return storageTemp;
	}
	public void setStorageTemp(int storageTemp) {
		this.storageTemp = storageTemp;
	}
	public String getCollectionDate() {
		return collectionDate;
	}
	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getDonorAddress() {
		return donorAddress;
	}
	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}
	public String getDonorContact() {
		return donorContact;
	}
	public void setDonorContact(String donorContact) {
		this.donorContact = donorContact;
	}
	public String getDonatedDate() {
		return donatedDate;
	}
	public void setDonatedDate(String donatedDate) {
		this.donatedDate = donatedDate;
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
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	
	
	
}
