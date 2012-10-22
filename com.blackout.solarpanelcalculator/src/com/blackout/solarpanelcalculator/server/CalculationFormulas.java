package com.blackout.solarpanelcalculator.server;
import java.util.TreeMap;
/**
 * 
 * @author Sen
 *This class contains formulas to calculate solar generation , savings
 *and payback times
 */
public class CalculationFormulas
{
	public static final double rateForRecs = 40;//in dollars
	public static final double ratedPowerOutput = 1.5; //kw
	public static final int deemingPeriod = 15;//in years		
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
	public static double daysInYear = 365;
	public static final double defaultDailyGeneration = 20; // in watts
	
	/**
	 * calculate daily solar generation in a given year
	 * 0 year is first year or ignore panel aging efficiency loss
	 * @param systemSize 				
	 * @param roofEfficiency			
	 * @param inverterEfficiency		
	 * @param wiringEfficiency			
	 * @param whatYear					Current year
	 * @param agingEfficiencyLoss		
	 * @param solarIrradiance			
	 * @return daily solar generation	
	 */
	public static double getDailySolarGeneFormula(double systemSize,double roofEfficiency,double inverterEfficiency,
											  double wiringEfficiency,double whatYear, double agingEfficiencyLoss,double solarIrradiance) {	
	systemSize = systemSize /1000; //convert to kws
	//convert to %
	roofEfficiency = roofEfficiency /100;
	inverterEfficiency = inverterEfficiency/100;
	wiringEfficiency = wiringEfficiency/100;
	agingEfficiencyLoss = agingEfficiencyLoss/100;
		
	// if values invalid, use default values instead 
	if(negativeInput(systemSize))
		systemSize = CalculationFormulas.defaultSystemSize;
	if(invalidEfficiency(roofEfficiency))	
		roofEfficiency = defaultRoofEfficiency;
	if (invalidEfficiency(inverterEfficiency))
		inverterEfficiency = defaultInverterEfficiency;
	if (invalidEfficiency(wiringEfficiency))
		wiringEfficiency = defaultWiringEfficiency;
	if (negativeInput(whatYear))
		whatYear = defaultYear;
	if (invalidEfficiency(agingEfficiencyLoss))
		agingEfficiencyLoss = defaultPanelAgeEfficiencyLoss;
	if (negativeInput(solarIrradiance))
		solarIrradiance = defaultSolarIrradiance;
	
	double panelEfficiency = Math.pow((1 - agingEfficiencyLoss), whatYear);
	
	//	assume no efficiency loss in the first year	
	double generation = systemSize * roofEfficiency * inverterEfficiency * 
			wiringEfficiency * solarIrradiance;
	
	double resultInGivenYear = generation * panelEfficiency;
	
	return twoDecimals(resultInGivenYear);
	
}
	/**
	 * calculate power generation for all months
	 * @param systemSize
	 * @param roofEfficiency
	 * @param inverterEfficiency
	 * @param wiringEfficiency
	 * @param whatYear
	 * @param agingEfficiencyLoss
	 * @return an array of 12 months generation
	 */
	public static double[] getSolarGeneFormulaForAllMonths(double[]dailyIrradianceInMonth,double systemSize,double roofEfficiency,double inverterEfficiency,
			  double wiringEfficiency,double whatYear, double agingEfficiencyLoss) {
		double monthsResults[] = new double[12];
		
		for(int i = 0; i<monthsResults.length;i++){
			monthsResults[i] = getDailySolarGeneFormula(systemSize,roofEfficiency,inverterEfficiency,
			wiringEfficiency,whatYear,agingEfficiencyLoss,dailyIrradianceInMonth[i]);
			switch(i){
			case 0:monthsResults[i] =twoDecimals(monthsResults[i]*31);
			break;
			case 1:monthsResults[i] =twoDecimals(monthsResults[i]*28);
			break;
			case 2:monthsResults[i] =twoDecimals(monthsResults[i]*31);
			break;
			case 3:monthsResults[i] =twoDecimals(monthsResults[i]*30);
			break;
			case 4:monthsResults[i] =twoDecimals(monthsResults[i]*31);
			break;
			case 5:monthsResults[i] =twoDecimals(monthsResults[i]*30);
			break;
			case 6:monthsResults[i] =twoDecimals(monthsResults[i]*31);
			break;
			case 7:monthsResults[i] =twoDecimals(monthsResults[i]*31);
			break;
			case 8:monthsResults[i] =twoDecimals(monthsResults[i]*30);
			break;
			case 9:monthsResults[i] =twoDecimals(monthsResults[i]*31);
			break;
			case 10:monthsResults[i] =twoDecimals(monthsResults[i]*30);
			break;
			case 11:monthsResults[i] =twoDecimals(monthsResults[i]*31);
			break;
			
			}
		}
		return monthsResults;	
	}
	
	/**
	 * calculate daily savings without electricity export percentage 
	 * @param dailyGeneration	in Watts
	 * @param replacePercent	
	 * @param feedInTarrif		rewarded money for providing more power than used
	 * @param powerCost			electrical costs of the living area
	 * @return savings each day	in AUD
	 */
	 public static double getDailySavingsFormula(double dailyGeneration, double replacePercent,double feedInTariff,double powerCost) {
		 
		 replacePercent = replacePercent / 100;
		 //convert cents to dollars
		 feedInTariff = feedInTariff / 100;
		 powerCost = powerCost / 100;
		 //		if values invalid , use default values instead
		 
		 double exportPercent = 1-replacePercent;
	
		 if (negativeInput(dailyGeneration)) dailyGeneration = defaultDailyGeneration;
		 if (invalidEfficiency(exportPercent))
			 exportPercent = defaultExportPercent;
		 if (invalidEfficiency(replacePercent)){
			 replacePercent = defaultReplacePercent;
		 }
		 if (negativeInput(feedInTariff))
			 feedInTariff = defaultFeedInFee;
		 if(negativeInput(powerCost))
			 powerCost = defaultPowerCost;
		double result = dailyGeneration * (exportPercent *feedInTariff + replacePercent*powerCost);
		return twoDecimals(result);
	}

