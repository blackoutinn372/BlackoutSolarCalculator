package com.blackout.solarpanelcalculator.server;
@SuppressWarnings("serial")
public class PowerConsumptionException extends Throwable {
	public PowerConsumptionException(){
		super();
	}
	public PowerConsumptionException(String message){
		super(message);
	}
}