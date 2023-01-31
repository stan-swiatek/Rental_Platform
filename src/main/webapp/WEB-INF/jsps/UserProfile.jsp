<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
          <img src="images/pngtree-vector-tyre-icon-png-image_1833985.png" alt="">
          <div class="header-bar-logo-name">Shazar</div>
        </div>
          <div class="header-bar-content">
            <a href="#">C</a>
            <a href="/">Back to main page</a>
          </div>
      </div>
    </header>
    <main class="main">
  
      <div class="log-name">Your profile</div>
      <div class="user-wrapper">
        <div class="log-name-block">
          <div class="user-block-main">
          <div class="log-in-button">Here will be user details
           <div class="product-main-text">User name:  ${userName}</div>
           <div class="product-main-text">First name: ${userFristName}</div>
           <div class="product-main-text">Sure name: ${userSurName}</div>
           <div class="product-main-text">E-mail: ${userEmail}</div>
           <div class="product-main-text">Address: ${userAddress}</div>
           
          <div>${user.firstName} </div>
          <div>${user.surName} </div>
          <div>${user.email} </div>
          </div>
          </div>
        </div>
        <div class="user-block">
          <div class="user-button">
            <a class="user-button-button-one" href="/editUserDetails"><span>editUserDetails</span></a>
          </div>
          <div class="user-button">
            <a class="user-button-button-two" href="/ProductOffer"><span>createProduct</span></a>
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