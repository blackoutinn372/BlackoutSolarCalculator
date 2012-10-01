package com.blackout.solarpanelcalculator.client;

import com.google.gwt.user.client.rpc.IsSerializable;


public class City implements IsSerializable {

	private String cityName;
	private double feedInTariff;
	private double electricityCost;
	private int postcode;
	private int optimalYearDegree;
	private int bestWinterDegree;
	private int bestSummerDegree;
	private double avgIrradiance;
	private double monthsIrradiance[];
	
	
	public String getCityName() {
		return cityName;
	}

	public double getFeedInTariff() {
		return feedInTariff;
	}

	public double getElectricityCost() {
		return electricityCost;
	}

	public int getPostcode() {
		return postcode;
	}
	public double getIrradiance(){
		return avgIrradiance;
	}
	public void setIrradiance(double irradiance){
		this.avgIrradiance = irradiance;
		
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setFeedInTariff(double feedInTariff) {
		this.feedInTariff = feedInTariff;
	}

	public void setElectricityCost(double electricityCost) {
		this.electricityCost = electricityCost;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public void setOptimalYearDegree(int optimalYearDegree) {
		this.optimalYearDegree = optimalYearDegree;
	}

	public void setBestWinterDegree(int bestWinterDegree) {
		this.bestWinterDegree = bestWinterDegree;
	}

	public void setBestSummerDegree(int bestSummerDegree) {
		this.bestSummerDegree = bestSummerDegree;
	}

	public void setMonthsIrradiance(double[] monthsIrradiance) {
		this.monthsIrradiance = monthsIrradiance;
	}

	public int getOptimalYearDegree() {
		return optimalYearDegree;
	}

	public int getBestWinterDegree() {
		return bestWinterDegree;
	}

	public int getBestSummerDegree() {
		return bestSummerDegree;
	}

	public double[] getMonthsIrradiance() {
		return monthsIrradiance;
	}

	public double getAvgIrradiance() {
		double total = 0;
		for(double d:monthsIrradiance){
			total+=d;
		}	
		return TwoDecimals(total/12);
	}
	private static double TwoDecimals(double number){
		
		return Math.round(number*100.00)/100.00;
	}
	
}
