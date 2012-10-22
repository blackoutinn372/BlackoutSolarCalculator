package com.blackout.solarpanelcalculator.client;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.blackout.solarpanelcalculator.server.ProductDAO;
import com.google.code.gwt.geolocation.client.Coordinates;
import com.google.code.gwt.geolocation.client.Geolocation;
import com.google.code.gwt.geolocation.client.Position;
import com.google.code.gwt.geolocation.client.PositionCallback;
import com.google.code.gwt.geolocation.client.PositionError;
import com.google.code.gwt.geolocation.client.PositionOptions;
import com.google.gwt.maps.client.Maps;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapType;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.control.MapTypeControl;

import com.google.gwt.maps.client.geocode.Geocoder;
import com.google.gwt.maps.client.geocode.LatLngCallback;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.visualizations.ColumnChart;
import com.google.gwt.visualization.client.visualizations.ColumnChart.Options;
import com.google.gwt.visualization.client.visualizations.LineChart;
import com.google.gwt.visualization.client.visualizations.Table;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CalculationClient implements EntryPoint 
{
	private double defaultIrradiance = 5.1;					//kWh/m2/day
	private double defaultRoofLossPercent = 88.5;			//percentage
	private double defaultFeedInTariff = 44;				// cents
	private double defaultElectricityCost = 19.41;			//cents
	private double defaultSystemCost = 18000;				// dollars
	private double defaultSystemSize = 4950;				//watts
	private double defaultInverterEfficiency= 96;			//percentage
	private double defaultWiringEfficiency = 98;			// percentage 
	private double defaultHomeUsePercent = 24;				//percentage
	private double defaultAgingEfficiencyLoss = 0.7;		//percentage
	private double defaultSolarPanelLife = 25; 				//years
	private String defaultAddress = "43 Queen St,Brisbane QLD 4000,Australia";
	private int postcode = 4000;
	MapWidget map = null ;
	private double[] dailyIrradianceInMonth = {6.19,5,3.9,4.95,3.98,3.23,3.02,3.22,4.04,5.12,5.52,6.07,6.35};
	private TextBox txtSimilarSystem = new TextBox();
	private double avgProducePerkw = 0;
	private double zoneRating = 0; 							//used for REC entitlement and subsidy calculation
	private double optimaYearRoundAngle = 0;
	private double bestWinterAngle = 0;
	private double bestSummerAngle = 0;
	private ColumnChart chart;								//for monthly results chart
	private LineChart lineChart;							//for payback time line chart
	private TreeMap<Double,String> payBackTime = null;	
	private Label lblAddressInput = new Label();
	private TextBox txtBoxAddressInput = new TextBox();
		private Button btnAddressInput = new Button();
		private Label lblNotFound = new Label();
	private ListBox cityComboBox = new ListBox();	
	private ListBox roofDirectioncomboBox = new ListBox();
	private ListBox angleComboBox = new ListBox();
	private ListBox roofDirectioncomboBox2 = new ListBox();
	private ListBox angleComboBox2 = new ListBox();
	private DoubleBox systemCostBox = new DoubleBox();		
	private DoubleBox doubleBoxSize = new DoubleBox();	
	private DoubleBox efficiencyForDirectionAndAngle = new DoubleBox();	              
    private DoubleBox inverterBox = new DoubleBox();    
    private DoubleBox doubleBoxWiring = new DoubleBox();   
    private DoubleBox integerBoxLifeSpan = new DoubleBox();    
    private DoubleBox doubleBoxPowerCost = new DoubleBox();  
    private DoubleBox doubleBoxTarrif = new DoubleBox();    
    private DoubleBox doubleBoxReplacePercent = new DoubleBox();	
	private DoubleBox doubleBoxAgeLoss = new DoubleBox();
	private DoubleBox doubleBoxIrradiance = new DoubleBox();
	private IntegerBox integerBoxpaybackYear = new IntegerBox();
	private DoubleBox txtWhatYear = new DoubleBox();
	private TextBox txtDailySolarGeneration = new TextBox();
	private Button btnCalculation = new Button();	
	private TextBox txtDailySavings = new TextBox();	
	private TextBox txtPayBackYear = new TextBox();
    private TextBox txtPowerEstimate = new TextBox();
    private TextBox txtOptimalYearAngle = new TextBox();
    private TextBox txtOptimalWinterAngle = new TextBox();
    private TextBox txtOptimalSummerAngle = new TextBox();
    private TextBox txtTotalSubsidy = new TextBox();
    
    private IntegerBox txtHouseholdSize = new IntegerBox();
    private TextBox txtPostcode = new TextBox();
    private RadioButton rdbtnHeavy = new RadioButton("usage", "Heavy");
    private RadioButton rdbtnMedium = new RadioButton("usage", "Medium");
    private RadioButton rdbtnLight = new RadioButton("usage", "Light");    
    
    /* WorthInvestment items */
    private DoubleBox txtDailySavings2 = new DoubleBox();
    private DoubleBox txtPayBackYear2 = new DoubleBox();
    private DoubleBox txtExpectedDuration = new DoubleBox();
    private Button btnWorthInvesting = new Button();
    private DoubleBox lblWorthInvesting = new DoubleBox();
    private DoubleBox lblBankInterest = new DoubleBox();
    private Label lblWorthText = new Label();
    
	private CalculationServiceAsync service;
	private double[] monthResults =null;
	private CheckBox secondBank = new CheckBox("click to add a second Bank");
	private TextBox txtSecondBank = new TextBox();
	private TextBox secondBankEfficiency = new TextBox();
	private double secondBankGeneration = 0;
	
	private DataTable pt;
	
	public void onModuleLoad() {
		RootPanel.get("tdMainPanel").add(loadAllControlsNew());		 
		service= (CalculationServiceAsync) GWT.create(CalculationService.class);
		loadAllUIControls();
        createColumnChart(monthResults );//load months results charts
        createLineChart(payBackTime);        
        loadUserLocationOnMap();	
        createTable();
	}

	private Widget loadAllControlsNew() {
		// Pop up message
		String irradianceMsg = "This value is auto updated based on your location you can also enter a value to override it";
		PopMessage irradianceHelpMsg = new PopMessage(irradianceMsg);		
		String overallCostMsg = "The overall cost is your solar system and installation cost minus any goverment rebates  ";
		PopMessage overallCostHelpMsg = new PopMessage(overallCostMsg);
		/*address input controls*/
		lblAddressInput.setText("Enter your address to find it on the map:");
		btnAddressInput.setText("Enter");
		lblNotFound.setText("address not found");
		lblNotFound.setStyleName("gwt-Label-error");
		lblNotFound.setVisible(false);
		btnAddressInput.addClickHandler(new ClickHandler(){
			/* click the button to show the address on the map*/
			@Override
			public void onClick(ClickEvent event) {
					lblNotFound.setVisible(false);
				 	Geocoder geocoder=new Geocoder();
				 	final String address = txtBoxAddressInput.getText();
				    geocoder.getLatLng(address, new LatLngCallback(){
				    @Override
				    public void onFailure() {
				    	lblNotFound.setVisible(true);//display error msg if not found
				    }
				    @Override
				    public void onSuccess(LatLng point) { 
				   LatLng addressLatlng = LatLng.newInstance(point.getLatitude(), point.getLongitude());
				   map.setCurrentMapType(MapType.getSatelliteMap());
				    map.setCenter(addressLatlng);

				    map.setZoomLevel(18);
				    // Add a marker
				    map.addOverlay(new Marker(point)); 
				    // Add an info window to highlight a point of interest
				    map.getInfoWindow().open(map.getCenter(),
				            new InfoWindowContent(address));
				    }
				    });				
			}		
		});
		// Add address labels box
		VerticalPanel verticalpanel = new VerticalPanel();
		HorizontalPanel addressPanel = new HorizontalPanel();
		addressPanel.add(lblAddressInput);

		HorizontalPanel addressPanel2 = new HorizontalPanel();
		txtBoxAddressInput.setWidth("342px");
		addressPanel2.add(txtBoxAddressInput);

		addressPanel2.add(lblNotFound);
		lblNotFound.setWidth("117px");
		verticalpanel.add(addressPanel);
		verticalpanel.add(addressPanel2);
		verticalpanel.add(btnAddressInput);
		RootPanel.get("idAddressInput").add(verticalpanel);

		//		Set boxes to their default values
		 systemCostBox.setValue(defaultSystemCost);	
		 doubleBoxSize.setValue(defaultSystemSize);	
		 efficiencyForDirectionAndAngle.setValue(defaultRoofLossPercent); 
	     inverterBox.setValue(defaultInverterEfficiency) ;
	     doubleBoxWiring.setValue(defaultWiringEfficiency);   
	     integerBoxLifeSpan.setValue(defaultSolarPanelLife);     
	     doubleBoxPowerCost.setValue(defaultElectricityCost);
	     doubleBoxTarrif.setValue(defaultFeedInTariff);  
	     doubleBoxReplacePercent.setValue(defaultHomeUsePercent); 
		 doubleBoxAgeLoss.setValue(defaultAgingEfficiencyLoss);
		 doubleBoxIrradiance.setValue(defaultIrradiance); //get irradiance from database based on city selection
		 integerBoxpaybackYear.setValue(25);

		 //		Create labels
		Label lblAssumeSolarIrradiance = new Label("Solar irradiance level in your location is(kWh/m2/day):");
		lblAssumeSolarIrradiance.addMouseOverHandler(irradianceHelpMsg);
		lblAssumeSolarIrradiance.addMouseOutHandler(irradianceHelpMsg);
		Label lblAssumeSolarPanel = new Label("Solar panel aging efficiency loss per year is(%):");
		Label lblAssumeUseAtHome = new Label("The percentage of solar generation used at home is(%):");
		Label lblTarrif = new Label("Your feed in tarrif is (cents in kwh):");
		Label lblPowerCost = new Label("Your electricity cost is (cents per kwh):");
		Label lblLifeSpan = new Label("The Solar panel life span is(years):");
		Label lblWiring = new Label("The wiring efficiency is(%):");
		Label inverterLbl = new Label("The inverter efficiency is(%):");
		Label roofLossLbl = new Label("The efficiency due to loss to angle and direction is(%):");
		Label lblSystemSize = new Label("Your solar system size (watts):");
		Label systemCostLbl = new Label("Your overall purchase cost(dollars):");
		systemCostLbl.addMouseOverHandler(overallCostHelpMsg);
		systemCostLbl.addMouseOutHandler(overallCostHelpMsg);
		Label roofFaceLbl = new Label("Select your roof direction:");
		HTML cityLbl = new HTML("&nbsp or Select city:");	 
		Label postcodeLbl = new Label("Postcode:");
		Label angleLbl = new Label("Select your roof angle:");
		
		//Mouse Handler
		txtPostcode.addMouseOutHandler(new PostcodeHandler());
		doubleBoxSize.addMouseOutHandler(new systemSizeValidation());
		systemCostBox.addMouseOutHandler(new systemCostValidation());
		efficiencyForDirectionAndAngle.addMouseOutHandler(new directionAndAngleValidation());
		inverterBox.addMouseOutHandler(new inverterValidation());
		doubleBoxWiring.addMouseOutHandler(new wiringValidation());
		integerBoxLifeSpan.addMouseOutHandler(new lifeSpanValidation());
		doubleBoxPowerCost.addMouseOutHandler(new powerCostValidation());
		doubleBoxTarrif.addMouseOutHandler(new tarrifValidation());
		doubleBoxReplacePercent.addMouseOutHandler(new replacePercentValidation());
		doubleBoxAgeLoss.addMouseOutHandler(new ageLossValidation());
		doubleBoxIrradiance.addMouseOutHandler(new irradianceValidation());
		txtSecondBank.addMouseOutHandler(new secondBankValidation());
		secondBankEfficiency.addMouseOutHandler(new secondBankEfficiencyValidation());
		
		cityComboBox.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {

				getCityValues();
				

			}

		});

		//	roof combobox selections
		roofDirectioncomboBox.addItem("South");
		roofDirectioncomboBox.addItem("South West");
		roofDirectioncomboBox.addItem("South East");
		roofDirectioncomboBox.addItem("West");
		roofDirectioncomboBox.addItem("North");
		roofDirectioncomboBox.addItem("North West");
		roofDirectioncomboBox.addItem("North East");
		roofDirectioncomboBox.addItem("East");
		roofDirectioncomboBox.setSelectedIndex(0);
		roofDirectioncomboBox.addChangeHandler(new DirectionAndAngleHandler());
		
		angleComboBox.addItem("Adjusted to best performance");
		angleComboBox.addItem("Close to flat");		
		angleComboBox.addItem("Close to steep");
		angleComboBox.setSelectedIndex(0);
		angleComboBox.addChangeHandler(new DirectionAndAngleHandler());
		//getAngleDirectionEfficiency();
		
		doubleBoxSize.setWidth("106px");
	    // Create a table to layout the form options
	    FlexTable layout = new FlexTable();
	    layout.setCellSpacing(2);
	    layout.setWidth("500px");

	    //	    add widgets to flextable
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
	    HorizontalPanel hpanel = new HorizontalPanel();
	    hpanel.add(postcodeLbl);
	    hpanel.add(txtPostcode);
	    hpanel.add(cityLbl);
	    txtPostcode.setWidth("55px");
	    HorizontalPanel hpanel2 = new HorizontalPanel();
	    
	    hpanel2.add(cityComboBox);
	    layout.setWidget(1, 0, hpanel);
	    layout.setWidget(1, 1,hpanel2);
	    cityComboBox.setWidth("122px");
	    layout.setWidget(2, 0, roofFaceLbl);
	    layout.setWidget(2, 1, roofDirectioncomboBox);
	    roofDirectioncomboBox.setWidth("123px");
	    layout.setWidget(3, 0, angleLbl);
	    layout.setWidget(3, 1, angleComboBox);
	    angleComboBox.setWidth("123px");
	    layout.setWidget(4, 0, lblSystemSize);
	    layout.setWidget(4, 1, doubleBoxSize);
	    systemCostBox.setWidth("106px");
	    layout.setWidget(5, 0, systemCostLbl);
	    layout.setWidget(5, 1, systemCostBox);

	    //	   set styles to labels and boxes
	    roofLossLbl.setStyleName("gwt-Label-assumptions"); 	   
	    efficiencyForDirectionAndAngle.setStyleName("gwt-DoubleBox-assumptions");   
	    inverterLbl.setStyleName("gwt-Label-assumptions");	
	    inverterBox.setStyleName("gwt-DoubleBox-assumptions");		
		lblWiring.setStyleName("gwt-Label-assumptions");			
		doubleBoxWiring.setStyleName("gwt-DoubleBox-assumptions");	
		lblLifeSpan.setStyleName("gwt-Label-assumptions");		
		integerBoxLifeSpan.setStyleName("gwt-DoubleBox-assumptions");		
		lblPowerCost.setStyleName("gwt-Label-assumptions");
		doubleBoxPowerCost.setStyleName("gwt-DoubleBox-assumptions");		
		lblTarrif.setStyleName("gwt-Label-assumptions");
		doubleBoxTarrif.setStyleName("gwt-DoubleBox-assumptions");		
		lblAssumeUseAtHome.setStyleName("gwt-Label-assumptions");
		doubleBoxReplacePercent.setStyleName("gwt-DoubleBox-assumptions");		
		lblAssumeSolarPanel.setStyleName("gwt-Label-assumptions");	
		doubleBoxAgeLoss.setStyleName("gwt-DoubleBox-assumptions");		
		doubleBoxIrradiance.setStyleName("gwt-DoubleBox-assumptions");		
		lblAssumeSolarIrradiance.setStyleName("gwt-Label-assumptions");	
	    
	    final FlexTable parameters = new FlexTable();
	    parameters.setCellSpacing(2);
	    parameters.setWidth("500px");
	    
	    parameters.setWidget(1, 0, roofLossLbl);
	    parameters.setWidget(1, 1, efficiencyForDirectionAndAngle);
	    parameters.setWidget(2, 0, inverterLbl);
	    parameters.setWidget(2, 1, inverterBox);
	    parameters.setWidget(3, 0, lblWiring);
	    parameters.setWidget(3, 1, doubleBoxWiring);
	    parameters.setWidget(4, 0, lblLifeSpan);
	    parameters.setWidget(4, 1, integerBoxLifeSpan);
	    parameters.setWidget(5, 0, lblPowerCost);
	    parameters.setWidget(5, 1,doubleBoxPowerCost);
	    parameters.setWidget(6, 0,lblTarrif);
	    parameters.setWidget(6, 1,doubleBoxTarrif);
	    parameters.setWidget(7, 0,lblAssumeUseAtHome);
	    parameters.setWidget(7, 1,doubleBoxReplacePercent);
	    parameters.setWidget(8, 0,lblAssumeSolarPanel);
	    parameters.setWidget(8, 1,doubleBoxAgeLoss);
	    parameters.setWidget(9, 0,lblAssumeSolarIrradiance);
	    parameters.setWidget(9, 1,doubleBoxIrradiance);    
	    parameters.setWidget(10,0,secondBank);
	    
	    /*controls for second bank*/
	    secondBank.addClickHandler(new ClickHandler(){

	    	@Override
			public void onClick(ClickEvent event) {
				if(secondBank.getValue())
					loadSecondBankUI();
				
			}

			private void loadSecondBankUI() {
				roofDirectioncomboBox2.addItem("South");
				roofDirectioncomboBox2.addItem("South West");
				roofDirectioncomboBox2.addItem("South East");
				roofDirectioncomboBox2.addItem("West");
				roofDirectioncomboBox2.addItem("North");
				roofDirectioncomboBox2.addItem("North West");
				roofDirectioncomboBox2.addItem("North East");
				roofDirectioncomboBox2.addItem("East");
				roofDirectioncomboBox2.setSelectedIndex(0);
				roofDirectioncomboBox2.addChangeHandler(new DirectionAndAngleHandler());
				angleComboBox2.addItem("Adjusted to best performance");
				angleComboBox2.addItem("Close to flat");		
				angleComboBox2.addItem("Close to steep");
				angleComboBox2.setSelectedIndex(0);
				angleComboBox2.addChangeHandler(new DirectionAndAngleHandler());
				txtSecondBank.setStyleName("gwt-DoubleBox-assumptions");
				txtSecondBank.setText(Double.toString(50));
				secondBankEfficiency.setText(Double.toString(defaultRoofLossPercent));
				secondBankEfficiency.setStyleName("gwt-DoubleBox-assumptions");
				secondBankEfficiency.setText(Double.toString(defaultRoofLossPercent));
				parameters.setWidget(11, 0, new HTML("<b>Second bank roof direction:</b>"));
				parameters.setWidget(11,1,roofDirectioncomboBox2);
				parameters.setWidget(12, 0, new HTML("<b>Second bank roof angle:</b>"));
				parameters.setWidget(12, 1, angleComboBox2);
				parameters.setWidget(13, 0,new HTML("<b>Enter the percentage of second bank(%)</b>"));
				parameters.setWidget(13, 1, txtSecondBank);
				parameters.setWidget(14, 0, new HTML("<b>Second bank angle and direction efficiency is(%)</b>"));
				parameters.setWidget(14,1,secondBankEfficiency);
				
			}

		
	    	
	    });
	
	    // Add advanced options to form in a disclosure panel
	    DisclosurePanel advancedDisclosure = new DisclosurePanel(
	        "Advanced Controls");
	    advancedDisclosure.setContent(parameters);
	    advancedDisclosure.setAnimationEnabled(false);   
	    layout.setWidget(6, 0, advancedDisclosure);
	    advancedDisclosure.setWidth("516px");
	    cellFormatter.setColSpan(6, 0, 2);
	    
	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setSize("550", "700");
	    decPanel.setWidget(layout);
	    return decPanel;
	}
	
	class DirectionAndAngleHandler implements ChangeHandler{

		@Override
		public void onChange(ChangeEvent event) {
			getAngleDirectionEfficiency();
			
		}
		
	}

	class PostcodeHandler implements MouseOutHandler {
		@Override
		public void onMouseOut(MouseOutEvent event) {
			
			if(Validator.isValidPostcode(txtPostcode.getText())==false)
			{
				txtPostcode.setStyleName("gwt-TextBox-Error", true);
				txtPostcode.setFocus(true);
			}
			else
			{
				txtPostcode.setStyleName("gwt-TextBox-Error", false);
				selectCityOnPostcode();	
			}
			
		}
   
	
		private void selectCityOnPostcode() {
			 service.getCityIDFromPostcode(Integer.parseInt(txtPostcode.getText()), new AsyncCallback<Integer> (){

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("server get postcode failed");						
				}

				@Override
				public void onSuccess(Integer result) {
					if(result ==-1){
						Window.alert("cannot find your postcode");							
					}
					cityComboBox.setSelectedIndex(result);
					getCityValues();						
				}					
			});
		}		
	}
	
	class systemSizeValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			String validFormat ="^([-+] ?)?[0-9]+(,[0-9]+)?$";
			if((Validator.isValidBigNumber(doubleBoxSize.getText()) == false) && (!doubleBoxSize.getText().matches(validFormat)))
			{
				doubleBoxSize.setStyleName("gwt-TextBox-Error", true);
				doubleBoxSize.setFocus(true);
			}
			else
			{
				doubleBoxSize.setStyleName("gwt-TextBox-Error", false);
			}
		}
		
	}
	
	class systemCostValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			String validFormat ="^([-+] ?)?[0-9]+(,[0-9]+)?$";
			if((Validator.isValidBigNumber(systemCostBox.getText()) == false) && (!systemCostBox.getText().matches(validFormat)))
			{
				systemCostBox.setStyleName("gwt-TextBox-Error", true);
				systemCostBox.setFocus(true);
			}
			else
			{
				systemCostBox.setStyleName("gwt-TextBox-Error", false);
			}
		}
		
	}
	
	class directionAndAngleValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			
			if(Validator.isValidPercentage(efficiencyForDirectionAndAngle.getText()) == false)
			{
				efficiencyForDirectionAndAngle.setStyleName("gwt-TextBox-Error", true);
				efficiencyForDirectionAndAngle.setFocus(true);
			}
			else
			{
				efficiencyForDirectionAndAngle.setStyleName("gwt-TextBox-Error", false);
			}
		}
	}
	
	class inverterValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			
			if(Validator.isValidPercentage(inverterBox.getText()) == false)
			{
				inverterBox.setStyleName("gwt-TextBox-Error", true);
				inverterBox.setFocus(true);
			}
			else
			{
				inverterBox.setStyleName("gwt-TextBox-Error", false);
			}
		}
	}
	
	class wiringValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			
			if(Validator.isValidPercentage(doubleBoxWiring.getText()) == false)
			{
				doubleBoxWiring.setStyleName("gwt-TextBox-Error", true);
				doubleBoxWiring.setFocus(true);
			}
			else
			{
				doubleBoxWiring.setStyleName("gwt-TextBox-Error", false);
			}
		}
	}
	class lifeSpanValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			
			if(Validator.isValidNumber(integerBoxLifeSpan.getText()) == false)
			{
				integerBoxLifeSpan.setStyleName("gwt-TextBox-Error", true);
				integerBoxLifeSpan.setFocus(true);
			}
			else
			{
				integerBoxLifeSpan.setStyleName("gwt-TextBox-Error", false);
			}
		}
	}
	class powerCostValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			
			if(Validator.isValidCents(doubleBoxPowerCost.getText()) == false)
			{
				doubleBoxPowerCost.setStyleName("gwt-TextBox-Error", true);
				doubleBoxPowerCost.setFocus(true);
			}
			else
			{
				doubleBoxPowerCost.setStyleName("gwt-TextBox-Error", false);
			}
		}
	}
	class tarrifValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			
			if(Validator.isValidCents(doubleBoxTarrif.getText()) == false)
			{
				doubleBoxTarrif.setStyleName("gwt-TextBox-Error", true);
				doubleBoxTarrif.setFocus(true);
			}
			else
			{
				doubleBoxTarrif.setStyleName("gwt-TextBox-Error", false);
			}
		}
	}
	class replacePercentValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			
			if(Validator.isValidPercentage(doubleBoxReplacePercent.getText()) == false)
			{
				doubleBoxReplacePercent.setStyleName("gwt-TextBox-Error", true);
				doubleBoxReplacePercent.setFocus(true);
			}
			else
			{
				doubleBoxReplacePercent.setStyleName("gwt-TextBox-Error", false);
			}
		}
	}
	class ageLossValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			
			if(Validator.isValidPercentage(doubleBoxAgeLoss.getText()) == false)
			{
				doubleBoxAgeLoss.setStyleName("gwt-TextBox-Error", true);
				doubleBoxAgeLoss.setFocus(true);
			}
			else
			{
				doubleBoxAgeLoss.setStyleName("gwt-TextBox-Error", false);
			}
		}
	}
	class irradianceValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			
			if(Validator.isValidIrradiance(doubleBoxIrradiance.getText()) == false)
			{
				doubleBoxIrradiance.setStyleName("gwt-TextBox-Error", true);
				doubleBoxIrradiance.setFocus(true);
			}
			else
			{
				doubleBoxIrradiance.setStyleName("gwt-TextBox-Error", false);
			}
		}
	}
	
	class secondBankValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			String validFormat ="^([-+] ?)?[0-9]+(,[0-9]+)?$";
			if((Validator.isValidPercentage(txtSecondBank.getText()) == false) && (!txtSecondBank.getText().matches(validFormat)))
			{
				txtSecondBank.setStyleName("gwt-TextBox-Error", true);
				txtSecondBank.setFocus(true);
			}
			else
			{
				txtSecondBank.setStyleName("gwt-TextBox-Error", false);
			}
		}
	}
	
	class secondBankEfficiencyValidation implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			String validFormat ="^([-+] ?)?[0-9]+(,[0-9]+)?$";
			if((Validator.isValidPercentage(secondBankEfficiency.getText()) == false) && (!secondBankEfficiency.getText().matches(validFormat)) )
			{
				secondBankEfficiency.setStyleName("gwt-TextBox-Error", true);
				secondBankEfficiency.setFocus(true);
			}
			else
			{
				secondBankEfficiency.setStyleName("gwt-TextBox-Error", false);
			}
		}
	}
	
	public void getAngleDirectionEfficiency() {
		if(secondBank.getValue())
			service.getEfficiencyForAngleAndDirection(roofDirectioncomboBox2.getSelectedIndex(), angleComboBox2.getSelectedIndex(), new AsyncCallback<Double>(){

				@Override
				public void onFailure(Throwable caught) {
					Window.alert(caught.getMessage());	
					
				}

				@Override
				public void onSuccess(Double result) {
					
					secondBankEfficiency.setText(result.toString());
				}
				
			});
		
		service.getEfficiencyForAngleAndDirection(roofDirectioncomboBox.getSelectedIndex(), angleComboBox.getSelectedIndex(), new AsyncCallback<Double>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());	
				
			}

			@Override
			public void onSuccess(Double result) {
				
				efficiencyForDirectionAndAngle.setText(result.toString());
			}
			
		});
		
	}
	private void getCityValues() {	
	//		 final double solarIrradiance;
		int selectedIndex = cityComboBox.getSelectedIndex();
		service.getCity(selectedIndex,new AsyncCallback<City>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());		

			}
			@Override
			public void onSuccess(City city) {
				 doubleBoxIrradiance.setValue(city.getAvgIrradiance());
				 doubleBoxTarrif.setValue(city.getFeedInTariff());
				 doubleBoxPowerCost.setValue(city.getElectricityCost());
				 dailyIrradianceInMonth = city.getMonthsIrradiance();
				 avgProducePerkw = city.getAvgProduePerkw();
				 zoneRating = city.getZoneRating();
				 optimaYearRoundAngle = city.getOptimalYearDegree();
				 bestWinterAngle = city.getBestWinterDegree();
				 bestSummerAngle = city.getBestSummerDegree();
				 txtPostcode.setText(Integer.toString(city.getPostcode()));
				 // TODO OPTIMAL DEGRESS
				 txtOptimalYearAngle.setText(Double.toString(city.getOptimalYearDegree()));
				 txtOptimalSummerAngle.setText(Double.toString(city.getBestSummerDegree()));
				 txtOptimalWinterAngle.setText(Double.toString(city.getBestWinterDegree()));
			}			
		});	
	}

	

	private void loadAllUIControls() {

		txtWhatYear.setText("0");

		rdbtnMedium.setValue(true);
		txtHouseholdSize.setValue(0);

		btnCalculation.setText("Calculate");
      
		txtDailySavings.setText("0");
		txtPayBackYear.setText("");
		
		btnCalculation.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String onlyNumber = "^[0-9]+$";
				if((txtPostcode.getStyleName().equals("gwt-TextBox gwt-TextBox-Error")) || (doubleBoxSize.getStyleName().equals("gwt-TextBox-Error")) || (systemCostBox.getStyleName().equals("gwt-TextBox-Error")) || (efficiencyForDirectionAndAngle.getStyleName().equals("gwt-DoubleBox-assumptions gwt-TextBox-Error")) || (inverterBox.getStyleName().equals("gwt-DoubleBox-assumptions gwt-TextBox-Error")) || (doubleBoxWiring.getStyleName().equals("gwt-DoubleBox-assumptions gwt-TextBox-Error"))|| (integerBoxLifeSpan.getStyleName().equals("gwt-DoubleBox-assumptions gwt-TextBox-Error")) || (doubleBoxPowerCost.getStyleName().equals("gwt-DoubleBox-assumptions gwt-TextBox-Error")) || (doubleBoxTarrif.getStyleName().equals("gwt-DoubleBox-assumptions gwt-TextBox-Error")) || (doubleBoxReplacePercent.getStyleName().equals("gwt-DoubleBox-assumptions gwt-TextBox-Error")) || (doubleBoxAgeLoss.getStyleName().equals("gwt-DoubleBox-assumptions gwt-TextBox-Error")) || (doubleBoxIrradiance.getStyleName().equals("gwt-DoubleBox-assumptions gwt-TextBox-Error")) || (txtSecondBank.getStyleName().equals("gwt-DoubleBox-assumptions gwt-TextBox-Error")) || (secondBankEfficiency.getStyleName().equals("gwt-DoubleBox-assumptions gwt-TextBox-Error")))
				{
					Window.alert("Please check your input");
					return;
				}
				else if (!txtHouseholdSize.getText().matches(onlyNumber) )
				{
					Window.alert("Please check household input size");
					return;
				}
				doCalculation();
				getSimilarSystemProduct();
				getTotalSubsidy();
				
			}
		});
		RootPanel.get("tdDailySolarGenerationCalculate").add(btnCalculation);
		RootPanel.get("tdDailySolarGenerationResult").add(txtDailySolarGeneration);		

		RootPanel.get("tdDailySavingsResult").add(txtDailySavings);		
		RootPanel.get("tdPowerEstimateResult").add(txtPowerEstimate);		
		RootPanel.get("tdHouseholdSize").add(txtHouseholdSize);		
		RootPanel.get("tdUsageType").add(rdbtnHeavy);
		RootPanel.get("tdUsageType").add(rdbtnMedium);
		RootPanel.get("tdUsageType").add(rdbtnLight);
		RootPanel.get("tdPayBackYearResult").add(txtPayBackYear);
		RootPanel.get("tdSimilarSystem").add(txtSimilarSystem);
		RootPanel.get("tdTotalSubsidy").add(txtTotalSubsidy);
		RootPanel.get("tdOptimalYearAngle").add(txtOptimalYearAngle);
		RootPanel.get("tdSummerAngle").add(txtOptimalSummerAngle);
		//RootPanel.get("tdSeasonAngle").add("<br/>");
		RootPanel.get("tdWinterAngle").add(txtOptimalWinterAngle);
		txtPayBackYear.setSize("151", "26");
		loadWorthInvesting();
	}

	protected void getTotalSubsidy() {
		
		if(zoneRating ==0){
			txtTotalSubsidy.setText("no data in "+getSelectedCity());
		}
		else
		{
			service.doTotalSubsidy(zoneRating, new AsyncCallback<Double>(){

				@Override
				public void onFailure(Throwable caught) {
					Window.alert(caught.getMessage());	
					
				}

				@Override
				public void onSuccess(Double totalSubsidy) {
					txtTotalSubsidy.setText(totalSubsidy.toString()+" dollars in "+getSelectedCity());
					
				}
				
			});
		}
		
	}

	private String getSelectedCity() {
		int selectedIndex = cityComboBox.getSelectedIndex();
		return cityComboBox.getItemText(selectedIndex);
	}

	protected void getSimilarSystemProduct() {
		if(avgProducePerkw ==0)
			txtSimilarSystem.setText("No data in "+getSelectedCity());
		else
		{	double production = doubleBoxSize.getValue()/1000 *avgProducePerkw;
			double twoDecimalResult = Math.round(production*100.00)/100.00;
			
			txtSimilarSystem.setText(Double.toString(twoDecimalResult)+" kws in "+getSelectedCity());
		}
		
	}

	/*track user's location and load google map using obtained latitude and longitude*/
	private void loadUserLocationOnMap() {
		if (!Geolocation.isSupported()) {
			Window.alert("Obtaining Geolocation FAILED! Geolocation API is not supported.");
        }

		final Geolocation geo = Geolocation.getGeolocation();

	    if (geo == null) {
	      Window.alert("Obtaining Geolocation FAILED!");
	      loadCityList(defaultAddress);//if use decline ip tracking,use default address
	      return;
	    }
	    geo.getCurrentPosition(new PositionCallback() {
	        public void onFailure(PositionError error) {
	          String message = "";
	          switch (error.getCode()) {
	            case PositionError.UNKNOWN_ERROR:
	              message = "Unknown Error";
	              break;
	            case PositionError.PERMISSION_DENIED:
	              message = "Permission Denied";
	              break;
	            case PositionError.POSITION_UNAVAILABLE:
	              message = "Position Unavailable";
	              break;
	            case PositionError.TIMEOUT:
	              message = "Time-out";
	              break;
	            default:
	              message = "Unknown error code.";
	          }
	          Window.alert("Obtaining position FAILED! Message: '"
		              + error.getMessage() + "', code: " + error.getCode() + " ("
		              + message + ")");
	          loadMap(32.3456,141.4346);//load map using default Australia latitude and longtitude
	          loadCityList(defaultAddress);//use default address
	        }      
			@Override
			public void onSuccess(
					Position position) {
		          Coordinates c = position.getCoords();

		          loadMap(c.getLatitude(),c.getLongitude());//load map use detected ip address's latititude and longitude 	
		          String latLng = c.getLatitude()+","+c.getLongitude();
                  service.getAddress(latLng, new AsyncCallback<String>() {
                	  
                          public void onFailure(Throwable arg0) {
                                  txtBoxAddressInput.setText("Address not found");
                          }
                          public void onSuccess(String fullAddress) {
                                 txtBoxAddressInput.setText(fullAddress);
                                 loadCityList(fullAddress);                                
                         }

						});		          		          
			}
	      }, PositionOptions.getPositionOptions(true, 15000, 30000));	   	  
	}
	private void loadCityList(String fullAddress) {
		int postcode = 4000;//initilise to brisbane city postcode
		if(Validator.isValidPostcode(getPostCode(fullAddress)))
		postcode = Integer.parseInt(getPostCode(fullAddress));//if valid use the input postcode
		txtPostcode.setText(Integer.toString(postcode));
		service.getCityList(postcode, new AsyncCallback<String[]>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());				
			}
			@Override
			public void onSuccess(String[] result) {
				for(String city:result){
					cityComboBox.addItem(city);
				}
					service.getCityIndex(new AsyncCallback<Integer>(){
						@Override
						public void onFailure(Throwable caught) {
							Window.alert(caught.getMessage());							
						}

						@Override
						public void onSuccess(Integer result) {							
							cityComboBox.setSelectedIndex(result);
							getCityValues();//set all the values based on city	
						}						
					});
				}				

		});


	}
	
	/*get postcode from a complete address such as 217 George St, Brisbane QLD 4000, Australia*/
	private String getPostCode(String fullAddress) {
		String addressString [] = fullAddress.split(",");
		String cityPart = addressString[1];
		char postcode []= cityPart.toCharArray();
		StringBuffer buffer = new StringBuffer();
		for(int i = postcode.length -5; i<postcode.length ;i++){
			buffer.append(postcode[i]);
		}
	
		return buffer.toString().trim();
	}
	
	/* WorthInvestment method */
	private void loadWorthInvesting() {
		txtDailySavings2.setText("25");
		txtPayBackYear2.setText("5y 6m");
		txtExpectedDuration.setText("25y 6m");
		btnWorthInvesting.setText("Worth it?");
		lblWorthText.setText("");
		lblWorthInvesting.setText("");
		lblBankInterest.setText("5");

		btnWorthInvesting.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			    final String dailySavings = txtDailySavings2.getText().toUpperCase().trim();
			    txtDailySavings2.setFocus(true);
			    txtPayBackYear2.setFocus(true);
			    txtExpectedDuration.setFocus(true);
			    String onlyNumber = "^[0-9]{1,2}([,.][0-9]{1,2})?$";
			    if (!dailySavings.matches(onlyNumber))
			    {
				    Window.alert("'" + dailySavings + "' is not a valid symbol.");
				    txtDailySavings2.selectAll();
				    return;
			    }
			    else if(!lblBankInterest.getText().matches(onlyNumber))
			    {
				    Window.alert("'" + lblBankInterest.getText() + "' is not a valid symbol.");
				    txtDailySavings2.selectAll();
				    return;
			    }
			    else
			    {
			    	getWorthInvestmentFromServer();
			    }
			}
		});

		RootPanel.get("tdDailySaved").add(txtDailySavings2);
		RootPanel.get("tdFinalPayback").add(txtPayBackYear2);
		RootPanel.get("tdExpectedDuration").add(txtExpectedDuration);
		RootPanel.get("tdWorthInvestingCalculate").add(btnWorthInvesting);
		RootPanel.get("tdWorthInvestingResultLabel").add(lblWorthText);
		RootPanel.get("tdWorthInvestingResult").add(lblWorthInvesting);
		RootPanel.get("tdBankInterest").add(lblBankInterest);
	}
	
	protected void getWorthInvestmentValues() {
		
		txtPayBackYear2.setText(txtPayBackYear.getValue()); // Need to parse...
	}

	/* Send "worth investing" to the server */
	protected void getWorthInvestmentFromServer() {
		CalculationServiceAsync service = (CalculationServiceAsync) GWT.create(CalculationService.class);
        ServiceDefTarget serviceDef = (ServiceDefTarget) service;
        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
            + "calculationService");
        WorthInvestingCallback callback = new WorthInvestingCallback(lblWorthInvesting, lblWorthText);
        service.doWorthInvestment(txtDailySavings2.getValue(), Validator.parseYears(txtPayBackYear2.getText()), 
        		Validator.parseYears(txtExpectedDuration.getText()), lblBankInterest.getValue()/100, callback);
	}

	/* The main calculation */
	protected void doCalculation() {
		double firstBankPercent = 1;
		 
		if(secondBank.getValue())
		{	double secondBankPercent = Double.parseDouble(txtSecondBank.getValue())/100;
			firstBankPercent = 1- secondBankPercent ;
			
			 service.doDailySolarGeneration(doubleBoxSize.getValue()*secondBankPercent, Double.parseDouble(secondBankEfficiency.getText()), inverterBox.getValue(), 
		        		doubleBoxWiring.getValue(), txtWhatYear.getValue(), doubleBoxAgeLoss.getValue(), 
		        		doubleBoxIrradiance.getValue(), new AsyncCallback<Double>() {
					public void onFailure(Throwable caught) {				
						Window.alert(caught.getMessage());				
					}

					public void onSuccess(Double result) {
						 secondBankGeneration = result;
					}});
			
		}
        // calculate the generation for all months
        service.doSolarGenerationForAllMonths(dailyIrradianceInMonth,doubleBoxSize.getValue(), efficiencyForDirectionAndAngle.getValue(), 
        		inverterBox.getValue(), doubleBoxWiring.getValue(), txtWhatYear.getValue(), doubleBoxAgeLoss.getValue(), 
        		new AsyncCallback<double[]>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(double[] result) {
				chart.draw(createMonthGenerationTable(result),createOptions());//draw column chart


			}});

        // calculate the daily generation,  
        service.doDailySolarGeneration(doubleBoxSize.getValue()*firstBankPercent, efficiencyForDirectionAndAngle.getValue(), inverterBox.getValue(), 
        		doubleBoxWiring.getValue(), txtWhatYear.getValue(), doubleBoxAgeLoss.getValue(), 
        		doubleBoxIrradiance.getValue(), new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Double result) {
				double dailyGeneration = secondBankGeneration +result;
				txtDailySolarGeneration.setText(Double.toString(dailyGeneration)+" kws");
				getDailySaving(dailyGeneration);//use dailyCalculation result for dailySavingCalculation
				getPaybackTime(dailyGeneration);
			}});
        
        //calculate power consumption
        service.doPowerConsumption(txtHouseholdSize.getValue(), getUsageSelection(), new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Double result) {
				txtPowerEstimate.setText(result.toString() +" kws");				
			}});
        
	}

	protected void getPaybackTime(Double result) {
		service.getPayBackTime(systemCostBox.getValue(), integerBoxLifeSpan.getValue(), doubleBoxReplacePercent.getValue(), 
				doubleBoxTarrif.getValue(), doubleBoxPowerCost.getValue(), result, doubleBoxAgeLoss.getValue(),
				integerBoxpaybackYear.getValue(), new AsyncCallback<TreeMap<Double,String>>() {
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());		
					}
					@Override
					public void onSuccess(TreeMap<Double, String> result) {
						calculatePayback(result);
						lineChart.draw(createPayBackTable(result),createLineChartOptions());

					}
		});

	}
	protected  void calculatePayback(TreeMap<Double, String> result) {

		for (Entry<Double, String> entry : result.entrySet()) {
        	if (entry.getKey() >0){
        		
        		txtPayBackYear.setText(entry.getValue());
        		return;
        	}
       			
        }
		 txtPayBackYear.setText("cannot pay back");
	}
	private String getUsageSelection() {
		if (rdbtnHeavy.getValue())
			return "Heavy";
		else if(rdbtnLight.getValue())
			return "Light";
		else return "Medium";	
	}

	/*	Calculate Daily savings */
	private void getDailySaving( double dailyGeneration){
 		   service.doDailySavings(dailyGeneration, doubleBoxReplacePercent.getValue(), doubleBoxTarrif.getValue(), 
 				   doubleBoxPowerCost.getValue(), new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Double result) {
				txtDailySavings.setText(result.toString() + " dollars");

			}});			

	}
	
	/* use to add pop msg to explain stuff */
	class PopMessage implements MouseOverHandler,MouseOutHandler {
		// Create a basic popup widget
		 PopupPanel simplePopup ;
		public PopMessage(String whatMsg) {
			simplePopup = new PopupPanel(true);
			simplePopup.addStyleName("gwt-PopupPanel");
		    simplePopup.ensureDebugId("cwBasicPopup-simplePopup");
		    simplePopup.setWidth("150px");
		    simplePopup.setWidget(
		        new HTML(whatMsg));
		}
		@Override
		public void onMouseOver(MouseOverEvent event) {
			// Reposition the popup relative to the button
			Widget source = (Widget) event.getSource();
            int left = source.getAbsoluteLeft() + 10;
            int top = source.getAbsoluteTop() +20;
            simplePopup.setPopupPosition(left, top);
            // Show the popup
            simplePopup.show();			
		}	
		@Override
		public void onMouseOut(MouseOutEvent event) {
			// hide it 
			simplePopup.hide();			
		}		
	}

	/* use gwt char api to create column chart*/
	 void createColumnChart(final double monthResults[]){
	        Runnable onLoadCallback = new Runnable() {
	          public void run() {
	            Panel panel = RootPanel.get("idMonthSolarGenerationResults");
	            
	            // Create a column chart visualization.	           
	            chart = new ColumnChart(createMonthGenerationTable(monthResults), createOptions());
	            //to do chart.addSelectHandler(createSelectHandler(chart));	           
	            panel.add(chart);
	          }
	        };

	        // Load the visualization api, passing the onLoadCallback to be called
	        // when loading is done.
	        VisualizationUtils.loadVisualizationApi(onLoadCallback, ColumnChart.PACKAGE);
	 }

	 /*create line chart for payback time*/
	 private void createLineChart(final TreeMap<Double,String> paybackResults){
		 Runnable onLoadCallback = new Runnable() {
	          public void run() {
	            Panel panel = RootPanel.get("idPayBackYearLineGraph");

	            // Create a column chart visualization.	           
	            lineChart = new LineChart(createPayBackTable(paybackResults),createLineChartOptions());
	           //to do chart.addSelectHandler(createSelectHandler(chart));

	            panel.add(lineChart);

	          }
	        };

	        // Load the visualization api, passing the onLoadCallback to be called
	        // when loading is done.
	        VisualizationUtils.loadVisualizationApi(onLoadCallback, LineChart.PACKAGE);
	 }
	 /*create options for payback linechart*/
	protected com.google.gwt.visualization.client.visualizations.LineChart.Options createLineChartOptions() {
		 com.google.gwt.visualization.client.visualizations.LineChart.Options options = LineChart.Options.create();
		   options.setWidth(600);
		    options.setHeight(240);    
		    options.setTitle("Payback years");		    
		    options.setMin(systemCostBox.getValue()*-1);

		return options;
	}

