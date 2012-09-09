package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.blackout.solarpanelcalculator.client.PowerConsumption;
import com.blackout.solarpanelcalculator.client.PowerConsumptionException;

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
	 
	/* defaults */
	static final int loneMan = 1;
	static final int couple = 2;
	static final int family = 5;
	
	static final String highUsage = "Heavy";
	static final String medUsage = "Medium";
	static final String lowUsage = "Light";
	
	PowerConsumption pc;
	
	/*
	@After
	public void clearPower() {
		pc = null;
	}*/
	@Before
	 public void PowerConsumption() throws PowerConsumptionException{
		pc = new PowerConsumption(householdsize, usageType);
	}
	
	
	/* Can create a powerConsumption object */
	@Test
	public void testPowerConsumption() {
		pc = new PowerConsumption(loneMan, lowUsage);
	}
	
	/* Gets the power usage of a single member */
	@Test
	public void getPowerOfSingle() {
		pc = new PowerConsumption(loneMan, lowUsage);
		double consumption = pc.getDailyPowerConsumption();
		assertTrue(consumption == 10.0);
	}
	
	/* Gets the power usage of a couple */
	@Test
	public void getPowerOfCouple() {
		pc = new PowerConsumption(couple, lowUsage);
		double consumption = pc.getDailyPowerConsumption();
		assertTrue(consumption == 20.0);
	}
	
	/* Gets the power usage of a typical family */
	@Test
	public void getPowerOfFamily() {
		pc = new PowerConsumption(family, lowUsage);
		double consumption = pc.getDailyPowerConsumption();
		assertTrue(consumption == 50.0);
	}
	
	/* Gets the cost of a single man's power usage */
	@Test
	public void getDailyPowerCost() {
		pc = new PowerConsumption(loneMan, lowUsage);
		double costs = pc.getDailyPowerCost();
		assertTrue(Double.compare(costs, 2.3) == 0);
	}
	
	/* Should create a proper string */
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}
	
	/* Gives an invalid amount of family members */
	@Test(expected = PowerConsumptionException.class)
	public void inValidFamily() {
		pc = new PowerConsumption(-1, lowUsage);
		
	}
	
	/* Gives an invalid amount of family members */
	@Test(expected = PowerConsumptionException.class)
	public void noFamily() {
		pc = new PowerConsumption(0, lowUsage);
		
	}
	
	/* Gives an unusual power consumption amount */
	@Test(expected = PowerConsumptionException.class)
	public void invalidUsage() {
		pc = new PowerConsumption(loneMan, "Too much");
		
	}
	
	/* Gives no actual usage */
	@Test(expected = PowerConsumptionException.class)
	public void noUsage() {
		pc = new PowerConsumption(loneMan, "");
	}
	 
	/*Test scenario 1 consumption output*/
	@Test
    public void PowerConsumed(){
	    assertEquals(Double.compare(pc.getDailyPowerConsumption(), 112.0), 0);
    }
	
	/*Test scenario 2 consumption output*/
	@Test
    public void PowerConsumed2() throws PowerConsumptionException{
		pc = new PowerConsumption(householdsize2, usageType2);
	    assertEquals(Double.compare(pc.getDailyPowerConsumption(), 30.0), 0);
    }
	
	/*Test scenario 3 consumption output*/
	@Test
    public void PowerConsumed3() throws PowerConsumptionException{
		pc = new PowerConsumption(householdsize3, usageType3);
		assertEquals(Double.compare(pc.getDailyPowerConsumption(), 95.0), 0);
    }
	// invalid householdsize
	@Test
    public void invalidHouseholdSize() throws PowerConsumptionException{
		pc = new PowerConsumption(invalidHouseholdsize, usageType);
    }
}