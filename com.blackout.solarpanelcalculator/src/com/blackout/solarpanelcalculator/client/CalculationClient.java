
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
//	auto generated widgets variable
	private DoubleBox sunlightHoursBox;
	private Label lblHowManySunlight;
	private ListBox directionCombo;
	private ListBox angleCombo;
	private ListBox stateCombo;
	private Label lblWhatsYourSystem;
	private DoubleBox systemSizeBox;	
	private CheckBox chckbxClickToEstimate;
	private Label lblHowManyPeople;
	private IntegerBox householdSizeBox;
	private RadioButton rdbtnHeavyUser;
	private RadioButton rdbtnMediumUser;
	private RadioButton rdbtnLightUser;
	private Label lblChooseYourUsage;
	private Label sunlightErrorLabel;
	private Label systemSizeErrorLabel;
	private Label noOfPeopleErrorLabel;
//	end of auto generated widgets variable
	
	private boolean estimateConsumptionSelected = false;//estimateConsumption boolean initial false, not shown
	private Button btnResultsfrmserver;
	private TextBox serverTextBox;
	private RadioButton rdbtnDaily;
	private RadioButton rdbtnWeekly;
	private RadioButton rdbtnMonthly;
	private RadioButton rdbtnSeasonly;
	private RadioButton rdbtnYearly;

	public void onModuleLoad() {
//		ToolDesigner auto generated codes		
		RootPanel rootPanel = RootPanel.get();		
		Label titleLabel = new Label("Solar Power Calculator");
		titleLabel.setStyleName("gwt-Label-Title");
		rootPanel.add(titleLabel, 10, 25);		
		Label lblSelectYourState = new Label("Select your state:");
		rootPanel.add(lblSelectYourState, 10, 88);
		
		stateCombo = new ListBox();
		stateCombo.addItem("---Select State---");
		stateCombo.addItem("SA");
		stateCombo.addItem("NT");
		stateCombo.addItem("QLD");
		stateCombo.addItem("ACT");
		stateCombo.addItem("TAS");
		stateCombo.addItem("VIC");
		stateCombo.addItem("WA");
		stateCombo.addItem("NSW");
		rootPanel.add(stateCombo, 521, 96);
		stateCombo.setSize("151px", "22px");
		
		Label lblWhatIsYour = new Label("What is your roof angle?");
		rootPanel.add(lblWhatIsYour, 10, 142);
		
		angleCombo = new ListBox();
		angleCombo.addItem("---Select Angle---");
		angleCombo.addItem("Flat");
		angleCombo.addItem("Normal");
		angleCombo.addItem("Steep");
		rootPanel.add(angleCombo, 521, 150);
		angleCombo.setSize("151px", "22px");
		
		Label lblWhatDirectionIs = new Label("What direction is your intended roof face?");
		rootPanel.add(lblWhatDirectionIs, 10, 194);
		
		directionCombo = new ListBox();
		directionCombo.addItem("---Select Direction---");
		directionCombo.addItem("North");
		directionCombo.addItem("North east/west");
		directionCombo.addItem("Due east/west");
		directionCombo.setVisibleItemCount(1);
		
		rootPanel.add(directionCombo, 521, 202);
		directionCombo.setSize("151px", "22px");
		
		lblHowManySunlight = new Label("How many sunlight hours do you have per day?");
		rootPanel.add(lblHowManySunlight, 10, 248);
		
		sunlightHoursBox = new DoubleBox();
//		validata sunlight box input if invalid show a red message
		sunlightHoursBox.addValueChangeHandler(new ValueChangeHandler<Double>() {
			public void onValueChange(ValueChangeEvent<Double> event) {
				try {
					if(!(sunlightHoursBox.getValueOrThrow() instanceof Double)||sunlightHoursBox.getValue()<=0){
					sunlightErrorLabel.setVisible(true);
					sunlightHoursBox.setValue(null);
					}
					else
						sunlightErrorLabel.setVisible(false);
				} catch (ParseException e) {
					sunlightErrorLabel.setVisible(true);
					sunlightHoursBox.setValue(null);
				}
					
			}
		});
//		end of validate
		
		rootPanel.add(sunlightHoursBox, 521, 256);
		sunlightHoursBox.setSize("147px", "16px");
		
		Button btnGetResults = new Button("Get results");
//		click to see results
		btnGetResults.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
//				if any boxe has null value, or any listbox is not selected, pop up a error message
				if( sunlightHoursBox.getValue()==null||systemSizeBox.getValue()==null||(estimateConsumptionSelected==true)&&(householdSizeBox.getValue()==null)
						||stateCombo.getSelectedIndex()==0||angleCombo.getSelectedIndex()==0||directionCombo.getSelectedIndex()==0){
					Window.alert("Please enter required fields");
				return;
				}				
				try {
					final String results = solarPanelResults() +EstimateResults();
					createDialogBox(results);
				} catch (SolarException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PowerConsumptionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		rootPanel.add(btnGetResults, 393, 25);
		
		lblWhatsYourSystem = new Label("what's your system size in kws?");
		rootPanel.add(lblWhatsYourSystem, 10, 309);
		
		systemSizeBox = new DoubleBox();
		
//		validate systemSizeBox input
		systemSizeBox.addValueChangeHandler(new ValueChangeHandler<Double>() {
			public void onValueChange(ValueChangeEvent<Double> event) {
				try {
					if(!(systemSizeBox.getValueOrThrow() instanceof Double)||systemSizeBox.getValue()<=0){
					systemSizeErrorLabel.setVisible(true);
					systemSizeBox.setText(null);
					}
					else
						systemSizeErrorLabel.setVisible(false);
				} catch (ParseException e) {
					systemSizeErrorLabel.setVisible(true);
					systemSizeBox.setText(null);
				}
			}
		});
//		end of validate
		
		rootPanel.add(systemSizeBox, 521, 313);
		
		chckbxClickToEstimate = new CheckBox("Click to estimate your household power consumption");
		
//		click to show estimate option and unclick to hide it
		chckbxClickToEstimate.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				 estimateConsumptionSelected = !estimateConsumptionSelected;		
				 
					householdSizeBox.setVisible( estimateConsumptionSelected);
					lblHowManyPeople.setVisible( estimateConsumptionSelected);
					rdbtnHeavyUser.setVisible( estimateConsumptionSelected);
					rdbtnMediumUser.setVisible( estimateConsumptionSelected);
					rdbtnLightUser.setVisible( estimateConsumptionSelected);
					lblChooseYourUsage.setVisible(estimateConsumptionSelected);
					if(estimateConsumptionSelected ==false){
						noOfPeopleErrorLabel.setVisible(false);
						householdSizeBox.setValue(null);
					}
										
			;
			}
		});
		
		rootPanel.add(chckbxClickToEstimate, 50, 423);		
		lblHowManyPeople = new Label("How many people in your household?");
		lblHowManyPeople.setStyleName("gwt-Label-household");
		lblHowManyPeople.setVisible( estimateConsumptionSelected);
		rootPanel.add(lblHowManyPeople, 78, 459);
		
