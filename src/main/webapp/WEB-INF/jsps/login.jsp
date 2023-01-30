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
          <img src="img/pngtree-vector-tyre-icon-png-image_1833985.png" alt="">
          <div class="header-bar-logo-name">Shazar</div>
        </div>
          <div class="header-bar-content">
            <a href="#">C</a>
            <a href="/">Back to main page</a>
          </div>
      </div>
    </header>
    <main class="main">
  
      <div class="log-name">Log in</div>
        <div class="main-row">
        <div class="log-name-block">
          <div class="log-name-block-main">
            <form action="/login" method="post">
              <label for="username">Username:</label><br>
              <input 
                type="text" 
                id="username" 
                name="username"
                class="first"
                placeholder="type here..."
              ><br>
              <label for="password">Password:</label><br>
              <input 
                type="password" 
                id="password" 
                name="password"
                class="second"
                placeholder="type here..."
              >
              <div class="register-button">
                <a href=""><input type="submit" value="Log in"></a>
              </div>
            </form>
            <a class="forgot-pass" href="#">Forgot password</a>
          </div>
          <div class="check"> 
            <form>
              <input type="checkbox" id="remain" name="remain" value="remain">
              <label for="remain">Remain logged in</label><br>
            </form>
          </div>
          <div class="log-in-button">
			<span class="button-reg">Not with us yet?</span> <a href="/register">Register here</a>
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