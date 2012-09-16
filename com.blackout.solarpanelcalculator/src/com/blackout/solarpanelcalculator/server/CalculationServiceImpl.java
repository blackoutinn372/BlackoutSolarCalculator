package com.blackout.solarpanelcalculator.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.blackout.solarpanelcalculator.client.CalculationFormulas;
import com.blackout.solarpanelcalculator.client.CalculationService;

public class CalculationServiceImpl extends RemoteServiceServlet implements CalculationService {

	private static final long serialVersionUID = -1314136203142788858L;

	public double doDailySolarGeneration(double systemSize,
			double roofEfficiency, double inverterEfficiency,
			double wiringEfficiency, double whatYear,
			double agingEfficiencyLoss, double solarIrradiance) {
		return CalculationFormulas.getDailySolarGeneFormula(systemSize, roofEfficiency, inverterEfficiency, wiringEfficiency, whatYear, agingEfficiencyLoss, solarIrradiance);
	}
	
}
