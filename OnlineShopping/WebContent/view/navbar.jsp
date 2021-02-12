<%@ page language="java" import="java.util.*,com.model.User" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%!User u;%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="home">Online shop</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<%
				if (session.getAttribute("user") != null) {

					 u = (User) session.getAttribute("user");
					if (u.getRole().equals("user")) {
			%>
			<li class="nav-item"><a class="nav-link" href="home">Home <span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="category">Category</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="product">Product</a>
			</li>
			<%
				} else if (u.getRole().equals("admin")) {
			%>
			<li class="nav-item"><a class="nav-link" href="adminHome">Home <span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="adminCategory">Category</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="adminProduct">Product</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="adminCustomer">Customers</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="adminOrder">Order</a>
			</li>

			<%
				}
				}
			%>
		</ul>
		<ul class="navbar-nav ml-auto">
			<%
				if (session.getAttribute("user") == null) {
			%>
			<li class="nav-item"><a class="nav-link" href="login">Signin</a></li>
			<li class="nav-item"><a class="nav-link" href="registeration2">SignUp</a></li>
			<%
				} else {
					
					if(u.getRole().equals("user")){
			%>
				<li class="nav-item"><a class="nav-link" href="viewCart">Cart

				 <%
				if (session.getAttribute("cart") != null) {
						out.print("<span class='badge badge-light'>"
								+ ((HashMap<Integer, Integer>) session.getAttribute("cart")).size() + "</span>");
					}
			%>
		
			</a></li><%} %>

			<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
			</li>
			<%
				}
			%>
		</ul>
	</div>
</nav>