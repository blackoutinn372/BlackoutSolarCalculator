package com.blackout.solarpanelcalculator.server;

import java.sql.*;

import com.blackout.solarpanelcalculator.client.Product;



/*
 * 
 * Read Solar panel products for Database 
 */

public class ProductDAO {
		
	private static final int rows=0; 

	public static Product getProduct(){
		
		Product pt = new Product();
		Connection connect = null;
		String sql = "select * from solarproducts";
		PreparedStatement ps = null;
		
		
		try {
			connect = DriverManager.getConnection("jdbc:google:rdbms://solarcalculator372:solarcalculator/solar");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
				ResultSet rs = null;
				try {
					ps = connect.prepareStatement(sql);
					rs = ps.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					while(rs.next()){
						pt.setType(rs.getString("Type"));
						pt.setBrand(rs.getString("Brand"));
						pt.setDescriptions(rs.getString("Descriptions"));
						pt.setPower(rs.getInt("Power"));
						pt.setEfficiency(rs.getDouble("Efficiency"));
						pt.setPrice(rs.getInt("Price"));						
				}
					return pt;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				try {
					if (ps != null) {
						ps.close();
					}

					if (connect != null) {
						connect.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
				
	}
	
	

}
