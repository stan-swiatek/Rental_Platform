<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="style.css">
  <title>Document</title>
</head>
<body>
  <div class="wrapper">
    <header class="header">
      <div class="header-bar">
        <div class="header-a">
          <img src="pngtree-vector-tyre-icon-png-image_1833985.png" alt="">
          <div class="header-bar-logo-name">Autolife</div>
        </div>
          <div class="header-bar-content">
            <a href="#">C</a>
            <a href="index.jsp">Back to main page</a>
          </div>
      </div>
    </header>
    <main class="main">
  
      <div class="log-name">Sign up</div>
        <div class="main-row">
        <div class="log-name-block">
          <div class="log-name-block-main">
            <form>
              <label for="fname">Create username</label><br>
              <input 
                type="text" 
                id="fname"
                name="fname"
                class="first"
                placeholder="type here..."
              ><br>
              <label for="pwd">Create password:</label><br>
              <input 
                type="password" 
                id="pwd" 
                name="pwd"
                class="second"
                placeholder="type here..."
              ><br>
              <label for="email">Enter your email</label><br>
              <input 
                type="email" 
                id="email" 
                name="email"
                class="second"
                placeholder="type here..."
              ><br>
            </form>
          </div>
          <div class="check"> 
            <form>
              <input type="checkbox" id="remain" name="remain" value="remain">
              <label for="remain">Remain logged in</label><br>
            </form>
          </div>
          <div class="log-in-button">
            <a href="logged.jsp"><span>Create account</span></a>
          </div>
        </div>
      </div>
  
    </main>
    <footer class="footer-contact-information">
        <div class="footer-contact-information-container">
          <div class="footer-contact-information-links-social-media">
              <a href="#">Home</a>
              <a href="#">Cart</a>
              <a href="#">Personal</a>
              <a href="#">Information</a>
          </div>
        </div>
    </footer>
  </div>
</body>
</html>