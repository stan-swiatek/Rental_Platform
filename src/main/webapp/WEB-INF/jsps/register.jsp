<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h3>Register new account</h3>

	<form action="/register" method="POST">
		<div>
			<label for="username">User name:</label> <input type="text"
				name="username" placeholder="User name">
		</div>
		<div>
			<label for="password">Password:</label> <input type="password"
				name="password" placeholder="Password">
		</div>
		<div>
			<label for="email">Email:</label> <input type="text" name="email"
				placeholder="Email">
		</div>
		<div>
			<label for="firstName">Name:</label> <input type="text"
				name="firstName" placeholder="Name">
		</div>
		<div>
			<label for="surName">Surname:</label> <input type="text"
				name="surName" placeholder="Surname">
		</div>
		<div>
			<label for="street">Street:</label> <input type="text" name="street"
				placeholder="Street">
		</div>
		<div>
			<label for="city">City:</label> <input type="text" name="city"
				placeholder="City">
		</div>
		<div>
			<label for="postalCode">Postal Code:</label> <input type="text"
				name="postalCode" placeholder="Postal Code">
		</div>
		<div>
			<label for="buildingNumber">Building Number:</label> <input
				type="text" name="buildingNumber" placeholder="Building Number">
		</div>
		<div>
			<label for="flatNumber">Flat Number:</label> <input type="text"
				name="flatNumber" placeholder="Flat Number">
		</div>
		<input type="submit" value="Register">
	</form>
</body>
</html>