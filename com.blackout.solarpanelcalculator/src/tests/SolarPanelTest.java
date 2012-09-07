package tests;

import static org.junit.Assert.*;
import com.blackout.solarpanelcalculator.client.SolarPanel;
import com.blackout.solarpanelcalculator.client.SolarPanelException;

import org.junit.Before;
import org.junit.Test;

public class SolarPanelTest {
	 /*Scenario one */
	 double systemSize = 4.0; // in kw
	 double sunlight = 5.5; // in hours per day
	 String roof = "Normal";
	 String orientation = "North";
	 
	 /*Scenario two*/
	 double systemSize2 = 3.5;
	 double sunlight2 = 6;
	 String roof2 = "Flat";
	 String orientation2 = "Due east/west";
	 
	 /*invalid data*/
	 double invalidSize = 0;
	 double invalidSunlight = 0;
	 String invalidroof ="High";
	 String invalidOrientation = "NorthEast";
	 
	 SolarPanel solarPanel; 
	 
	 @Before
	 public void SolarPanel()throws SolarPanelException{
		 solarPanel = new SolarPanel(systemSize,sunlight,roof,orientation);
	 }
	 /*Test scenario one's power output*/
	@Test
	 public void SolarGeneration(){
		 assertEquals(Double.compare(solarPanel.getPowerGeneration(), 17.92),0);
	 }
	 /*Test exception is thrown for invalid data*/
	@Test
	public void SolarGeneration2() throws SolarPanelException{
		solarPanel = new SolarPanel(systemSize2,sunlight2,roof2,orientation2);
		assertEquals(Double.compare(solarPanel.getPowerGeneration(), 13.88),0);
	}
	 /*Test scenario two's power output*/
	 @Test(expected = SolarPanelException.class)
	 public void SolarPanelInvalid()throws SolarPanelException{
		 solarPanel = new SolarPanel(invalidSize,invalidSunlight,invalidroof,invalidOrientation);
	 }
	 /* Testing individual failures */
	 @Test(expected = SolarPanelException.class)
	 public void InvalidSize() throws SolarPanelException {
		 solarPanel = new SolarPanel(invalidSize,sunlight,roof,orientation);
	 }
	 @Test(expected = SolarPanelException.class)
	 public void InvalidLight() throws SolarPanelException {
		 solarPanel = new SolarPanel(systemSize,invalidSunlight,roof,orientation);
	 }
	 @Test(expected = SolarPanelException.class)
	 public void InvalidAngel() throws SolarPanelException {
		 solarPanel = new SolarPanel(systemSize,sunlight,invalidroof,orientation);
	 }
	 @Test(expected = SolarPanelException.class)
	 public void InvalidOrientation() throws SolarPanelException {
		 solarPanel = new SolarPanel(systemSize,sunlight,roof,invalidOrientation);
	 }
}
