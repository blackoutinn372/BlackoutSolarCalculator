package com.blackout.solarpanelcalculator.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.Label;

public class WorthInvestingCallback implements AsyncCallback<Double> {
	
	private String saving = "By investing in the system, you will earn an estimate of ";
	private String losing = "You are better off saving your money, or you risk losing up to ";

	private DoubleBox lblResults;
	private Label lblText;
	
	public WorthInvestingCallback(DoubleBox lblResults, Label text) {
		this.lblResults = lblResults;
		this.lblText = text;
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
 		lblText.setText(message);
 		lblResults.setText("$" + result.toString());
    }
}