package com.project.programs;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		String From = req.getParameter("FromCity");
		String To = req.getParameter("ToCity");
		String Departure = req.getParameter("DDate");
		String Return = req.getParameter("RDate");
		String Npass = req.getParameter("NPass");
		
		PrintWriter out = resp.getWriter();
		
		try {
			String Query = "select * from flights where Departure = ? AND Destination = ?";
			
			pstat = con.prepareStatement(Query);
			pstat.setString(1, From);
			pstat.setString(2, To);
			result = pstat.executeQuery();
			if(result.next() == true) {
				System.out.println(result.getString(1)+" "+ result.getString(2)+" "+ result.getString(3)+" "+ result.getString(4) +" "+  result.getString(5)+" "+ result.getString(6)+" "+ result.getString(7)+" "+ result.getString(8)+" "+ result.getString(9)+" "+ result.getString(10)+" "+ result.getString(11)+" "+ result.getString(12)+" "+ result.getString(13)+" "+ result.getString(14)+" "+ result.getString(15)+" "+ result.getString(16)+" "+ result.getString(17)+" "+ result.getString(18) +" "+ result.getString(19));
				out.println(result.getString(1)+" "+ result.getString(2)+" "+ result.getString(3)+" "+ result.getString(4)+" "+  result.getString(5)+" "+ result.getString(6)+" "+ result.getString(7)+" "+ result.getString(8)+" "+ result.getString(9)+" "+ result.getString(10)+" "+ result.getString(11)+" "+ result.getString(12)+" "+ result.getString(13)+" "+ result.getString(14)+" "+ result.getString(15)+" "+ result.getString(16)+" "+ result.getString(17)+" "+ result.getString(18) +" "+ result.getString(19));
			}
			else {
				out.println("flight not Found");
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("erroer");
		}
		
		
	}


}
