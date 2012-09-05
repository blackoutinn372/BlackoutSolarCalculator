package com.blackout.solarpanelcalculator.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.blackout.solarpanelcalculator.client.CalculationService;

public class CalculationServiceImpl extends RemoteServiceServlet implements CalculationService {

	private static final long serialVersionUID = -1314136203142788858L;

	public Integer doCalculationA(double a, double b, String c, String d) {
		return 42;
	}
	
}
