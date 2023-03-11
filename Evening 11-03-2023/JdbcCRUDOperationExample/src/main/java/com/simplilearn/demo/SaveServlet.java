package com.simplilearn.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class SaveServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1. check the connectivity
		
		Properties props= new Properties();
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);
		
		//2. get the connection object
		Connection conn=DBConfig.getConnection(props);
		
		
		//3. get the parameter
		String name=req.getParameter("pname");
		BigDecimal price=new BigDecimal(req.getParameter("pprice"));
		
		//4. write query to insert the data
		PrintWriter out=resp.getWriter();
		if(conn!=null) {
			out.print("Connection Established");
			
			try {
				
				PreparedStatement stmt=conn.prepareStatement("insert into product(name,price) values (?,?)");
				
				stmt.setString(1, name);
				stmt.setBigDecimal(2, price);
				
				int x=stmt.executeUpdate();
				
				if(x>0) {
					System.out.println("Data inserted Successfully");
					out.print("Data inserted Successfully");
					//action
					resp.sendRedirect("fetch");
				}
				else {
					System.out.println("Error While Inserting a Data");
					out.print("Error While Inserting a Data");
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
