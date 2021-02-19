<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>verify</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class=" row justify-content-md-center h-100">
		<div class="col-md-4 h-100">
			<div class="align-middle card">
				<div class="card-header bg-primary">
					<h3 class="text-center">verify</h3>
				</div>
				<div class="card-body border-primary">
					<form  method="post">
						<div class="form-group">
							<label for="verify">Verification code</label> <input type="text"
								class="form-control" name="code" id="code"
								placeholder="Enter code">

							<button type="submit" class="btn btn-success btn-block">verify</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>