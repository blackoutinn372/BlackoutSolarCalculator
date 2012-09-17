package com.blackout.solarpanelcalculator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CalculationClient implements EntryPoint {
	// DailySolarGenerationControls
	private DoubleBox txtSystemSize = new DoubleBox();
	private DoubleBox txtRoofEfficiency = new DoubleBox();
	private DoubleBox txtInverterEfficiency = new DoubleBox();
	private DoubleBox txtWiringEfficiency = new DoubleBox();
	private DoubleBox txtWhatYear = new DoubleBox();
	private DoubleBox txtAgingEfficiencyLoss = new DoubleBox();
	private DoubleBox txtSolarIrradiance = new DoubleBox();
	private Button btnDailySolarGeneration = new Button();
	private DoubleBox lblDailySolarGeneration = new DoubleBox();

	// DailySavingsControls
	private DoubleBox txtDailyGeneration = new DoubleBox();
	private DoubleBox txtExportPercent = new DoubleBox();
	private DoubleBox txtReplacePercent = new DoubleBox();
	private DoubleBox txtFeedInTariff = new DoubleBox();
	private DoubleBox txtPowerCost = new DoubleBox();
	private Button btnDailySavings = new Button();
	private DoubleBox lblDailySavings = new DoubleBox();

	// PayBackYear
	private DoubleBox txtSystemCost = new DoubleBox();
	private DoubleBox txtLifeSpan = new DoubleBox();
	private DoubleBox txtDailySavings = new DoubleBox();
	private Button btnPayBackYear = new Button();
	private DoubleBox lblPayBackYear = new DoubleBox();
    private Label lblMonthResult=new Label();
    private DoubleBox txtPowerEstimate = new DoubleBox();
    
    private IntegerBox txtHouseholdSize = new IntegerBox();
    private RadioButton rdbtnHeavy = new RadioButton("usage", "Heavy");
    private RadioButton rdbtnMedium = new RadioButton("usage", "Medium");
    private RadioButton rdbtnLight = new RadioButton("usage", "Light");
    
	
	private CalculationServiceAsync service; 
	
	public void onModuleLoad() {
		loadDailySolarGenerationControls();
		loadDailySavingsControls();
		loadPayBackYearControls();
		service= (CalculationServiceAsync) GWT.create(CalculationService.class);
		ServiceDefTarget serviceDef = (ServiceDefTarget) service;
        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
            + "calculationService");
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
		lblDailySolarGeneration.setText("");
		rdbtnMedium.setValue(true);
		txtHouseholdSize.setValue(0);
		btnDailySolarGeneration.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				doCalculation();
			}
		});

		RootPanel.get("tdSystemSize").add(txtSystemSize);
		RootPanel.get("tdRoofEfficiency").add(txtRoofEfficiency);
		RootPanel.get("tdInverterEfficiency").add(txtInverterEfficiency);
		RootPanel.get("tdWiringEfficiency").add(txtWiringEfficiency);
		RootPanel.get("tdWhatYear").add(txtWhatYear);
		RootPanel.get("tdAgingEfficiencyLoss").add(txtAgingEfficiencyLoss);
		RootPanel.get("tdSolarIrradiance").add(txtSolarIrradiance);
		RootPanel.get("tdDailySolarGenerationCalculate").add(
				btnDailySolarGeneration);
		RootPanel.get("tdDailySolarGenerationResult").add(
				lblDailySolarGeneration);
		
		RootPanel.get("idMonthSolarGenerationResults").add(lblMonthResult);
		
		RootPanel.get("tdDailySavingsResult").add(txtDailySavings);
		
		RootPanel.get("tdPowerEstimateResult").add(txtPowerEstimate);
		
		RootPanel.get("tdHouseholdSize").add(txtHouseholdSize);
		
		RootPanel.get("tdUsageType").add(rdbtnHeavy);
		RootPanel.get("tdUsageType").add(rdbtnMedium);
		RootPanel.get("tdUsageType").add(rdbtnLight);
		
	}

	private void loadDailySavingsControls() {
		txtDailyGeneration.setText("0");
		txtExportPercent.setText("0");
		txtReplacePercent.setText("0");
		txtFeedInTariff.setText("0");
		txtPowerCost.setText("0");
		btnDailySavings.setText("Calculate");
		lblDailySavings.setText("");
		

		btnDailySavings.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getDailySavingsFromServer();
			}
		});
		
		RootPanel.get("tdExportPercent").add(txtExportPercent);
		RootPanel.get("tdReplacePercent").add(txtReplacePercent);
		RootPanel.get("tdFeedInTariff").add(txtFeedInTariff);
		RootPanel.get("tdPowerCost").add(txtPowerCost);	
		
	}

	private void loadPayBackYearControls() {
		txtSystemCost.setText("0");
		txtLifeSpan.setText("0");
		txtDailySavings.setText("0");
		btnPayBackYear.setText("Calculate");
		lblPayBackYear.setText("");

		btnPayBackYear.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getPayBackYearFromServer();
			}
		});

		RootPanel.get("tdSystemCost").add(txtSystemCost);
		RootPanel.get("tdLifeSpan").add(txtLifeSpan);		
		RootPanel.get("tdPayBackYearResult").add(lblPayBackYear);
	}

	protected void doCalculation(){		
        
        // calculate the generation for all months
        service.doSolarGenerationForAllMonths(txtSystemSize.getValue(), txtRoofEfficiency.getValue(), txtInverterEfficiency.getValue(), txtWiringEfficiency.getValue(), txtWhatYear.getValue(), txtAgingEfficiencyLoss.getValue(), new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(String result) {
				lblMonthResult.setText(result);
			}
		});

        // calculate the daily generation
        service.doDailySolarGeneration(txtSystemSize.getValue(), txtRoofEfficiency.getValue(), txtInverterEfficiency.getValue(), txtWiringEfficiency.getValue(), txtWhatYear.getValue(), txtAgingEfficiencyLoss.getValue(), txtSolarIrradiance.getValue(), new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Double result) {
				lblDailySolarGeneration.setValue(result);
				getDailySaving(result);
			}});
        
        service.doPowerConsumption(txtHouseholdSize.getValue(), getUsageSelection(), new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Double result) {
				txtPowerEstimate.setValue(result);				
			}});


	}
	
	private String getUsageSelection() {
		if (rdbtnHeavy.getValue())
			return "Heavy";
		else if(rdbtnLight.getValue())
			return "Light";
		else return "Medium";
		
	}

	private void getDailySaving( double dailyGeneration){
 		   service.doDailySavings(dailyGeneration, txtExportPercent.getValue(), txtReplacePercent.getValue(), txtFeedInTariff.getValue(), txtPowerCost.getValue(), new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Double result) {
				txtDailySavings.setText(result.toString());
				getPayBackYear(result);
			}});			

	}
	
	private void getPayBackYear( double dailySaving){
		service.doPayBackYear(txtSystemCost.getValue(), txtLifeSpan.getValue(),
				dailySaving,new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Double result) {
				lblPayBackYear.setText(result.toString());
			}});
	}

	protected void getDailySolarGenerationFromServer() {
		CalculationServiceAsync service = (CalculationServiceAsync) GWT
				.create(CalculationService.class);
		ServiceDefTarget serviceDef = (ServiceDefTarget) service;
		serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
				+ "calculationService");
		DailySolarGenerationCallback callback = new DailySolarGenerationCallback(
				lblDailySolarGeneration);
		service.doMonthlySolarGeneration(txtSystemSize.getValue(),
				txtRoofEfficiency.getValue(), txtInverterEfficiency.getValue(),
				txtWiringEfficiency.getValue(), txtWhatYear.getValue(),
				txtAgingEfficiencyLoss.getValue(), 10, callback);
	}

	protected void getDailySavingsFromServer() {
		CalculationServiceAsync service = (CalculationServiceAsync) GWT
				.create(CalculationService.class);
		ServiceDefTarget serviceDef = (ServiceDefTarget) service;
		serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
				+ "calculationService");
		DailySavingsCallback callback = new DailySavingsCallback(
				lblDailySavings);
		service.doDailySavings(txtDailyGeneration.getValue(),
				txtExportPercent.getValue(), txtReplacePercent.getValue(),
				txtFeedInTariff.getValue(), txtPowerCost.getValue(), callback);
	}

	protected void getPayBackYearFromServer() {
		CalculationServiceAsync service = (CalculationServiceAsync) GWT
				.create(CalculationService.class);
		ServiceDefTarget serviceDef = (ServiceDefTarget) service;
		serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
				+ "calculationService");
		PayBackYearCallback callback = new PayBackYearCallback(lblPayBackYear);
		service.doPayBackYear(txtSystemCost.getValue(), txtLifeSpan.getValue(),
				txtDailySavings.getValue(), callback);
	}

}
