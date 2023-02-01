<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h3>Log in to Rental Platform</h3>

	<form action="/login" method="post">
		<div>
			<label for="username">User name:</label>
			<input type="text" name="username" placeholder="User name">
		</div>
		<div>
			<label for="password">Password:</label>
			<input type="password" name="password" placeholder="Password">		
		</div>
		<input type="submit" value="Log in">
	</form>
	<div>
		Not with us yet? Register <a href="/register">here</a>
	</div>
</body>
</html>