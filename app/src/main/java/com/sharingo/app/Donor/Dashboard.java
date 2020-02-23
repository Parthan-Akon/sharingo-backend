package com.sharingo.app.Donor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dashboard {

	int foodCallRecords;
	int completed;
	int plates;
	
	public Dashboard(){
		
	}
	
	public int getFoodCallRecords() {
		return foodCallRecords;
	}
	public void setFoodCallRecords(int foodCallRecords) {
		this.foodCallRecords = foodCallRecords;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public int getPlates() {
		return plates;
	}
	public void setPlates(int plates) {
		this.plates = plates;
	}
	
	
}
