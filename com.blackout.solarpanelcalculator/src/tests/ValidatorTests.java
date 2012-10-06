package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import com.blackout.solarpanelcalculator.client.Validator;
/**
 * tests user inputs
 * @author Sen
 *
 */
public class ValidatorTests {
	
	String invalidLifeSpan = "1337";//years
	String validYear = "25";//years
	String InValidInteger = "random text";
	String validEfficiency = "95";//percentage
	String InValidDouble = "mmm.pie";
	String validNumberPeople = "3";
	String validPostcode = "4104";
	String invalidPostcode = "-9";
	String validIrradiance = "5.9";
	String invaidIrradiance = "100";
	String validDollars = "45000";
	String invalidDollars = "-987";
	String validWatts ="45000";
	String invaidWatts ="-998";
	@Test
	public void testIsLifeSpan() {
		assertEquals(false, Validator.isValidNumber(invalidLifeSpan));
	}
	
	@Test
	public void testIsValidNumber() {
		assertEquals(false, Validator.isValidNumber(InValidInteger));
		assertEquals(true, Validator.isValidNumber(validNumberPeople));
	}

	@Test
	public void testIsValidEfficiencyAndCents() {
		assertEquals(true, Validator.isValidPercentageAndCents(validEfficiency));
		assertEquals(false, Validator.isValidPercentageAndCents(InValidDouble));
	}
	
	@Test
	public void testIsValidDollarsAndWatts() {
		assertEquals(true,Validator.isValidDollarsAndWatts(validDollars));
		assertEquals(false,Validator.isValidDollarsAndWatts(invalidDollars));
		assertEquals(true,Validator.isValidDollarsAndWatts(validWatts));
		assertEquals(false,Validator.isValidDollarsAndWatts(invaidWatts));
		
	}
	
	@Test
	public void testIsValidPostcode() {
		assertEquals(true,Validator.isValidPostcode(validPostcode));
		assertEquals(false,Validator.isValidPostcode(invalidPostcode));
	}
}
