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


@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Connection con = null;
	   public static Statement stat = null ;
	   public static ResultSet result = null;
	   String url = "jdbc:mysql://localhost:3306/ARS";
	   String user = "root";
	   String pwd = "root";
	   private static final String  QUERY = "INSERT into `FLIGHTS` (`Departure`, `Destination`, `Flight_Time`,`Landing_Time`, `Flight_Number`, `E_Price`, `B_Price`, `PE_Price`, `FC_Price`, `Mon`,`Tue`,`Wed`, `Thu`, `Fri`, `Sat`, `Sun`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
	   
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
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stat = con.createStatement();
//			result = stat.executeQuery("SELECT * from user ");
		
		
		
		
		
		
		String Departure = request.getParameter("Departure");
		String Destination = request.getParameter("Destination");
		String Flight_Time = request.getParameter("Flight_Time");
		String Landing_Time = request.getParameter("Landing_Time");
		String Flight_Number = request.getParameter("Flight_Number");
		String E_Price = request.getParameter("E_Price");
		String B_Price = request.getParameter("B_Price");
		String PE_Price = request.getParameter("PE_Price");
		String FC_Price = request.getParameter("FC_Price");
		String Mon = request.getParameter("Mon");
		String Tue = request.getParameter("Tue");
		String Wed = request.getParameter("Wed");
		String Thu = request.getParameter("Thu");
		String Fri = request.getParameter("Fri");
		String Sat = request.getParameter("Sat");
		String Sun = request.getParameter("Sun");
		
		
	
			 PrintWriter out = response.getWriter();
			 PreparedStatement stmt = con.prepareStatement(QUERY);
			 
// This field was for testing there response			 
//			 out.println(Departure);
//			 out.println(Destination);
//			 out.println(Flight_Time);
//			 out.println(Landing_Time);
//			 out.println(Distance);
//			 out.println(Flight_Duration);
//			 out.println(Flight_Number);
//			 out.println(Plane_Model);
//			 out.println(E_Price);
//			 out.println(B_Price);
//			 out.println(PE_Price);
//			 out.println(FC_Price);
//			 out.println(Mon);
//			 out.println(Tue);
//			 out.println(Wed);
//			 out.println(Thu);
//			 out.println(Fri);
//			 out.println(Sat);
//			 out.println(Sun);
	         
			 
				 
				 stmt.setString(1,Departure);
				 stmt.setString(2,Destination);
				 stmt.setString(3,Flight_Time);
				 stmt.setString(4,Landing_Time);
				 stmt.setString(5,Flight_Number);
				 stmt.setString(6,E_Price);
				 stmt.setString(7,B_Price);
				 stmt.setString(8,PE_Price);
				 stmt.setString(9,FC_Price);
				 if(Mon == null) {
					 stmt.setString(10,"FALSE");
				 }
				 else {
					 stmt.setString(10,"TRUE");
				 }
				 if(Tue == null) {
					 stmt.setString(11,"FALSE");
					 
				 }
				 else {
					 stmt.setString(11,"TRUE");
				 }
				 if(Wed == null) {
					 
					 stmt.setString(12,"FALSE");
				 }
				 else {
					 stmt.setString(12,"TRUE");
				 }
				 if(Thu == null) {
					 stmt.setString(13,"FALSE");
					 
				 }
				 else {
					 stmt.setString(13,"TRUE");
				 }
				 if(Fri == null) {
					 stmt.setString(14,"FALSE");
					 
				 }
				 else {
					 stmt.setString(14,"TRUE");
				 }
				 if(Sat == null) {
					 stmt.setString(15,"FALSE");
					 
				 }
				 else {
					 stmt.setString(15,"TRUE");
				 }
				 if(Sun == null) {
					 stmt.setString(16,"FALSE");
					 
				 }
				 else {
					 stmt.setString(16,"TRUE");
				 }
				 
				 
				 stmt.executeUpdate();
				 System.out.println("Flight Added Successfully");
				 out.println("Flight Added Successfully");
				   try {
					   String  QUERY2 = "CREATE TABLE "+Flight_Number+" (Date DATE, E1 varchar(20) DEFAULT 'O', E2 varchar(20)DEFAULT 'O', E3 varchar(20) DEFAULT 'O', E4 varchar(20) DEFAULT 'O', E5 varchar(20) DEFAULT 'O', E6 varchar(20) DEFAULT 'O', E7 varchar(20) DEFAULT 'O', E8 varchar(20) DEFAULT 'O', E9 varchar(20) DEFAULT 'O', E10 varchar(20) DEFAULT 'O', PE1 varchar(20) DEFAULT 'O', PE2 varchar(20) DEFAULT 'O', PE3 varchar(20) DEFAULT 'O', PE4 varchar(20) DEFAULT 'O', PE5 varchar(20) DEFAULT 'O', PE6 varchar(20) DEFAULT 'O', PE7 varchar(20) DEFAULT 'O', PE8 varchar(20) DEFAULT 'O', PE9 varchar(20) DEFAULT 'O', PE10 varchar(20) DEFAULT 'O', B1 varchar(20) DEFAULT 'O', B2 varchar(20) DEFAULT 'O', B3 varchar(20) DEFAULT 'O', B4 varchar(20) DEFAULT 'O', B5 varchar(20) DEFAULT 'O', B6 varchar(20) DEFAULT 'O', B7 varchar(20) DEFAULT 'O', B8 varchar(20) DEFAULT 'O', B9 varchar(20) DEFAULT 'O', B10 varchar(20) DEFAULT 'O', F1 varchar(20) DEFAULT 'O', F2 varchar(20) DEFAULT 'O', F3 varchar(20) DEFAULT 'O', F4 varchar(20) DEFAULT 'O', F5 varchar(20) DEFAULT 'O', F6 varchar(20) DEFAULT 'O', F7 varchar(20) DEFAULT 'O', F8 varchar(20) DEFAULT 'O', F9 varchar(20) DEFAULT 'O', F10 varchar(20) DEFAULT 'O')";
					   stmt.executeUpdate(QUERY2);
					   System.out.println("DataBase Added Successfully");
				   } catch (SQLException e) {
						 System.out.println("DataBase Creation Unuccessfull");
				            e.printStackTrace();
				   }
			
				
		
		} catch (IOException e) {
			 System.out.println("Registeration Unuccessfull");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		finally{
            try {
                close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

	} 
		
	}


