package com.blackout.solarpanelcalculator.client;




/**
 * This Month enum type represents 12 months with two values 
 * 1st value is 1kw system daily output 
 * 2nd value is no. of days in the month
 * (output values based in Melbourne)
 * @author Sen
 *
 */

public enum Month {
	June(1.3,30),July(1.5,31),August(2.1,31),September(2.6,30),October(4.2,31),
	November(4.4,30),December(5.1,31),January(4.9,31),February(4.5,28),
	March(3.5,31),April(2.3,30),May(1.8,31);
	
	private final double generation;
	private final int daysInMonth;
	
	
	Month(double generation,int daysInMonth){
		this.generation = generation;
		this.daysInMonth = daysInMonth;
	}
	public Double GetMonthGeneration(){
		return TwoDecimals((generation * daysInMonth)) ;
	}
	public static double GetSummerGeneration(){
		return TwoDecimals(December.GetMonthGeneration()+January.GetMonthGeneration()+February.GetMonthGeneration());
	}
	public static double GetAutumnGeneration(){
		return TwoDecimals(March.GetMonthGeneration()+April.GetMonthGeneration()+May.GetMonthGeneration());
	}
	public static double GetWinterGeneration(){
		return TwoDecimals(June.GetMonthGeneration() + July.GetMonthGeneration() +August.GetMonthGeneration());
	}
	public static double GetSpringGeneration(){
		return TwoDecimals(September.GetMonthGeneration() + October.GetMonthGeneration() + November.GetMonthGeneration());
	}
//	make numbers to two decimals places
	private static double TwoDecimals(double number){
		
		return Math.round(number*100.00)/100.00;
	}
}
