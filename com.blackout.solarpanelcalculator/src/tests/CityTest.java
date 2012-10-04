package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.blackout.solarpanelcalculator.client.City;
public class CityTest {
	
	
	private static final String name1 = "Sydney";
	private static final String name2 = "Melbourne";
	City city1;
	City city2;
	@Before
	public void CityOne(){
		city1 = new City();
		city1.setCityName(name1);
		city1.setPostcode(2000);
		city1.setFeedInTariff(20);
		city1.setElectricityCost(22.6);
		city1.setOptimalYearDegree(56);
		
	}
	@Before
	public void CityTwo(){
		city2 = new City();
		city2.setCityName(name2);
		city2.setPostcode(3000);
		city2.setFeedInTariff(66);
		city2.setElectricityCost(25);
		city2.setOptimalYearDegree(52);
		
	}
	@Test
	public void TestCityOneData(){
		assertTrue(city1.getCityName()==name1);
		assertTrue(city1.getPostcode()==2000);
		assertTrue(city1.getFeedInTariff()==20);
		assertTrue(city1.getElectricityCost()==22.6);
		assertTrue(city1.getOptimalYearDegree()==56);
	}
	@Test
	public void TestCityTwoData(){
		assertTrue(city2.getCityName()==name2);
		assertTrue(city2.getPostcode()==3000);
		assertTrue(city2.getFeedInTariff()==66);
		assertTrue(city2.getElectricityCost()==25);
		assertTrue(city2.getOptimalYearDegree()==52);
	}
}
