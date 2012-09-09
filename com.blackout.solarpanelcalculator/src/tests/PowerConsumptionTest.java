package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import com.blackout.solarpanelcalculator.client.PowerConsumption;
import com.blackout.solarpanelcalculator.client.PowerConsumptionException;

public class PowerConsumptionTest {
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
	
	/* TODO: test costs of other varying degrees */
	
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

}
