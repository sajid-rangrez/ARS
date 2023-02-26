package com.project.programs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String CheckEmail = null;
        	if (cookies != null) {
                // loop through the cookies and find the one with the name "myCookie"
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("Email")) {
                        // do something with the cookie's value
                        CheckEmail = cookie.getValue();
                    }
                    
                }
            }
        	if(CheckEmail == null) {
        		response.sendRedirect("login.jsp");
        	}
		request.getRequestDispatcher("NavBar.jsp").include(request, response);
		request.getRequestDispatcher("Wellcome.jsp").include(request, response);
		request.getRequestDispatcher("SearchBox.jsp").include(request, response);
		
	
	}

	
	

}
