package tests;

import static org.junit.Assert.*;

import com.blackout.solarpanelcalculator.client.PowerConsumption;
import com.blackout.solarpanelcalculator.client.PowerConsumptionException;

import org.junit.Before;
import org.junit.Test;


public class PowerConsumptionTest {

	 /*Scenario 1 */
	 int householdsize = 4;
	 String usageType = "Heavy";
	 
	 /*Scenario 2*/
	 int householdsize2 = 3;
	 String usageType2 = "Light";
	 
	 /*Scenario 3*/
	 int householdsize3 = 5;
	 String usageType3 = "medium";

	 /*invalid Scenario*/
	 int invalidHouseholdsize = 0;

	 PowerConsumption powerConsump;
	 
	 @Before
	 public void PowerConsumption() throws PowerConsumptionException{
		 powerConsump = new PowerConsumption(householdsize, usageType);
	 }
	 
	 /*Test scenario 1 consumption output*/
	 @Test
     public void PowerConsumed(){
	     assertEquals(Double.compare(powerConsump.getDailyPowerConsumption(), 112.0), 0);
     }
	 
	 /*Test scenario 2 consumption output*/
	 @Test
     public void PowerConsumed2() throws PowerConsumptionException{
		 powerConsump = new PowerConsumption(householdsize2, usageType2);
	     assertEquals(Double.compare(powerConsump.getDailyPowerConsumption(), 30.0), 0);
     }
	 
	 /*Test scenario 3 consumption output*/
	 @Test
     public void PowerConsumed3() throws PowerConsumptionException{
		 powerConsump = new PowerConsumption(householdsize3, usageType3);
		 assertEquals(Double.compare(powerConsump.getDailyPowerConsumption(), 95.0), 0);
     }
	 // invalid householdsize
	 @Test
     public void invalidHouseholdSize() throws PowerConsumptionException{
		 powerConsump = new PowerConsumption(invalidHouseholdsize, usageType);
     }
}
