package com.blackout.solarpanelcalculator.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.blackout.solarpanelcalculator.client.CalculationService;

public class CalculationServiceImpl extends RemoteServiceServlet implements CalculationService {

	private static final long serialVersionUID = -1314136203142788858L;
	
	@Override
	public double doPowerConsumption(Integer householdSize, String usageType) {
		PowerConsumption powerConsumption=null;
		try {
			powerConsumption = new PowerConsumption(householdSize, usageType);
		} catch (PowerConsumptionException e) {
		
		}
		if(powerConsumption!=null){
		return powerConsumption.getDailyPowerConsumption();
		}
		return 0;
	}
	

	@Override
	public double doDailySolarGeneration(double systemSize,
			double roofEfficiency, double inverterEfficiency,
			double wiringEfficiency, double whatYear,
			double agingEfficiencyLoss, double solarIrradiance) {
		return CalculationFormulas.getDailySolarGeneFormula(systemSize, roofEfficiency, inverterEfficiency, wiringEfficiency, whatYear, agingEfficiencyLoss, solarIrradiance);
	}
	
	
	
	@Override
	public double doDailySavings(double dailyGeneration, double exportPercent,
			double replacePercent, double feedInTarrif, double powerCost) {
		return CalculationFormulas.getDailySavingsFormula(dailyGeneration, exportPercent, replacePercent, feedInTarrif, powerCost);
	}

	@Override
	public double doPayBackYear(double systemCost, double lifeSpan,
			double dailySavings) {
		
		return CalculationFormulas.getPayBackYear(systemCost, lifeSpan, dailySavings);
	}

	@Override
	public double[] doSolarGenerationForAllMonths(double systemSize,
			double roofEfficiency, double inverterEfficiency,
			double wiringEfficiency, double whatYear, double agingEfficiencyLoss) {
		
		return CalculationFormulas.getSolarGeneFormulaForAllMonths(systemSize, roofEfficiency, inverterEfficiency, wiringEfficiency, whatYear, agingEfficiencyLoss);
	}


	@Override
	public double doDailySavings(double dailyGeneration, double replacePercent,
			double feedInTarrif, double powerCost) {
		// TODO Auto-generated method stub
		return CalculationFormulas.getDailySavingsFormula(dailyGeneration, replacePercent, feedInTarrif, powerCost);
	}


	@Override
	public double doDailySolarGeneration(double systemSize,
			double roofEfficiency, double inverterEfficiency,
			double wiringEfficiency, double agingEfficiencyLoss,
			double solarIrradiance) {
		return CalculationFormulas.getDailySolarGeneFormula(systemSize, roofEfficiency, inverterEfficiency, wiringEfficiency, agingEfficiencyLoss, solarIrradiance);
	}

	
	public double doWorthInvestment(double dailySavings, double paybackYear, double duration) {
		return CalculationFormulas.isWorthInvesting(dailySavings, paybackYear, duration);
	}
	
}
