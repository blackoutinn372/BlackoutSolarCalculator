
/**
  * @author Sen
  * This class is power consumption estimate based on household size 
  * and usage type heavy, meidum or light use
  */
package com.blackout.solarpanelcalculator.client;


public class PowerConsumption {
	static final String[] usageAmounts = {"Heavy", "Medium", "Light"};
	static final double costperKwh = 0.23;//in dollars
	static final double heavyUsagePerDay = 28;//in kwhs
	static final double mediumUsagePerDay = 19;//in kwhs
	static final double lightUsagePerDay = 10;//in kwhs
	
	
	private int householdSize;
	private String usageType;// either heavy, medium , or light
	public PowerConsumption(int householdSize, String usageType) {
		super();
		this.householdSize = householdSize;
		this.usageType = usageType;
	}
	
	
	public double getDailyPowerConsumption(){
		double dailyConsumption = householdSize * getUsagePerDay();
		return Month.TwoDecimals(dailyConsumption);
	}
	
	public double getDailyPowerCost(){
		double dailyPowerCost = getDailyPowerConsumption() * costperKwh;
		return Month.TwoDecimals(dailyPowerCost);
	}
//	output results
	public String toString(){
		return "\nYour household consumes " +getDailyPowerConsumption()+" kws and cost you "+ getDailyPowerCost()+" dollars per day";
	}

	private double getUsagePerDay() {
		if(usageType=="Heavy")
			return heavyUsagePerDay;
		if(usageType=="Medium")
			return mediumUsagePerDay;
		else return lightUsagePerDay;
		}
	}

