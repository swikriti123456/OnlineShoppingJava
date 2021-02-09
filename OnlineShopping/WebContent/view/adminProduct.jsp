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
	<%
		List<category> clist = (List<category>) request.getAttribute("clist");
		if (clist != null) {
	%>
	<br>
	<div class="container">
	
		<button type="button" class="btn btn-success" data-toggle="modal"
			data-target="#addProduct">Add Product</button>
			
			<jsp:include page="alerts.jsp"></jsp:include>
			
		<div class="modal fade" id="addProduct" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<form action="addProduct" method="post">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<!-- form start -->
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="inputname">Product Name</label> <input type="text"
											class="form-control" id="inputname" name="inputname"
											placeholder="product name">
									</div>
									<div class="form-group col-md-6">
										<label for="inputPrice">Price</label> <input type="text"
											class="form-control" id="inputPrice" name="inputPrice" placeholder="price">
									</div>
								</div>
								<div class="form-group">
									<label for="inputQuantity">Quantity</label> <input type="text"
										class="form-control" id="inputQuantity" name="inputQuantity" placeholder="quantity">
								</div>
								<div class="form-group">
									<label for="cid">CName</label> <select id="cid" name="cid"
										class="form-control">
										<%
											for (category c : clist) {
										%>
										<option value="<%=c.getcId()%>"><%=c.getcName()%></option>
										<%
											}
											}
										%>
									</select>

								</div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="inputBrandName">Brand Name</label> <input
											type="text" class="form-control" name="inputBrandName" id="inputBrandName">
									</div>
									<div class="form-group col-md-6">
										<label for="inputSubCateg">SubCategory</label><input
											type="text" class="form-control" name="inputSubCateg" id="inputSubCateg">
									</div>
									</div>
									<div class="form-row">
									<div class="form-group col-md-12 ">
										<label for="inputDesc">Description</label> <textarea rows="5"
											class="form-control" id="inputDesc" name="inputDesc"></textarea>
									</div>
								
								</div>
								<div class="form-row">
									<div class="form-group col-md-8">
										<label for="inputImage">ImageUrl</label> <input type="text"
											class="form-control" name="inputImage" id="inputImage">
									</div>
									<div class="form-group col-md-4">
										<label for="inputWeight">Weight</label> <input type="text"
											class="form-control" name="inputWeight" id="inputWeight">
									</div>
								</div>

								<!-- form end -->
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Add
									Product</button>
							</div>
					</form>
				</div>
			</div>
		</div>
		<%
			List<Product> list = (List<Product>) request.getAttribute("plist");
			if (list != null) {
		%>
		<table class="table table-bordered" id="myDataTable">
			<thead>
				<tr>
					<th scope="col">Image</th>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Brand Name</th>
					<th scope="col">Sub-Category</th>
					<th scope="col">Description</th>
					<th scope="col">weight</th>
					<th scope="col">Modify</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Product p : list) {
				%>
				<tr>
					<td><img style="height: 75px; width: 75px"
						src="resources/image/<%=p.getImage()%>"></td>
					<td><%=p.getpName()%></td>
					<td><%=p.getPrice()%></td>
					<td><%=p.getQty()%></td>
					<td><%=p.getBrandName()%></td>
					<td><%=p.getSubCategory()%></td>
					<td><%=p.getDescription()%></td>
					<td><%=p.getWeight()%></td>

					<td><a href="editProduct?pid=<%=p.getPid()%>"
						class="btn btn-info">edit</a>/<a
						href="deleteProduct?pid=<%=p.getPid()%>" class="btn btn-danger"
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