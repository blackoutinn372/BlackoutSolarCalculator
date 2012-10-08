package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blackout.solarpanelcalculator.client.City;
import com.blackout.solarpanelcalculator.server.CityDAO;
/**
 * It turns out junit tests can't access a database. 
 * This means the tests are doomed to fail.
 *
 */
public class CityDAOTest {
	
	/*
	@Test
	public void getCity() {
		City c = new City();
		c.setCityName("Brisbane");
		assertEquals(c.getCityName(), CityDAO.getCity(0).getCityName());
	}
	@Test
	public void testReturnCityIndex() {
		assertEquals(0, CityDAO.returnCityIndex());
	}

	@Test
	public void getCityIDFromPostcode() {
		assertEquals(0,CityDAO.getCityIDFromPostcode(4000));
	}*/

}
