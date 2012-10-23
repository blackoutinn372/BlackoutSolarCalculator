package com.blackout.solarpanelcalculator.desktop;

import java.io.IOException;
import javax.servlet.http.*;
import java.util.TreeMap;
import java.util.Map;

import com.blackout.solarpanelcalculator.server.CalculationFormulas;
import com.blackout.solarpanelcalculator.server.CityDAO;
import com.blackout.solarpanelcalculator.server.PowerConsumption;
import com.blackout.solarpanelcalculator.server.PowerConsumptionException;
import com.blackout.solarpanelcalculator.client.City;

@SuppressWarnings("serial")
public class DesktopCommunicationsServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		String method = req.getParameter("method");
		String returnString = "Error";
	  
		//getSolarGeneFormulaForAllMonths
		if (method.equalsIgnoreCase("getSolarGeneFormulaForAllMonths")) {
			double[] monthValueParams = new double[12];
			double[] remainingParams = new double[6];
	   
			monthValueParams[0] = Double.parseDouble(req.getParameter("jan"));
			monthValueParams[1] = Double.parseDouble(req.getParameter("feb"));
			monthValueParams[2] = Double.parseDouble(req.getParameter("mar"));
			monthValueParams[3] = Double.parseDouble(req.getParameter("apr"));
			monthValueParams[4] = Double.parseDouble(req.getParameter("may"));
			monthValueParams[5] = Double.parseDouble(req.getParameter("jun"));
			monthValueParams[6] = Double.parseDouble(req.getParameter("jul"));
			monthValueParams[7] = Double.parseDouble(req.getParameter("aug"));
			monthValueParams[8] = Double.parseDouble(req.getParameter("sep"));
			monthValueParams[9] = Double.parseDouble(req.getParameter("oct"));
			monthValueParams[10] = Double.parseDouble(req.getParameter("nov"));
			monthValueParams[11] = Double.parseDouble(req.getParameter("dec"));
	   
			remainingParams[0] = Double.parseDouble(req.getParameter("systemSize"));
			remainingParams[1] = Double.parseDouble(req.getParameter("roofEfficiency"));
			remainingParams[2] = Double.parseDouble(req.getParameter("inverterEfficiency"));
			remainingParams[3] = Double.parseDouble(req.getParameter("wiringEfficiency"));
			remainingParams[4] = Double.parseDouble(req.getParameter("whatYear"));
			remainingParams[5] = Double.parseDouble(req.getParameter("agingEfficiencyLoss"));
			double[] monthIrradianceValues = CalculationFormulas.getSolarGeneFormulaForAllMonths(monthValueParams,remainingParams[0],remainingParams[1],remainingParams[2],remainingParams[3],remainingParams[4],remainingParams[5]);
			returnString="";
			String sep = "";
			for (int i=0;i<monthIrradianceValues.length;i++) {
				returnString += sep + monthIrradianceValues[i];
				sep = "~";
			}
		}
	  
		//getEfficiencyForAngleAndDirection
		if (method.equalsIgnoreCase("getEfficiencyForAngleAndDirection")) {
			int directionIndex = Integer.parseInt(req.getParameter("directionIndex"));
			int angleIndex = Integer.parseInt(req.getParameter("angleIndex"));
			double efficiency = CalculationFormulas.getEfficiencyForAngleAndDirection(directionIndex, angleIndex);
	   
			returnString = "";
			returnString += efficiency;
		}
	  
		//getCityList
		if (method.equalsIgnoreCase("getCityList")) {
			int postcode = Integer.parseInt(req.getParameter("postcode"));
			String[] cityList = CityDAO.getCityList(postcode);
	   
			returnString="";
			String sep = "";
			for (int i=0;i<cityList.length;i++) {
				returnString += sep + cityList[i];
				sep = "~";
			}
		}
	  
		//getCityList
		if (method.equalsIgnoreCase("getCity")) {
			int cityIndex = Integer.parseInt(req.getParameter("cityIndex"));
			City city = CityDAO.getCity(cityIndex);
	   
			returnString="";
			String sep = "~";
			returnString+= city.getFeedInTariff();
			returnString+= sep + city.getElectricityCost();
			returnString+= sep + city.getPostcode();
			returnString+= sep + city.getOptimalYearDegree();
			returnString+= sep + city.getBestWinterDegree();
			returnString+= sep + city.getBestSummerDegree();
			double[] irradianceValues = city.getMonthsIrradiance();
			for (int i=0;i<irradianceValues.length;i++) {
				returnString += sep + irradianceValues[i];
			}
			returnString+= sep + city.getAvgIrradiance();
		}
		
		//getPowerConsumption
		if (method.equalsIgnoreCase("getPowerConsumption")) {
			int householdSize = Integer.parseInt(req.getParameter("householdSize"));
			String usageType = req.getParameter("usageType");

			PowerConsumption powerConsumption;
			try {
				powerConsumption = new PowerConsumption(householdSize, usageType);
				returnString = "";
				returnString += powerConsumption.getDailyPowerConsumption();
			} catch (PowerConsumptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//getAggregateSavingsData
		if (method.equalsIgnoreCase("getAggregateSavingsData")) {
			double systemCost = Double.parseDouble(req.getParameter("systemCost"));
			double dailyGeneration = Double.parseDouble(req.getParameter("dailyGeneration"));
			City city = CityDAO.getCity(Integer.parseInt(req.getParameter("cityIndex")));
			double replacePercent = Double.parseDouble(req.getParameter("replacePercent"));
			double agingEfficiencyLoss = Double.parseDouble(req.getParameter("agingEfficiencyloss"));
			double lifeSpan = Double.parseDouble(req.getParameter("lifeSpan"));
			double yearsToCalculate = Double.parseDouble(req.getParameter("yearsToCalculate"));
			
			double dailySavings = CalculationFormulas.getDailySavingsFormula(dailyGeneration, replacePercent, city.getFeedInTariff(), city.getElectricityCost());
			TreeMap<Double, String> treemap = CalculationFormulas.getPayBackTime(systemCost, lifeSpan, replacePercent, city.getFeedInTariff(), city.getElectricityCost(), dailyGeneration, agingEfficiencyLoss, yearsToCalculate);
			
			returnString="";
			String sep = "~";
			returnString+= dailySavings;
			for(Map.Entry<Double,String> entry : treemap.entrySet()) {
				returnString+= sep + entry.getKey() + "|" + entry.getValue();
			}
		}

		resp.getWriter().write(returnString);
	}
}