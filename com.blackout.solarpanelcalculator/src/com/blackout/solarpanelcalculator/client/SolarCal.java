package com.blackout.solarpanelcalculator.client;



public class SolarCal{
	private double seasonRate; /*seasonRate depends different season*/
	
	/* Durations of time */
	private static final double week = 7;
	private static final double month = 30;
		
	public SolarCal(double seasonRate)  throws SolarCalException{
		if(seasonRate<=0)
			throw new SolarCalException("seasonRate must be for positive double number.");
		this.seasonRate=seasonRate;
		
	}
	
	public SolarCal() {
		// TODO Auto-generated constructor stub
		seasonRate = 1;
	}

	/* Removed the solar panel to lessen the amount of dependencies - Court */
	//private SolarPanel sp = new SolarPanel(); // create a SoalrPanel object 
	
	/*weekly power generation*/
	public double weeklyGenertaion(double powerGenerated){
		double weeklyGeneration= powerGenerated * week;
		return weeklyGeneration;
	}
	
	/*monthly power generation*/
	public double monthlyGenertaion(double powerGenerated){
		double monthlyGeneration= powerGenerated*month;
		return monthlyGeneration;
	}
	
	/*seasonal power generation*/
	public double seasonalGeneration(double powerGenerated){
		double seasonalGeneration= powerGenerated*seasonRate*month*3;
		return seasonalGeneration;
	}
	
	/*yearly power generation*/
	public double yearlyGenertaion(double powerGenerated){
		double yearlyGeneration= powerGenerated*seasonRate*month*3*4;
		return yearlyGeneration;
	}
	
	/*per day average generation*/
	public double dayAverage(double powerGenerated){
		double dayAverageGeneration = seasonalGeneration(powerGenerated)*seasonRate*2/180; //it is based 2 seasons power generation
		return dayAverageGeneration;
	}
	
}
