package com.simplilearn.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class StoredProcedureExample {
	
	/*
	 STORED PROCEDURE: the query Written in Database and called from java code 
	 
	 Syntax to prepare Stored Procedure:
	 -----------------------------------
	 create procedure add_product(IN pname varchar(100),IN pprice int) insert into product(name,price) values(pname,pprice);
	 
	 Syntax to call Stored Procedure:
	 --------------------------------
	 call add_product('demo laptop',56000);
	 */
	
	public static void main(String[] args) {
		
		
		Connection conn=DBConfig.getConnection();
		CallableStatement stmt;
		
		try {
			
			stmt=conn.prepareCall("call add_product(?,?)");
			stmt.setString(1,"Thinkpad-Lenovo");
			stmt.setInt(2, 96000);
			
			int x=stmt.executeUpdate();
			
			if(x>0)
				System.out.println("Data Inserted Successfully");
			else
				System.out.println("Error While Inserting a Data");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error Msg:"+e.getMessage());
		}
	}

}
