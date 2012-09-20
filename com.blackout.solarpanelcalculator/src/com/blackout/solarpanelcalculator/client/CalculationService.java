package com.blackout.solarpanelcalculator.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("calculationService")
public interface CalculationService extends RemoteService {
	double doDailySolarGeneration(double systemSize, double roofEfficiency, double inverterEfficiency, double wiringEfficiency, double agingEfficiencyLoss, double solarIrradiance);
	double doDailySolarGeneration(double systemSize, double roofEfficiency, double inverterEfficiency, double wiringEfficiency, double whatYear, double agingEfficiencyLoss, double solarIrradiance);
	double[] doSolarGenerationForAllMonths(double systemSize, double roofEfficiency, double inverterEfficiency, double wiringEfficiency, double whatYear, double agingEfficiencyLoss);
	double doDailySavings(double dailyGeneration, double exportPercent, double replacePercent, double feedInTarrif, double powerCost);
	double doPayBackYear(double systemCost, double lifeSpan, double dailySavings);
	double doPowerConsumption(Integer householdSize, String usageType);	
	double doDailySavings(double dailyGeneration, double replacePercent, double feedInTarrif, double powerCost);
}
