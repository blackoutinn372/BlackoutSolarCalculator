package com.blackout.solarpanelcalculator.client;
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
	public static final int defaultLifeSpan = 25;
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
 * Calculate pay back year
 * @param systemCost
 * @param lifeSpan
 * @param dailySavings
 * @return paybackyear if not exceeding panel life Span, return -1 otherwise
 */
 public static int getPayBackYear(double systemCost, int lifeSpan, double dailySavings  ){
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
	else return -1;

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