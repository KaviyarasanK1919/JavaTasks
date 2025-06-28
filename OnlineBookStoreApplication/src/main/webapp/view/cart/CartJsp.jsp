<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.CartDao" %>
    <%@ page import="model.User" %>
    <%@ page import="java.util.*" %>
    <%@ page import="model.Product" %>
    <%
    	User user = (User) session.getAttribute("auth");
    	
  		 if (user == null) {
        	response.sendRedirect("/OnlineBookStoreApplication/view/login/Login.jsp");
        	return;
    	}
  		 CartDao c = new CartDao(); 
  		 List<Product> cartIdems = c.getAllCartIdems(user.getId());
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
  <style>
    body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.cart-container {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 400px;
}

.cart-container h1 {
    text-align: center;
    margin-bottom: 20px;
}

.cart-items {
    margin-bottom: 20px;
}

.cart-item {
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-bottom: 1px solid #ddd;
    padding: 10px 0;
}

.cart-item img {
    width: 50px;
    height: 50px;
    margin-right: 10px;
}

.item-details {
    flex-grow: 1;
}

.item-details h3 {
    margin: 0;
    font-size: 16px;
}

.item-details p {
    margin: 5px 0;
    color: #555;
}

.quantity {
    display: flex;
    align-items: center;
}

.quantity button {
    background-color: #007bff;
    color: #fff;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
    border-radius: 4px;
}

.quantity button:hover {
    background-color: #0056b3;
}

.quantity span {
    margin: 0 10px;
}

.remove-item {
    background-color: #dc3545;
    color: #fff;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
    border-radius: 4px;
}

.remove-item:hover {
    background-color: #c82333;
}

.cart-summary {
    border-top: 1px solid #ddd;
    padding-top: 20px;
}

.cart-summary h2 {
    margin: 0 0 10px;
    font-size: 18px;
}

.cart-summary p {
    margin: 5px 0;
}

.checkout-btn {
    background-color: #28a745;
    color: #fff;
    border: none;
    padding: 10px 20px;
    width: 100%;
    cursor: pointer;
    border-radius: 4px;
    font-size: 16px;
}

.checkout-btn:hover {
    background-color: #218838;
}
  </style>
</head>
<body>
    <div class="cart-container">
        <h1>Your Shopping Cart</h1>
        
        <div class="cart-items">
        <%
        int totalIdems = 0;
        int totalAmount = 0;
        for(Product i : cartIdems)
        {
        %>
            <div class="cart-item">
                <img src="/OnlineBookStoreApplication/<%=i.getImageLink()%>" alt="ji">
                <div class="item-details">
                    <h3><%=i.getBookName() %></h3>
                    <p>₹<%=i.getPrice() %></p>
                    <div class="quantity">
                    <form action="/OnlineBookStoreApplication/DecrementServlet" method = "post">
                    <input type = "hidden" name = "bookID" value = "<%= i.getId()%>">
                    <input type = "hidden" name = "userID" value = "<%= user.getId()%>">
                        <button class="decrement">-</button>
                        </form>
                        <span><%=i.getQuantity()  %></span>
                        <form action="/OnlineBookStoreApplication/IncrementServlet" method = "post">
                         <input type = "hidden" name = "bookID" value = "<%= i.getId()%>">
                    	 <input type = "hidden" name = "userID" value = "<%= user.getId()%>">
                        <button class="increment">+</button></form>
                    </div>
                </div>
                <form action="/OnlineBookStoreApplication/RemoveServlet" method = "post">
                 <input type = "hidden" name = "bookID" value = "<%= i.getId()%>">
                 <input type = "hidden" name = "userID" value = "<%= user.getId()%>">
                <button class="remove-item">Remove</button></form>
            </div>
            <%totalIdems++; totalAmount+= (i.getPrice() * i.getQuantity()); } %>
            
        <div class="cart-summary">
            <h2>Summary</h2>
            <p>Total Items: <%=totalIdems%></p>
            <p>Total Price: <%=totalAmount %></p>
            <button class="checkout-btn">Proceed to Checkout</button>
        </div>
    </div>
    </div>
</body>
</html>