	 /**
	  * calculate accumulative cash  in every month and year in given years
	  * @param systemCost 			How much the system costs
	  * @param panelLifeSpan		In years
	  * @param replacePercent		
	  * @param feedInTarrif			rewarded money for providing more power than used
	  * @param powerCost			electrical costs of the living area
	  * @param dailyGeneration		Amount of energy generated daily
	  * @param agingEfficiencyLoss	As a percentage
	  * @param yearsToCalculate		Definitive 
	  * @return a map of key in money , value in month and year
	  */
	 public static TreeMap<Double,String> getPayBackTime (double systemCost, double panelLifeSpan, double replacePercent,double feedInTarrif,
			 double powerCost, double dailyGeneration , double agingEfficiencyLoss,double yearsToCalculate) {
		agingEfficiencyLoss = agingEfficiencyLoss/100;
		if (yearsToCalculate <= 0) return null;
		if (panelLifeSpan < yearsToCalculate)
			yearsToCalculate = Math.max(panelLifeSpan,0);//use panel life span if number of calculate years is greater	 
		systemCost = Math.max(systemCost, 0);
		
		TreeMap<Double,String> resultsMap = new TreeMap<Double, String>();
		
		String yearMonth = null;
		int totalMonthsInYears = (int)yearsToCalculate * 12;	 
		double panelEfficiencyMonthly = ( 1-agingEfficiencyLoss / 12);
		double generationMonthly;
		double accumulativeCashFlow = systemCost * -1;
		int monthCounter = 0;
		int yearCounter = 0;
		int month = 1;
		
		while( month<=totalMonthsInYears) {
			generationMonthly= dailyGeneration*Math.pow(panelEfficiencyMonthly, month)*30;
			accumulativeCashFlow +=getDailySavingsFormula(generationMonthly, replacePercent, feedInTarrif, powerCost);
			
			if(monthCounter==12) {
				monthCounter =0;
				yearCounter++;
			}
			
			yearMonth = yearCounter+"y "+monthCounter+"m";
			resultsMap.put(twoDecimals(accumulativeCashFlow),yearMonth);
			month++;
			monthCounter++;
		}
		return resultsMap;
	 }
	 /**
	  * calculate total subsidy
	  * @param zoneRating		
	  * @return totalSubsidy	
	  */
	 public static double getTotalSubsidy(double zoneRating) {
		 zoneRating = Math.max(0, zoneRating);
		 double totalSubsidy = zoneRating * rateForRecs * ratedPowerOutput * deemingPeriod;
		 return twoDecimals(totalSubsidy);
	 }
	 public static double getEfficiencyForAngleAndDirection(int directionIndex, int angleIndex){
		 double directionEfficiency = 0;
		 double angleEfficiency = 0;
		 
		 switch(directionIndex) {
			 case 0: directionEfficiency = 0.98;
			 break;
			 case 1: directionEfficiency = 0.975;
			 break;
			 case 2: directionEfficiency = 0.955;
			 break;
			 case 3: directionEfficiency = 0.783;
			 break;
			 case 4: directionEfficiency = 0.95;
			 break;
			 case 5: directionEfficiency = 0.9;
			 break;
			 case 6: directionEfficiency = 0.9;
			 break;
			 case 7: directionEfficiency = 0.783;
			 break;
			 default: directionEfficiency = 0;
		 }
		 
		 switch(angleIndex){
			 case 0:angleEfficiency = 0.903;
			 break;
			 case 1:angleEfficiency = 0.81;
			 break;
			 case 2:angleEfficiency = 0.78;
			 break;
			 default: angleEfficiency = 0;
		 }
		 return twoDecimals(directionEfficiency*angleEfficiency)*100; 
	 }
	 
	 /**
	  * Is it worth investing in a system of solar panels? This assumes the user already knows how much
	  * their system will earn them and how long it would take to pay itself off.
	  * @param 		savings How much their Daily Savings is
	  * @param 		paybackYear The expected PayBack Year of their panels are
	  * @param 		duration How many years later should the result wait for. 
	  * @return 	How much money the user should expect to earn after the duration of years. 
	  * 			(or how much they lose, should the paybackyear be higher than the duration)
	  */
	public static double isWorthInvesting(double savings, double paybackYear, double duration) {
		if (paybackYear < 0 || duration <= 0) { return 0; }
		try {
			double yearsSaved = duration - paybackYear;
			return twoDecimals((savings*daysInYear) * yearsSaved);
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * How much interest can a bank account acquire over time?
	 * @param years			
	 * @param startingBank	Amount of money starting in the bank account
	 * @param interest		Additional % of interest (eg .15 will become 1.15)
	 * @return				
	 */
	public static double calculateBankSavings(double years, double startingBank, double interest) {
		if (years < 0 || startingBank < 0 || interest < 0) return 0;
		double amount = startingBank;
		for (int i = 0; i < years; i++) {
			amount = amount*(1+interest);
		}
		return twoDecimals(amount);
	}
	
	public static double compareSystems() {
		return 0.0;
	}
	
	// use to for two decimals places, gwt doesn't support java.text.decimal	
	private static double twoDecimals(double number) {
		return Math.round(number*100.00)/100.00;
	}
	
	private static boolean negativeInput(double input) {
	    return  (input <= 0);
	}
	
	private static boolean invalidEfficiency(double input) {
		return (input < 0 || input > 1);
	}

}