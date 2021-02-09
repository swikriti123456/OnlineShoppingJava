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
	<div class="container">
	<a href="addToProduct" class="btn btn-success" >Add Product</a>
		<%
			List<Product> list = (List<Product>) request.getAttribute("plist");
			if (list != null) {
		%>
		<table class="table table-bordered table-dark">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
				</tr>
			</thead>
			<tbody>
<%
					for (Product p : list) {
				%>
				<tr>
				<td><img src="resources/image/<%=p.getImage()%>"></td>
				<td><%=p.getpName() %></td>
				<td><%=p.getPrice() %></td>
				<td><%=p.getQty() %></td>
				<td><a href="editProduct?pid=<%=p.getPid()%>" class="btn btn-info">edit</a>/<a href="deleteProduct?pid=<%=p.getPid()%>" class="btn btn-danger" onClick="return confirm('Are you sure?')">delete</a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			} else {
		%>
		<h2>no list.........</h2>
		<%
			}
		%>
	</div>
</body>
</html>