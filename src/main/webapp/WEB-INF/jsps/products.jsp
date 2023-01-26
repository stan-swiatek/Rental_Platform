<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<h3>Products to rent:</h3>

	<form action="/products" method="POST">
		<div>
			<label for="productName">Product name:</label>
			<input type="text" name="productName" placeholder="Product name">
		</div>
			<input type="submit" value="Save">
	</form>
</body>
</html>