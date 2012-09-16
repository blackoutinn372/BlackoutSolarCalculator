package com.blackout.solarpanelcalculator.Variables;
/**
 * 
 * @author Sen
 * This class represents wiring efficiency 
 * default value is 98% if no input value is given
 * or input value is invalid
 */
public class WiringEfficiency implements Efficiency {
	private double wiringEfficiency;
	private final double defaultEfficiency = 0.98;
	public WiringEfficiency(double wiringEfficiency) {
		if(checkInputEfficiency(wiringEfficiency))
		this.wiringEfficiency = wiringEfficiency;
		else
			this.wiringEfficiency = defaultEfficiency;
	}
	public WiringEfficiency() {
		this.wiringEfficiency = defaultEfficiency;
	}
	public double getWiringEfficiency() {
		return wiringEfficiency;
	}
	public void setWiringEfficiency(double wiringEfficiency) {
		if(checkInputEfficiency(wiringEfficiency))
			this.wiringEfficiency = wiringEfficiency;
		this.wiringEfficiency = wiringEfficiency;
	}
	private boolean checkInputEfficiency(double userInput){
		return userInput >0 && userInput <1;
	}

}
