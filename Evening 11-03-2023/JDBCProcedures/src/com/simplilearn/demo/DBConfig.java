package com.simplilearn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	
	public static Connection getConnection() {
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jdbc_2023";
		String user="root";
		String password="Nikunj@123";
		
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
