package com.blackout.solarpanelcalculator.Variables;
/**
 * 
 * @author Sen
 * This class represents RoofEfficiency
 * default value is 88.5%  if no input value is given
 * or input value is invalid
 */
public class RoofEfficiency implements Efficiency {

	private double roofEfficiency;
	private final double  defaultRoofEfficiency = 0.885;
	
	public RoofEfficiency() {
		roofEfficiency = defaultRoofEfficiency;
	}
	public RoofEfficiency(double roofEfficiency){
		if (checkInputEfficiency(roofEfficiency))
			this.roofEfficiency = roofEfficiency;
		else 
			roofEfficiency = defaultRoofEfficiency;
}
	public double getRoofEfficiency() {
		return roofEfficiency;
	}
	public void setRoofEfficiency(double roofEfficiency) {
		if (checkInputEfficiency(roofEfficiency))
			this.roofEfficiency = roofEfficiency;
		else 
			roofEfficiency = defaultRoofEfficiency;
	}
	
	private boolean checkInputEfficiency(double userInput){
		return userInput >0 && userInput <1;
	}
}

