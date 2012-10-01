package com.blackout.solarpanelcalculator.server;
import com.blackout.solarpanelcalculator.client.City;
import com.google.appengine.api.rdbms.AppEngineDriver;
import java.io.IOException;
import java.sql.*;


public class CityDAO {


	
	public static City getCity(String cityName) {
		City city = new City();
		city.setMonthsIrradiance(new double[12]);
		Connection connection = null;
		String select_sql = "SELECT * from cities WHERE CityName LIKE ?";
		PreparedStatement select = null;
		try {

			connection = DriverManager
					.getConnection("jdbc:google:rdbms://solarcalculator372:solarcalculator/mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			select = connection.prepareStatement(select_sql);
			select.setString(1, cityName);
			ResultSet rs = select.executeQuery();
			while (rs.next()) {
				city.setCityName(rs.getString(2));
				city.setFeedInTariff(rs.getDouble(3));
//				city.setIrradiance(rs.getDouble("Avg"));
				city.setElectricityCost(rs.getDouble(4));
				city.setPostcode(rs.getInt(5));
				city.setOptimalYearDegree(rs.getInt(6));
				city.setBestWinterDegree(rs.getInt(7));
				city.setBestSummerDegree(rs.getInt(8));
				for (int i = 0; i < 12; i++) {
					city.getMonthsIrradiance()[i] = rs.getDouble(9 + i);
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

}
