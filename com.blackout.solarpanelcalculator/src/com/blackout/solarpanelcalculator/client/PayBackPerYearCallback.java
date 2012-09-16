package com.blackout.solarpanelcalculator.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;

public class PayBackPerYearCallback implements AsyncCallback<Double>{

	private Label lblResults;
	
	public PayBackPerYearCallback(Label lblResults) {
		this.lblResults = lblResults;
	}
	
	public void onFailure(Throwable caught) {
	    Window.alert(caught.getMessage());
	}

 	public void onSuccess(Double result) {
 		lblResults.setText(result.toString());
    }
}