<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="row justify-content-md-center mx-1">
		<div class="col-md-6">
			<div class="card">
				<div class="card-header ">
					<h3 class="text-center">Registration</h3>
				</div>
				<div class="card-body">
					<form method="post">
					<div class="form-group">
							<label for="fName">First Name</label> <input
								type="text" class="form-control" name="fName" id="fName"
								 placeholder="Enter first name">

						</div>
						<div class="form-group">
							<label for="lName">Last Name</label> <input
								type="text" class="form-control" name="lName" id="lName"
								 placeholder="Enter last Name">

						</div>
						<div class="form-group">
							<label for="address">Address</label> <input
								type="text" class="form-control" name="address" id="address"
								 placeholder="Enter address">

						</div>
						<div class="form-group">
							<label for="email1">Email address</label> <input
								type="email" class="form-control" name="email" id="email"
								 placeholder="Enter email">

						</div>
						<div class="form-group">
							<label for="mob">mobile no</label> <input
								type="text" class="form-control" name="mob" id="mob"
								 placeholder="Enter mobile number">

						</div>
						<div class="form-group">
							<label for="passwords">Password</label> <input
								type="password" name="password" class="form-control" id="password"
								placeholder="Password">
						</div>
						
						<button type="submit" class="btn btn-success btn-block">Register</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>