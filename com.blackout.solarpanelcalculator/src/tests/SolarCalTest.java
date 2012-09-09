package tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.blackout.solarpanelcalculator.client.SolarCal;
import com.blackout.solarpanelcalculator.client.SolarCalException;
import com.blackout.solarpanelcalculator.client.SolarPanel;

public class SolarCalTest {
	/* defaults */
	private static double seasonRate = 1.1;
	private static double badSeasonRate = -1.1;
	
	static SolarCal sc;
	static SolarPanel sp = new SolarPanel();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception, SolarCalException {
		sc = new SolarCal(seasonRate);
		sp = new SolarPanel();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sc = null;
		sp = null;
	}

	/*Test for the average day*/
	@Test
	public void testDayAverage() throws SolarCalException{
		assertEquals(Double.compare(sc.dayAverage(sp.getPowerGeneration()), 1), 0);
	}
	
	/*Test for the average week*/
	@Test
	public void testWeekAverage() throws SolarCalException{
		assertEquals(Double.compare( sc.weeklyGenertaion(sp.getPowerGeneration()), 1), 0);
	}
	
	/*Test for the average month*/
	@Test
	public void testMonthAverage() throws SolarCalException{
		assertEquals(Double.compare(sc.monthlyGenertaion(sp.getPowerGeneration()), 1), 0);
	}
	
	/*Test for the average season*/
	@Test
	public void testSeasonAverage() throws SolarCalException{
		assertEquals(Double.compare(sc.seasonalGeneration(sp.getPowerGeneration()), 1), 0);
	}
	
	/*Test for the yearly average*/
	@Test
	public void testYearAverage() throws SolarCalException{
		assertEquals(Double.compare(sc.yearlyGenertaion(sp.getPowerGeneration()), 1), 0);
	}
	
	/*Test for a bad season rate.*/
	@Test(expected = SolarCalException.class)
	public void InvalidSeasonRate() throws SolarCalException {
		sc = new SolarCal(badSeasonRate);
	}
	
	/*Test for no season rate.*/
	@Test(expected = SolarCalException.class)
	public void NoSeasonRate() throws SolarCalException {
		sc = new SolarCal(0);
	}
	

}