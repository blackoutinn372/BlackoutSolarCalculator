package tests;
/**
 * This test is not used yet.only represents a new formula to 
 * calculate solar power generation
 * dailyGeneration = systemSize * roofEfficiency *inverterEfficiency *wiringEfficiency *solarIrradiance
 * 					
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.blackout.solarpanelcalculator.Variables.InverterEfficiency;
import com.blackout.solarpanelcalculator.Variables.RoofEfficiency;
import com.blackout.solarpanelcalculator.Variables.SolarIrradiance;
import com.blackout.solarpanelcalculator.Variables.WiringEfficiency;

public class SolarGenerationTest {
	private static final double DELTA = 1e-15;
	private static double systemSize1= 4.95;//in kws
	InverterEfficiency inverterEfficiency;
	RoofEfficiency roofEfficiency;
	WiringEfficiency  wiringEfficiency;
	SolarIrradiance solarIrradiance;
	 
	 @Before
	 public void SolarPanel(){
		 inverterEfficiency = new InverterEfficiency();
			 roofEfficiency = new RoofEfficiency();
			  wiringEfficiency = new WiringEfficiency() ;
			 solarIrradiance = new SolarIrradiance();
	 }
	 /*Test default value solar daily output*/
	@Test
	 public void SolarGeneration(){
		double expectedDailyPower = 21.02;
		double overallEfficiency = inverterEfficiency.getInverterEfficiency() * roofEfficiency.getRoofEfficiency()
									*wiringEfficiency.getWiringEfficiency();
		double dailyGeneration1 = systemSize1 * overallEfficiency *solarIrradiance.getIrradianceValue();
		assertEquals(TwoDecimals(dailyGeneration1),expectedDailyPower,DELTA);
	}
	
private double TwoDecimals(double number){
		
		return Math.round(number*100.00)/100.00;
	}
	 }