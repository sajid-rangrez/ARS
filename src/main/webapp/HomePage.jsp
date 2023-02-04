<%@ page import="com.project.programs.User" %>
<%@ page import="com.project.programs.ReadCookie" %>

<html>
  <head>
  <title> Home Page </title>
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
	<a href="#">Services</a></li>  
   <a href="AboutUs.html">About Us</a></li>
   <a href="ContactUs.jsp">Contact Us</a></li>
   
   <img src="images/Logo.png" height="50" width="50" Style="margin-left:10px; margin-top:5px;">
    
   
</div>


<div class="title">
  <h1> Life Is Short<br>
        And <br>
       World Is Wide!
  </h1>
  <h2>
    Welcome to our Airline!
</h2>
</div> 
<div class="main-button">
<a id="contact-btn" href="ContactUs.jsp"><b>Contact us</b></a> &nbsp;&nbsp;&nbsp;
<a id="about-btn" href="AboutUs.html"><b>About us</b></a>
</div>
<form class="searchbox" action="SearchFlight" method="get">
           <div class="inputBox">
            
              <p>FROM</p>
              <input type="text" name="FromCity" placeholder="Search City">
           </div>
           <div class="inputBox">
              <p>TO</p>
              <input type="text" name="ToCity" placeholder="Search City" >
           </div>
           <div class="inputBox">
              <p>DEPARTURE</p>  
              <input type="date" name="DDate" placeholder="Select Date">
           </div>
           <div class="inputBox">
              <p>RETURN</p>
              <input type="date" name="RDate">
           </div>
           <div class="inputBox">
              <p>PASSENGERS</p>
              <input type="Number" min="1" max="5" name="NPass" class="passengers" placeholder="No.">
           </div>
           <div class="inputBox">
            <p class="white"> </p>
            <input type="submit" value="   Search   ">
         </div>
        </form>


</body>
</html>