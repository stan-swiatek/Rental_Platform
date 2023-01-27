<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="wrapper">
    <header class="header" id="header">
      <div class="header-bar">
        <div class="header-a">
          <img src="pngtree-vector-tyre-icon-png-image_1833985.png" alt="">
          <div class="header-bar-logo-name">Autolife</div>
        </div>
          <div class="header-bar-content">
            <a href="#">C</a>
            <a href="index.html">Back to main page</a>
          </div>
      </div>
    </header>
    <main class="main">
      <div class="log-name-block">
        <div class="offer-block-main">
          <div class="log-name">Place your offer here:</div>
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
          </form>
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