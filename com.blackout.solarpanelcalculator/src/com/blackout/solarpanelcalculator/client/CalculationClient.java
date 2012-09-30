package com.blackout.solarpanelcalculator.client;
import java.util.Map.Entry;
import java.util.TreeMap;



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
import com.google.gwt.maps.client.MapOptions;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CalculationClient implements EntryPoint {
	
	private double defaultIrradiance = 5.1;
	private double defaultFeedInTariff = 44;
	String cityName = "Sydney";
	MapWidget map = null ;
	private double[] monthResults = null;
	private ColumnChart chart;//for monthly results chart
	private LineChart lineChart;//for payback time line chart
	private TreeMap<Double,String> payBackTime = null;	
	private Label lblAddressInput = new Label();
	private TextBox txtBoxAddressInput = new TextBox();
	private Button btnAddressInput = new Button();
	private Label lblNotFound = new Label();
	private Label lblmonthsResultstext = new Label();
	private ListBox citycomboBox = new ListBox();	
	private ListBox roofDirectioncomboBox = new ListBox();		
	private DoubleBox systemCostBox = new DoubleBox();		
	private DoubleBox doubleBoxSize = new DoubleBox();	
	private DoubleBox roofLossBox = new DoubleBox();	              
    private DoubleBox inverterBox = new DoubleBox();    
    private DoubleBox doubleBoxWiring = new DoubleBox();   
    private IntegerBox integerBoxLifeSpan = new IntegerBox();    
    private DoubleBox doubleBoxPowerCost = new DoubleBox();  
    private DoubleBox doubleBoxTarrif = new DoubleBox();    
    private DoubleBox doubleBoxReplacePercent = new DoubleBox();	
	private DoubleBox doubleBoxAgeLoss = new DoubleBox();
	private DoubleBox doubleBoxIrradiance = new DoubleBox();
	private IntegerBox integerBoxpaybackYear = new IntegerBox();
	private DoubleBox txtWhatYear = new DoubleBox();
	private DoubleBox txtDailySolarGeneration = new DoubleBox();
	private Button btnCalculation = new Button();	
	private DoubleBox txtDailySavings = new DoubleBox();	
	private DoubleBox txtPayBackYear = new DoubleBox();
    private DoubleBox txtPowerEstimate = new DoubleBox();
    private IntegerBox txtHouseholdSize = new IntegerBox();
    private RadioButton rdbtnHeavy = new RadioButton("usage", "Heavy");
    private RadioButton rdbtnMedium = new RadioButton("usage", "Medium");
    private RadioButton rdbtnLight = new RadioButton("usage", "Light");    
    
    /* vv Court's WorthInvestment items vv */
    private DoubleBox txtDailySavings2 = new DoubleBox();
    private DoubleBox txtPayBackYear2 = new DoubleBox();
    private DoubleBox txtExpectedDuration = new DoubleBox();
    private Button btnWorthInvesting = new Button();
    private DoubleBox lblWorthInvesting = new DoubleBox();
    /* ^^ Court's WorthInvestment items ^^ */
    
	private CalculationServiceAsync service; 
	
	

	public void onModuleLoad() {
		 RootPanel.get("tdMainPanel").add(loadAllControlsNew());
		 
		
		service= (CalculationServiceAsync) GWT.create(CalculationService.class);

       
		
		loadAllUIControls();
        createColumnChart(monthResults);//load months results charts
        createLineChart(payBackTime);
        
        loadUserLocationOnMap();	//commented out 
        createTable();
	}

private Widget loadAllControlsNew() {
		
//		pop up message
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
		/*add address labels, box */
		VerticalPanel verticalpanel = new VerticalPanel();
		HorizontalPanel addressPanel = new HorizontalPanel();
		addressPanel.add(lblAddressInput);
		
		HorizontalPanel addressPanel2 = new HorizontalPanel();
		txtBoxAddressInput.setWidth("280px");
		addressPanel2.add(txtBoxAddressInput);
		
		addressPanel2.add(lblNotFound);
		verticalpanel.add(addressPanel);
		verticalpanel.add(addressPanel2);
		verticalpanel.add(btnAddressInput);
		RootPanel.get("idAddressInput").add(verticalpanel);
		
//		set boxes to their default values
		 systemCostBox.setText("18000");	
		 doubleBoxSize.setText("4950");	
		 roofLossBox.setText("88.5"); 
	     inverterBox.setText("96") ;
	     doubleBoxWiring.setText("98");   
	     integerBoxLifeSpan.setText("25");     
	     doubleBoxPowerCost.setText("19.41");
	     doubleBoxTarrif.setValue(defaultFeedInTariff);  
	     doubleBoxReplacePercent.setText("24"); 
		 doubleBoxAgeLoss.setText("0.7"); 
		 doubleBoxIrradiance.setValue(defaultIrradiance); //get irradiance from database based on city selection
		 integerBoxpaybackYear.setValue(25);
		
//		create labels
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
		Label roofLossLbl = new Label("The efficiency loss due to angles and directions is(%):");
		Label lblSystemSize = new Label("Your solar system size (watts):");
		Label systemCostLbl = new Label("Your overall purchase cost(dollars):");
		systemCostLbl.addMouseOverHandler(overallCostHelpMsg);
		systemCostLbl.addMouseOutHandler(overallCostHelpMsg);
		Label roofFaceLbl = new Label("Select your roof direction:");
		Label cityLbl = new Label("Select your city:");	 
		
//		 combobox selections
		citycomboBox.addItem("Select City....");
		citycomboBox.addItem("Sydney");
		citycomboBox.addItem("Melbourne");
		citycomboBox.addItem("Brisbane");
		citycomboBox.addItem("Perth");
		citycomboBox.addItem("Adelaide");
		citycomboBox.addItem("Gold Coast");
		citycomboBox.addItem("Newcastle");
		citycomboBox.addItem("Canberra");
		citycomboBox.addItem("Wollongong");
		citycomboBox.addItem("Sunshine Coast");
		citycomboBox.addItem("Hobart");
		citycomboBox.addItem("Geelong");
		citycomboBox.addItem("Townsville");
		citycomboBox.addItem("Cairns");
		citycomboBox.addItem("Toowoomba");
		citycomboBox.addItem("Darwin");
		citycomboBox.addChangeHandler(new ChangeHandler(){

			@Override
			public void onChange(ChangeEvent event) {
				
				getCityValues();
				
			}
			
		});
	
//	root combobox selections
		roofDirectioncomboBox.addItem("Select panel direction...");
		roofDirectioncomboBox.addItem("Facing directly South");
		roofDirectioncomboBox.addItem("South South West(22.5 degrees from South)");
		roofDirectioncomboBox.addItem("South West(45 degrees from South)");
		roofDirectioncomboBox.addItem("West South West(67.5 degrees from South)");
		roofDirectioncomboBox.addItem("Facing directly West");
		roofDirectioncomboBox.addItem("South South East(22.5 degrees from South)");
		roofDirectioncomboBox.addItem("South East(45 degrees from South)");
		roofDirectioncomboBox.addItem("East South East(67.5 degrees from South)");
		roofDirectioncomboBox.addItem("Facing directly East");
		
	
		doubleBoxSize.setWidth("106px");
	    // Create a table to layout the form options
	    FlexTable layout = new FlexTable();
	    layout.setCellSpacing(2);
	    layout.setWidth("364px");

//	    add widgets to flextable
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
	    layout.setWidget(1, 0, cityLbl);
	    layout.setWidget(1, 1,citycomboBox);
	    citycomboBox.setWidth("122px");
	    layout.setWidget(2, 0, roofFaceLbl);
	    layout.setWidget(2, 1, roofDirectioncomboBox);
	    roofDirectioncomboBox.setWidth("123px");
	    layout.setWidget(3, 0, lblSystemSize);
	    layout.setWidget(3, 1, doubleBoxSize);
	    systemCostBox.setWidth("106px");
	    layout.setWidget(4, 0, systemCostLbl);
	    layout.setWidget(4, 1, systemCostBox);
	    
//	   set styles to labels and boxes
	    roofLossLbl.setStyleName("gwt-Label-assumptions"); 	   
	    roofLossBox.setStyleName("gwt-DoubleBox-assumptions");   
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
	    
//		all the horizontalPanels host each label and doublebox in disclosure panel
	    HorizontalPanel horizontalPanel = new HorizontalPanel();
	    HorizontalPanel horizontalPanel1 = new HorizontalPanel();
	    HorizontalPanel horizontalPanel2 = new HorizontalPanel();
	    HorizontalPanel horizontalPanel3 = new HorizontalPanel();	    
	    HorizontalPanel horizontalPanel4 = new HorizontalPanel();
	    HorizontalPanel horizontalPanel5 = new HorizontalPanel();
	    HorizontalPanel horizontalPanel6 = new HorizontalPanel();
	    HorizontalPanel horizontalPanel7 = new HorizontalPanel();
	    HorizontalPanel horizontalPanel8 = new HorizontalPanel();	    
	    horizontalPanel.add(roofLossLbl);
	    horizontalPanel.add(roofLossBox);
	    horizontalPanel1.add(inverterLbl);
	    horizontalPanel1.add(inverterBox);	    
	    horizontalPanel2.add(lblWiring);
	    horizontalPanel2.add(doubleBoxWiring);
	    horizontalPanel3.add(lblLifeSpan);
	    horizontalPanel3.add(integerBoxLifeSpan);
	    horizontalPanel4.add(lblPowerCost);
	    horizontalPanel4.add(doubleBoxPowerCost);
	    horizontalPanel5.add(lblTarrif);
	    horizontalPanel5.add(doubleBoxTarrif);
	    horizontalPanel6.add(lblAssumeUseAtHome);
	    horizontalPanel6.add(doubleBoxReplacePercent);
	    horizontalPanel7.add(lblAssumeSolarPanel);
	    horizontalPanel7.add(doubleBoxAgeLoss);
	    horizontalPanel8.add(lblAssumeSolarIrradiance);
	    horizontalPanel8.add(doubleBoxIrradiance);    
	    VerticalPanel verticalPanel = new VerticalPanel();
	    verticalPanel.add(horizontalPanel);
	    verticalPanel.add(horizontalPanel1);
	    verticalPanel.add(horizontalPanel2);
	    verticalPanel.add(horizontalPanel3);
	    verticalPanel.add(horizontalPanel4);
	    verticalPanel.add(horizontalPanel5);
	    verticalPanel.add(horizontalPanel6);
	    verticalPanel.add(horizontalPanel7);
	    verticalPanel.add(horizontalPanel8);    
	    
	    // Add advanced options to form in a disclosure panel
	    DisclosurePanel advancedDisclosure = new DisclosurePanel(
	        "Our assumptions");
	    advancedDisclosure.setContent(verticalPanel);
	    advancedDisclosure.setOpen(false);
	    advancedDisclosure.setAnimationEnabled(false);   
	    layout.setWidget(5, 0, advancedDisclosure);
	    advancedDisclosure.setWidth("358px");
	    cellFormatter.setColSpan(5, 0, 2);
	 // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidget(layout);
	    return decPanel;
	  }

	private void getCityValues() {
		int selectedIndex = 0;
	
//		 final double solarIrradiance;
		selectedIndex = citycomboBox.getSelectedIndex();
		if(selectedIndex ==0){
			doubleBoxIrradiance.setValue(defaultIrradiance);//default value
			doubleBoxTarrif.setValue(defaultFeedInTariff);
			return;
		}
		cityName = citycomboBox.getItemText(selectedIndex);
		service.getSolarIrradiance(cityName,new AsyncCallback<Double>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());		
				
			}

			@Override
			public void onSuccess(Double result) {
				 doubleBoxIrradiance.setValue(result);
				
			}
			
		});
		
		service.getFeedInTariff(cityName, new AsyncCallback<Double>(){
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
				
			}

			@Override
			public void onSuccess(Double result) {
				doubleBoxTarrif.setValue(result);
				
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
				doCalculation();
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
		loadWorthInvesting();
	}
	
	/*track user's location and load google map using obtained latitude and longitude*/
	private void loadUserLocationOnMap() {
		if (!Geolocation.isSupported()) {
			Window.alert("Obtaining Geolocation FAILED! Geolocation API is not supported.");
        }
		
		final Geolocation geo = Geolocation.getGeolocation();
		
	    if (geo == null) {
	      Window.alert("Obtaining Geolocation FAILED!");
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
	        }      
			@Override
			public void onSuccess(
					Position position) {
		          Coordinates c = position.getCoords();
		          
		          loadMap(c.getLatitude(),c.getLongitude());//load map use detected ip address's latititude and longitude 	
		          String latLng = c.getLatitude()+","+c.getLongitude();
		          
		          service = (CalculationServiceAsync)GWT.create(CalculationService.class);
		          
                  service.getAddress(latLng, new AsyncCallback<String>() {
                	  
                          public void onFailure(Throwable arg0) {
                                  txtBoxAddressInput.setText("Address not found");
                                  
                          }

                          public void onSuccess(String fullAddress) {
                                 txtBoxAddressInput.setText(fullAddress);
                                 
                          }});
		          
		          
			}
	      }, PositionOptions.getPositionOptions(true, 15000, 30000));
	   
	  
	}
	/* Court's WorthInvestment method */
	private void loadWorthInvesting() {
		txtDailySavings2.setText("0");
		txtPayBackYear2.setText("3");
		txtExpectedDuration.setText("5");
		btnWorthInvesting.setText("Worth it?");
		lblWorthInvesting.setText("");
		
		btnWorthInvesting.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getWorthInvestmentFromServer();
			}
		});
		
		RootPanel.get("tdDailySaved").add(txtDailySavings2);
		RootPanel.get("tdFinalPayback").add(txtPayBackYear2);
		RootPanel.get("tdExpectedDuration").add(txtExpectedDuration);
		RootPanel.get("tdWorthInvestingCalculate").add(btnWorthInvesting);
		RootPanel.get("tdWorthInvestingResult").add(lblWorthInvesting);
	}
	
	protected void getWorthInvestmentFromServer() {
		CalculationServiceAsync service = (CalculationServiceAsync) GWT.create(CalculationService.class);
        ServiceDefTarget serviceDef = (ServiceDefTarget) service;
        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()
            + "calculationService");
        WorthInvestingCallback callback = new WorthInvestingCallback(lblWorthInvesting);
        service.doWorthInvestment(txtDailySavings2.getValue(), txtPayBackYear2.getValue(), txtExpectedDuration.getValue(), callback);
	}

	protected void doCalculation(){		
        
        // calculate the generation for all months
        service.doSolarGenerationForAllMonths(doubleBoxSize.getValue()/1000, roofLossBox.getValue()/100, inverterBox.getValue()/100, doubleBoxWiring.getValue()/100, txtWhatYear.getValue(), doubleBoxAgeLoss.getValue()/100, new AsyncCallback<double[]>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(double[] result) {
				chart.draw(createMonthGenerationTable(result),createOptions());//draw column chart
				
				//to remove the string month results display when charts are properly set up
				 String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
				 StringBuffer buffer = new StringBuffer();
				 for(int i=0;i<12;i++){
						buffer.append(months[i]);
						buffer.append(":");
						buffer.append(result[i]);
						buffer.append("kwh\n");					
			}
				 lblmonthsResultstext.setText(buffer.toString());
			}
		});

        // calculate the daily generation,  
        service.doDailySolarGeneration(doubleBoxSize.getValue()/1000, roofLossBox.getValue()/100, inverterBox.getValue()/100, doubleBoxWiring.getValue()/100, txtWhatYear.getValue(), doubleBoxAgeLoss.getValue()/100, doubleBoxIrradiance.getValue(), new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}

			public void onSuccess(Double result) {
				txtDailySolarGeneration.setValue(result);
				getDailySaving(result);//use dailyCalculation result for dailySavingCalculation
				getPaybackTime(result);
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
	
	protected void getPaybackTime(Double result) {
		service.getPayBackTime(systemCostBox.getValue(), integerBoxLifeSpan.getValue(), doubleBoxReplacePercent.getValue()/100, 
				doubleBoxTarrif.getValue()/100, doubleBoxPowerCost.getValue()/100, result, doubleBoxAgeLoss.getValue()/100,integerBoxpaybackYear.getValue(), new AsyncCallback<TreeMap<Double,String>>(){
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());		
					}
					@Override
					public void onSuccess(TreeMap<Double, String> result) {
						lineChart.draw(createPayBackTable(result),createLineChartOptions());	
					}
		});
		
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
 		   service.doDailySavings(dailyGeneration, doubleBoxReplacePercent.getValue()/100, doubleBoxTarrif.getValue()/100, doubleBoxPowerCost.getValue()/100, new AsyncCallback<Double>() {
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
		service.doPayBackYear(systemCostBox.getValue(), integerBoxLifeSpan.getValue(),
				dailySaving,new AsyncCallback<Double>() {
			public void onFailure(Throwable caught) {				
				Window.alert(caught.getMessage());				
			}
			public void onSuccess(Double result) {
				txtPayBackYear.setText(result.toString());
			}});
	}
	
	
	/*use to add pop msg to explain stuff*/
	class PopMessage implements MouseOverHandler,MouseOutHandler {
		// Create a basic popup widget
		 PopupPanel simplePopup ;
		public PopMessage(String whatMsg){
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
		    options.setWidth(700);
		    options.setHeight(400);		    
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
	    options.setWidth(700);
	    options.setHeight(240);
	    options.set3D(true);
	    options.setTitle("kwh Generation per month");
	    options.setStacked(true);
	    options.setMin(0);
	    options.setEnableTooltip(true);
	    return options;
	  }
	 private void createTable(){
		 Runnable onLoadCallback = new Runnable() {
	          public void run() {
	            Panel panel = RootPanel.get("idPanelTable");
	            Panel panelInverter = RootPanel.get("idInverterTable");
	            // Create a table visualization.	           
	            Table table= new Table(createTableData(),createTableOptions());
	            Table tableInverter = new Table(createInverterData(),createTableOptions());
	           
	            panel.add(table);
	            panelInverter.add(tableInverter);
	            
	          }
	        };

	        // Load the visualization api, passing the onLoadCallback to be called
	        // when loading is done.
	        VisualizationUtils.loadVisualizationApi(onLoadCallback, Table.PACKAGE);
	        
	 }
	 /* dataset for inverter need to be refactored by using datastore data*/
	protected AbstractDataTable createInverterData() {
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Brand");
		data.addColumn(ColumnType.STRING, "Descriptions","desc");
		data.addColumn(ColumnType.NUMBER,"Power(watts)");
		data.addColumn(ColumnType.NUMBER, "Efficiency(%)");
		data.addColumn(ColumnType.NUMBER, "Price($)");
		
		data.addRows(2);
		data.setValue(0, 0, "Aurora");
		data.setValue(0, 1, "PVI-2000-AU Outdoor 2kW Grid Connect Inverter IP65 rated");
		data.setValue(0, 2, 2000);
		data.setValue(0, 3, 96);
		data.setValue(0, 4, 1174);
		data.setValue(1, 0, "Aurora");
		data.setValue(1, 1, "PVI-4.2-AU Outdoor 4.2kW Grid Connect Inverter IP65 rated (transformerless)");
		data.setValue(1, 2, 4200);
		data.setValue(1, 3, 96);
		data.setValue(1, 4, 2376);
		
		
		return data;
	}
	/*create tables options for both inverter and solar panels tables*/
	protected com.google.gwt.visualization.client.visualizations.Table.Options createTableOptions() {
		com.google.gwt.visualization.client.visualizations.Table.Options options = Table.Options.create();
		

		return options;
	}
/* dataset for solar panels need to be refactored by using datastore data*/
	protected AbstractDataTable createTableData() {
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Brand");
		data.addColumn(ColumnType.STRING, "Descriptions","desc");
		data.addColumn(ColumnType.NUMBER,"Power(watts)");
//		data.addColumn(, "Quantity", "quantity");
		
		//data.addColumn(ColumnType.NUMBER, "Efficiency(%)");
		data.addColumn(ColumnType.NUMBER, "Price($)");
		data.addRows(1);
		data.setValue(0, 0, "REC Solar");
		data.setValue(0, 1, "REC Solar 250 W Peak Energy Series, polycrystalline cell Black Frame");
		data.setValue(0, 2, 250);
		data.setValue(0, 3, 412.50);	
		
		return data;
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
	/*optonal for maps not used */
	private MapOptions createMapOptions(){
		MapOptions mapOption = MapOptions.newInstance();
		
		return mapOption;
	}
}
