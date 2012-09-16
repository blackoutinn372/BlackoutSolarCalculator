package tests;

import static org.junit.Assert.*;
import com.blackout.solarpanelcalculator.client.SolarPanel;
import com.blackout.solarpanelcalculator.client.SolarException;

import org.junit.Before;
import org.junit.Test;

public class SolarPanelTest {
	private static final double DELTA = 1e-15;
	 /*Scenario one */
	 double systemSize = 4.0; // in kw
	 double sunlight = 5.5; // in hours per day
	 String roof = "Normal";
	 String orientation = "North";
	 double brandNew = 0;
	 
	 /*Scenario two*/
	 double systemSize2 = 3.5;
	 double sunlight2 = 6;
	 String roof2 = "Flat";
	 String orientation2 = "Due east/west";
	 double fewYearsOld = 3;
	 
	 /*invalid data*/
	 double invalidSize = 0;
	 double invalidSunlight = 0;
	 String invalidroof ="High";
	 String invalidOrientation = "NorthEast";
	 double invalidAge = -1;
	 
	 SolarPanel solarPanel; 
	 SolarPanel solarPanel2;
	 SolarPanel solarPanel3;
	 
	 
	 @Before
	 public void SolarPanel()throws SolarException{
		 solarPanel = new SolarPanel(systemSize,sunlight,roof,orientation);
		 solarPanel3 = new SolarPanel();//use default values
		 solarPanel2 = new SolarPanel(systemSize2,sunlight2,roof2,orientation2);
	 }
	 /*Test scenario one's power output*/
	@Test
	 public void SolarGeneration(){
		 assertEquals(solarPanel.getDailyPowerGeneration(), 17.92,DELTA);
	 }
	//test  generation in June
	@Test
	public void SolarGenerationJune(){
		assertEquals(solarPanel3.getMonthlyPowerGeneration("June"), 78.0,DELTA);
	}
//	test generation in July
	@Test
	public void SolarGenerationJuly(){
		assertEquals(solarPanel3.getMonthlyPowerGeneration("July"),93.0,DELTA);
	}
//	test generation in August
	@Test
	public void SolarGenerationAugust(){
		assertEquals(solarPanel3.getMonthlyPowerGeneration("August"),130.2,DELTA);
	}
//	test generation in Winter
	@Test
	public void SolarGenerationWinter(){
		assertEquals(solarPanel3.getWinterPowerGeneration(),301.2,DELTA);
	}
	 /*Test another set of data for daily generation*/
	@Test
	public void SolarGeneration2() throws SolarException{
//		solarPanel = new SolarPanel(systemSize2,sunlight2,roof2,orientation2);
		assertEquals(solarPanel2.getDailyPowerGeneration(), 13.88,DELTA);
	}
	@Test
	public void SolarGeneration2Yearly() throws SolarException{
		assertEquals(solarPanel2.GetYearPowerGeneration(),5066.2,DELTA);
	}
	@Test
	public void SolarGeneration2Weekly() throws SolarException{
		assertEquals(solarPanel2.getWeeklyPowerGeneration(),97.16,DELTA);
	}
	@Test
	public void SolarGeneration2Seasonly() throws SolarException{
		assertEquals(solarPanel2.getSummerPowerGeneration(),2616,DELTA);
	}
	 /*Test invalid data*/
	 @Test(expected = SolarException.class)
	 public void SolarPanelInvalid()throws SolarException{
		 solarPanel = new SolarPanel(invalidSize,invalidSunlight,invalidroof,invalidOrientation);
	 }
	 /* Testing individual failures */
	 @Test(expected = SolarException.class)
	 public void InvalidSize() throws SolarException {
		 solarPanel = new SolarPanel(invalidSize,sunlight,roof,orientation);
	 }
	 @Test(expected = SolarException.class)
	 public void InvalidLight() throws SolarException {
		 solarPanel = new SolarPanel(systemSize,invalidSunlight,roof,orientation);
	 }
	 @Test(expected = SolarException.class)
	 public void InvalidAngle() throws SolarException {
		 solarPanel = new SolarPanel(systemSize,sunlight,invalidroof,orientation);
	 }
	 @Test(expected = SolarException.class)
	 public void InvalidOrientation() throws SolarException {
		 solarPanel = new SolarPanel(systemSize,sunlight,roof,invalidOrientation);
	 }
	 @Test
	 public void CanUseAge() throws SolarException {
		solarPanel = new SolarPanel(systemSize,sunlight,roof,orientation,brandNew);
	 }
	 @Test
	 public void CanUseAgeAgain() throws SolarException {
		solarPanel = new SolarPanel(systemSize,sunlight,roof,orientation,fewYearsOld);
	 }
	 @Test(expected = SolarException.class)
	 public void InvalidAge() throws SolarException {
		solarPanel = new SolarPanel(systemSize,sunlight,roof,invalidOrientation,invalidAge); 
	 }
}
