package com.blackout.solarpanelcalculator.client;
/**
 * This class contains methods to test user input
 * @author Sen
 *
 */
public class Validator {
		
public static int maxInt = 50;
	private Validator(){		
	}
	
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
	static public boolean isValidNumber(String str){
		try {
			return Integer.parseInt(str) <=maxInt && Integer.parseInt(str)>0;			
		}
		catch (Exception e) {
			return false;
		}
	}
	
	static public boolean isValidPercentageAndCents(String str){
		try {
			 return Double.parseDouble(str) > 0 && Double.parseDouble(str) <100;			
		}
		catch (Exception e) {
			return false;
		}
	}
	static public boolean isValidIrradiance(String str){
		try {
			 return Double.parseDouble(str) > 0 && Double.parseDouble(str) <10;			
		}
		catch (Exception e) {
			return false;
		}
	}
	static public boolean isValidDollarsAndWatts(String str){
			try {
				 return Double.parseDouble(str) > 0 && Double.parseDouble(str) <1000000;				
			}
			catch (Exception e) {
				return false;
			}
	}
	
	
}
