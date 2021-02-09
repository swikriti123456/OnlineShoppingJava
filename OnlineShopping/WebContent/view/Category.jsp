<%@ page language="java" import="com.model.category"
	import="java.util.List" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	
		
	<%
		if (session.getAttribute("user") == null) {
			response.sendRedirect("home");
		}
	%>
	<div class="row">
			<%
			List<category> list=(List<category>)request.getAttribute("clist");
			if(list != null){
				for (category c : list) {
			%>
			<div class="col-md-3">
				<div class="card" style="height: 20rem;">
					<img  src="resources/image/<%=c.getImage() %>"  class="card-img-top h-100" alt="<%= c.getcName()%>">
					<div class="card-body">
						<h5 class="card-title"><%=c.getcName() %></h5>
						
						<a href="product?cid=<%=c.getcId() %>" class="btn btn-primary btn-block">Show More</a>
					</div>
				</div>
			</div>
			<%
				} }
				else {
			%>
			
				<h1>No List.......</h1>
			<%} %>
		</div>
	</div>
</body>
</html>