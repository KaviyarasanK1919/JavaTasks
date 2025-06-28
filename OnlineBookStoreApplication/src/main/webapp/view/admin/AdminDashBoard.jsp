<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Functionalities</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
            color: #333;
        }
        .form-container {
            margin-bottom: 30px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .form-container h3 {
            margin-top: 0;
            color: #007BFF;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="number"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .header {
            text-align: center;
            margin-bottom: 30px;
        }
        .header h1 {
            color: #333;
        }
        .header p {
            color: #555;
        }
        .link-btn a{
        font-size: 20px;
        text-decoration: none;
        color:white;

        }
        
    </style>
</head>
<body>
	<% 
    if(request.getAttribute("message") == "This Book is not found.") { 
%>
    <script type="text/javascript">
        alert('<%=request.getAttribute("message")%>');
    </script>
<% 
    } else if(request.getAttribute("message") == "Sucessfully Removed.") { 
%>
    <script type="text/javascript">
        alert('<%=request.getAttribute("message")%>');
    </script>
<% 
    }
%>
)
    <div class="header">
        <h1>Admin Functionalities</h1>
        <p>Manage your book store with ease</p>
    </div>

    <!-- Add Book Form -->
    <div class="form-container">
        <h3>Add Book</h3>
        <form action="/OnlineBookStoreApplication/AddBookServlet" method="post">
            <label for="bookName">Book Name:</label>
            <input type="text" id="bookName" name="bookName" required>

            <label for="author">Author:</label>
            <input type="text" id="author" name="author" required>
			
			<label for="category">Category:</label>
            <input type="text" id="category" name="category" required>
            
            <label for="price">Price:</label>
            <input type="number" id="price" name="price" step="0.01" required>
			
			<label for="image">Image Name:</label>
            <input type="text" id="image" name="image" placeholder = "Type image name with extension" required>
            
            <button type="submit">Add Book</button>
        </form>
    </div>

    <!-- Remove Book Form -->
    <div class="form-container">
        <h3>Remove Book</h3>
        <form action="/OnlineBookStoreApplication/RemoveBookServlet" method="post">
            <label for="bookId">Book ID:</label>
            <input type="number" id="bookId" name="bookId" required>

            <button type="submit">Remove Book</button>
        </form>
    </div>

    <!-- Add Admin Form -->
    <div class="form-container">
        <h3>Add Admin</h3>
        <button type = "submit" class="link-btn"><a href = "view/login/RegisterJsp.jsp">Add</a></button>
    </div>

    <!-- View Book Store -->
    <div class="form-container">
        <h3>Book Store</h3>
            <button type="submit"> <a href = "view/login/Index.jsp">View All Books</a></button>
    </div>

</body>


</html>
