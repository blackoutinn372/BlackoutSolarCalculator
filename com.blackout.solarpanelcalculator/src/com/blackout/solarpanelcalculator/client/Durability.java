package com.blackout.solarpanelcalculator.client;

import java.util.*;
import java.util.Map.*;


public class Durability{
		
		//create SolarPanelSize Object
		SolarPanelSize sps = new SolarPanelSize();
		
		//create SolarPanelEfficiency Object
		SolarPanelEffcy spe = new SolarPanelEffcy();
		
		//Solar Panel Lifetime is 20 years
		private int panelYearlifetime=20;
		
		
		//calculate different solar size panel efficiency
		public void getDurability(){
			
			
			//calculate solar panel efficiency and store it
			Map<Integer, Double> panelEffcy = new HashMap<Integer, Double>();
			for(int i=1; i<=panelYearlifetime; i++){
				panelEffcy.put(i, spe.getPanelEfficiency()[i-1]*sps.getPanelSize(i));
			}
		    
		    //read year and efficiency result
			Iterator<Entry<Integer, Double>> iter = panelEffcy.entrySet().iterator();
			
			//display result
			while(iter.hasNext()){
				Entry<Integer, Double> en = iter.next();
				System.out.println(en.getKey()+" "+en.getValue());
				}
	
		}
}