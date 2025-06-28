<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="dao.ProductDao" %>
<%@ page import="model.Product" %>

<%
    User user = (User) session.getAttribute("auth");
    if (user == null) {
        response.sendRedirect("/OnlineBookStoreApplication/view/login/Login.jsp");
        return;
    }
    String id = (String)session.getAttribute("bookDetails");
    if (id == null) {
        return;
    }
    int bookID = Integer.parseInt(id);
    ProductDao pd = new ProductDao();
    Product book = pd.getSingeProduct(bookID);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><%=book.getBookName()%> - Book Details</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f8;
            color: #333;
            padding: 2rem;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            display: flex;
            background-color: #fff;
            padding: 2rem;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            max-width: 800px;
            width: 100%;
            gap: 2rem;
            flex-wrap: wrap;
        }

        .imgContainer {
            flex: 1;
            min-width: 250px;
        }

        .imgContainer img {
            width: 100%;
            height: auto;
            border-radius: 10px;
            object-fit: cover;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        .details {
            flex: 2;
        }

        .details h3 {
            font-size: 24px;
            color: #007bff;
            margin-bottom: 1rem;
        }

        .details p {
            font-size: 18px;
            margin-bottom: 0.7rem;
            line-height: 1.6;
        }

        .btn {
            padding: 0.7rem 1.5rem;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 1rem;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        @media (max-width: 600px) {
            .container {
                flex-direction: column;
                padding: 1rem;
            }

            .details h3 {
                font-size: 20px;
            }

            .details p {
                font-size: 16px;
            }
        }
        .notification {
    		position: fixed;
    		top: 20px;
    		left: 50%;
    		transform: translateX(-50%);
		    background-color: #4BB543;
		    color: white;
		    padding: 15px 30px;
		    border-radius: 8px;
		    font-weight: 600;
		    box-shadow: 0 4px 8px rgba(0,0,0,0.2);
		    z-index: 999;
		    animation: fadeOut 0.5s ease-in-out 4.5s forwards;
		}

@keyframes fadeOut {
    to {
        opacity: 0;
        transform: translateX(-50%) translateY(-20px);
        visibility: hidden;
    }
    </style>
</head>
<body>
	<%
		String cart = (String)(session.getAttribute("cartAdd"));
		boolean showCartMessage = false;
		if(cart != null){
			showCartMessage = true;
			session.removeAttribute("cartAdd");
		}
	%>
	<% if(showCartMessage) { %>
		<div id="cartMessage" class="notification">
    		Product successfully added to Cart
		</div>
	<% } %>
<div class="container">
    <div class="imgContainer">
        <img src="<%=book.getImageLink()%>" alt="<%=book.getBookName()%>">
    </div>
    <div class="details">
        <h3><%=book.getBookName()%></h3>
        <p><strong>Author:</strong> <%=book.getAuthorName()%></p>
        <p><strong>Price:</strong> ₹<%=book.getPrice()%></p>
        <p><strong>Category:</strong> <%=book.getCategory()%></p>
        <p><strong>Description:</strong> No description available.</p>
        <form action="/OnlineBookStoreApplication/BookDetailsCart" method="POST">
            <input type="hidden" name="bookId" value="<%=book.getId()%>">
            <input type="hidden" name="userName" value="<%=user.getName()%>">
            <input type="hidden" name="userID" value="<%=user.getId()%>">
            <button type="submit" class="btn">Add to Cart</button>
        </form>
    </div>
</div>
<script>
    setTimeout(() => {
        const msg = document.getElementById('cartMessage');
        if (msg) msg.remove();
    }, 5000);
</script>
</body>
</html>
