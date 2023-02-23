package com.project.programs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Tickets")
public class Tickets extends HttpServlet {
	
	public static Connection con = null;
	   public static Statement stat = null ;
	   public static ResultSet result = null;
	   String url = "jdbc:mysql://localhost:3306/ARS";
	   String user = "root";
	   String pwd = "root";
	   private static final String  QUERY = "select * from seats where Flight_Number = ? and Date = ?"; 
	   
	   static void close() throws SQLException, IOException {
	        if(result != null){
	            result.close();
	        }
	        if(stat != null){
	            stat.close();
	        }
	        if(con != null){
	            con.close();
	        }
	        
	    }
	   
	   public void init() throws ServletException{
		   try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   DriverManager.getConnection(url, user, pwd);
		   }
		   catch (Exception e) {
			   e.printStackTrace();
		   }
	   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int count = 0;
		String Flight = request.getParameter("Flight");
		String pass = request.getParameter("pass");
		String Date = request.getParameter("Date");
		String Class = request.getParameter("Class");
//		out.println(Flight);
//		out.println(pass);
//		out.println(Date);
//		out.println(Class);
		
		 
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stat = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			
			pstmt.setString(1,Flight);
			pstmt.setString(2,Date);
			
			result = pstmt.executeQuery();
			
			while(result.next() && count ==0) {
//				start from here its working now
				count++;
			}
			while(!result.next() && count == 0) {
				
				   try {
					   String  QUERY2 = "INSERT INTO seats (date, Flight_Number) VALUES('"+Date+"','"+Flight+"')";
					pstmt.executeUpdate(QUERY2);
					   System.out.println("DataBase Added Successfully");
					   count++;
				   } catch (SQLException e) {
						 System.out.println("DataBase Creation Unuccessfull");
				            e.printStackTrace();
				   }
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		System.out.println("empty");
		}
		response.setContentType("text/html");
		
		int n =  Integer.parseInt(pass);
		String[] Travlers = new String[n];
		String[] ages = new String[n];
		
		
		for(int i=0; i < n; i++) {
			Travlers[i]  = request.getParameter("travler"+i);
			ages[i]  = request.getParameter("agegroup"+i);
		}
		
		
		for(int i = 0; i < n; i++) {
//		out.println(Travlers[i]);
//		out.println(ages[i]);
		}
		
		
		
		request.getRequestDispatcher("NavBar.jsp").include(request, response);
		request.getRequestDispatcher("Ticket.jsp").include(request, response);
		
	}

}
