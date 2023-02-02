<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
      <%@ include file="headerBar.jsp" %>
    </header>
    <main class="main-user">
      <div class="user-main">
      <div class="log-name">Your profile</div>
      <div class="user-wrapper">
        <div class="log-name-block">
          <div class="user-block-main">
          <div class="log-in-button">Here will be user details
           <div class="product-main-text">User name:  ${userName}</div>
           <div class="product-main-text">First name: ${userFristName}</div>
           <div class="product-main-text">Sure name: ${userSurName}</div>
           <div class="product-main-text">E-mail: ${userEmail}</div>
           <div class="product-main-text">Phone: ${userPhone}</div>
           <div class="product-main-text">Address: ${userAddress}</div>
           
          
          </div>
          </div>
        </div>
        <div class="user-block">
          <div class="user-button">
            <a class="user-button-button-one" href="/editUserDetails"><span>Settings</span></a>
          </div>
          <div class="user-button">
            <a class="user-button-button-two" href="/ProductOffer"><span>Add new product</span></a>
          </div>
        </div>
      </div>
      </div>
      <div class="help-block">
        <div class="help-block-main">
          <div class="help-block-one">
            <div class="help-sec-main-one">Have questions?</div>
            <div class="help-sec-a">Visit our <a class="link" href="/FAQ">FAQ page</a> - you will find most of the answers there.</div>
          </div>
          <div class="help-block-two">
          <div class="help-sec-main-one">FAQ page didn't help you?</div>
          <div class="help-sec">Feel free to contact our support team!</div>
          <div class="help-sec"><span>Email:</span> shazar-support@gmail.com</div> 
          <div class="help-sec">OR</div>
          <div class="logos">
          <a href="https://telegram.me/tobosssss">
            <img class="logo-site" src="pngwing.com.png" alt="">
          </a>
          <a href="https://wa.me/48452750127">
            <img class="logo-site" src="pngwing.com-3.png" alt="">
          </a>
          <a href="https://www.instagram.com/ann.peretyatko/">
            <img class="logo-site" src="pngwing.com-2.png" alt="">
          </a>
        </div>
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