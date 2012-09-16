
package com.blackout.solarpanelcalculator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;


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
	
	//PayBackYear
	private DoubleBox txtSystemCost = new DoubleBox();
	private IntegerBox txtLifeSpan = new IntegerBox();
	private DoubleBox txtDailySavings = new DoubleBox();
	private Button btnPayBackYear = new Button();
	private Label lblPayBackYear = new Label();
	
	public void onModuleLoad() {
		loadDailySolarGenerationControls();
		loadDailySavingsControls();
		loadPayBackYearControls();
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
		
		RootPanel.get("tdSystemSize").add(txtSystemSize);
		RootPanel.get("tdRoofEfficiency").add(txtRoofEfficiency);
		RootPanel.get("tdInverterEfficiency").add(txtInverterEfficiency);
		RootPanel.get("tdWiringEfficiency").add(txtWiringEfficiency);
		RootPanel.get("tdWhatYear").add(txtWhatYear);
		RootPanel.get("tdAgingEfficiencyLoss").add(txtAgingEfficiencyLoss);
		RootPanel.get("tdSolarIrradiance").add(txtSolarIrradiance);
		RootPanel.get("tdDailySolarGenerationCalculate").add(btnDailySolarGeneration);
		RootPanel.get("tdDailySolarGenerationResult").add(lblDailySolarGeneration);
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
		
		RootPanel.get("tdDailyGeneration").add(txtDailyGeneration);
		RootPanel.get("tdExportPercent").add(txtExportPercent);
		RootPanel.get("tdReplacePercent").add(txtReplacePercent);
		RootPanel.get("tdFeedInTariff").add(txtFeedInTariff);
		RootPanel.get("tdPowerCost").add(txtPowerCost);
		RootPanel.get("tdDailySavingsCalculate").add(btnDailySavings);
		RootPanel.get("tdDailySavingsResult").add(lblDailySavings);
	}

	private void loadPayBackYearControls() {
		txtSystemCost.setText("0");
		txtLifeSpan.setText("0");
		txtDailySavings.setText("0");
		btnPayBackYear.setText("Calculate");
		lblPayBackYear.setText("Answer Box");
		
		btnPayBackYear.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getPayBackYearFromServer();
			}
		});
		
		RootPanel.get("tdSystemCost").add(txtSystemCost);
		RootPanel.get("tdLifeSpan").add(txtLifeSpan);
		RootPanel.get("tdDailySavings").add(txtDailySavings);
		RootPanel.get("tdPayBackYearCalculate").add(btnPayBackYear);
		RootPanel.get("tdPayBackYearResult").add(lblPayBackYear);
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
	
	protected void getPayBackYearFromServer() {
		CalculationServiceAsync service = (CalculationServiceAsync) GWT.create(CalculationService.class);
        ServiceDefTarget serviceDef = (ServiceDefTarget) service;
        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
            + "calculationService");
        PayBackYearCallback callback = new PayBackYearCallback(lblPayBackYear);
        service.doPayBackYear(txtSystemCost.getValue(), txtLifeSpan.getValue(), txtDailySavings.getValue(), callback);
	}
	
}
