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
            <a href="/UserProfile">Back to your profile</a>
        </div>
      </div>
    </header>
    <main class="main">
      <div class="log-name">Edit Your Details</div>
        <div class="main-row">
        <div class="log-name-block">
          <div class="log-name-block-main">
            <form action="/editUserDetails" method="POST">
              <label for="email">Enter your email:</label><br>
              <input 
                type="email" 
                id="email" 
                name="email"
                class="second"
                value="${user.email}"
                
                
                placeholder="type here..."
              ><br>
              <label for="email">Enter your phone number:</label><br>
              <input 
                type="text" 
                id="phoneNumber" 
                name="phoneNumber"
                class="second"
                value="${user.phoneNumber}"
                
                placeholder="type here..."
              ><br>
              <label for="firstName">Name:</label><br>
              <input 
              	type="text"
              	id="firstName" 
				name="firstName" 
				class="second"
				value="${user.firstName}"
				
				placeholder="Name"
			  ><br>
			  <label for="surName">Surname:</label><br>
			  <input
			  	id="surName" 
			  	class="second"
			  	type="text"
				name="surName"
				value="${user.surName}" 
				
				placeholder="Surname"
			  ><br>	 
			  <div class="register-button">
           		<input type="submit" value="Save changes">
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
        <%@ include file ="footerBar.jsp" %>
    </footer>
  </div>
</body>
</html>