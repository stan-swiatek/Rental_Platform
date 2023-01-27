<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h3>Add new product to rent:</h3>

	<form action="addproduct" method="POST">
		<div>
			<label for="productName">Product name:</label>
			<input type="text" name="productName" placeholder="Product name">
		</div>
		<div>
			<label for="description">Description:</label>
			<input type="text" name="description" placeholder="Description">
		</div>
		<div>
			<label for="category">Category:</label>
			<input type="text" name="category" placeholder="Category">
		</div>
		<div>
			<label for="type">Type:</label>
			<input type="text" name="type" placeholder="Type">
		</div>
		<div>
			<label for="color">Color:</label>
			<input type="text" name="color" placeholder="Color">
		</div>		
		<div>
			<label for="price">Price:</label>
			<input type="number" name="price" placeholder="Price">
		</div>		
			<input type="submit" value="Save">
	</form>
</body>
</html>