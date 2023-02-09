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
public class ReadCookie extends HttpServlet {
	public static String Name = null;
	public static String Value = null;
	public static String Access = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] ck = request.getCookies();
		Name = ck[1].getValue();
		Value = ck[2].getValue();
		Access = ck[3].getValue();
		
		System.out.println(Name);
		System.out.println(Value);
		System.out.println(Access);
		response.sendRedirect("Home");
	}

	

}
