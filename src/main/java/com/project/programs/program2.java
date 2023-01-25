package com.project.programs;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class program2
 */
@WebServlet("")
public class program2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		System.out.println(fname);
		System.out.println( lname);
		System.out.println(email);
		System.out.println(dob);
		System.out.println(age);
		System.out.println(phone);
		System.out.println(password);
		System.out.println(cpassword);
		System.out.println(gender);

		out.println(fname);
		out.println(lname);
		out.println( email);
		out.println(dob);
		out.println(age);
		out.println(phone);
		out.println(password);
		out.println(cpassword);
		out.println(gender);

	}

}
