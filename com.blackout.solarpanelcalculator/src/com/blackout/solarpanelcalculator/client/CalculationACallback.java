package com.blackout.solarpanelcalculator.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class CalculationACallback implements AsyncCallback<Integer>{

	private TextBox boxResults;
	
	public CalculationACallback(TextBox serverTextBox) {
		this.boxResults = serverTextBox;
	}
	
	public void onFailure(Throwable caught) {
	    Window.alert(caught.getMessage());
	}

 	public void onSuccess(Integer result) {
	    boxResults.setText(result.toString());
    }
	
}
