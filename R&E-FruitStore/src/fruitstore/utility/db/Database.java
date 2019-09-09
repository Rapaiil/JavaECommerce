package fruitstore.utility.db;

import java.sql.*;
import fruitstore.utility.security.AES;

public class Database implements DBInfo {
	private static Connection connection;
	
	private static void connect() throws Exception {
		if(connection != null)
			return;
		try {
			Class.forName(DB_CLASS);
		} catch(ClassNotFoundException cnfe) {
			throw new ClassNotFoundException("Driver not found! Kindly locate the driver for MySQL.");
		}
		connection = DriverManager.getConnection(DB_URL, AES.decrypt(DB_UNAME), AES.decrypt(DB_PASS));
	}
	
	public void close() {
		if(connection != null) {
			try {
				connection.close();
			} catch(SQLException sqle) {
				System.err.println(sqle.getMessage());
			}
		}
	}
	
	public static Connection getConnection() {
		try {
			connect();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return connection;
	}

}
