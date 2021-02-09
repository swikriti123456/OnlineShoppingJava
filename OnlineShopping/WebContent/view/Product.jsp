<%@ page language="java" import="com.model.Product,java.util.List"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<%
		if (session.getAttribute("user") == null)
			response.sendRedirect("home");
	%>
	<div class="row">
		<%
			List<Product> list = (List<Product>) request.getAttribute("plist");
			if (list != null) {
				for (Product p : list) {
		%>
		<div class="col-md-3 ">
			<div class="card p-1 style=height:25rem;width:25rem">
				<img style="height: 310px; width: 310px"
					src="resources/image/<%=p.getImage()%>" class="card-img-top "
					alt="<%=p.getpName()%>">
				<div class="card-body">
					<h5 class="card-title"><%=p.getpName()%></h5>
					<p>
						price:
						<%=p.getPrice()%></p>
					<div class="row">
						<div class="col">
							<a href="productDetails?pid=<%=p.getPid()%>"
								class="btn btn-info btn-block stretched-link">Details</a>
						</div>
						<div class="col">
							<a href="addToCart?pid=<%=p.getPid()%>&qty=1"
								class="btn btn-success btn-block">Add To Cart</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%
			}
			} else {
		%>
		<h2>no list.........</h2>
		<%
			}
		%>
	</div>
</body>
</html>