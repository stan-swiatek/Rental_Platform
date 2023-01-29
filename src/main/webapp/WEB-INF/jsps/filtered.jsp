<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filtered Products</title>
</head>
<body>

	<br/>
	<br/>
	
	<form action="/filtered" method="post">
		<input type="text" name="filter"/>
		<input type="submit" value="Filter"/>
	</form>
	<h3>Filtered Products</h3>
	<table>
		<tr>
			<td>ID</td>
			<th>Name</th>
			<th>Category</th>
			<th>Type</th>
			<th>Color</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${filterProducts}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.category}</td>
				<td>${product.type}</td>
				<td>${product.color}</td>
				<td>${product.price}</td>
				<td><a href="/product/${product.id}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>