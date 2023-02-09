<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.project.programs.ReadCookie" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NavBar</title>
<link rel="stylesheet" href="CssFiles/HomePage.css">
</head>
<body>
<div class="topnav" id="myTopnav">
<%!
	public String link(){
	if(ReadCookie.Name == null){
		return "login.jsp";
	}
	else{
		return "UserProfile.jsp";
	}
}
%>
	<a href="<%= link() %>" class="active"><%
	if(ReadCookie.Name == null){
		out.print("Login");
	}
	else{
		out.print(ReadCookie.Name);
	}
	%></a></li> 
   <a href="#">Your Bookings</a></li>
   <a href="AboutUs.html">About Us</a></li>
   <a href="ContactUs.jsp">Contact Us</a></li>
   
   <img src="images/Logo.png" height="50" width="50" Style="margin-left:10px; margin-top:5px;">
    
   
</div>
</body>
</html>