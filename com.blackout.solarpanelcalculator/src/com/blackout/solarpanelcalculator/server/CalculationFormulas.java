package com.blackout.solarpanelcalculator.server;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Sen
 *This class contains formulas to calculate solar generation , savings
 *and payback times
 */
public class CalculationFormulas{
	
	public static final double defaultSystemSize = 4.95;// in kw
	public static final double defaultRoofEfficiency = 0.885;
	public static final double defaultInverterEfficiency = 0.96;
	public static final double defaultWiringEfficiency = 0.98;
	public static final double defaultSolarIrradiance = 5.1;//kWh/m2/day
	public static final double defaultPanelAgeEfficiencyLoss = 0.007;
	public static final double defaultYear = 0;
	public static final double defaultSystemCost = 18000;// in dollars
	public static final double defaultPowerCost = 0.1941;// in dollars per kwh
	public static final double defaultFeedInFee = 0.44; // in dollars per kwh
	public static final double defaultExportPercent = 0.76;
	public static final double defaultReplacePercent = 0.24;
	public static final double defaultLifeSpan = 25;
	public static final double[] monthlySolarIrradiance={6.19*31,5*28,3.9*31,4.95*30,3.98*31,3.23*30,3.02*31,3.22*30,4.04*31,5.12*30,5.52*31,6.07*30,6.35*31};
	public static final String[] months={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	/**
	 * calculate daily solar generation
	 * @param systemSize
	 * @param roofEfficiency
	 * @param inverterEfficiency
	 * @param wiringEfficiency
	 * @param whatYear
	 * @param agingEfficiencyLoss
	 * @param solarIrradiance
	 * @return daily solar generation
	 */
	public static double getDailySolarGeneFormula(double systemSize,double roofEfficiency,double inverterEfficiency,
											  double wiringEfficiency,double whatYear, double agingEfficiencyLoss,double solarIrradiance)
{
		
//		if values invalid , use default values instead
	if(chkInput(systemSize))
		systemSize = defaultSystemSize;
	if(chkEfficiency(roofEfficiency))	
		roofEfficiency = defaultRoofEfficiency;
	if (chkEfficiency(inverterEfficiency))
		inverterEfficiency = defaultInverterEfficiency;
	if (chkEfficiency(wiringEfficiency))
		wiringEfficiency = defaultWiringEfficiency;
	if (chkInput(whatYear))
		whatYear = defaultYear;
	if (chkEfficiency(agingEfficiencyLoss))
		agingEfficiencyLoss = defaultPanelAgeEfficiencyLoss;
	if (chkInput(solarIrradiance))
		solarIrradiance = defaultSolarIrradiance;

	double panelEfficiency = Math.pow((1 - agingEfficiencyLoss)	,whatYear);
	
//	assume no efficiency loss in the first year	
	double generation = systemSize*roofEfficiency*inverterEfficiency*wiringEfficiency*solarIrradiance;
	
	double resultInGivenYear = generation * panelEfficiency;
	
	return TwoDecimals(resultInGivenYear);
	
}
	public static double getDailySolarGeneFormula(double systemSize,double roofEfficiency,double inverterEfficiency,
			  double wiringEfficiency, double agingEfficiencyLoss,double solarIrradiance)
{

double whatYear=0;
double panelEfficiency = Math.pow((1 - agingEfficiencyLoss)	,whatYear);

//assume no efficiency loss in the first year	
double generation = systemSize*roofEfficiency*inverterEfficiency*wiringEfficiency*solarIrradiance;

double resultInGivenYear = generation * panelEfficiency;

return TwoDecimals(resultInGivenYear);

}
	
	public static double[] getSolarGeneFormulaForAllMonths(double systemSize,double roofEfficiency,double inverterEfficiency,
			  double wiringEfficiency,double whatYear, double agingEfficiencyLoss){
		double monthsResults[] = new double[12];
		for(int i = 0; i<monthsResults.length;i++){
			monthsResults[i] = getDailySolarGeneFormula(systemSize,roofEfficiency,inverterEfficiency,
					  wiringEfficiency,whatYear,agingEfficiencyLoss,monthlySolarIrradiance[i]);
		}
		return monthsResults;
		
	}
	 
	
	
	/**
	 * calculate daily savings 
	 * @param dailyGeneration
	 * @param exportPercent
	 * @param replacePercent
	 * @param feedInTarrif
	 * @param powerCost
	 * @return savings each day
	 */
 public static double getDailySavingsFormula(double dailyGeneration, double exportPercent, double replacePercent,double feedInTarrif,double powerCost){
	 
//		if values invalid , use default values instead

	 if (chkEfficiency(exportPercent))
		 exportPercent = defaultExportPercent;
	 if (chkEfficiency(replacePercent)){
		 replacePercent = defaultReplacePercent;
	 }
	 if (chkInput(feedInTarrif))
		 feedInTarrif = defaultFeedInFee;
	 if(chkInput(powerCost))
		 powerCost = defaultPowerCost;
	 
	double result = dailyGeneration * (exportPercent *feedInTarrif + replacePercent*powerCost);
	
	return TwoDecimals(result);
 }
 
/**
 * calculate daily savings without electricity export percentage 
 * @param dailyGeneration
 * @param replacePercent
 * @param feedInTarrif
 * @param powerCost
 * @return savings each day
 */
 public static double getDailySavingsFormula(double dailyGeneration, double replacePercent,double feedInTarrif,double powerCost){
	 

	 
//		if values invalid , use default values instead
	 double exportPercent = 1-replacePercent;

	 if (chkEfficiency(exportPercent))
		 exportPercent = defaultExportPercent;
	 if (chkEfficiency(replacePercent)){
		 replacePercent = defaultReplacePercent;
	 }
	 if (chkInput(feedInTarrif))
		 feedInTarrif = defaultFeedInFee;
	 if(chkInput(powerCost))
		 powerCost = defaultPowerCost;
	 
	double result = dailyGeneration * (exportPercent *feedInTarrif + replacePercent*powerCost);
	
	return TwoDecimals(result);
}
/**
 * Calculate pay back year
 * @param systemCost
 * @param lifeSpan
 * @param dailySavings
 * @return paybackyear if not exceeding panel life Span, otherwise return how many years
 * it would take to pay back (in negatives).
 */
 public static int getPayBackYear(double systemCost, double lifeSpan, double dailySavings  ){
//	 use default year if input not valid
	 if (chkInput(lifeSpan))
		 lifeSpan = defaultLifeSpan;
	 int year = 1;
	 double yearSavings = dailySavings * 365;
	 while(systemCost>yearSavings){
		 yearSavings += yearSavings;
		 year++;
		 if(systemCost<yearSavings){
			 break;
		 }		 
	 }
	if(year<lifeSpan)
		return year;
	else return (int)(year-lifeSpan);

 }
 
 public static TreeMap<Double,String> getPayBackTime(double systemCost, double lifeSpan, double replacePercent,double feedInTarrif,
		 double powerCost, double dailyGeneration , double agingEfficiencyLoss,double yearsToCalculate){
	 
	 if(lifeSpan <yearsToCalculate )
	 yearsToCalculate = lifeSpan;//use panel life span if number of calculate years is greater
	 
	 TreeMap<Double,String> resultsMap = new TreeMap<Double, String>();
	 String yearMonth = null;
	 int totalMonthsInYears = (int)yearsToCalculate * 12;
	 
	double panelEfficiencyMonthly = (1-agingEfficiencyLoss/12);
	double generationMonthly;
	double accumulativeCashFlow = systemCost * -1;
	int monthCounter = 0;
	int yearCounter = 0;
	int month = 1;
	while( month<=totalMonthsInYears){
	 
	
	generationMonthly= dailyGeneration*Math.pow(panelEfficiencyMonthly, month)*30;
	
	accumulativeCashFlow +=getDailySavingsFormula(generationMonthly, replacePercent, feedInTarrif, powerCost);
	if(monthCounter==12){
		monthCounter =0;
		yearCounter++;
	}
	yearMonth = "y"+yearCounter;
	resultsMap.put(TwoDecimals(accumulativeCashFlow),yearMonth);
	month++;
	monthCounter++;
	}
	return resultsMap;
 }
 
 /**
  * Is it worth investing in a system of solar panels? This assumes the user already knows how much
  * their system will earn them and how long it would take to pay itself off.
  * @param savings How much their Daily Savings is
  * @param paybackYear The expected PayBack Year of their panels are
  * @param duration How many years later should the result wait for. 
  * @return How much money the user should expect to earn after the duration of years. 
  * (or how much they lose, should the paybackyear be higher than the duration)
  */
 public static double isWorthInvesting(double savings, double paybackYear, double duration) {
	 double yearsSaved = duration - paybackYear;
	 return savings * yearsSaved;
 }
// use to for two decimals places, gwt doesn't support java.text.decimal	
private static double TwoDecimals(double number){
	
	return Math.round(number*100.00)/100.00;
}
private static boolean chkInput(double input){
    return  !(input>0);
}
private static boolean chkEfficiency(double input){
	return !(input>0&&input<1);
}
}