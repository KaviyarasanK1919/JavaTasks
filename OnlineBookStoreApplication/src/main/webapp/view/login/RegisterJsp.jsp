<%@page import="dbconnection.DBConnection"%>
<%@page import="java.sql.Connection"%> 
<%@page import="java.sql.PreparedStatement"%> 
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>	
<html>
<head>
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            padding: 20px;
        }
        form {
            max-width: 400px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        label {
            font-weight: bold;
            margin-top: 10px;
            display: block;
        }
        input, select, button {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2>Registration Form</h2>
    <%
    	if(request.getAttribute("message") == "This Mobile Number is Already Found."){%>
    	<script type="text/javascript">
			alert("<%=request.getAttribute("message")%>");
		</script>
	<%} %>
		<%
    	if(request.getAttribute("message") != null && request.getAttribute("message").toString().indexOf("Successfully") == 0){%>
    	<script type="text/javascript">
			alert("<%=request.getAttribute("message")%>");
			window.location.href = "view/login/Login.jsp";
		</script>
	<%} %>
    <form action="/OnlineBookStoreApplication/RegistrationServlet" method="post">
        <!-- Name -->
        <label for="name">Full Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter your full name" required>

        <!-- Country Code -->
        <label for="countryCode">Country Code:</label>
        <select id="countryCode" name="countryCode" required>
            <option value="+1">+1 (United States)</option>
            <option value="+91">+91 (India)</option>
            <option value="+44">+44 (United Kingdom)</option>
            <option value="+61">+61 (Australia)</option>
            <option value="+81">+81 (Japan)</option>
            <!-- Add more country codes as needed -->
        </select>

        <!-- Mobile Number -->
        <label for="mobileNumber">Mobile Number:</label>
        <input type="tel" id="mobileNumber" name="mobileNumber" placeholder="Enter your mobile number" required>
        
        <!-- Password -->
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>

        <!-- Place -->
        <label for="place">Place:</label>
        <input type="text" id="place" name="place" placeholder="Enter your place" required>

        <!-- Post -->
        <label for="post">Post:</label>
        <input type="text" id="post" name="post" placeholder="Enter your post" required>

        <!-- District -->
        <label for="district">District:</label>
        <input type="text" id="district" name="district" placeholder="Enter your district" required>
		<!-- Pin code -->
		<label for="pinCode">Pin Code:</label>
		<input type="number" id="pinCode" name="pinCode" placeholder="Enter your PinCode" required>
        <!-- Submit Button -->
        <button type="submit">Register</button>
    </form>
</body>
</html>
