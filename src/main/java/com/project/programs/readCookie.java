package com.project.programs;
import javax.servlet.http.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class readCookie
 */
@WebServlet("/readCookie")
public class readCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] ck = request.getCookies();
		String Name = ck[0].getName();
		String Value = ck[0].getValue();
		PrintWriter out = response.getWriter();
		out.println(Name);
		out.println(Value);
		
	}

	

}
