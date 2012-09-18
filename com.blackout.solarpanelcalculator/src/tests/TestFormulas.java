package tests;
/**
 * This test is not used yet.only represents a new formula to 
 * calculate solar power generation
 * dailyGeneration = systemSize * roofEfficiency *inverterEfficiency *wiringEfficiency *solarIrradiance
 * 					
 */
import static org.junit.Assert.*;

import org.junit.Test;
import com.blackout.solarpanelcalculator.server.CalculationFormulas;

public class TestFormulas {
	private static final double DELTA = 1e-10;
	
//	1st set of values for solar generation
	private final double systemSize1 = 4.95;
	private final double roof1 = 0.885;
	double inverter1 = 0.96;
	double wiring1 = 0.98;
	double solarIrradiance = 5.1;
	double year = 0;
	double age1 =0.007;
	double expectedDailyGeneration1 = 21.02;
	
//	1st set of values for daily savings
	double dailyGeneration1 = 21.02;
	double export1 = 0.76;
	double replacement1 = 0.24;
	double tarrif1 = 0.44;
	double powerCost1 = 0.1941;
	double expectedSavings1 = 8.01;
	
// 1st set of values of payback time
	double systemCost1 = 18000;
	int lifeSpan1 = 25;
	double dailySavings1 = 8.01;
	int expectedPaybackYear1 = 4;
	@Test
	 public void SolarGeneration(){
		
		assertEquals(CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1, inverter1, wiring1, year, age1, solarIrradiance),
					expectedDailyGeneration1,DELTA);
	}
	
	@Test
	public void SolarSavings(){
		assertEquals(CalculationFormulas.getDailySavingsFormula(dailyGeneration1, export1, replacement1, tarrif1, powerCost1),
					expectedSavings1,DELTA);
	}
	@Test
	public void PayBackTime(){
		assertEquals(CalculationFormulas.getPayBackYear(systemCost1, lifeSpan1, dailySavings1),expectedPaybackYear1);
	}
	 }
