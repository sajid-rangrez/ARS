<html>
  <head>
  <title> Home Page </title>
  <link rel="stylesheet" href="HomePage.css">
  </head>
<body>
<div class="topnav" id="myTopnav">

	<a href="login.jsp" class="active">Login</a></li> 
	<a href="#">Services</a></li>  
   <a href="AboutUs.html">About Us</a></li>
   <a href="ContactUs.html">Contact Us</a></li>
   
   <img src="https://w7.pngwing.com/pngs/657/810/png-transparent-social-media-linkedin-business-organization-company-plane-angle-company-logo-thumbnail.png" height="50" width="50">
    
   
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
<a id="contact-btn" href="ContactUs.html"><b>Contact us</b></a> &nbsp;&nbsp;&nbsp;
<a id="about-btn" href="AboutUs.html"><b>About us</b></a>
</div>
<form class="searchbox" action="SearchFlights" method="get">
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
              <input type="text" name="NPass" class="passengers" placeholder="No.">
           </div>
           <div class="inputBox">
            <p class="white"> </p>
            <input type="submit" value="   Search   ">
         </div>
        </form>


</body>
</html>