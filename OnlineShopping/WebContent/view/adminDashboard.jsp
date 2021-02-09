<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body style="height: 100vh;">
	<jsp:include page="navbar.jsp"></jsp:include>
	<br>
	<div class="container-fluid">
		<div class="row h-25">
			<div class="col m-4">
				<div class="card" style="background-color:#ff0000 ">
					<div class="card-body">
						<h2>4000</h2>
						<h3>Current Customer</h3>
					</div>
					<div class="card-footer">
						<a href="#">go to customers</a>

					</div>
				</div>
			</div>
			<div class="col m-4">
				<div class="card">
					<div class="card-body">
						<h2>8000</h2>
						<h3>Orders</h3>
					</div>
					<div class="card-footer">
						<a href="#">go to customers</a>

					</div>
				</div>
			</div>
			<div class="col m-4">
				<div class="card">
					<div class="card-body">
						<h2>10</h2>
						<h3>Category</h3>
					</div>
					<div class="card-footer">
						<a href="#">go to customers</a>

					</div>
				</div>
			</div>
			<div class="col m-4">
				<div class="card">
					<div class="card-body">
						<h2>1500</h2>
						<h3>Products</h3>
					</div>
					<div class="card-footer">
						<a href="#">go to customers</a>

					</div>
				</div>
			</div>
		</div>
		<div class="row h-75">
			<div class="col-7">
				<div class="jumbotron">
					<h1>Sales chart</h1>
				</div>
			</div>
			<div class="col-5">
				<div class="jumbotron">
					<h1>WebSite Statistic</h1>
				</div>
			</div>
		</div>
	</div>
</body>
</html>