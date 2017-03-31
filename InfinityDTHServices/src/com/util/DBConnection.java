package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {
	private static final Logger logger = LogManager.getLogger(DBConnection.class);
	
	public static Connection getConnection() {
		Connection con = null;
		PropertiesManager manager = PropertiesManager.getPropertiesManager();
		
		try {
			Class.forName(manager.loadProperty(Property.DRIVER));
			
			con = DriverManager.getConnection(
					manager.loadProperty(Property.URL),
					manager.loadProperty(Property.USERNAME),
					manager.loadProperty(Property.PASSWORD));
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		
		return con;
	}
	
	
	public static Connection getConnectionTest() throws SQLException 
	{
	    //URL of Oracle database server
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	String url = "jdbc:oracle:thin:@10.101.121.11:1521:xe";
	    //properties for creating connection to Oracle database
	    Properties props = new Properties();
	    props.setProperty("user", "Import Team Name");
	    props.setProperty("password", "2017");
	  
	    //creating connection to Oracle database using JDBC
	    Connection conn = DriverManager.getConnection(url,props);
    
	    return conn;
	}
	
	
	public static void CloseConnection(Connection cn) {
		if(cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
			}
		}
	}
}
