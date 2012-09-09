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

	@Test
	public void testDayAverage() throws SolarCalException{
		assertEquals(Double.compare(sc.dayAverage(sp.getDailyPowerGeneration()), 1), 0);
	}
	
	@Test
	public void testWeekAverage() throws SolarCalException{
		assertEquals(Double.compare( sc.weeklyGenertaion(sp.getDailyPowerGeneration()), 1), 0);
	}
	
	@Test
	public void testMonthAverage() throws SolarCalException{
		assertEquals(Double.compare(sc.monthlyGenertaion(sp.getDailyPowerGeneration()), 1), 0);
	}
	
	@Test
	public void testSeasonAverage() throws SolarCalException{
		assertEquals(Double.compare(sc.seasonalGeneration(sp.getDailyPowerGeneration()), 1), 0);
	}
	
	@Test
	public void testYearAverage() throws SolarCalException{
		assertEquals(Double.compare(sc.yearlyGenertaion(sp.getDailyPowerGeneration()), 1), 0);
	}
	
	@Test(expected = SolarCalException.class)
	public void InvalidSeasonRate() throws SolarCalException {
		sc = new SolarCal(badSeasonRate);
	}
	

}
