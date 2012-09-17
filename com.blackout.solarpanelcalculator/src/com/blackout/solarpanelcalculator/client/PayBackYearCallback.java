package com.blackout.solarpanelcalculator.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.Label;

public class PayBackYearCallback implements AsyncCallback<Double>{

	private DoubleBox lblResults;
	
	public PayBackYearCallback(DoubleBox lblResults) {
		this.lblResults = lblResults;
	}
	
	public void onFailure(Throwable caught) {
	    Window.alert(caught.getMessage());
	}

 	public void onSuccess(Double result) {
 		lblResults.setText(result.toString());

    }
}