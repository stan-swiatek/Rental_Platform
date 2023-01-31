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
      <%@ include file="headerBar.jsp" %>
    </header>
    <main class="main">
      <div class="main-info">
        <div class="info-blog">
          <div class="main-row-item-block-blog">

            <div class="main-row-a">
              <div class="main-row-b">
                <div class="main-row-item-block-title-blog-b">About us</div>
              </div>
            </div>

            <div class="main-row-item-block-description-blog">Learn more about our company</div>
            <div class="main-row-item-block-button-blog">
                <a href=""><span>Read more...</span></a>
            </div>

          </div>
          <div class="main-row-item-block-blog">

            <div class="main-row-a">
              <div class="main-row-b">
                <div class="main-row-item-block-title-blog-b">FAQ</div>
              </div>
            </div>

            <div class="main-row-item-block-description-blog">Find answers to all your questions</div>
            <div class="main-row-item-block-button-blog">
                <a href=""><span>Read more...</span></a>
            </div>

          </div>


            <div class="main-row-item-block-blog">
              <div class="main-row-a">
                <div class="main-row-b">
                  <div 
                    class="main-row-item-block-title-blog-b"
                  >Legal regulations
                  </div>
                </div>
              </div>

              <div class="main-row-item-block-description-blog">Find out about our terms and conditions</div>
              <div class="main-row-item-block-button-blog">
                  <a href="/terms"><span>Read more...</span></a>
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