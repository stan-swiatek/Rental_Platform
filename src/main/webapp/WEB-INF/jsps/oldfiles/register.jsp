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
			<label for="username">User name:</label>
			<input type="text" name="username" placeholder="User name">
		</div>
		<div>
			<label for="password">Password:</label>
			<input type="password" name="password" placeholder="Password">	
		</div>
		<div>
			<label for="firstName">First name:</label>
			<input type="text" name="firstName" placeholder="First name">	
		</div>
		<div>
			<label for="surName">Surname:</label>
			<input type="text" name="surName" placeholder="Surname">	
		</div>
		<div>
			<label for="email">Email:</label>
			<input type="text" name="email" placeholder="Email">	
		</div>
		<input type="submit" value="Register">
	</form>
</body>
</html>