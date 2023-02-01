<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/style.css">
  <title>Shazar</title>
</head>
<body>
  <div class="wrapper">
    <header class="header">
      <div class="header-bar">
        <div class="header-a">
          <img class="logo" src="pngtree-vector-tyre-icon-png-image_1833985.png" alt="">
          <div class="header-bar-logo-name">Shazar</div>
        </div>
          <div class="header-bar-content">
            <a href="/">Back to main page</a>
          </div>
      </div>
    </header>
    <main class="main">
      <div class="log-name">Sign up</div>
        <div class="main-row">
        <div class="log-name-block">
          <div class="form-block-main">
            <form action="/register" method="POST" class="form">
            <div class=form-container>
            <div class="form-one">
              <label for="username">Create username:</label><br>
              <input 
                type="text" 
                id="username"
                name="username"
                class="first"
                placeholder="type here..."
              ><br>
              <label for="password">Create password:</label><br>
              <input 
                type="password"
                id="password"
                name="password"
                class="second"
                placeholder="type here..."
              ><br>
              <label for="email">Enter your email:</label><br>
              <input 
                type="email" 
                id="email" 
                name="email"
                class="second"
                placeholder="type here..."
              ><br>
              <label for="firstName">Name:</label><br>
              <input 
              	type="text"
              	id="firstName" 
				name="firstName" 
				class="second"
				placeholder="Name"
			  ><br>
			  <label for="surName">Surname:</label><br>
			  <input
			  	id="surName" 
			  	class="second"
			  	type="text"
				name="surName" 
				placeholder="Surname"
			  ><br>
			</div>
			<div class="form-two">
              <label for="street">Street:</label><br>
              <input 
              	id="surName" 
			  	class="second"
              	type="text" 
              	name="street"
				placeholder="Street"
			  ><br>
			  <label for="city">City:</label><br>
			  <input 
			  	id="city" 
			  	class="second"
			  	type="text" 
			  	name="city"
				placeholder="City"
			  ><br>
			  <label for="country">Country:</label><br>
			  <input 
			  	id="country" 
			  	class="second"
			  	type="text" 
			  	name="country"
				placeholder="Country"
			  ><br>
			  <label for="postalCode">Postal Code:</label><br>
			  <input 
			  	id="postalCode" 
			  	class="second"
			  	type="text"
				name="postalCode" 
				placeholder="Postal Code"
			  ><br>
			  <label for="buildingNumber">Building Number:</label><br>
			  <input
			  	id="buildingNumber" 
			  	class="second"
				type="text" 
				name="buildingNumber" 
				placeholder="Building Number"
			  ><br>
			  <label for="flatNumber">Flat Number:</label><br> 
			  <input 
			  	id="flatNumber" 
			  	class="second"
			  	type="text"
				name="flatNumber" 
				placeholder="Flat Number"
			  ><br>
			</div>
			</div>
			  <div class="register-button">
           		<input type="submit" value="Register">
          	  </div>
            </form>
          </div>
          <div class="check"> 
            <form>
              <input type="checkbox" id="remain" name="remain" value="remain">
              <label for="remain">Remain logged in</label><br>
            </form>
          </div>
        </div>
      </div>
  
    </main>
    <footer class="footer-contact-information">
        <div class="footer-contact-information-container">
          <div class="footer-contact-information-links-social-media">
              <a href="#">Home</a>
              <a href="#">Cart</a>
              <a href="/UserProfile">Personal</a>
              <a href="/Information">Information</a>
          </div>
        </div>
    </footer>
  </div>
</body>
</html>