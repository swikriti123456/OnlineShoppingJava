<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% if(session.getAttribute("successMsg")!=null){ %>
<div class="alert alert-success alert-dismissible fade show" role="alert">
	<strong>Success!</strong><%= session.getAttribute("successMsg")%>
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>

<% session.removeAttribute("successMsg"); } %>


<% if(session.getAttribute("errorMsg")!=null){ %>
<div class="alert alert-danger alert-dismissible fade show" role="alert">
	<strong>Error!</strong><%= session.getAttribute("errorMsg")%>
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>

<% session.removeAttribute("errorMsg"); } %>

<% if(session.getAttribute("warningMsg")!=null){ %>
<div class="alert alert-warning alert-dismissible fade show" role="alert">
	<strong>warning!</strong><%= session.getAttribute("warningMsg")%>
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>

<% session.removeAttribute("warningMsg"); } %>