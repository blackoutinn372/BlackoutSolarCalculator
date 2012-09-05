package com.blackout.solarpanelcalculator.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CalculationServiceAsync {
	void doCalculationA(double a, double b, String c, String d, AsyncCallback<Integer> callback);
}
