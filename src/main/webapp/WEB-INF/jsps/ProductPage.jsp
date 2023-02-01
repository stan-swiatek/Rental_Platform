<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
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
            <img src="/new_car_landing_S_2.jpg" alt="">
          </div>
          <div class="product-main-two">
            <div class="product-main-title">${productName}${test}</div>

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
            <form action="/Booking/${id}" method="POST">
            	<!-- <label for="startDate">Start date:</label>
				<input type="date" id="startDate" name="start date"
				value="2018-07-22"
				min="2018-01-01" max="2018-12-31"> -->
				
            	<label for="startDate">End date:</label>
				<input type="date" id="startDate" name="startDate">
				
            	<label for="endDate">End date:</label>
				<input type="date" id="endDate" name="endDate">
			  
			  <button>book</button>
            
              <!-- <div class="product-button-row-one">
                <div class="main-row-item-block-button">
                  <a href="#"><span>Book</span></a>
                </div>
              </div> -->
              </form>
              
              <div class="product-button-row-two">
                <div class="main-row-item-block-button" id="rate">
                  <a href="#"><span>Rate the product</span></a>
                </div>
                <div class="main-row-item-block-button" id="rate">
                  <a href="#"><span>Rate the owner</span></a>
                </div> 
                <div class="main-row-item-block-button" id="rate">
                  <a href="/messages/${product.id}/${user_id}"><span>Send a message</span></a>
                </div>
              </div>
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