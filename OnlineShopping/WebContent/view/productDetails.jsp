<%@ page language="java" import="com.model.Product"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product details</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<%
		if (session.getAttribute("user") == null)
			response.sendRedirect("home");
	%>
	<%
		Product p = (Product) request.getAttribute("product");
		if (p != null) {
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-5  ">
				<img src="resources/image/<%=p.getImage()%>"
					class="img-thumbnasil w-100 shadow-lg ">
			</div>

			<div class="col-md-7 shadow-lg bg-light">
				<h3 class="text-uppercase"><%=p.getpName()%></h3>
				<h5>
					Price:- &#8377;<%=p.getPrice()%></h5>
				<form>
					<input type="hidden" value="<%=p.getPid()%>" name="pid">
					<%
						if (p.getQty() <= 0) {
								out.print("<h4 class='text-danger'>out of stock</h4>");
					%>
					<%
						} else {
					%>
					<h5>QTY:-</h5>
					<select name="qty">
						<%
							int qty = p.getQty() > 9 ? 9 : p.getQty();
									for (int i = 1; i <= p.getQty(); i++) {
						%>
						<option value="<%=i%>"><%=i%></option>
						<%
							}
								}
						%>

					</select>
					<button formaction="addToCart" class="btn btn-info btn-block">Add
						to cart</button>
					<hr>
					<button formaction="billing" class="btn btn-info btn-block">Buy
						Now</button>
				</form>
			</div>
		</div>

		<div class="shadow-lg bg-light">
			<p><%=p.getDescription()%></p>
		</div>
	</div>
	<%
		} else {
	%>
	<h5>no list</h5>
	<%
		}
	%>
</body>
</html>