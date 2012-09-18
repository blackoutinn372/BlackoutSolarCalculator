package com.blackout.solarpanelcalculator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CalculationClient implements EntryPoint {

	private DoubleBox txtSystemSize = new DoubleBox();
	private DoubleBox txtRoofEfficiency = new DoubleBox();
	private DoubleBox txtInverterEfficiency = new DoubleBox();
	private DoubleBox txtWiringEfficiency = new DoubleBox();
	private DoubleBox txtWhatYear = new DoubleBox();
	private DoubleBox txtAgingEfficiencyLoss = new DoubleBox();
	private DoubleBox txtSolarIrradiance = new DoubleBox();
	private DoubleBox txtDailySolarGeneration = new DoubleBox();
	private DoubleBox txtDailyGeneration = new DoubleBox();
	private DoubleBox txtExportPercent = new DoubleBox();
	private DoubleBox txtReplacePercent = new DoubleBox();
	private DoubleBox txtFeedInTariff = new DoubleBox();
	private DoubleBox txtPowerCost = new DoubleBox();
	private Button btnCalculation = new Button();
	private DoubleBox txtSystemCost = new DoubleBox();
	private DoubleBox txtLifeSpan = new DoubleBox();
	private DoubleBox txtDailySavings = new DoubleBox();
	private DoubleBox txtPayBackYear = new DoubleBox();
    private Label lblMonthResult=new Label();
    private DoubleBox txtPowerEstimate = new DoubleBox();
    private IntegerBox txtHouseholdSize = new IntegerBox();
    private RadioButton rdbtnHeavy = new RadioButton("usage", "Heavy");
    private RadioButton rdbtnMedium = new RadioButton("usage", "Medium");
    private RadioButton rdbtnLight = new RadioButton("usage", "Light");    
	
	private CalculationServiceAsync service; 
	
	public void onModuleLoad() {
		loadAllUIControls();
		service= (CalculationServiceAsync) GWT.create(CalculationService.class);
		ServiceDefTarget serviceDef = (ServiceDefTarget) service;
        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
            + "calculationService");
	}

	private void loadAllUIControls() {
		txtSystemSize.setText("0");
		txtRoofEfficiency.setText("0");
		txtInverterEfficiency.setText("0");
		txtWiringEfficiency.setText("0");
		txtWhatYear.setText("0");
		txtAgingEfficiencyLoss.setText("0");
		txtSolarIrradiance.setText("0");
		btnCalculation.setText("Calculate");
		txtDailySolarGeneration.setText("");
		rdbtnMedium.setValue(true);
		txtHouseholdSize.setValue(0);
		txtDailyGeneration.setText("0");
		txtExportPercent.setText("0");
		txtReplacePercent.setText("0");
		txtFeedInTariff.setText("0");
		txtPowerCost.setText("0");
		btnCalculation.setText("Calculate");
		txtSystemCost.setText("0");
		txtLifeSpan.setText("0");
		txtDailySavings.setText("0");
		txtPayBackYear.setText("");
		btnCalculation.addClickHandler(new ClickHandler() {
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
		RootPanel.get("tdDailySolarGenerationCalculate").add(btnCalculation);
		RootPanel.get("tdDailySolarGenerationResult").add(txtDailySolarGeneration);		
		RootPanel.get("idMonthSolarGenerationResults").add(lblMonthResult);		
		RootPanel.get("tdDailySavingsResult").add(txtDailySavings);		
		RootPanel.get("tdPowerEstimateResult").add(txtPowerEstimate);		
		RootPanel.get("tdHouseholdSize").add(txtHouseholdSize);		
		RootPanel.get("tdUsageType").add(rdbtnHeavy);
		RootPanel.get("tdUsageType").add(rdbtnMedium);
		RootPanel.get("tdUsageType").add(rdbtnLight);
		RootPanel.get("tdExportPercent").add(txtExportPercent);
		RootPanel.get("tdReplacePercent").add(txtReplacePercent);
		RootPanel.get("tdFeedInTariff").add(txtFeedInTariff);
		RootPanel.get("tdPowerCost").add(txtPowerCost);	
		RootPanel.get("tdSystemCost").add(txtSystemCost);
		RootPanel.get("tdLifeSpan").add(txtLifeSpan);		
		RootPanel.get("tdPayBackYearResult").add(txtPayBackYear);
		
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

        // calculate the daily generation,  
        service.doDailySolarGeneration(txtSystemSize.getValue(), txtRoofEfficiency.getValue(), txtInverterEfficiency.getValue(), txtWiringEfficiency.getValue(), txtWhatYear.getValue(), txtAgingEfficiencyLoss.getValue(), txtSolarIrradiance.getValue(), new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Double result) {
				txtDailySolarGeneration.setValue(result);
				getDailySaving(result);//use dailyCalculation result for dailySavingCalculation
			}});
        
        //calculate power consumption
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
	
//	Calculate Daily savings
	private void getDailySaving( double dailyGeneration){
 		   service.doDailySavings(dailyGeneration, txtExportPercent.getValue(), txtReplacePercent.getValue(), txtFeedInTariff.getValue(), txtPowerCost.getValue(), new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Double result) {
				txtDailySavings.setText(result.toString());
				getPayBackYear(result);// use savings result to calculate pay back year
			}});			

	}
//	Calculate Payback year
	private void getPayBackYear( double dailySaving){
		service.doPayBackYear(txtSystemCost.getValue(), txtLifeSpan.getValue(),
				dailySaving,new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Double result) {
				txtPayBackYear.setText(result.toString());
			}});
	}

}
