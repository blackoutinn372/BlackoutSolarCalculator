package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import com.blackout.solarpanelcalculator.client.Validator;
/**
 * tests user inputs
 *
 */
public class ValidatorTests {
	private static final double DELTA = 1e-10;
	
	String randomText = "random text";
	String emptyString = "";
	String zero = "0";			
	
	String invalidLifeSpan = "1337";		//years
	String invalidLifeSpan2 = "-2";			//years
	String validYear = "25";				//years
	
	String validEfficiency = "95";			//percentage
	String invalidEfficiency = "101";
	String invalidEfficiency2 = "-4%";
	String invalidEfficiency3 = "thirty-four";
	String invalidEfficiency4 = "32%";
	
	String invalidDouble = "mmm.pie";
	String validNumberPeople = "3";
	String validPostcode = "4104";
	String invalidPostcode = "-9";
	
	String validDollars = "45000";
	String invalidDollars = "-987";
	String tooManyWatts ="100001";
	
	String validIrradiance = "5.9";
	String invalidIrradiance = "100";
	
	/* Year tests */
	@Test
	public void tooMuchLifeSpan() {
		assertEquals(false, Validator.isValidNumber(invalidLifeSpan));
	}
	
	@Test
	public void tooSmallLifeSpan() {
		assertEquals(false, Validator.isValidNumber(invalidLifeSpan2));
	}
	
	@Test
	public void noLifeSpan() {
		assertEquals(false, Validator.isValidNumber(zero));
	}
	
	@Test
	public void validLifeSpan() {
		assertEquals(true, Validator.isValidNumber(validYear));
	}
	
	/* Testing generic invalid number errors with isValidNumber*/
	@Test
	public void invalidNumber() {
		assertEquals(false, Validator.isValidNumber(randomText));
	}
	
	@Test
	public void noInputNumber() {
		assertEquals(false, Validator.isValidNumber(emptyString));
	}
	
	@Test
	public void testValidNumber() {
		assertEquals(true, Validator.isValidNumber(validNumberPeople));
	}

	/* Testing Efficiency (and cents) */
	@Test
	public void validEfficiency() {
		assertEquals(true, Validator.isValidPercentage(validEfficiency));
	}
	
	@Test
	public void invalidPercentage() {
		assertEquals(false, Validator.isValidPercentage(invalidEfficiency4));
	}
	
	@Test
	public void tooMuchEfficiency() {
		assertEquals(false, Validator.isValidPercentage(invalidEfficiency));
	}
	
	@Test
	public void negativeEfficiency() {
		assertEquals(false, Validator.isValidPercentage(invalidEfficiency2));
	}
	
	@Test
	public void nanEfficiency() {
		assertEquals(false, Validator.isValidPercentage(randomText));
	}
	
	@Test
	public void noEfficiency() {
		assertEquals(false, Validator.isValidPercentage(emptyString));
	}
	
	/* Testing Cents */
	@Test
	public void validCents() {
		assertEquals(true, Validator.isValidCents(validEfficiency));
	}
	@Test
	public void invalidDecimalCents() {
		assertEquals(false, Validator.isValidCents(validIrradiance));
	}
	
	@Test
	public void testCents() {
		assertEquals(false, Validator.isValidCents(invalidDouble));
	}
	
	@Test
	public void nanCents() {
		assertEquals(false, Validator.isValidCents(randomText));
	}
	
	@Test
	public void nonCents() {
		assertEquals(false, Validator.isValidCents(emptyString));
	}
	
	/* Testing big numbers (For dollars and watts) */
	@Test
	public void validDollars() {
		assertEquals(true,Validator.isValidBigNumber(validDollars));
		
	}
	
	public void negativeDollars() {
		assertEquals(false,Validator.isValidBigNumber(invalidDollars));
		
	}
	
	public void zeroDollars() {
		assertEquals(true,Validator.isValidBigNumber(zero));
	}
	
	public void tooManyDollars() {
		assertEquals(false,Validator.isValidBigNumber(tooManyWatts));
		
	}
	
	public void noDollars() {
		assertEquals(false,Validator.isValidBigNumber(randomText));
	}
	
	public void nothingToUseAsDollars() {
		assertEquals(false,Validator.isValidBigNumber(emptyString));
		
	}
	
	/* Testing valid postcodes */
	@Test
	public void validPostcode() {
		assertEquals(true,Validator.isValidPostcode(validPostcode));
	}
	
	@Test
	public void invalidPostcode() {
		assertEquals(false,Validator.isValidPostcode(invalidPostcode));
	}
	
	@Test
	public void nonNumberPostcode() {
		assertEquals(false,Validator.isValidPostcode(randomText));
	}
	
	@Test
	public void noPostcode() {
		assertEquals(false,Validator.isValidPostcode(emptyString));
	}
	
	/* Testing Irradiance */
	@Test
	public void validIrradiance() {
		assertEquals(true,Validator.isValidIrradiance(validIrradiance));
	}
	
	@Test
	public void invalidIrradiance() {
		assertEquals(false,Validator.isValidIrradiance(invalidIrradiance));
	}
	
	@Test
	public void zeroIrradiance() {
		assertEquals(false,Validator.isValidIrradiance(zero));
	}
	
	@Test
	public void nanIrradiance() {
		assertEquals(false,Validator.isValidIrradiance(randomText));
	}
	
	@Test
	public void noIrradiance() {
		assertEquals(false,Validator.isValidIrradiance(emptyString));
	}
	
	/* Test year conversion */
	@Test
	public void parseYearsAndMonths() {
		assertEquals(6.25,Validator.parseYears("6y 3m"), DELTA);
	}
	
	@Test
	public void parseYears() {
		assertEquals(6,Validator.parseYears("6y 0m"), DELTA);
	}
	
	@Test
	public void parseMonths() {
		assertEquals(.25,Validator.parseYears("0y 3m"), DELTA);
	}
	
	@Test
	public void noDurationParsed() {
		assertEquals(0.0,Validator.parseYears("0y 0m"), DELTA);
	}
	
	@Test
	public void technicallyCorrectYears() {
		assertEquals(5.0,Validator.parseYears("4y 12m"), DELTA);
	}
	
	@Test
	public void noYearsParsed() {
		assertEquals(0.0 ,Validator.parseYears(emptyString), DELTA);
	}
}
