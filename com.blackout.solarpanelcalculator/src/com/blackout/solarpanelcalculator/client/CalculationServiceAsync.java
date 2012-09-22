package com.blackout.solarpanelcalculator.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CalculationServiceAsync {
	void doDailySolarGeneration(double systemSize, double roofEfficiency, double inverterEfficiency, double wiringEfficiency, double whatYear, double agingEfficiencyLoss, double solarIrradiance, AsyncCallback<Double> callback);
	void doSolarGenerationForAllMonths(double systemSize, double roofEfficiency, double inverterEfficiency, double wiringEfficiency, double whatYear, double agingEfficiencyLoss, AsyncCallback<double[]> callback);  
	void doDailySavings(double dailyGeneration, double exportPercent, double replacePercent, double feedInTarrif, double powerCost, AsyncCallback<Double> callback);
	void doPayBackYear(double systemCost, double lifeSpan, double dailySavings,
			AsyncCallback<Double> callback);
	void doPowerConsumption(Integer householdSize, String usageType,AsyncCallback<Double> callback);
	void doDailySavings(double dailyGeneration, double replacePercent,
			double feedInTarrif, double powerCost,
			AsyncCallback<Double> callback);
	void doDailySolarGeneration(double systemSize, double roofEfficiency,
			double inverterEfficiency, double wiringEfficiency,
			double agingEfficiencyLoss, double solarIrradiance,
			AsyncCallback<Double> callback);

	void doWorthInvestment(double savings, double paybackYear, double duration,
			AsyncCallback<Double> callback);
}
