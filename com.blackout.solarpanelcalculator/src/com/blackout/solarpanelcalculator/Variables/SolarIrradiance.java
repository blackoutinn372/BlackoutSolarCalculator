package com.blackout.solarpanelcalculator.Variables;
/**
 * 
 * @author Sen
 * This class represents SolarIrradiance 
 * default value is 5.1 in kWh/m2/day  if no input value is given
 * or input value is invalid
 */
public class SolarIrradiance {
	private double irradianceValue;
	private final double defaultValue = 5.1;// in kWh/m2/day
	public SolarIrradiance() {
		irradianceValue = defaultValue;
	}
	public SolarIrradiance(double irradianceValue){
		if(irradianceValue > 0 || irradianceValue <10)
			this.irradianceValue = irradianceValue;
		else
			this.irradianceValue = defaultValue;
	}
	public double getIrradianceValue() {
		return irradianceValue;
	}
	public void setIrradianceValue(double irradianceValue) {
		if(irradianceValue > 0 || irradianceValue <10)
			this.irradianceValue = irradianceValue;
		else
			this.irradianceValue = defaultValue;
	}
	
}
