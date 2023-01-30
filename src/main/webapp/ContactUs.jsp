<%@ page import="com.project.programs.User" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compactible" content="IE-edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CONTACT US</title>
    <link rel="stylesheet" href="CssFiles/ContactUs.css">
    
    <script src="https://kit.fontawesome.com/c89de0c309.js" ></script>
</head>

<body>
   <div class="topnav" id="myTopnav">
<%!
	public String link(){
	if(User.FName == null){
		return "login.jsp";
	}
	else{
		return "UserProfile.jsp";
	}
}
%>
	<a href="<%= link() %>" class="active"><%
	if(User.FName == null){
		out.print("Login");
	}
	else{
		out.print(User.FName);
	}
	%></a></li> 
	<a href="#">Services</a></li>  
   <a href="AboutUs.html">About Us</a></li>
   <a href="ContactUs.html">Contact Us</a></li>
   
   <img src="images/Logo.png" height="50" width="50" Style="margin-left:10px; margin-top:5px;">
    
   
</div>
    <div class="hero">
        <div class="container">
            <form>
                <div class="row">
                    <div class="input-group">
                        <input type="text" id="name" required>
                        <label for="name"><i class="fa-solid fa-user"></i> YOUR NAME</label>
                    </div>
                    <div class="input-group">
                        <input type="text" id="number" required>
                        <label for="number"><i class="fa-solid fa-phone"></i> PHONE NO.</label>
                    </div>
                </div>
                <div class="input-group">
                    <input type="email" id="email" required>
                    <label for="email"><i class="fa-solid fa-envelope"></i> EMAIL ID</label>
                </div>
                <div class="input-group">
                    <input type="text" id="SUBJECT" required>
                    <label for="SUBJECT"><i class="fa-solid fa-file"></i> SUBJECT</label>
                </div>
                <div class="input-group">
                    <TEXTAREA id="message" rows="8" required></TEXTAREA>
                    <label for="message"><i class="fas fa-comments"></i> YOUR MESSAGE</label>
                </div>
                <button type="submit" id="submit">SUBMIT<i class="fas fa-paper-plane"></i> </button>
            </form>

        </div>
    </div>
</body>

</html>