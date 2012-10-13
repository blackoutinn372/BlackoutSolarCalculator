package tests;
/**
 * This test is not used yet.only represents a new formula to 
 * calculate solar power generation
 * dailyGeneration = systemSize * roofEfficiency *inverterEfficiency *wiringEfficiency *solarIrradiance
 * 					
 */
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.TreeMap;

import org.junit.Test;
import com.blackout.solarpanelcalculator.server.CalculationFormulas;

public class TestFormulas 
{
	private static final double DELTA = 1e-10;
	
	//	1st set of values for solar generation
	private final double systemSize1 = 4950; // watts
	private final double roof1 = 88.5; // in percentage
	double inverter1 = 96; // in percentage
	double wiring1 = 98;// in percentage
	double solarIrradiance = 5.1;// in percentage
	double year = 0;
	double age1 =0.7;// in percentage
	double expectedDailyGeneration1 = 21.02;
	
	//	1st set of values for daily savings
	double dailyGeneration1 = 21.02;
	double export1 = 76; // in cents
	double replacement1 = 24; // in percentage
	double tarrif1 = 44;//in cents
	double powerCost1 = 19.47; // in cents
	double expectedSavings1 = 8.01; // in dollars
	
	// 1st set of values of payback time
	double systemCost1 = 18000;
	int lifeSpan1 = 25;
	double dailySavings1 = 8.01;
	double[] dailyIrradianceInMonth = {6.19,5.39,4.95,3.98,3.23,3.02,3.22,4.04,5.12,5.52,6.07,6.35};
	
	double[] expectedMonthGeneration ={790.81,621.88,632.4,492,412.61,373.5,411.37,516.15,633,705.25,750.6,811.27};
	double dailyGeneration = 20.0;//in kws
	double yearsToCalculate = 25;
	String expectedPaybackTime ="6y 8m";
	double expectedFirstPaybackYearProfit = 86.6;
	double expectedSavings = 7.62;
	
	// WorthInvesting Items
	double validSavings = 15;
	double three = 3;
	
	// BankSaving Items
	double bankAmt = 1000;
	double tenPercent = .10;
	
	@Test
	public void testDailyGeneration() {
		assertEquals(expectedDailyGeneration1,CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1, inverter1, wiring1, year, age1, solarIrradiance),
					DELTA);
	}
	@Test
	public void testDailySavings(){
		assertEquals(expectedSavings,CalculationFormulas.getDailySavingsFormula(dailyGeneration, replacement1, tarrif1, powerCost1),DELTA);
	}
	@Test
	public void testPaybackYear(){
		TreeMap<Double,String> resultsMap = CalculationFormulas.getPayBackTime(systemCost1
				, lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		assertEquals(expectedPaybackTime,resultsMap.get(expectedFirstPaybackYearProfit));
	}
	@Test
	public void testMonthlyGeneration(){
		assertTrue(Arrays.equals(expectedMonthGeneration, CalculationFormulas.getSolarGeneFormulaForAllMonths(dailyIrradianceInMonth, systemSize1, roof1, inverter1, wiring1, year, age1)));
	}
	
	/* Worth Investing tests */
	@Test
	public void worthwhileInvestment() {
		assertEquals(validSavings*three, CalculationFormulas.isWorthInvesting(validSavings, three, three*2), DELTA);
	}
	
	@Test
	public void paysForItselfInvestment() {
		assertEquals(0.0, CalculationFormulas.isWorthInvesting(validSavings, three, three), DELTA);
	}
	
	@Test
	public void notWorthInvesting() {
		assertEquals(-15.0, CalculationFormulas.isWorthInvesting(validSavings, three+1, three), DELTA);
	}
	
	@Test
	public void nothingToInvest() {
		assertEquals(0.0, CalculationFormulas.isWorthInvesting(0, 0, 0), DELTA);
	}
	
	@Test
	public void invalidInvestment() {
		assertEquals(0, CalculationFormulas.isWorthInvesting(-validSavings, 0, 0), DELTA);
	}
	
	@Test
	public void unusualLifespanInvestment() {
		assertEquals(0, CalculationFormulas.isWorthInvesting(validSavings, -three, three), DELTA);
	}
	
	@Test
	public void unusualDurationInvestment() {
		assertEquals(0, CalculationFormulas.isWorthInvesting(validSavings, three, -three), DELTA);
	}
	
	/* Bank Interest */
	@Test
	public void aBankTest() {
		// 1000
		// 1100 - 1 year
		// 1210 - 2 year
		// 1331 - 3 years cumulative interest
		assertEquals(1331, CalculationFormulas.calculateBankSavings(three, bankAmt, tenPercent), DELTA);
	}
	
	@Test
	public void noInterestBank() {
		assertEquals(bankAmt, CalculationFormulas.calculateBankSavings(three, bankAmt, 0), DELTA);
	}
	
	@Test
	public void noBaseAmountBank() {
		assertEquals(0, CalculationFormulas.calculateBankSavings(three, 0, tenPercent), DELTA);
	}
	
	@Test
	public void noTimeBank() {
		assertEquals(bankAmt, CalculationFormulas.calculateBankSavings(0, bankAmt, tenPercent), DELTA);
	}
	
	@Test
	public void invalidTimeBank() {
		assertEquals(0, CalculationFormulas.calculateBankSavings(-three, bankAmt, tenPercent), DELTA);
	}
	
	@Test
	public void invalidBaseAmountBank() {
		assertEquals(0, CalculationFormulas.calculateBankSavings(three, -bankAmt, tenPercent), DELTA);
	}
	
	@Test
	public void invalidInterestBank() {
		assertEquals(0, CalculationFormulas.calculateBankSavings(three, bankAmt, -tenPercent), DELTA);
	}
 }
