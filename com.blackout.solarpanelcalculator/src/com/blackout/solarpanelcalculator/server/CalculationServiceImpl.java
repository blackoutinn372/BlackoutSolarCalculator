package com.blackout.solarpanelcalculator.server;

import java.io.InputStream;
import java.net.URL;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.blackout.solarpanelcalculator.client.CalculationService;
import com.blackout.solarpanelcalculator.client.City;
import com.blackout.solarpanelcalculator.client.Product;

public class CalculationServiceImpl extends RemoteServiceServlet implements CalculationService {
	
	private static double daysInYear = 365;
	private static final long serialVersionUID = -1314136203142788858L;
	
	@Override
	public double doPowerConsumption(Integer householdSize, String usageType) {
		PowerConsumption powerConsumption=null;
		try {
			powerConsumption = new PowerConsumption(householdSize, usageType);
		} catch (PowerConsumptionException e) {
		
		}
		if(powerConsumption!=null){
		return powerConsumption.getDailyPowerConsumption();
		}
		return 0;
	}
	

	@Override
	public double doDailySolarGeneration(double systemSize,
			double roofEfficiency, double inverterEfficiency,
			double wiringEfficiency, double whatYear,
			double agingEfficiencyLoss, double solarIrradiance) {
		return CalculationFormulas.getDailySolarGeneFormula(systemSize, roofEfficiency, inverterEfficiency, wiringEfficiency, whatYear, agingEfficiencyLoss, solarIrradiance);
	}
	
	
	@Override
	public double[] doSolarGenerationForAllMonths(double[]dailyIrradianceInMonth,double systemSize,
			double roofEfficiency, double inverterEfficiency,
			double wiringEfficiency, double whatYear, double agingEfficiencyLoss) {
		
		return CalculationFormulas.getSolarGeneFormulaForAllMonths(dailyIrradianceInMonth,systemSize, roofEfficiency, inverterEfficiency, wiringEfficiency, whatYear, agingEfficiencyLoss);
	}


	@Override
	public double doDailySavings(double dailyGeneration, double replacePercent,
			double feedInTarrif, double powerCost) {
		return CalculationFormulas.getDailySavingsFormula(dailyGeneration, replacePercent, feedInTarrif, powerCost);
	}


	@Override
	public double doWorthInvestment(double dailySavings, double paybackYear, double lifetime, double interest) {
		double earnings = CalculationFormulas.isWorthInvesting(dailySavings, paybackYear, lifetime);
		double totalInterest = CalculationFormulas.calculateBankSavings(lifetime, (dailySavings*daysInYear)*paybackYear, interest);
		return earnings-totalInterest;
	}


	@Override
	public TreeMap<Double, String> getPayBackTime(double systemCost,
			double lifeSpan, double replacePercent, double feedInTarrif,
			double powerCost, double dailyGeneration,
			double agingEfficiencyLoss, double yearsToCalculate) {
		return CalculationFormulas.getPayBackTime(systemCost, lifeSpan, replacePercent, feedInTarrif, powerCost, dailyGeneration, agingEfficiencyLoss, yearsToCalculate);
	}
	
/**
 * retrive address based on latitude and lontitude
 * @param latLong
 * @return a detailed address 
 */
	public String getAddress(String latLong) {
		  try {
          URL mapsUrl = new URL(
                          "http://maps.googleapis.com/maps/api/geocode/xml?latlng="
                                          + latLong + "&sensor=true");
          InputStream openStream = mapsUrl.openStream();
          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
          DocumentBuilder db = dbf.newDocumentBuilder();
          Document doc = db.parse(openStream);
          NodeList formattedAddress = doc.getElementsByTagName("formatted_address");
          Element formattedAddressElement = (Element) formattedAddress.item(0);
          return formattedAddressElement.getTextContent();
  } catch (Exception e) {
          return null;
	}

}
	

	@Override
	public City getCity(int cityIndex) {
		// TODO Auto-generated method stub
		return CityDAO.getCity(cityIndex);
	}


	@Override
	public String[] getCityList(int postcode) {
		// TODO Auto-generated method stub
		return CityDAO.getCityList(postcode);
	}


	@Override
	public int getCityIndex() {
		// TODO Auto-generated method stub
		return CityDAO.returnCityIndex();
	}


	@Override
	public int getCityIDFromPostcode(int postcode) {
		// TODO Auto-generated method stub
		return CityDAO.getCityIDFromPostcode(postcode);
	}


	@Override
	public double doTotalSubsidy(double zoneRating) {
		// TODO Auto-generated method stub
		return CalculationFormulas.getTotalSubsidy(zoneRating);
	}


	@Override
	public double getEfficiencyForAngleAndDirection(int directionIndex,
			int angleIndex) {
		// TODO Auto-generated method stub
		return CalculationFormulas.getEfficiencyForAngleAndDirection(directionIndex, angleIndex);
	}
	
	public Product getPorduct(){
		return ProductDAO.getProduct();
	}
	
	@Override
	public Product getProduct(){
		return ProductDAO.getProduct();
	}
//
//	
//	public int getProductRows(){
//		return ProductDAO.getProductRows();
//	}
	

}