package com.project.programs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookFlight
 */
@WebServlet("/BookFlight")
public class BookFlight extends HttpServlet {
	public static Connection con = null;
	public static PreparedStatement pstat = null ;
	public static ResultSet result = null;
	String url = "jdbc:mysql://localhost:3306/ARS";
	String user = "root";
	String pwd = "root";
       
	
	public void init() throws ServletException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Flight = request.getParameter("Flight");
		String Date = request.getParameter("Date");
		System.out.println(Flight);
		System.out.println(Date);
		String Query = "SELECT * FROM FLIGHTS WHERE Flight_Number = "+Flight+" AND Date = "+Date+"";
		try {
			result = pstat.executeQuery();
			
			if(result.next()) {
				
			}
			else {
				//Error no flights here
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
