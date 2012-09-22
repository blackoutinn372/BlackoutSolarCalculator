package tests;

import java.util.Map.Entry;
import java.util.TreeMap;

import com.blackout.solarpanelcalculator.server.CalculationFormulas;

public class TestPayback {

	public TestPayback() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMap<Double,String> resultsMap = CalculationFormulas.getPayBackTime(18000
				, 25, 0.24, 0.44, 0.1947, 20.0, 0.07, 25);
		 for (Entry<Double, String> entry : resultsMap.entrySet()) {
	        	System.out.println("Key : " + entry.getKey() 
	       			+ " Value : " + entry.getValue());
	        }

	}

}
