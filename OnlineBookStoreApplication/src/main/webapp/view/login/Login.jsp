<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f3f4f6;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* Container */
.login-container {
    background-color: #fff;
    padding: 20px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    width: 100%;
    max-width: 400px;
    text-align: center;
}

/* Heading */
.login-container h1 {
    margin-bottom: 20px;
    font-size: 24px;
    color: #333;
}

/* Input Group */
.input-group {
    margin-bottom: 15px;
    text-align: left;
}

.input-group label {
    display: block;
    font-size: 14px;
    margin-bottom: 5px;
    color: #555;
}

.input-group input {
    width: 100%;
    padding: 10px;
    font-size: 1	4px;
    border: 1px solid #ccc;
    border-radius: 4px;
    outline: none;
}

.input-group input:focus {
    border-color: #007BFF;
}

/* Button */
.btn {
    display: inline-block;
    width: 100%;
    padding: 10px;
    font-size: 16px;
    color: #fff;
    background-color: #007BFF;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.btn:hover {
    background-color: #0056b3;
}

/* Signup Link */
.signup-link {
    margin-top: 15px;
    font-size: 14px;
    color: #666;
}

.signup-link a {
    color: #007BFF;
    text-decoration: none;
}

.signup-link a:hover {
    text-decoration: underline;
}
</style>
</head>
<body>

<div class="login-container">
        <h1>Login</h1> 
        <form action="/OnlineBookStoreApplication/LoginServlet" method="post">
            <div class="input-group">
                <label for="userID">Enter your UserID : </label>
                <input type="text" id="userID" name="userID" placeholder="Enter your userID" required>
            </div>
            <div class="input-group">
                <label for="password">Enter your password :</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <button type="submit" class="btn">Login</button>
            <p class="signup-link">Don't have an account? <a href="RegisterJsp.jsp">Sign up here</a>.</p>
        </form>
    </div>
</body>
</html>