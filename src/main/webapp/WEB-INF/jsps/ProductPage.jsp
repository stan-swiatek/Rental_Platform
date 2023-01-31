<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" href="/css/style.css">

  <title>Shazar</title>
</head>
<body>
  <div class="wrapper">
    <header class="header" id="header">
      <%@ include file="headerBar.jsp" %>
      
    </header>
    <main class="main">

      <div class="log-name-block">
        <div class="product-main">
          <div class="product-main-one">
            <img src="new_car_landing_S_2.jpg" alt="">
          </div>
          <div class="product-main-two">
            <div class="product-main-title">${productName}</div>

            <div class="product-main-text">Bike category: ${productCategory}</div>
            <div class="product-main-text">Bike type: ${productType}</div>
            <div class="product-main-text">Bike Color: ${productColor}</div>
            <div class="product-main-text">Price: ${productPrice} $ per 24 hours</div>

            <div class="product-main-description">Description: </div>
            <div class="product-main-description-text">${productDescription}</div>

            <div class="product-main-price">Pricing policy:</div>
            <div class="product-main-price-description">One hour (up to 12 hours): x</div>
            <div class="product-main-price-description">One hour (more than 12 hours): x</div>
            <div class="product-main-price-description">One hour (more than 24 hours): x</div>

            <div class="product-button-block">
              <div class="product-button-row-one">
                <div class="main-row-item-block-button">
                  <a href="#"><span>Book</span></a>
                </div>
              </div>
              <div class="product-button-row-two">
                <div class="main-row-item-block-button" id="rate">
<%--                   <form method="post" th:object="${rating}" class="mt-5">

                    <input value="0" type="hidden" class="rating" data-glyphicon="0" th:field="*{stars}" name="content">

                    <button class="main-row-item-block-button" type="submit">Submit</button>
                  </form> --%>
                  <a href="#"><span>Rate the product</span></a> 
                </div>
                <div class="main-row-item-block-button" id="rate">
                  <a href="#"><span>Rate the owner</span></a>
                </div> 
              </div>
            </div>
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
  
<!--   <script th:src="@{/webjars/jquery/jquery.min.js}"></script>
  <script th:src="@{/webjars/popper.js/umd/popper.min.js}"></script>
  <script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
  <script th:src="@{/assets/bootstrapless-star-rating/star-rating.min.js}"></script> -->
</body>
</html>