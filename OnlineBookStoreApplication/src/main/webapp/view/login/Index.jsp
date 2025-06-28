<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ProductDao" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.*" %>
<%@ page import="registration.LoginServlet" %>
<%@ page import="dao.UserDao" %>
<%@ page import="model.User" %>

<%
	ProductDao pd = new ProductDao();
	List<Product> books = pd.getAllProduts();
	User user = (User)(session.getAttribute("auth"));
	List<Product> pr = (List<Product>)session.getAttribute("productRem");
	request.getAttribute("searchValue");
	if(pr != null  && request.getAttribute("searchValue") == "true") {
		books = pr;
	}
	if(user == null) {
		response.sendRedirect("/OnlineBookStoreApplication/view/login/Login.jsp");
		return;
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Online Bookstore</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">

	<style>
		* {
			box-sizing: border-box;
			margin: 0;
			padding: 0;
			font-family: 'Poppins', sans-serif;
		}

		body {
			background-color: #f4f6f8;
			color: #333;
		}

		header {
			background-color: #3b3b98;
			color: #fff;
			padding: 1.5rem 2rem;
			text-align: center;
			box-shadow: 0 2px 4px rgba(0,0,0,0.1);
		}

		nav {
			display: flex;
			flex-wrap: wrap;
			align-items: center;
			justify-content: space-between;
			background-color: #6c5ce7;
			padding: 0.8rem 2rem;
			color: white;
		}

		nav a {
			color: white;
			text-decoration: none;
			padding: 0.5rem 1rem;
			border-radius: 5px;
			transition: background 0.3s ease;
		}

		nav a:hover {
			background-color: #4b4baf;
		}

		.search-container {
			display: flex;
			align-items: center;
			background-color: white;
			padding: 6px 10px;
			border-radius: 8px;
			box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
			width: 300px;
		}

		.searchbar {
			border: none;
			outline: none;
			flex: 1;
			font-size: 15px;
			padding: 6px;
		}

		.voice-button {
			background-color: #3b3b98;
			color: white;
			border: none;
			border-radius: 50%;
			width: 36px;
			height: 36px;
			display: flex;
			align-items: center;
			justify-content: center;
			cursor: pointer;
			transition: background 0.3s ease;
		}

		.voice-button:hover {
			background-color: #2b2b8c;
		}

		.container {
			padding: 2rem;
		}

		h2 {
			text-align: center;
			margin-bottom: 2rem;
			color: #3b3b98;
		}

		.featured-books {
			display: grid;
			grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
			gap: 1.5rem;
		}

		.book {
			background: #fff;
			border-radius: 10px;
			box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
			padding: 1rem;
			text-align: center;
			transition: transform 0.3s ease;
		}

		.book:hover {
			transform: translateY(-5px);
		}

		.book img {
			width: 100%;
			max-height: 180px;
			object-fit: contain;
			margin-bottom: 1rem;
		}

		.book h3 {
			font-size: 18px;
			margin-bottom: 0.5rem;
			color: #3b3b98;
		}

		.book p {
			margin: 4px 0;
			font-size: 14px;
		}

		.book form {
			margin-top: 10px;
		}

		.book button {
			background-color: #3b3b98;
			color: white;
			border: none;
			padding: 8px 16px;
			border-radius: 6px;
			cursor: pointer;
			transition: backgroun	d 0.3s ease;
		}

		.book button:hover {
			background-color: #2f2f80;
		}

		footer {
			text-align: center;
			background-color: #3b3b98;
			color: white;
			padding: 1rem;
			margin-top: 2rem;
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
		
		
		/* Dropdown Categories */
.dropdown {
	position: relative;
	display: inline-block;
	margin: 8px;
}

.nav-link {
	color: white;
	text-decoration: none;
	padding: 0.5rem 1rem;
	border-radius: 6px;
	background-color: transparent;
	font-weight: 500;
	transition: background-color 0.3s ease;
	cursor: pointer;
}

.nav-link:hover {
	background-color: #4b4baf;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #fff;
	min-width: 180px;
	box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.15);
	border-radius: 10px;
	overflow: hidden;
	z-index: 1000;
	top: 110%;
	left: 0;
	animation: fadeIn 0.2s ease-in-out;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown-content button {
	background: none;
	border: none;
	width: 100%;
	text-align: left;
	padding: 12px 20px;
	font-size: 15px;
	font-weight: 500;
	color: #3b3b98;
	cursor: pointer;
	transition: background 0.3s ease;
}

.dropdown-content button:hover {
	background-color: #f0f0ff;
	color: #2f2f80;
}



@keyframes fadeOut {
    to {
        opacity: 0;
        transform: translateX(-50%) translateY(-20px);
        visibility: hidden;
    }
}
		
	</style>
</head>
<body>
	<%
	String cart = (String)session.getAttribute("cart");
	boolean showCartMessage = false;
	if(cart != null){
		showCartMessage = true;
		session.removeAttribute("cart");
	}
	%>
	<% if(showCartMessage) { %>
		<div id="cartMessage" class="notification">
    		Product successfully added to Cart
		</div>
	<% } %>
	<header>
		<h1>Welcome to the Online Bookstore</h1>
	</header>

	<nav>
		<div style="display: flex; gap: 15px;">
			
			<form action="/OnlineBookStoreApplication/CategoryServlet" method = "post">
				<div class="dropdown">
				<a href="#" class="nav-link">Categories</a>
				<div class="dropdown-content">
					<button type="submit" name="category" value="Love">Love</button>
					<button type="submit" name="category" value="Action">Action</button>
					<button type="submit" name="category" value="Romance">Romance</button>
					<button type="submit" name="category" value="Comedy">Comedy</button>
					<button type="submit" name="category" value="Comics">Comics</button>
					<button type="submit" name="category" value="Adventure">Adventure</button>
					<button type="submit" name="category" value="manga">Manga</button>
				</div>
			</div>
			</form>
		</div>
		<div class="search-container">
			<form action="/OnlineBookStoreApplication/SearchingServlet" method="post" style="display: flex; width: 100%;">
				<input type="search" class="searchbar" id="searchInput" placeholder="Search books..." name="value">
				<button type="button" class="voice-button" onclick="startVoiceSearch()">🎙️</button>
			</form>
		</div>
		<a href="/OnlineBookStoreApplication/view/cart/CartJsp.jsp">Cart</a>
		<a href="/OnlineBookStoreApplication/view/login/UserDetails.jsp"><%=user.getName()%></a>
	</nav>

	<div class="container">
		<h2>Featured Books</h2>
		<div class="featured-books">
			<%
				if(!books.isEmpty()) {
					for(Product b : books) {
			%>
			<div class="book">
				<form action="/OnlineBookStoreApplication/BookDetailsServlet" method = "post">
						<input type="hidden" name="bookId" value="<%= b.getId() %>">
						<input type="hidden" name="userName" value="<%=user.getName() %>">
						<input type="hidden" name="userID" value="<%=user.getId() %>">
					<button>
						<img src="/OnlineBookStoreApplication/<%=b.getImageLink()%>" alt="<%=b.getBookName()%>">
					</button>
				</form>
				<h3><%=b.getBookName()%></h3>
				<p>Author: <%=b.getAuthorName()%></p>
				<p>Price: ₹<%=b.getPrice()%></p>
				<p>Category: <%=b.getCategory()%></p>
				<form action="/OnlineBookStoreApplication/CartServlet" method="POST">
					<input type="hidden" name="bookId" value="<%= b.getId() %>">
					<input type="hidden" name="userName" value="<%=user.getName() %>">
					<input type="hidden" name="userID" value="<%=user.getId() %>">
					<button type="submit">Add to Cart</button>
				</form>
			</div>
			<%
					}
				} else {
			%>
			<p>No books available at the moment.</p>
			<%
				}
			%>
		</div>
	</div>

	<footer>
		<p>&copy; 2025 Online Bookstore. All rights reserved.</p>
	</footer>

	<script>
		function startVoiceSearch() {
			const recognition = new (window.SpeechRecognition || window.webkitSpeechRecognition)();
			recognition.lang = 'en-US';
			recognition.onstart = function () {
				alert("Please speak your search query...");
			};
			recognition.onresult = function (event) {
				const transcript = event.results[0][0].transcript;
				document.getElementById("searchInput").value = transcript;
			};
			recognition.onerror = function (event) {
				alert("Error capturing voice: " + event.error);
			};
			recognition.start();
		}
	</script>
	<script>
    setTimeout(() => {
        const msg = document.getElementById('cartMessage');
        if (msg) msg.remove();
    }, 5000);
</script>
</body>
</html>
