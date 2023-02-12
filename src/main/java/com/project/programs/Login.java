package com.project.programs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginuser")
public class Login extends HttpServlet {
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


	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String email = req.getParameter("email");
		   String password = req.getParameter("password");



// 	Validating login data
		   try {
			   String query = "select * from user WHERE email = ? AND Password = ?";
//			   con = DriverManager.getConnection(url, user, pwd);
			   pstat = con.prepareStatement(query);
			   pstat.setString(1, email);
			   pstat.setString(2, password);
			   result = pstat.executeQuery();
			   if(result.next() == true ) {
				   
//	Setting Requesting User's data from Database
				   
				   Cookie ck1 = new Cookie("Name" , result.getString(1));
				   Cookie ck2 = new Cookie("Email" , result.getString(8));
				   Cookie ck3 = new Cookie("Access" , result.getString(9));
				   ck1.setMaxAge(-1);
				   ck2.setMaxAge(-1);
				   ck3.setMaxAge(-1);
				   resp.addCookie(ck1);
				   resp.addCookie(ck2);
				   resp.addCookie(ck3);

//				   User.FName = result.getString(1);
//				   User.LName = result.getString(2);
//				   User.Dob = result.getString(3);
//				   User.Age = result.getInt(4);
//				   User.Mob = result.getString(5);
//				   User.Gender = result.getString(7);
//				   User.Email = result.getString(8);
				   
				   
//	Request Dispeture With Include

//				   req.getRequestDispatcher("/HomePage.jsp").forward(req, resp);
				   resp.sendRedirect("Home");
				   System.out.println("Login Successfully");
			   }
			   else {
				   out.println("<h3>Invalid login details. Please try again!</h3>");
				   req.getRequestDispatcher("login.jsp").include(req, resp);
				   System.out.println(email);
				   System.out.println(password);
			   }
		   } catch (Exception e) {
			   e.printStackTrace();
			}
		
	}

}
