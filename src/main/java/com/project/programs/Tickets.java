package com.project.programs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Tickets")
public class Tickets extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String Flight = request.getParameter("Flight");
		String pass = request.getParameter("pass");
		String Date = request.getParameter("Date");
		String Class = request.getParameter("Class");
		out.println(Flight);
		out.println(pass);
		out.println(Date);
		out.println(Class);
		
		int n =  Integer.parseInt(pass);
		String[] Travlers = new String[n];
		String[] ages = new String[n];
		
		
		for(int i=0; i < n; i++) {
			Travlers[i]  = request.getParameter("travler"+i);
		}
		
		
		for(int i = 0; i < n; i++) {
		out.println(Travlers[i]);
		}
		for(int i=0; i < n; i++) {
			ages[i]  = request.getParameter("agegroup"+i);
		}
		
		
		for(int i = 0; i < n; i++) {
			out.println(ages[i]);
		}
		
	}

}