//		validate householdsizeBox user input
		householdSizeBox = new IntegerBox();
		householdSizeBox.addValueChangeHandler(new ValueChangeHandler<Integer>() {
			public void onValueChange(ValueChangeEvent<Integer> event) {
				try {
					if(!(householdSizeBox.getValueOrThrow() instanceof Integer)||householdSizeBox.getValue()<=0){
					noOfPeopleErrorLabel.setVisible(true);
					householdSizeBox.setText(null);
				
					}
					else
						noOfPeopleErrorLabel.setVisible(false);
				} catch (ParseException e) {
					noOfPeopleErrorLabel.setVisible(true);
					householdSizeBox.setText(null);
				}
			}
		});
//		end of validate
		
		householdSizeBox.setVisible( estimateConsumptionSelected);
		rootPanel.add(householdSizeBox, 521, 459);
		
		rdbtnHeavyUser = new RadioButton("new name", "Heavy");
		rdbtnHeavyUser.setVisible( estimateConsumptionSelected);
		rdbtnHeavyUser.setStyleName("gwt-radiobutton");
		rootPanel.add(rdbtnHeavyUser, 505, 481);
		
		rdbtnMediumUser = new RadioButton("new name", "Medium");
		rdbtnMediumUser.setValue(true);
		rdbtnMediumUser.setVisible( estimateConsumptionSelected);
		rootPanel.add(rdbtnMediumUser, 563, 481);
		
		rdbtnLightUser = new RadioButton("new name", "Light");
		rdbtnLightUser.setVisible( estimateConsumptionSelected);
		rootPanel.add(rdbtnLightUser, 640, 481);
		
		lblChooseYourUsage = new Label("Choose your usage type");
		lblChooseYourUsage.setVisible(estimateConsumptionSelected);
		rootPanel.add(lblChooseYourUsage, 88, 484);
		
		sunlightErrorLabel = new Label("Please enter valid sunlight hours");
		sunlightErrorLabel.setVisible(false);
		sunlightErrorLabel.setStyleName("gwt-Label-error");
		rootPanel.add(sunlightErrorLabel, 521, 284);
		
		systemSizeErrorLabel = new Label("please enter valid system size");
		systemSizeErrorLabel.setVisible(false);
		systemSizeErrorLabel.setStyleName("gwt-Label-error");
		rootPanel.add(systemSizeErrorLabel, 528, 345);
		
		noOfPeopleErrorLabel = new Label("Please enter valid number of people");
		noOfPeopleErrorLabel.setVisible(false);
		noOfPeopleErrorLabel.setStyleName("gwt-Label-error");
		rootPanel.add(noOfPeopleErrorLabel, 521, 472);	
		
		Button btnReset = new Button("Reset");
		btnReset.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				clearContent();
			}
		});
		rootPanel.add(btnReset, 615, 25);
		
		btnResultsfrmserver = new Button("Serverbtn");
		btnResultsfrmserver.setVisible(false);
		btnResultsfrmserver.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getResultsFromServer();
			}
		});
		rootPanel.add(btnResultsfrmserver, 393, 74);
		btnResultsfrmserver.setSize("80px", "30px");
		
		serverTextBox = new TextBox();
		serverTextBox.setVisible(false);
		rootPanel.add(serverTextBox, 326, 73);
		serverTextBox.setSize("57px", "31px");
		
		Label lblShowPowerGeneration = new Label("Show Power generation details ?");
		rootPanel.add(lblShowPowerGeneration, 10, 356);
		
		rdbtnDaily = new RadioButton("new name", "Daily");
		rootPanel.add(rdbtnDaily, 10, 378);
		
		rdbtnWeekly = new RadioButton("new name", "Weekly");
		rootPanel.add(rdbtnWeekly, 89, 378);
		
		rdbtnMonthly = new RadioButton("new name", "Monthly");
		rootPanel.add(rdbtnMonthly, 181, 378);
		
		rdbtnSeasonly = new RadioButton("new name", "Seasonly");
		rootPanel.add(rdbtnSeasonly, 280, 378);
		
		rdbtnYearly = new RadioButton("new name", "Yearly");
		rootPanel.add(rdbtnYearly, 392, 378);
		rdbtnYearly.setSize("76px", "15px");
	
