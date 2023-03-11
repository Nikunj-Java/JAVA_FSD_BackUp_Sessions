package com.simplilearn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConfig {
	
	public static Connection getConnection(Properties props) {
		
		String driver=props.getProperty("driver");
		String url=props.getProperty("url");
		String user=props.getProperty("username");
		String password=props.getProperty("password");
		
		Connection conn=null;
		
		
		
		try {
			//load driver
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			
			if(conn!=null)
				System.out.println("Connected");
			else
				System.out.println("Error While Connecting");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Sql:"+e.getMessage()+",Error:"+e.getErrorCode());
		}
		
		
		return conn;
	}

}
