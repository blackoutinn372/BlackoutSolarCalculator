package com.blackout.solarpanelcalculator.client;

import java.text.DecimalFormat;
/**
 * based on 1kw system daily output in Melbourne
 * @author Sen
 *
 */

public enum Month {
	June(1.3,30),July(1.5,31),August(2.1,31),September(2.6,30),October(4.2,31),
	November(4.4,30),December(5.1,31),January(4.9,31),February(4.5,28),
	March(3.5,31),April(2.3,30),May(1.8,31);
	
	private final double generation;
	private final int daysInMonth;
	DecimalFormat twoDForm = new DecimalFormat("#.##");
	
	Month(double generation,int daysInMonth){
		this.generation = generation;
		this.daysInMonth = daysInMonth;
	}
	public double GetMonthGeneration(){
		return Double.valueOf(twoDForm.format(generation * daysInMonth)) ;
	}
	public static double GetSummerGeneration(){
		return December.GetMonthGeneration()+January.GetMonthGeneration()+February.GetMonthGeneration();
	}
	public static double GetAutumnGeneration(){
		return March.GetMonthGeneration()+April.GetMonthGeneration()+May.GetMonthGeneration();
	}
	public static double GetWinterGeneration(){
		return June.GetMonthGeneration() + July.GetMonthGeneration() +August.GetMonthGeneration();
	}
	public static double GetSpringGeneration(){
		return September.GetMonthGeneration() + October.GetMonthGeneration() + November.GetMonthGeneration();
	}

}
