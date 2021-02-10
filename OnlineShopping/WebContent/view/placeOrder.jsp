<%@ page language="java" import="com.model.Product,com.model.user,java.util.List"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view cart</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<%!double totAmt = 0; %>
	<%!user u; %>
	<%
		if (session.getAttribute("user") == null) {
			response.sendRedirect("home");
		}else{
			u=(user)session.getAttribute("user");
		}
	%>
	<jsp:include page="navbar.jsp"></jsp:include>
	<br>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-8">
			<div class="bg-light shadow-lg mx-2 p-5"><h2 class="text-uppercase"><%=u.getFirstName() %> <%=u.getLastName() %></h2></div>
			<div class="bg-light shadow-lg mx-2 p-5"><h4>Deliver At:-</h4>
			<%= u.getAddress()%></div>
			<div class="bg-light shadow-lg mx-2 p-5">
				<ul class="list-unstyled">
			<%
				List<Product> plist = (List<Product>) request.getAttribute("list");
				
				if (plist != null)
					for (Product p : plist) {
						totAmt += p.getPrice() * p.getQty();
			%>

			<li class="media mt-2">
					<img class="mr-3" style="height:75px;width:75px" src="resources/image/<%=p.getImage()%>"
						alt="<%=p.getpName()%>">
					<div class="media-body">
						<h5 class="mt-0"><%=p.getpName()%></h5>
						PRICE:-<%=p.getPrice()%>
						<br> QTY:-<%=p.getQty()%>
						<br> Total:-<%=p.getPrice() * p.getQty()%>
					</div>
			</li>
			<%}%>
		</ul>
			</div>
		</div>
		<div class="col-md-4">
			<div class="bg-light shadow-lg mx-2 p-5 h-50">total</div>
		</div>
	</div>
	<div class="shadow-lg bg-light p-4">
		
		<h3>
			Total Amount:-<%=totAmt%></h3>
	<a href="confirmOrder" style="width:65rem; margin-left: 30px;" class="btn btn-outline-primary">Confirm Order</a>
	</div>
	</div>
	
</body>
</html>