<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
    // Retrieve the user object from the session or request
     response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0");
    User user = (User) session.getAttribute("auth"); // Replace "auth" with your session attribute key
	System.out.println(user);
    if (user == null) {
        response.sendRedirect("/OnlineBookStoreApplication/view/login/Login.jsp");
        return;
    }
    User cancelAuth = (User)session.getAttribute("cancelAuth");
    if(cancelAuth == null)
    {
    	System.out.println("comes");
    }
   
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #343a40;
            color: white;
            padding: 1rem;
            text-align: center;
        }
        .container {
            margin: 2rem auto;
            padding: 1rem;
            max-width: 600px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .user-details {
            line-height: 1.8;
        }
        .user-details span {
            font-weight: bold;
        }
        .logout-btn {
            display: block;
            margin-top: 1.5rem;
            text-align: center;
        }
        .logout-btn button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 0.5rem 1rem;
            border-radius: 5px;
            cursor: pointer;
        }
        .logout-btn button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <header>
        <h1>User Details</h1>
    </header>
    <div class="container">
        <div class="user-details">
            <p><span>ID:</span> <%= user.getId() %></p>
            <p><span>User ID:</span> <%= user.getUserID() %></p>
            <p><span>Name:</span> <%= user.getName() %></p>
            <p><span>Place:</span> <%= user.getPlace() %></p>
            <p><span>Post:</span> <%= user.getPost() %></p>
            <p><span>District:</span> <%= user.getDistrict() %></p>
            <p><span>Country Code:</span> <%= user.getCounrtyCode() %></p>
            <p><span>Role:</span> <%= user.getRole() %></p>
            <p><span>Mobile Number:</span> <%= user.getMobileNumber() %></p>
            <p><span>Pin Code:</span> <%= user.getPinCode() %></p>
        </div>
        <div class="logout-btn">
            <form action="/OnlineBookStoreApplication/LogoutServlet" method="POST">
                <button type="submit">Logout</button>
            </form>
        </div>
    </div>
</body>
</html>
