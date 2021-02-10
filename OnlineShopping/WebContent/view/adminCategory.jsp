<%@ page language="java" import="com.model.*,java.util.List"
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

	<br>
	<div class="container">

		<button type="button" class="btn btn-success" data-toggle="modal"
			data-target="#addCategory">Add Category</button>

		<jsp:include page="alerts.jsp"></jsp:include>

		<div class="modal fade" id="addCategory" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<form action="addCategory" method="post">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Add Category</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<!-- form start -->
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputname">Category Name</label> <input type="text"
										class="form-control" id="inputname" name="inputname"
										placeholder="product name">


								</div>
								<div class="form-row">
									<div class="form-group col-md-8">
										<label for="inputImage">ImageUrl</label> <input type="text"
											class="form-control" name="inputImage" id="inputImage">
									</div>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
									<button type="submit" class="btn btn-primary">Add
										Category</button>
								</div>

							</div>
						</div>
					</form>
				</div>
			</div>
		</div><br>
		<table class="table table-bordered mt-4" id="myDataTable">
			<thead>
				<tr>
					<th scope="col">Image</th>
					<th scope="col">Name</th>
					<th scope="col">Modify</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<category> clist = (List<category>) request.getAttribute("clist");
					if (clist != null) {
						for (category c : clist) {
				%>
				<tr>
					<td><img style="height: 75px; width: 75px"
						src="resources/image/<%=c.getImage()%>"></td>
					<td><%=c.getcName()%></td>

					<td><a href="editProduct?pid=<%=c.getcId()%>"
						class="btn btn-info">edit</a>/<a
						href="deleteProduct?pid=<%=c.getcId()%>" class="btn btn-danger"
						onClick="return confirm('Are you sure?')">delete</a></td>
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