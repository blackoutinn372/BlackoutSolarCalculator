
/**
  * @author Sen
  * This class is power consumption estimate based on household size 
  * and usage type heavy, meidum or light use
  */
package com.blackout.solarpanelcalculator.client;

import java.util.Arrays;


public class PowerConsumption {
	static final String[] okayUsageType = {"Heavy", "Medium", "Light"};
	static final double costperKwh = 0.23;//in dollars
	static final double heavyUsagePerDay = 28;//in kwhs
	static final double mediumUsagePerDay = 19;//in kwhs
	static final double lightUsagePerDay = 10;//in kwhs
	
	
	private int householdSize;
	private String usageType;// either heavy, medium , or light
	public PowerConsumption(Integer householdSize, String usageType) throws PowerConsumptionException {
		if(!Arrays.asList(okayUsageType).contains(usageType))
			throw new PowerConsumptionException("invalid usage type");
		if(householdSize <1 || !(householdSize instanceof Integer))
			throw new PowerConsumptionException("invalid householdSize");
		this.householdSize = householdSize;
		this.usageType = usageType;
	}
	
	
	public double getDailyPowerConsumption(){
		double dailyConsumption = householdSize * getUsagePerDay();
		return TwoDecimals(dailyConsumption);
	}
	
	public double getDailyPowerCost(){
		double dailyPowerCost = getDailyPowerConsumption() * costperKwh;
		return TwoDecimals(dailyPowerCost);
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
//	make numbers to two decimals places
	private  double TwoDecimals(double number){
		
		return Math.round(number*100.00)/100.00;
	}
	}

