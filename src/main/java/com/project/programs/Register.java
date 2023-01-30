package com.project.programs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class program2
 */
@WebServlet("/registeruser")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   public static Connection con = null;
	   public static Statement stat = null ;
	   public static ResultSet result = null;
	   String url = "jdbc:mysql://localhost:3306/ARS";
	   String user = "root";
	   String pwd = "root";
	   private static final String  QUERY = "INSERT into `USER` (`First_name`, `Last_name`, `DOB`,`Age`, `Mobile`, `Password`, `Gender`, `email`) values (?,?,?,?,?,?,?,?)"; 
	   
	   
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
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stat = con.createStatement();
			result = stat.executeQuery("SELECT * from user ");
		
		
		
		
		
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("co-password");
		String gender = request.getParameter("gender");
	
		
		
		
		 
			 PrintWriter out = response.getWriter();
			 PreparedStatement stmt = con.prepareStatement(QUERY);
	         
			 if(password.equals(cpassword)) {
				 
				 stmt.setString(1,fname);
				 stmt.setString(2, lname);
				 stmt.setString(3, dob);
				 stmt.setString(4, age);
				 stmt.setString(5, phone);
				 stmt.setString(6, password);
				 stmt.setString(7,gender);
				 stmt.setString(8,email);
				 
				 stmt.executeUpdate();
				 System.out.println("Registered Successfully");
				 out.println(fname + " You have Registered Successfully");
			 }
			 else {
				 out.println("Password doesn't match! Try Again...");
				 RequestDispatcher rd = request.getRequestDispatcher("/register.html");
				 out.println("Registeration Unuccessfull");
				 System.out.println("Registeration Unuccessfull");
				 
				 rd.forward(request, response);
				 
			 }
	         
	        	
		 
        	 
             
		
		} catch (IOException e) {
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
	
	public void distroy(){
		try {
			result.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
