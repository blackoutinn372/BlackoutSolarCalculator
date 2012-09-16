
package com.blackout.solarpanelcalculator.client;

import java.text.ParseException;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CalculationClient implements EntryPoint {
	//DailySolarGenerationControls
	private DoubleBox txtSystemSize = new DoubleBox();
	private DoubleBox txtRoofEfficiency = new DoubleBox();
	private DoubleBox txtInverterEfficiency = new DoubleBox();
	private DoubleBox txtWiringEfficiency = new DoubleBox();
	private DoubleBox txtWhatYear = new DoubleBox();
	private DoubleBox txtAgingEfficiencyLoss = new DoubleBox();
	private DoubleBox txtSolarIrradiance = new DoubleBox();
	private Button btnDailySolarGeneration = new Button();
	private Label lblDailySolarGeneration = new Label();
	
	//DailySavingsControls
	private DoubleBox txtDailyGeneration = new DoubleBox();
	private DoubleBox txtExportPercent = new DoubleBox();
	private DoubleBox txtReplacePercent = new DoubleBox();
	private DoubleBox txtFeedInTariff = new DoubleBox();
	private DoubleBox txtPowerCost = new DoubleBox();
	private Button btnDailySavings = new Button();
	private Label lblDailySavings = new Label();
	
	//PayBackPerYear
	private DoubleBox txtSystemCost = new DoubleBox();
	private IntegerBox txtLifeSpan = new IntegerBox();
	private DoubleBox txtDailySavings = new DoubleBox();
	private Button btnPayBackPerYear = new Button();
	private Label lblPayBackPerYear = new Label();
	
	public void onModuleLoad() {
		loadDailySolarGenerationControls();
		loadDailySavingsControls();
		loadPayBackPerYearControls();
	}
	
	private void loadDailySolarGenerationControls() {
		txtSystemSize.setText("0");
		txtRoofEfficiency.setText("0");
		txtInverterEfficiency.setText("0");
		txtWiringEfficiency.setText("0");
		txtWhatYear.setText("0");
		txtAgingEfficiencyLoss.setText("0");
		txtSolarIrradiance.setText("0");
		btnDailySolarGeneration.setText("Calculate");
		lblDailySolarGeneration.setText("Answer Box");
		
		btnDailySolarGeneration.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getDailySolarGenerationFromServer();
			}
		});
		
		RootPanel.get().add(txtSystemSize);
		RootPanel.get().add(txtRoofEfficiency);
		RootPanel.get().add(txtInverterEfficiency);
		RootPanel.get().add(txtWiringEfficiency);
		RootPanel.get().add(txtWhatYear);
		RootPanel.get().add(txtAgingEfficiencyLoss);
		RootPanel.get().add(txtSolarIrradiance);
		RootPanel.get().add(btnDailySolarGeneration);
		RootPanel.get().add(lblDailySolarGeneration);
	}
	
	private void loadDailySavingsControls() {
		txtDailyGeneration.setText("0");
		txtExportPercent.setText("0");
		txtReplacePercent.setText("0");
		txtFeedInTariff.setText("0");
		txtPowerCost.setText("0");
		btnDailySavings.setText("Calculate");
		lblDailySavings.setText("Answer Box");
		
		btnDailySavings.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getDailySavingsFromServer();
			}
		});
		
		RootPanel.get().add(txtDailyGeneration);
		RootPanel.get().add(txtExportPercent);
		RootPanel.get().add(txtReplacePercent);
		RootPanel.get().add(txtFeedInTariff);
		RootPanel.get().add(txtPowerCost);
		RootPanel.get().add(btnDailySavings);
		RootPanel.get().add(lblDailySavings);
	}

	private void loadPayBackPerYearControls() {
		txtSystemCost.setText("0");
		txtLifeSpan.setText("0");
		txtDailySavings.setText("0");
		btnPayBackPerYear.setText("Calculate");
		lblPayBackPerYear.setText("Answer Box");
		
		btnPayBackPerYear.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getPayBackPerYearFromServer();
			}
		});
		
		RootPanel.get().add(txtSystemCost);
		RootPanel.get().add(txtLifeSpan);
		RootPanel.get().add(txtDailySavings);
		RootPanel.get().add(btnPayBackPerYear);
		RootPanel.get().add(lblPayBackPerYear);
	}
	
	protected void getDailySolarGenerationFromServer() {
		CalculationServiceAsync service = (CalculationServiceAsync) GWT.create(CalculationService.class);
        ServiceDefTarget serviceDef = (ServiceDefTarget) service;
        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
            + "calculationService");
        DailySolarGenerationCallback callback = new DailySolarGenerationCallback(lblDailySolarGeneration);
        service.doDailySolarGeneration(txtSystemSize.getValue(), txtRoofEfficiency.getValue(), txtInverterEfficiency.getValue(), txtWiringEfficiency.getValue(), txtWhatYear.getValue(), txtAgingEfficiencyLoss.getValue(), txtSolarIrradiance.getValue(), callback);
	}
	
	protected void getDailySavingsFromServer() {
		CalculationServiceAsync service = (CalculationServiceAsync) GWT.create(CalculationService.class);
        ServiceDefTarget serviceDef = (ServiceDefTarget) service;
        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
            + "calculationService");
        DailySavingsCallback callback = new DailySavingsCallback(lblDailySavings);
        service.doDailySavings(txtDailyGeneration.getValue(), txtExportPercent.getValue(), txtReplacePercent.getValue(), txtFeedInTariff.getValue(), txtPowerCost.getValue(), callback);
	}
	
	protected void getPayBackPerYearFromServer() {
		CalculationServiceAsync service = (CalculationServiceAsync) GWT.create(CalculationService.class);
        ServiceDefTarget serviceDef = (ServiceDefTarget) service;
        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
            + "calculationService");
        PayBackPerYearCallback callback = new PayBackPerYearCallback(lblPayBackPerYear);
        service.doPayBackPerYear(txtSystemCost.getValue(), txtLifeSpan.getValue(), txtDailySavings.getValue(), callback);
	}
	
}
