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
	<div class="shadow-lg bg-light p-4">
		<ul class="list-unstyled">
			<%
				List<Item> ilist = (List<Item>) request.getAttribute("ilist");
				double totAmt = 0;
				if (ilist != null)
					for (Item item : ilist) {
						totAmt += item.getPrice() * item.getQty();
			%>

			<li class="media">
					<img class="mr-3" style="height:75px;width:75px" src="resources/image/<%=item.getImage()%>"
						alt="<%=item.getpName()%>">
					<div class="media-body">
						<h5 class="mt-0"><%=item.getpName()%><a
								href="removeFromCart?pid=<%=item.getPid()%>"class="close" aria-label="Close"><span aria-hidden="true">&times;</span></a>
						</h5>
						PRICE:-<%=item.getPrice()%>
						<br> QTY:-
						<%=item.getQty()%>
						<br> Total:-<%=item.getPrice() * item.getQty()%>
					</div>
			</li>
			<%
				}
			%>
		</ul>
		<h3>
			Total Amount:-<%=totAmt%></h3>
	<a href="confirmOrder" style="width:65rem; margin-left: 30px;" class="btn btn-outline-primary">Confirm Order</a>
	</div>
	</div>
	
</body>
</html>