//		auto generated codes ends
		
	}
	protected void getResultsFromServer() {
		CalculationServiceAsync service = (CalculationServiceAsync) GWT.create(CalculationService.class);
        ServiceDefTarget serviceDef = (ServiceDefTarget) service;
        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
            + "calculationService");
        CalculationACallback calculationACallback = new CalculationACallback(serverTextBox);
        service.doCalculationA(1, 1, "", "", calculationACallback);
      }
		
	
	// reset everything to empty and hide error msgs 
	protected void clearContent() {
		stateCombo.setSelectedIndex(0);
		angleCombo.setSelectedIndex(0);
		directionCombo.setSelectedIndex(0);
		sunlightHoursBox.setText(null);
		systemSizeBox.setText(null);
		householdSizeBox.setText(null);
		sunlightErrorLabel.setVisible(false);
		systemSizeErrorLabel.setVisible(false);
		noOfPeopleErrorLabel.setVisible(false);
	}
	
	protected String EstimateResults() throws PowerConsumptionException {
		if(estimateConsumptionSelected){
		final int householdSize = householdSizeBox.getValue();
		final String usageType;
		if(rdbtnHeavyUser.getValue())
			usageType = rdbtnHeavyUser.getText();
		else if(rdbtnMediumUser.getWordWrap())
			usageType = rdbtnMediumUser.getText();
		else usageType = rdbtnLightUser.getText();
		
		PowerConsumption powerConsumption = new PowerConsumption(householdSize,usageType);
		
		return powerConsumption.toString();
		}
		else return "";
		
	}

	protected void createDialogBox(String results) {
		/*popup dialog box to show results*/
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Results based on your details\n");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");			
		VerticalPanel dialogVPanel = new VerticalPanel();
		
		final Label resultsLabel = new Label();
		resultsLabel.setText(results);
		
		dialogVPanel.add(resultsLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
		dialogBox.center();
		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();						
			}
		});
		
	}
/**
 * I don't know why I cannot use selected texts and use them parse into solarPanel constructor
 * so i used multiple if statements, need refactoring
 */
	protected String solarPanelResults() throws SolarException {
//get selected index from Listbox
		final int angleSelectedIndex = angleCombo.getSelectedIndex();
		final int directionSelectedIndex = directionCombo.getSelectedIndex();		
//assign the text in the index to string angle
		String angle =angleCombo.getItemText(angleSelectedIndex);
		if (angle.compareTo("Flat")==0)
		angle = "Flat";
		else if (angle.compareTo("Normal")==0)
			angle = "Normal";
		else if (angle.compareTo("Steep")==0)
				angle = "Steep";
		
		String direction = directionCombo.getItemText(directionSelectedIndex);
		
		if(direction.compareTo("North")==0)
			direction = "North";
		else if (angle.compareTo("North east/west")==0)
			direction = "North east/west";
		else if (direction.compareTo("east/west")==0)
			direction = "Due east/west";
		
		SolarPanel solarpanel = new SolarPanel(sunlightHoursBox.getValue(), systemSizeBox.getValue(),
				angle,direction);
		
		if(rdbtnDaily.getValue()==true)
//		generated power in kws daily
		return solarpanel.toStringDaily();
		else if(rdbtnWeekly.getValue()==true)
			return solarpanel.toStringWeekly();
		else if(rdbtnMonthly.getValue()==true)
			return solarpanel.toStringMonthly();
		else if(rdbtnSeasonly.getValue()==true)
			return solarpanel.toStringSeasonly();
		else 
			return solarpanel.toStringYearly();
		
	}
}
