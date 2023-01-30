<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
<title>Shazar</title>
</head>
<body>
  <div class="wrapper">
    <header class="header" id="header">
      <div class="header-bar">
        <div class="header-a">
          <img src="pngtree-vector-tyre-icon-png-image_1833985.png" alt="">
          <div class="header-bar-logo-name">Shazar</div>
        </div>
          <div class="header-bar-content">
            <a href="#">C</a>
            <a href="/UserProfile">Back to your profile</a>
          </div>
      </div>
    </header>
    <main class="main">
      <div class="log-name-block">
        <div class="offer-block-main">
          <div class="offer-name">Create your offer here:</div>
          <form>
            <label for="productName">productName:</label><br>
            <input 
              type="text" 
              id="productName" 
              name="productName"
              class="first"
              placeholder="type here..."
            ><br>
            <label for="description">description:</label><br>
            <textarea 
              id="description" 
              name="description" 
              rows="7" 
              cols="35"
              class="textarea"
              class="first"
              placeholder="type here..."
            >
            </textarea><br>
            <label for="category">category:</label><br>
            <input 
              type="text" 
              id="category" 
              name="category"
              class="first"
              placeholder="type here..."
            ><br>
            <label for="price">price:</label><br>
            <input 
              type="text" 
              id="price" 
              name="price"
              class="first"
              placeholder="type here..."
            ><br>
            <div class="register-button">
           	  <input type="submit" value="Create">
          	</div>
          </form>
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