/*data table used for payback line chart*/
	protected AbstractDataTable createPayBackTable(
			TreeMap<Double, String> paybackResults) {
		 DataTable data = DataTable.create();
		 data.addColumn(ColumnType.STRING,"Time");
		 data.addColumn(ColumnType.NUMBER, "money");
		 if(paybackResults==null){
			 data.addRows(integerBoxpaybackYear.getValue());
			for(int i = 0; i<integerBoxpaybackYear.getValue();i++){
				data.setValue(i, 0, Integer.toString(i));
				data.setValue(i, 1, 0);			
			}
		 }
		 else{
		 data.addRows(paybackResults.size());	 
			 int i = 0;
			for(Entry<Double, String> entry :paybackResults.entrySet()){
				data.setValue(i, 0, entry.getValue());
				data.setValue(i, 1, entry.getKey());
				i++;
			}
		 }
		return data;
	}


	/*use to populate month generation table for Column chart*/	
	private AbstractDataTable createMonthGenerationTable(double monthResults[]) {
	    DataTable data = DataTable.create();
	    data.addColumn(ColumnType.STRING, "Month");
	    data.addColumn(ColumnType.NUMBER, "kwh");
	    String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

	    data.addRows(months.length);

	    for(int i = 0; i<months.length;i++){
	    	data.setValue(i, 0, months[i].toString());
	    	if(monthResults==null)
	    		data.setValue(i, 1, 0);
	    	else
	    	data.setValue(i, 1, monthResults[i]);
	    }
	    return data;

}
	/*column create options*/
	private Options createOptions() {
	    Options options = ColumnChart.Options.create();
	    options.setWidth(600);
	    options.setHeight(240);
	    options.set3D(true);
	    options.setTitle("kwh Generation per month");
	    options.setStacked(true);
	    options.setMin(0);
	    options.setEnableTooltip(true);
	    return options;
	  }
	
	
	private void getProductValues() {	
		//		 final double solarIrradiance;
			service.getProduct(new AsyncCallback<Product>(){

				@Override
				public void onFailure(Throwable caught) {
					Window.alert(caught.getMessage());		

				}
				
				@Override
				public void onSuccess(Product result) {
					// TODO Auto-generated method stub
					
				}			
			});	
		}
	
	 private void createTable(){
		 Runnable onLoadCallback = new Runnable() {
	          public void run() {
	        	
	            Panel panel = RootPanel.get("idPanelTable");
	                    
	            // Create a table visualization.	           
	            Table table= new Table(createTableData(),createTableOptions());
	            panel.add(table);
	          }
	        };

	        // Load the visualization api, passing the onLoadCallback to be called
	        // when loading is done.
	        VisualizationUtils.loadVisualizationApi(onLoadCallback, Table.PACKAGE);

	 }
	 
	 /* dataset for solar panels need to be refactored by using datastore data*/
		protected AbstractDataTable createTableData() {
			
			DataTable data = DataTable.create();
			
			data.addColumn(ColumnType.STRING, "Type");
			data.addColumn(ColumnType.STRING, "Brand");
			data.addColumn(ColumnType.STRING, "Descriptions");
			data.addColumn(ColumnType.NUMBER, "Power");
			data.addColumn(ColumnType.NUMBER, "Efficiency");
			data.addColumn(ColumnType.NUMBER, "Price($)");
			
			data.addRows(10);
			data.setValue(0, 0, "Inverters");
			data.setValue(0, 1, "Aurora");		
			data.setValue(0, 2, "PVI-4.2-AU Outdoor Grid Connect IP65 rated");		
			data.setValue(0, 3, 4200);		
			data.setValue(0, 4, 0.96);		
			data.setValue(0, 5, 2370);
			
			data.setValue(1, 0, "Inverters");
			data.setValue(1, 1, "Aurora");		
			data.setValue(1, 2, "PVI-3.6-AU Outdoor Grid Connect IIP65 rated");		
			data.setValue(1, 3, 3600);		
			data.setValue(1, 4, 0.97);		
			data.setValue(1, 5, 1980);
			
			data.setValue(2, 0, "Solar panels");
			data.setValue(2, 1, "SolarOne");		
			data.setValue(2, 2, "24V, 5 inch cell Monocrystalline Cell Solar Module");		
			data.setValue(2, 3, 195);		
			data.setValue(2, 4, 0.1512);
			data.setValue(2, 5, 418);	
			
			data.setValue(3, 0, "Inverters");
			data.setValue(3, 1, "Fronius");		
			data.setValue(3, 2, "IG TL 3.0 Indoor and Outdoor -");		
			data.setValue(3, 3, 3313);		
			data.setValue(3, 4, 0.98);
			data.setValue(3, 5, 2046);
			
			data.setValue(4, 0, "Inverters");
			data.setValue(4, 1, "Aurora");		
			data.setValue(4, 2, "PVI-2000-AU Outdoor Grid Connect IP65 rated");		
			data.setValue(4, 3, 2000);		
			data.setValue(4, 4, 0.96);
			data.setValue(4, 5, 1174);
			
			data.setValue(5, 0, "Solar panels");
			data.setValue(5, 1, "REC Solar");		
			data.setValue(5, 2, "Peak Energy Series, polycrystalline cell Black Frame");		
			data.setValue(5, 3, 250);		
			data.setValue(5, 4, 0.151);
			data.setValue(5, 5, 412);
			
			data.setValue(6, 0, "Inverters");
			data.setValue(6, 1, "Fronius");		
			data.setValue(6, 2, "IG15 Outdoor - Grid Connect");		
			data.setValue(6, 3, 1500);		
			data.setValue(6, 4, 0.94);
			data.setValue(6, 5, 1575);
			
			data.setValue(7, 0, "Solar panels");
			data.setValue(7, 1, "Sharp");		
			data.setValue(7, 2, "12V Polycrystalline");		
			data.setValue(7, 3, 130);		
			data.setValue(7, 4, 0.1599);
			data.setValue(7, 5, 554);
			
			data.setValue(8, 0, "Solar panels");
			data.setValue(8, 1, "Panasonic");		
			data.setValue(8, 2, "HIT Solar Module");		
			data.setValue(8, 3, 235);		
			data.setValue(8, 4, 0.186);
			data.setValue(8, 5, 882);
			
			data.setValue(9, 0, "Solar panels");
			data.setValue(9, 1, "Suntech");		
			data.setValue(9, 2, "HIT Solar Module");		
			data.setValue(9, 3, 140);		
			data.setValue(9, 4, 0.151);
			data.setValue(9, 5, 421);
			

			return data;
		} 

	 
	/*create tables options for both inverter and solar panels tables*/
	protected com.google.gwt.visualization.client.visualizations.Table.Options createTableOptions() {
		com.google.gwt.visualization.client.visualizations.Table.Options options = Table.Options.create();


		return options;
	}



	/*load the map*/
	private void loadMap(final double latitude,final double longitude){
		 /*
		    * Asynchronously loads the Maps API.
		    *
		    * The first parameter should be a valid Maps API Key to deploy this
		    * application on a public server, but a blank key will work for an
		    * application served from localhost.
		   */
		Maps.loadMapsApi("AIzaSyDJms88qiHMw8AA3qNZaxVCXyV9r59LVJk", "2", false, new Runnable() {
		      public void run() {
		        buildUi(latitude,longitude);
		      }
		    });
	}
	/*build map ui*/
	private void buildUi(double latitude,double longitude) {
	    // Open a map centered in Australia
	    LatLng australia = LatLng.newInstance(latitude, longitude);	   
	     map = new MapWidget(australia,15);
	    MapType mapType = MapType.getSatelliteMap();
	    map.addMapType(mapType);	    
	    map.setSize("100%", "100%");
	    // Add some controls for the zoom level	 
	    map.setWidth("600pt");
	    map.setHeight("240pt");	
	     
	    map.setCurrentMapType(MapType.getNormalMap());
	    map.addControl(new LargeMapControl());
	 // Add some type controls for the different map types
	    map.addControl(new MapTypeControl());
	    map.setCenter(australia);
	    final DockLayoutPanel dock = new DockLayoutPanel(Unit.PX);
	    dock.addNorth(map,400);
	    // Add the map to the HTML host page
	    RootPanel.get("tdMap").add(dock); 
	  }

}
