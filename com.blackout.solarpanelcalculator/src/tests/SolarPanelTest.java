package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.blackout.solarpanelcalculator.server.SolarPanel;
public class SolarPanelTest {
	private static final double DELTA = 1e-10;
	
	SolarPanel sp;
	@Before
	public void SetUp() {
		sp = new SolarPanel();
	}
	
	// A default brand can be made
	@Test
	public void defaultBrand() {
		assertEquals("BRAND", sp.getBrand());
	}
	// A default description is applies
	@Test
	public void defaultDescription() {
		assertEquals("A Solar Panel", sp.getDescription());
	}
	// Default Power is implemented
	@Test
	public void defaultWatts() {
		assertEquals(123.45, sp.getWatts(), DELTA);
	}
	// Default price is implemented
	@Test
	public void defaultPrice() {
		assertEquals(123.45, sp.getPrice(), DELTA);
	}
	
	// Can change the brand
	@Test
	public void changeBrand() {
		String newBrand = "OCD";
		sp.setBrand(newBrand);
		assertEquals(newBrand, sp.getBrand());
	}
	
	// Can change the desctiption
	@Test
	public void changeDescription() {
		String newDescription = "OCD";
		sp.setDescription(newDescription);
		assertEquals(newDescription, sp.getDescription());
	}
	
	// Can change the brand
	@Test
	public void changePower() {
		double newPower = 321.01;
		sp.setWatts(newPower);
		assertEquals(newPower, sp.getWatts(), DELTA);
	}
	
	// Can change the brand
	@Test
	public void changeCost() {
		double newCost = 321.01;
		sp.setPrice(newCost);
		assertEquals(newCost, sp.getPrice(), DELTA);
	}

}
