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
            <div class="product-main-title">Car name</div>

            <div class="product-main-text">Model: x</div>
            <div class="product-main-text">Manufacture year: x</div>
            <div class="product-main-text">Condition: x</div>
            <div class="product-main-text">Owner: x</div>

            <div class="product-main-description">Description:</div>
            <div class="product-main-description-text">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Repellat, quasi assumenda. Id quisquam assumenda earum labore quos veritatis nobis accusamus minima exercitationem nam non mollitia a temporibus eaque animi molestias, nulla nemo ipsa libero. Dolores consequatur ad quam totam at minus, eaque numquam velit neque alias sint a obcaecati tempore.</div>

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
              <a href="#">Information</a>
          </div>
        </div>
    </footer>
  </div>
</body>
</html>