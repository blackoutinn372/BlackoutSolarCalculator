package com.blackout.solarpanelcalculator.client;

import java_cup.internal_error;

/**
 * This class contains methods to test user input
 * @author Sen
 *
 */
public class Validator {
		
	public static int maxInt = 50;
	private Validator() {		
	}
	
	/* Checks if the postcode is valid for Australia */
	static public boolean isValidPostcode(String str){
		try {
			int postcode = Integer.parseInt(str);
			if((postcode>=2000&&postcode<=2920)||(postcode>=800&&postcode<=899)||(postcode>=3000&&postcode<=5799
					)||(postcode>=6000&&postcode<=6797)||(postcode>=7000&&postcode<=7799))
					return true;
					else return false;
								
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/* Checks if a string is a sensible amount 0-50, inclusive. Used for Years */
	static public boolean isValidNumber(String str){
		try {
			return Integer.parseInt(str) <= maxInt && Integer.parseInt(str)>0;			
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/* Checks if the format of a string is a valid percent 
	 * (Basically 0-100) */
	static public boolean isValidPercentage(String str){
		try {
			if (str.contains("%")) {
				str.replaceFirst("%", "");
			}
			 return Double.parseDouble(str) > 0 && Double.parseDouble(str) <=100;			
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/* Checks if the format of a string is a valid amount of cents 
	 * (Basically 0-99) */
	static public boolean isValidCents(String str){
		try {
			 return Integer.parseInt(str) > 0 && Integer.parseInt(str) < 100;			
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/* Checks if the irradiance is sensible  */
	static public boolean isValidIrradiance(String str){
		try {
			 return Double.parseDouble(str) > 0 && Double.parseDouble(str) < 10;			
		}
		catch (Exception e) {
			return false;
		}
	}
	/* For Watts and Dollars, we expect these numbers big.  */
	static public boolean isValidBigNumber(String str){
			try {
				 return Double.parseDouble(str) > 0 && Double.parseDouble(str) < 1000000;				
			}
			catch (Exception e) {
				return false;
			}
	}
	
	static public double parseYears(String str) {
		double noMonths = 12;
		double number;
		String[] temp;
		temp = str.split(" ");
		try {
			temp[0] = temp[0].replaceFirst("y", "");
			number = Double.parseDouble(temp[0]);
		} catch (Exception ex) {
			number = 0.0;
		}
		try {
			temp[1] = temp[1].replaceFirst("m", "");
			number += Double.parseDouble(temp[1])/noMonths;
		} catch (Exception ex) {
		}
		return number;
	}
	
	
}
