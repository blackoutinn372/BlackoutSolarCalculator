package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.blackout.solarpanelcalculator.client.PowerConsumption;
import com.blackout.solarpanelcalculator.client.PowerConsumptionException;

public class PowerConsumptionTest {
	private static final double DELTA = 1e-15;
	/*Scenario 1 */
	 int householdsize = 4;
	 String usageType = "Heavy";
	 
	 /*Scenario 2*/
	 int householdsize2 = 3;
	 String usageType2 = "Light";
	 
	 /*Scenario 3*/
	 int householdsize3 = 5;
	 String usageType3 = "Medium";
	
	 /*invalid Scenario*/
	 int invalidHouseholdsize = 0;
	 
	/* defaults */
	static final int loneMan = 1;
	static final int couple = 2;
	static final int family = 5;
	
	static final String highUsage = "Heavy";
	static final String medUsage = "Medium";
	static final String lowUsage = "Light";
	
	PowerConsumption powerConsumption;
	
	/*
	@After
	public void clearPower() {
		pc = null;
	}*/
	@Before
	 public void PowerConsumption() throws PowerConsumptionException{
		powerConsumption = new PowerConsumption(householdsize, usageType);
	}
	
	
	/* Can create a powerConsumption object */
	@Test
	public void testPowerConsumption() throws PowerConsumptionException {
		powerConsumption = new PowerConsumption(loneMan, lowUsage);
	}
	
	/* Gets the power usage of a single member */
	@Test
	public void getPowerOfSingle() throws PowerConsumptionException {
		powerConsumption = new PowerConsumption(loneMan, lowUsage);
		double consumption = powerConsumption.getDailyPowerConsumption();
		assertEquals(consumption,10.0,DELTA);
	}
	
	/* Gets the power usage of a couple */
	@Test
	public void getPowerOfCouple() throws PowerConsumptionException {
		powerConsumption = new PowerConsumption(couple, lowUsage);
		double consumption = powerConsumption.getDailyPowerConsumption();
		assertEquals(consumption,20.0,DELTA);
	}
	
	/* Gets the power usage of a typical family */
	@Test
	public void getPowerOfFamily() throws PowerConsumptionException {
		powerConsumption = new PowerConsumption(family, lowUsage);
		double consumption = powerConsumption.getDailyPowerConsumption();
		assertEquals(consumption,50.0,DELTA);
	}
	
	/* Gets the cost of a single man's power usage */
	@Test
	public void getDailyPowerCost() throws PowerConsumptionException {
		powerConsumption = new PowerConsumption(loneMan, lowUsage);
		double costs = powerConsumption.getDailyPowerCost();
		assertTrue(Double.compare(costs, 2.3) == 0);
		assertEquals(costs,2.3,DELTA);
	}
	
	/* Gives an invalid amount of family members */
	@Test(expected = PowerConsumptionException.class)
	public void inValidFamily() throws PowerConsumptionException {
		powerConsumption = new PowerConsumption(-1, lowUsage);
		
	}
	
	/* Gives an invalid amount of family members */
	@Test(expected = PowerConsumptionException.class)
	public void noFamily() throws PowerConsumptionException {
		powerConsumption = new PowerConsumption(0, lowUsage);
		
	}
	
	/* Gives an unusual power consumption amount */
	@Test(expected = PowerConsumptionException.class)
	public void invalidUsage() throws PowerConsumptionException {
		powerConsumption = new PowerConsumption(loneMan, "Too much");
		
	}
	
	/* Gives no actual usage */
	@Test(expected = PowerConsumptionException.class)
	public void noUsage() throws PowerConsumptionException {
		powerConsumption = new PowerConsumption(loneMan, "");
	}
	 
	/*Test scenario 1 consumption output*/
	@Test
    public void PowerConsumed(){
	    
	    assertEquals(powerConsumption.getDailyPowerConsumption(),112.0,DELTA);
    }
	
	/*Test scenario 2 consumption output*/
	@Test
    public void PowerConsumed2() throws PowerConsumptionException{
		powerConsumption = new PowerConsumption(householdsize2, usageType2);
	    assertEquals(powerConsumption.getDailyPowerConsumption(),30.0,DELTA);
    }
	
	/*Test scenario 3 consumption output*/
	@Test
    public void PowerConsumed3() throws PowerConsumptionException{
		powerConsumption = new PowerConsumption(householdsize3, usageType3);
		assertEquals( powerConsumption.getDailyPowerConsumption(),95.0, DELTA);
    }
	// invalid householdsize
	@Test(expected = PowerConsumptionException.class)
    public void invalidHouseholdSize() throws PowerConsumptionException{
		powerConsumption = new PowerConsumption(invalidHouseholdsize, usageType);
    }
}