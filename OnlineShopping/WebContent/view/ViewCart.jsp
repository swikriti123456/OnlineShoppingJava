<%@ page language="java" import="com.model.Item,java.util.List"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view cart</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>

	<%
		if (session.getAttribute("user") == null) {
			response.sendRedirect("home");
		}
	%>
	<jsp:include page="navbar.jsp"></jsp:include>
	<br>
	<div class="container">
		<ul class="list-unstyled">
			<%
				List<Item> ilist = (List<Item>) request.getAttribute("ilist");
				double totAmt = 0;
				if (ilist != null)
					for (Item item : ilist) {
						totAmt += item.getPrice() * item.getQty();
			%>

			<li class="list-group">
				<div class="media">
					<img class="mr-3" src="resources/image/<%=item.getImage()%>"
						alt="<%=item.getpName()%>">
					<div class="media-body">
						<h5 class="mt-0"><%=item.getpName()%><a class="close"
								href="removeFromCart?pid=<%=item.getPid()%>"><span
								aria-hidden="true">$times;</span></a>
						</h5>
						PRICE:-<%=item.getPrice()%>
						<br> QTY:-
						<%=item.getQty()%>
						<br> Total:-<%=item.getPrice() * item.getQty()%>
					</div>
				</div>
			</li>
			<%
				}
			%>
		</ul>
		<h3>
			Total Amount:-<%=totAmt%></h3>
	<a href="confirmOrder" class="btn btn-outline-info">Confirm Order</a>
	</div>
	
</body>
</html>