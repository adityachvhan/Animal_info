<%@page import="com.jspiders.springmvc.pojo.AnimalPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<AnimalPOJO> animals = (List<AnimalPOJO>) request.getAttribute("Animal");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animal Info Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<div class="text-center mb-4">
			<h1>Welcome to the Animal Info Application</h1>
		</div>

		<div class="mb-3">
			<a href="./add" class="btn btn-primary">Add New Animal</a>
		</div>

		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Category</th>
					<th>Image</th>
					<th>Description</th>
					<th>Life Expectancy</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (animals != null) {
					for (AnimalPOJO pojo : animals) {
				%>
				<tr>
					<td><%=pojo.getId()%></td>
					<td><%=pojo.getName()%></td>
					<td><%=pojo.getCategory()%></td>
					<td><img src="<%=pojo.getImage()%>" alt="<%=pojo.getName()%>"
						class="img-thumbnail" style="max-width: 100px;"></td>
					<td><%=pojo.getDescription()%></td>
					<td><%=pojo.getLifeExpectancy()%></td>
					<td><a class="btn btn-success" href="./edit/<%=pojo.getId()%>">Edit</a></td>
					<td><a class="btn btn-danger"
						href="./remove/<%=pojo.getId()%>">Delete</a></td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="8" class="text-center">No animals found</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>
