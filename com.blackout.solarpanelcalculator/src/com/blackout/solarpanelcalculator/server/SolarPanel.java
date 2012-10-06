package com.blackout.solarpanelcalculator.server;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;

/**
 * SolarPanel entity used by JDO to store data
 * CURRENTLY UNUSED, LEFT IN FOR POTENTIAL USE.
 */
@PersistenceCapable
public class SolarPanel {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key panelID;
	
	@Persistent
	private String brand;
	
	@Persistent
	private String description;
	
	@Persistent
	private double watts;
	
	@Persistent
	private double price;
	
	public SolarPanel() {
		brand = "BRAND";
		description = "A Solar Panel";
		watts = 123.45;
		price = 123.45;
	}
	public SolarPanel(String brnd, String des, double watt, double cost) {
		brand = brnd;
		description = des;
		watts = watt;
		price = cost;
	}
	
	/* Properties */
	public String getBrand() { return brand; }
	public void setBrand(String s) { brand = s; } 
	public String getDescription() { return description; }
	public void setDescription(String s) { description = s; } 
	public double getWatts() { return watts; }
	public void setWatts(double d) { watts = d; } 
	public double getPrice() { return price; }
	public void setPrice(double d) { price = d; }
}
