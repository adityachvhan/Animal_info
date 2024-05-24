<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f0f0f0;
}

h1, h2 {
	color: #333;
}

div {
	margin: 20px;
}

table {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #ddd;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f4f4f4;
}

a {
	text-decoration: none;
	color: #007BFF;
}

a:hover {
	text-decoration: underline;
}

form {
	width: 50%;
	margin: 20px auto;
	padding: 20px;
	border: 1px solid #ddd;
	background-color: #fff;
}

form div {
	margin-bottom: 15px;
}

form label {
	display: block;
	margin-bottom: 5px;
}

form input, form select, form textarea {
	width: 100%;
	padding: 10px;
	box-sizing: border-box;
}

form button {
	padding: 10px 20px;
	background-color: #007BFF;
	color: #fff;
	border: none;
	cursor: pointer;
}

form button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div align="center">
		<form action="add" method="post" enctype="multipart/form-data">
			<div>
				<label for="name">Name:</label> <input type="text" id="name"
					name="name">
			</div>
			<div>
				<label for="category">Category:</label> <select id="category"
					name="category">
					<option value="Mammal">Mammal</option>
					<option value="Bird">Bird</option>
					<option value="Fish">Fish</option>
					<option value="Wild">Wild</option>
				</select>
			</div>
			<div>
				<label for="image">Image:</label> <input type="file" id="image"
					name="imageFile">
			</div>
			<div>
				<label for="description">Description:</label>
				<textarea id="description" name="description"></textarea>
			</div>
			<div>
				<label for="lifeExpectancy">Life Expectancy:</label> <select
					id="lifeExpectancy" name="lifeExpectancy">
					<option value="2-5">2-5 years</option>
					<option value="5-10">5-10 years</option>
					<option value="10-20">10-20 years</option>
				</select>
			</div>
			<div>
				<label for="captcha">Captcha: 2 + 3 = ?</label> <input type="text"
					id="captcha" name="captcha">
			</div>
			<div>
				<button type="submit">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>