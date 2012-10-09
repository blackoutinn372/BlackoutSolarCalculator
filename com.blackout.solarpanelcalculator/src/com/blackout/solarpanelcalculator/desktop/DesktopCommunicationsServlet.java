package com.blackout.solarpanelcalculator.desktop;

import java.io.IOException;
import javax.servlet.http.*;

import com.blackout.solarpanelcalculator.server.CalculationFormulas;

@SuppressWarnings("serial")
public class DesktopCommunicationsServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String method = req.getParameter("method");
		String returnString = "Error";
		
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
			double[] returnArray = CalculationFormulas.getSolarGeneFormulaForAllMonths(monthValueParams,remainingParams[0],remainingParams[1],remainingParams[2],remainingParams[3],remainingParams[4],remainingParams[5]);
			returnString="Values: ";
			for (int i=0;i<returnArray.length;i++) {
				returnString += "[" + returnArray[i] + "]";
			}
		}
		
		resp.getWriter().write("Value returned: " + returnString);
	}
	
}
