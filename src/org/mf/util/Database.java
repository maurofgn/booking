package org.mf.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	private static Connection connection; 

	public static Connection getConnection() {
		
		if (connection != null)
			return connection;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "toor");
			return connection;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());
			return null;
		}
	}

	public static void close() {
		if (connection != null) 
			try {
				connection.close();
			} catch (Exception ex) { /* NO ACTION */ }
	}
}
