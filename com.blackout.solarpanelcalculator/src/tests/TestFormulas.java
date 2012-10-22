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
	double inverter1 = 96;   // in percentage
	double wiring1 = 98;  // in percentage
	double solarIrradiance = 5.1;  // in percentage
	double year = 2;
	double age1 = 0.7;				// in percentage
	double expectedDailyGeneration1 = 20.73;
	
	//	Invalid Values
	private final double invalidNumber = -999999999; 
	private final int invalidInt = -1;
	
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
	
	double[] expectedMonthGeneration ={779.96,613.2,623.72,485.1,407.03,368.1,405.79,509.02,624.3,695.33,740.1,800.11};
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
	
	/* Testing the Daily Generation */
	@Test
	public void testDailyGeneration() {
		assertEquals(expectedDailyGeneration1,
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1, inverter1, 
						wiring1, year, age1, solarIrradiance),
					DELTA);
	}
	
	@Test
	public void badSizeDailyGeneration() {
		assertEquals(
				CalculationFormulas.getDailySolarGeneFormula(CalculationFormulas.defaultSystemSize*1000, 
						roof1, inverter1, wiring1, year, age1, solarIrradiance),
				CalculationFormulas.getDailySolarGeneFormula(invalidNumber, roof1, inverter1, 
						wiring1, year, age1, solarIrradiance),
					DELTA);
	}
	
	@Test
	public void badRoofDailyGeneration() {
		assertEquals(
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, CalculationFormulas.defaultRoofEfficiency*100, 
						inverter1, wiring1, year, age1, solarIrradiance),
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, invalidNumber, inverter1, 
						wiring1, year, age1, solarIrradiance),
					DELTA);
	}
	
	@Test
	public void badInverterDailyGeneration() {
		assertEquals(
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1, 
						CalculationFormulas.defaultInverterEfficiency*100, wiring1, year, age1, solarIrradiance),
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1, invalidNumber, 
						wiring1, year, age1, solarIrradiance),
					DELTA);
	}
	
	@Test
	public void badWiringDailyGeneration() {
		assertEquals(
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1,inverter1, 
						CalculationFormulas.defaultWiringEfficiency*100, year, age1, solarIrradiance),
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1, inverter1, 
						invalidNumber, year, age1, solarIrradiance),
					DELTA);
	}
	
	@Test
	public void badYearDailyGeneration() {
		assertEquals(
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1,inverter1, 
						wiring1, CalculationFormulas.defaultYear, age1, solarIrradiance),
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1, inverter1, 
						wiring1, invalidNumber, age1, solarIrradiance),
					DELTA);
	}
	
	@Test
	public void badAgeDailyGeneration() {
		assertEquals(
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1,inverter1, 
						wiring1, year, CalculationFormulas.defaultPanelAgeEfficiencyLoss*100, solarIrradiance),
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1, inverter1, 
						wiring1, year, invalidNumber, solarIrradiance),
					DELTA);
	}
	
	@Test
	public void badIrradianceDailyGeneration() {
		assertEquals(
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1,inverter1, 
						wiring1, year, age1, 
						CalculationFormulas.defaultSolarIrradiance),
				CalculationFormulas.getDailySolarGeneFormula(systemSize1, roof1, inverter1, 
						wiring1, year, age1, invalidNumber),
					DELTA);
	}
	
	/* Testing Daily Savings */
	@Test
	public void testDailySavings(){
		assertEquals(expectedSavings, CalculationFormulas.getDailySavingsFormula(dailyGeneration, 
				replacement1, tarrif1, powerCost1), DELTA);
	}
	
	@Test
	public void badDailyGenerationDailySavings() {
		assertEquals(CalculationFormulas.getDailySavingsFormula(CalculationFormulas.defaultDailyGeneration, 
				replacement1, tarrif1, powerCost1),
				CalculationFormulas.getDailySavingsFormula(invalidNumber, replacement1, tarrif1, powerCost1),
				DELTA);
	}
	
	@Test
	public void badReplacePercentDailySavings() {
		assertEquals(CalculationFormulas.getDailySavingsFormula(dailyGeneration, CalculationFormulas.defaultReplacePercent*100, 
				tarrif1, powerCost1),
				CalculationFormulas.getDailySavingsFormula(dailyGeneration, invalidNumber, tarrif1, powerCost1),
				DELTA);
	}
	
	@Test
	public void badTariffDailySavings() {
		assertEquals(CalculationFormulas.getDailySavingsFormula(dailyGeneration, replacement1, 
				CalculationFormulas.defaultFeedInFee*100, powerCost1),
				CalculationFormulas.getDailySavingsFormula(dailyGeneration, replacement1, invalidNumber, powerCost1),
				DELTA);
	}
	
	@Test
	public void badPowerCostDailySavings() {
		assertEquals(CalculationFormulas.getDailySavingsFormula(dailyGeneration, replacement1, 
				tarrif1, CalculationFormulas.defaultPowerCost*100),
				CalculationFormulas.getDailySavingsFormula(dailyGeneration, replacement1, tarrif1, invalidNumber),
				DELTA);
	}
	
	/* Test Payback year */
	@Test
	public void testPaybackYear() {
		TreeMap<Double,String> resultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		assertEquals(expectedPaybackTime,resultsMap.get(expectedFirstPaybackYearProfit));
	}
	
	@Test
	public void invalidCostPaybackYear() {
		TreeMap<Double,String> resultsMap = CalculationFormulas.getPayBackTime(0,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		TreeMap<Double,String> invalidResultsMap = CalculationFormulas.getPayBackTime(invalidNumber,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		assertEquals(resultsMap.get(expectedFirstPaybackYearProfit),
				invalidResultsMap.get(expectedFirstPaybackYearProfit));
	}
	
	@Test
	public void invalidLifespanPaybackYear() {
		TreeMap<Double,String> invalidResultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				invalidNumber, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		assertEquals(null,
				invalidResultsMap.get(expectedFirstPaybackYearProfit));
	}
	
	@Test
	public void invalidReplacementPaybackYear() {
		TreeMap<Double,String> resultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		TreeMap<Double,String> invalidResultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, invalidNumber, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		assertEquals(resultsMap.get(expectedFirstPaybackYearProfit),
				invalidResultsMap.get(expectedFirstPaybackYearProfit));
	}
	
	@Test
	public void invalidTariffPaybackYear() {
		TreeMap<Double,String> resultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		TreeMap<Double,String> invalidResultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, invalidNumber, powerCost1, dailyGeneration, age1, yearsToCalculate);
		assertEquals(resultsMap.get(expectedFirstPaybackYearProfit),
				invalidResultsMap.get(expectedFirstPaybackYearProfit));
	}
	
	@Test
	public void invalidPowerCostPaybackYear() {
		TreeMap<Double,String> resultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		TreeMap<Double,String> invalidResultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		assertEquals(resultsMap.get(expectedFirstPaybackYearProfit),
				invalidResultsMap.get(expectedFirstPaybackYearProfit));
	}
	
	@Test
	public void invalidDailyGenPaybackYear() {
		TreeMap<Double,String> resultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		TreeMap<Double,String> invalidResultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		assertEquals(resultsMap.get(expectedFirstPaybackYearProfit),
				invalidResultsMap.get(expectedFirstPaybackYearProfit));
	}
	
	@Test
	public void invalidAgePaybackYear() {
		TreeMap<Double,String> resultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		TreeMap<Double,String> invalidResultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		assertEquals(resultsMap.get(expectedFirstPaybackYearProfit),
				invalidResultsMap.get(expectedFirstPaybackYearProfit));
	}
	
	@Test
	public void invalidYearsPaybackYear() {
		TreeMap<Double,String> resultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		TreeMap<Double,String> invalidResultsMap = CalculationFormulas.getPayBackTime(systemCost1,
				lifeSpan1, replacement1, tarrif1, powerCost1, dailyGeneration, age1, yearsToCalculate);
		assertEquals(resultsMap.get(expectedFirstPaybackYearProfit),
				invalidResultsMap.get(expectedFirstPaybackYearProfit));
	}
	
	/* Monthly Gen tests */
	@Test
	public void testMonthlyGeneration() {
		double[] months = CalculationFormulas.getSolarGeneFormulaForAllMonths(dailyIrradianceInMonth, 
				systemSize1, roof1, inverter1, wiring1, year, age1);
		
		for (int index = 0; index < 12; index++) {
			assertEquals(expectedMonthGeneration[index],months[index], DELTA);
		}
		assertEquals(true, Arrays.equals(expectedMonthGeneration, months));
	}
	
	/* Get efficiency tests (Angle and Direction) */
	@Test
	public void testGetEfficiency() {
		assertNotNull(CalculationFormulas.getEfficiencyForAngleAndDirection(0,0));
	}
	
	@Test
	public void invalidAngleForEfficiency() {
		assertEquals(0.0, CalculationFormulas.getEfficiencyForAngleAndDirection(invalidInt,0),DELTA);
	}
	
	@Test
	public void invalidDirectionForEfficiency() {
		assertEquals(0.0, CalculationFormulas.getEfficiencyForAngleAndDirection(0,invalidInt),DELTA);
	}
	
	/* Worth Investing tests */
	@Test
	public void worthwhileInvestment() {
		assertEquals((validSavings*365)*three, CalculationFormulas.isWorthInvesting(validSavings, three, three*2), DELTA);
	}
	
	@Test
	public void paysForItselfInvestment() {
		assertEquals(0.0, CalculationFormulas.isWorthInvesting(validSavings, three, three), DELTA);
	}
	
	@Test
	public void notWorthInvesting() {
		assertEquals((validSavings*365)*-(three-2), CalculationFormulas.isWorthInvesting(validSavings, three+1, three), DELTA);
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
	
	/* Test Subsidy */
	@Test
	public void testSubsidy() {
		assertEquals(900, CalculationFormulas.getTotalSubsidy(1), DELTA);
	}
	
	@Test
	public void noSubsidy() {
		assertEquals(0, CalculationFormulas.getTotalSubsidy(0), DELTA);
	}
	
	@Test
	public void invalidSubsidy() {
		assertEquals(0, CalculationFormulas.getTotalSubsidy(invalidNumber), DELTA);
	}
	
	/* Bank Interest */
	@Test
	public void aBankTest() {
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
