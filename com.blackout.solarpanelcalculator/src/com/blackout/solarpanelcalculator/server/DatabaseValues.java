package com.blackout.solarpanelcalculator.server;
import com.google.appengine.api.rdbms.AppEngineDriver;
import java.io.IOException;
import java.sql.*;


public class DatabaseValues {

	
	 
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
