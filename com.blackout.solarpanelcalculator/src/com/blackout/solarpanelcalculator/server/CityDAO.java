package com.blackout.solarpanelcalculator.server;
import com.blackout.solarpanelcalculator.client.City;
import java.sql.*;
import java.util.ArrayList;


public class CityDAO {

	public static int cityIndex = 0;
	
	public static City getCity(int cityIndex) {
		
		City city = new City();
		city.setMonthsIrradiance(new double[12]);
		Connection connection = null;
		String select_sql = "select * from cities natural join states where CityID =?";
		PreparedStatement select = null;
		try {

			connection = DriverManager
					.getConnection("jdbc:google:rdbms://solarcalculator372:solarcalculator/solar");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			select = connection.prepareStatement(select_sql);
			select.setInt(1, cityIndex);
			ResultSet rs = select.executeQuery();
			while (rs.next()) {
				city.setCityName(rs.getString("CityName"));
				city.setZoneRating(rs.getDouble("ZoneRating"));
				city.setAvgProduePerkw(rs.getDouble("AvgProducePerkw"));
				city.setFeedInTariff(rs.getDouble("FeedInTariff"));
				city.setElectricityCost(rs.getDouble("AvgElectricityCost"));
				city.setPostcode(rs.getInt("Postcode"));
				city.setOptimalYearDegree(rs.getInt("OptimalYearRound"));
				city.setBestWinterDegree(rs.getInt("BestWinter"));
				city.setBestSummerDegree(rs.getInt("BestSummer"));				
				for (int i = 0; i < 12; i++) {
					city.getMonthsIrradiance()[i] = rs.getDouble(10 + i);
				}
				return city;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			if (select != null) {
				select.close();
			}

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String[] getCityList(int postcode) {
		ArrayList<String> cityList = new ArrayList<String>();
		//		String cityList[] = new String[20];
		
		Connection connection = null;
		String select_sql = "select CityName from cities";
		String select_CityID = "select CityID from cities where CapitalCity = 'true' and StateCode=(" +
				"select StateCode from states where PostcodeMin<= ? and PostcodeMax>=?)";
		PreparedStatement select = null;
		PreparedStatement select2 = null;
		try {
			connection = DriverManager.getConnection("jdbc:google:rdbms://solarcalculator372:solarcalculator/solar");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			select = connection.prepareStatement(select_sql);
			select2 = connection.prepareStatement(select_CityID);
			select2.setInt(1, postcode);
			select2.setInt(2, postcode);
			ResultSet rs = select.executeQuery();
			ResultSet rs2 = select2.executeQuery();
		while(rs.next()){
			cityList.add(rs.getString(1));
			
		}
		while(rs2.next()){
			cityIndex = rs2.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cityListArray[] = new String[cityList.size()];
		cityList.toArray(cityListArray);
		try {
			select.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cityListArray;
	}
	public static int returnCityIndex(){
		return cityIndex;
	}
	public static int getCityIDFromPostcode(int postcode){
		
		int cityID = -1;
		Connection connection = null;
		
		String select_sql = "select CityID from cities where CapitalCity = 'true' and StateCode=(" +
				"select StateCode from states where PostcodeMin<= ? and PostcodeMax>=?)";
		PreparedStatement select = null;
		try {
			connection = DriverManager.getConnection("jdbc:google:rdbms://solarcalculator372:solarcalculator/solar");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			select = connection.prepareStatement(select_sql);
			select.setInt(1, postcode);
			select.setInt(2, postcode);
			ResultSet rs = select.executeQuery();
			
		while(rs.next()){
			cityID = rs.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			select.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cityID;
	}
	
}
