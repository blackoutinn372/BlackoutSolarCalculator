package com.blackout.solarpanelcalculator.client;

public class SolarPanelSize {
	
			//Solar Panel System Size (KWT/h)
			private double[] panelSizeOptions={1.5, 2.8, 3.0, 4.9, 9.8};
			
			@SuppressWarnings("unused")
			private double panelSize;
			
			public double getPanelSize(int a) {
				return panelSize= panelSizeOptions[a];
			}			
}
