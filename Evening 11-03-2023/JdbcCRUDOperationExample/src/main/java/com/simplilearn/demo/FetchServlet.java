package com.simplilearn.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetch")
public class FetchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//to read html tags and syntax
		resp.setContentType("text/html");
		
		//1. check the connectivity
		
		Properties props= new Properties();
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);
		
		//2. get the connection object
		Connection conn=DBConfig.getConnection(props);
	
		
		//3. write query to insert the data
		PrintWriter out=resp.getWriter();
		if(conn!=null) {
			out.print("Connection Established");
			
			Statement stmt;
			try {
				stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from product");
				 
				while(rs.next()) {
					out.print("<br>"+rs.getInt(1)+","+rs.getString(2)+","+rs.getBigDecimal(3)+","+rs.getTimestamp(4)+"<br>");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			out.print("Not Connected");
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	

}
