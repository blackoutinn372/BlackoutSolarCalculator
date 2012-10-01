package com.blackout.solarpanelcalculator.server;
import com.google.appengine.api.rdbms.AppEngineDriver;
import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.Query;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.blackout.solarpanelcalculator.server.PMF;

public class DatabaseValues {
	private static PersistenceManager pm = PMF.get().getPersistenceManager();
	
	// A quick fake method that would add an entry to the datastore
	// because I don't know how to otherwise add to it - Court
	/*private static void quickAdd() {
		String brand = "REC Solar";
		String des = "REC Solar 250 W Peak Energy Series, polycrystalline cell Black Frame";
		double watts = 250; double price = 412.5;
		SolarPanel s = new SolarPanel(brand,des,watts,price);
	
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(s);
		} finally {
			pm.close();
		}
	}*/
	
	// An attempt to access the datastore using JDO
	// Doesn't seem to work, so I'll leave it as a possible lead - Court
	/*
	public static double getSolarIrradiance(String city) {
		quickAdd();
		double solarIrradiance = 5.1;
		
		Query q = pm.newQuery(SolarPanel.class);
		q.setFilter("name == nameParameter");
		q.declareParameters("String nameParameter");
	 
		try {
			List<SolarPanel> results = (List<SolarPanel>) q.execute(city);
			
			solarIrradiance = results.get(0).getWatts();
			
		} finally {
			q.closeAll();
			pm.close();
		}
		
		return solarIrradiance;
	}*/
	
	 
	public static double getSolarIrradiance(String city){
		double solarIrradiance = 5.1;
		 Connection c = null;
		 String select_sql = "SELECT Avg from cities WHERE CityName LIKE ?";
		 PreparedStatement select;
		 try {
			c = DriverManager.getConnection("jdbc:google:rdbms://solarcalculator372:solarcalculator/mysql");
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 try {
			 select = c.prepareStatement(select_sql);
			 select.setString(1, city);
			ResultSet rs = select.executeQuery();
			while(rs.next()){
				solarIrradiance = rs.getDouble(1);
			}
			 select.close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		
		 return solarIrradiance;
	}
	
	
	public static double getFeedInTariff(String city){
		double feedInTariff = 20;
		 Connection c = null;
		 String select_sql = "SELECT FeedInTariff from cities WHERE CityName LIKE ?";
		 PreparedStatement select;
		 try {
			
			c = DriverManager.getConnection("jdbc:google:rdbms://solarcalculator372:solarcalculator/mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			 select = c.prepareStatement(select_sql);
			 select.setString(1, city);
			ResultSet rs = select.executeQuery();
			while(rs.next()){
				feedInTariff = rs.getDouble(1);
			}
			 select.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 return feedInTariff;
	}
}
