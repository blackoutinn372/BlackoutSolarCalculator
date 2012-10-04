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
				, 25, 24, 44, 19.47, 20.0, 0.7, 25);
		 for (Entry<Double, String> entry : resultsMap.entrySet()) {
		
	        	System.out.println("Key : " + entry.getKey() 
	       			+ " Value : " + entry.getValue());
	        	
	        
		 }
		 System.out.println(resultsMap.get(14155.88));
	}

}
