<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Ragisteration Form</title>
        <link rel="stylesheet" href="CssFiles/register.css">
    </head>

<body>
    <div class="form">
        <div class="register">
            <h2>Register Here</h2>
            <form id="register" action="registeruser" method="post">
            <div class="inputs">
            <div id="1">
                <label>First Name:</label>
                <br>
                <input type="text" name="fname"
                id="name" placeholder="Enter Your First Name" required>
                <br>
            </div>
            <div id="2">
                <label>Last Name:</label>
                <br>
                <input type="text" name="lname" id="name" placeholder="Enter Your Last Name" required>
                <br>
            </div>
            <div id="3">
                <label>D.O.B</label>
                <br>
                <input type="date" name="dob" id="name" value="" min="1990-01-01" max="2023-12-31" placeholder="Date Of Birth" required>
                <br>
            </div>
            <div id="4">
                <label>Your Age:</label>
                <br>
                <input type="number" name="age"id="name"placeholder="age" required>
                <br>
            </div>
            <div id="5">
                <label>Email:</label>
                <br>
                <input type="email" name="email"id="name"placeholder="Enter your valid Email" required>
                <br>
            </div>
            <div id="6">
                <label>Mobile no.:</label>
                <br>
                <input type="number" placeholder="**********" name="phone"id="name" required>
                <br>
            </div>
            <div id="7">
                <label>Password:</label>
                <br>
                <input type="text" placeholder="password" name="password"id="name" required>
                <br>
                
            </div>
            <div id="8">
                <label>Confirm Password:</label>
                <br>
                <input type ="password" placeholder=" confirm password"name="co-password"id="name" required>
            </div>
            </div>
            <br>
            <div id="9">
                <label>Gender :   </label>
            
                <input type="radio"name="gender" value="male"id="male" required>
                <span id="male">Male</span>
                <input type="radio" name="gender" value="female" id="female">
                <span  id="female">Female</span>
            
            </div>
        <div class="center">
            <input type="submit" value="SUBMIT"id="submit">
        </div>
        <div class="center" style="font-size: 15px;">
        <a href="login.jsp" >Login here</a>
        </div>
        </form>
    </div><!--end register-->
    </div><!--end main-->
</body>
</html>