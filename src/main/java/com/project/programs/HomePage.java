package com.project.programs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/SearchFlights")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** xa      bp   ;;
	 * Get data from Search Fields of HomePage
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FromCity = request.getParameter("FromCity");
		String ToCity = request.getParameter("ToCity");
		String DDate = request.getParameter("DDate");
		String RDate = request.getParameter("RDate");
		String NPass = request.getParameter("NPass");
		
		PrintWriter out = response.getWriter();
		
		out.println(FromCity);
		out.println(ToCity);
		out.println(DDate);
		out.println(RDate);
		out.println(NPass);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
