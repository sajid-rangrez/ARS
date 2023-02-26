<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.lang.Class" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   Connection con = null;
	Statement stat = null;
	ResultSet result = null;
   String url = "jdbc:mysql://localhost:3306/ars";
   String user = "root";
   String password = "root";
   
   
   String Id = null;  
   String Travler = null;  
   String ClassName = null;  
   String Seat = null;  
   String Date = null;  
   String Time = null;  
   String Flight = null;  
   String From = null;  
   String To = null;  
   
	  String Access = null;
      String Name = null;
      String Email = null;
   try {

      // Load the JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      
      
  	//Check login
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
      

      Cookie[] ck = request.getCookies();
      
      if (ck != null) {
    	    for (Cookie ckName : ck) {
    	        if (ckName.getName().equals("Name")) {
    	            Name = ckName.getValue();
    	            // do something with the cookie value
    	           
    	        }
    	    }
    	}
      if (ck != null) {
    	    for (Cookie ckName : ck) {
    	        if (ckName.getName().equals("Email")) {
    	            Email = ckName.getValue();
    	            // do something with the cookie value
    	           
    	        }
    	    }
    	}
      String QUERY = "SELECT * FROM TICKETS WHERE Email = '"+Email+"'";
      // Create a connection to the database
      con = DriverManager.getConnection(url, user, password);
      stat = con.createStatement();
      
      stat.executeQuery(QUERY);
      result = stat.executeQuery(QUERY);
      // Do something with the connection here...
      while(result.next()){
    	  Id = result.getString(1);
    	  Travler = result.getString(2);
    	  ClassName = result.getString(3);
    	  Seat = result.getString(4);
    	  Date = result.getString(5);
    	  Time = result.getString(6);
    	  Flight = result.getString(7);
    	  From = result.getString(8);
    	  To = result.getString(9);
    	  out.println("<p>"+Id +" "+ Travler +" "+ ClassName+"</p>");
      }
      

   } catch (SQLException e) {
      out.println("SQLException: " + e.getMessage());
   } 
   catch (ClassNotFoundException e) {
      out.println("ClassNotFoundException: " + e.getMessage());
   }
   finally {
      // Close the connection
      if (con != null) {
         try {
            con.close();
         } catch (SQLException e) {
            out.println("SQLException: " + e.getMessage());
         }
      }
   }
%>
</body>
</html>