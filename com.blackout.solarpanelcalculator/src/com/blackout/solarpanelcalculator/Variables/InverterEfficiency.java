package com.blackout.solarpanelcalculator.Variables;
/**
 * 
 * @author Sen
 * This class represents InverterEfficiency
 * default value is 96% if no input value is given
 * or input value is invalid
 */
public class InverterEfficiency implements Efficiency {
	private double inverterEfficiency;
	private final double defaultEfficiency = 0.96;
	public InverterEfficiency() {
		inverterEfficiency = defaultEfficiency;
	}
	public InverterEfficiency(double inverterEfficiency ){
		if(checkInputEfficiency(inverterEfficiency))
			this.inverterEfficiency = inverterEfficiency;
			else this.inverterEfficiency = defaultEfficiency;
	}
	
	public double getInverterEfficiency() {
		return inverterEfficiency;
	}


	public void setInverterEfficiency(double inverterEfficiency) {
		if(checkInputEfficiency(inverterEfficiency))
		this.inverterEfficiency = inverterEfficiency;
		else this.inverterEfficiency = defaultEfficiency;
	}


	private boolean checkInputEfficiency(double userInput){
		return userInput >0 && userInput <1;
	}

}
