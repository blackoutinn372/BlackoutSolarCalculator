package com.blackout.solarpanelcalculator.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DoubleBox;

public class WorthInvestingCallback implements AsyncCallback<Double> {
	
	private String saving = "You can save up to $";
	private String losing = "You stand to lose up to $";

	private DoubleBox lblResults;
	
	public WorthInvestingCallback(DoubleBox lblResults) {
		this.lblResults = lblResults;
	}
	
	public void onFailure(Throwable caught) {
	    Window.alert(caught.getMessage());
	}

 	public void onSuccess(Double result) {
 		String message;
 		if (result >= 0) {
 			message = saving;
 		} else {
 			result *= -1;
 			message = losing;
 		}
 		
 		lblResults.setText(message + result.toString());
    }
}