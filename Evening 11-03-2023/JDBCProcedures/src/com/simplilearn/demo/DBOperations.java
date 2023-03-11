package com.simplilearn.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {
	
	public static void main(String[] args) {
		
		Connection conn=DBConfig.getConnection();
		
		try {
			Statement stmt=conn.createStatement();
			
			//creating Database
			stmt.executeUpdate("Create database sample");
			System.out.println("Database Created");
			
			//selecting newly created database
			stmt.executeUpdate("use sample");
			System.out.println("Database is Selected");
			
			//delete a database
			stmt.executeUpdate("Drop database sample");
			System.out.println("Database Removed/Dropped");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error:"+e.getMessage());
		}
		 
		
	}

}
