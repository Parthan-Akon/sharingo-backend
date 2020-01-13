package com.sharingo.app;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Donor {
	
	private int id;
	private int inActive;
	private String name;
	private String address;
	private String contactNumber;
	
	
	public int getInActive() {
		return inActive;
	}
	public void setInActive(int inActive) {
		this.inActive = inActive;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	
}
