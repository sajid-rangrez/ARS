package com.project.programs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchFlight
 */
@WebServlet("/SearchFlight")
public class SearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String From = req.getParameter("From");
		String To = req.getParameter("To");
		String Departure = req.getParameter("Departure");
		String Return = req.getParameter("Return");
		String Npass = req.getParameter("NPass");
		
		try {
			String Query = "SELECT * FROM FLIGHTS WHERE Departure = ? AND Destination = ?";
			
			pstat = con.prepareStatement(Query);
			pstat.setString(1, From);
			pstat.setString(2, To);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}


}
