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
          <img src="pngtree-vector-tyre-icon-png-image_1833985.png" alt="">
          <div class="header-bar-logo-name">Shazar</div>
        </div>
          <div class="header-bar-content">
            <a href="#">C</a>
            <a href="/">Back to main page</a>
          </div>
      </div>
    </header>
    <main class="main">
  
      <div class="log-name">Forgotten Password</div>
      
        <div class="main-row">
        <div class="log-name-block">
          <div class="log-name-block-main">
          <div>${message3}</div>
          
            <form action="/forgottenPassword" method="post">
             <label for="email">Enter your email:</label><br>
              <input 
                type="email" 
                id="email" 
                name="email"
                class="second"
                placeholder="type here..."
              ><br>
              <div>${message4}</div>
              
              <div class="register-button">
                <a href=""><input type="submit" value="Send"></a>
              </div>
              
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