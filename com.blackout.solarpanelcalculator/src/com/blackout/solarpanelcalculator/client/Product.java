package com.blackout.solarpanelcalculator.client;


import com.google.gwt.user.client.rpc.IsSerializable;

/*
* Product Set and Get methods
*/

public class Product implements IsSerializable {
	
	private int id;
	private String type;
	private String brand;
	private String descriptions;
	private double power;
	private double efficiency;
	private double price;
	
	/*Gets Methods*/
	public int getId(){
		return id;
	}
	public String getType() {
		return type;
	}
	public String getBrand() {
		return brand;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public double getPower() {
		return power;
	}
	public double getEfficiency() {
		return efficiency;
	}
	public double getPrice() {
		return price;
	}
	
	
	/*Setters methods*/
	public void setId(int type) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
