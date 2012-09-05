package com.blackout.solarpanelcalculator.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("calculationService")
public interface CalculationService extends RemoteService {
	Integer doCalculationA(double a, double b, String c, String d);
}
