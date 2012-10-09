package com.blackout.solarpanelcalculator.client;

import java.util.TreeMap;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("calculationService")
public interface CalculationService extends RemoteService 
{
	
	double doDailySolarGeneration(double systemSize, double roofEfficiency, 
			double inverterEfficiency, double wiringEfficiency, double whatYear, 
			double agingEfficiencyLoss, double solarIrradiance);
	
	double[] doSolarGenerationForAllMonths(double[]dailyIrradianceInMonth,double systemSize, 
			double roofEfficiency, double inverterEfficiency, double wiringEfficiency, 
			double whatYear, double agingEfficiencyLoss);
	
	double doPowerConsumption(Integer householdSize, String usageType);	
	
	double doDailySavings(double dailyGeneration, double replacePercent, double feedInTarrif, double powerCost);
	
	double doWorthInvestment(double savings, double paybackYear, double duration);
	TreeMap<Double,String> getPayBackTime(double systemCost, double lifeSpan, double replacePercent,double feedInTarrif,
			 double powerCost, double dailyGeneration , double agingEfficiencyLoss,double yearsToCalculate);
	
	double doTotalSubsidy(double zoneRating);
	double getEfficiencyForAngleAndDirection(int directionIndex, int angleIndex);
	/*geo address*/
	String getAddress(String latLong);
	
	/*test sql database*/
	City getCity(int cityIndex);
	String[] getCityList(int postcode);
	int getCityIndex();
	int getCityIDFromPostcode(int postcode);
	
}
