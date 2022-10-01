package com.masai.methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetDataFromSql {
	
	
	public static PreparedStatement GetData(String massage){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String url = "jdbc:mysql://localhost:3306/javaproject";
		
		PreparedStatement pres = null;
		
		try {
			Connection conn = DriverManager.getConnection(url,"root","gaurav#2001");
			
			pres = conn.prepareStatement(massage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pres;
	}

}
