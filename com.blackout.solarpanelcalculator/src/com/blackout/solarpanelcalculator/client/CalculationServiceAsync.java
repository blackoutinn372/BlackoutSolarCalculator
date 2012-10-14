package com.blackout.solarpanelcalculator.client;

import java.util.TreeMap;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CalculationServiceAsync {
	void doDailySolarGeneration(double systemSize, double roofEfficiency, double inverterEfficiency, double wiringEfficiency, double whatYear, double agingEfficiencyLoss, double solarIrradiance, AsyncCallback<Double> callback);
	void doSolarGenerationForAllMonths(double[]dailyIrradianceInMonth,double systemSize, double roofEfficiency, double inverterEfficiency, double wiringEfficiency, double whatYear, double agingEfficiencyLoss, AsyncCallback<double[]> callback);  
	void doPowerConsumption(Integer householdSize, String usageType,AsyncCallback<Double> callback);
	void doDailySavings(double dailyGeneration, double replacePercent,
			double feedInTarrif, double powerCost,
			AsyncCallback<Double> callback);
	void doWorthInvestment(double savings, double paybackYear, double lifetime, 
			double bankInterest, AsyncCallback<Double> callback);
	void getPayBackTime(double systemCost, double lifeSpan,
			double replacePercent, double feedInTarrif, double powerCost,
			double dailyGeneration, double agingEfficiencyLoss,
			double yearsToCalculate,
			AsyncCallback<TreeMap<Double, String>> callback);
	
	
	
	void getAddress(String latLong, AsyncCallback<String> callback);	
	void getCity(int cityIndex, AsyncCallback<City> callback);
	void getCityList(int postcode, AsyncCallback<String[]> callback);
	void getCityIndex(AsyncCallback<Integer> callback);
	void getCityIDFromPostcode(int postcode, AsyncCallback<Integer> callback);
	void doTotalSubsidy(double zoneRating, AsyncCallback<Double> callback);
	void getEfficiencyForAngleAndDirection(int directionIndex, int angleIndex,
			AsyncCallback<Double> callback);

}
