<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
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
            <div class="product-main-one-container">
              <img src="/new_car_landing_S_2.jpg" alt="">  
            </div>
            <div>
            <div class="product-main-description">Description: </div>
            <div class="product-main-description-text">${productDescription} </div>
            </div>
          </div>
          <div class="product-main-two">
            <div class="product-main-two-container">
            <div class="product-main-title">${productName}</div>

            <div class="product-main-text">Bike category: ${productCategory}</div>
            <div class="product-main-text">Bike type: ${productType}</div>
            <div class="product-main-text">Bike Color: ${productColor}</div>
            
            <div class="product-main-text">Owner rating: ${userRating}</div>
            <div class="product-main-text">Product rating: ${productRating}</div>
            
            <div class="product-main-text">Price: ${productPrice} $ per 24 hours</div>


			<c:if test="${not isAvailable}">
				NOT AVAILABLE
			</c:if>
			<c:if test="${isAvailable}">
            <div class="product-button-block">
            <div class="product-book-one">Book the product for the rent:</div>
            <form action="/Booking/${id}" method="POST">
            	<!-- <label for="startDate">Start date:</label>
				<input type="date" id="startDate" name="start date"
				value="2018-07-22"
				min="2018-01-01" max="2018-12-31"> -->
				
            	<label for="startDate">Start date:</label>
				<input type="date" id="startDate" name="startDate"><br>
				
            	<label for="endDate">End date:</label>
				<input type="date" id="endDate" name="endDate">
			  
			  <button class="rating-input">Book</button>
            
              <!-- <div class="product-button-row-one">
                <div class="main-row-item-block-button">
                  <a href="#"><span>Book</span></a>
                </div>
              </div> -->
              </form>
              </div>
              <div class="product-button-row-two">
              <div class="product-book">Rate the product and the owner:</div>
                <div class="main-row-item-block-button" id="rate">
                
                  <form action="/rate/${id}" method="post">
<!--                   commandName="review"> -->
<!--                     <div>Rating:</div> -->
<!--                     <div id="rating"></div>
                    <input type="hidden" id="hdrating" name="hdrating"> -->
                    
                    <label for="value"></label><br>
					  <input 
					    class="rate-input"
					  	id="value" 
					  	class="second"
					  	type="number" 
					  	name="userValue"
					  	min="0"
					  	max="5"
						placeholder="Place user rating here"
					  >
					  <input 
					    class="rate-input"
					  	id="value" 
					  	class="second"
					  	type="number" 
					  	name="productValue"
					  	min="0"
					  	max="5"
						placeholder="Place product rating here"
					  >
                    <input type="submit" value="Rate" class="rating-input">
                  </form>  
                </div>
              </div>
                <div class="main-row-item-block-button" id="rate">
                  <a href="/messages/${product.id}/${user_id}"><span>Send message to the product owner</span></a>
                </div>
            </div>
			</c:if>
          </div>
        </div>
      </div>
      
      <c:forEach items="${bookings}" var="booking">
      <br>
      <tr>
      
        <td>${booking.product.productName}</td>
        <td>${booking.user.username}</td>
        <td>${booking.bookingDate} - ${booking.status}</td>
        <%-- <td><form action="/messages/${booking.product.id}/${booking.user.id}"</td> --%>
      <%-- <td><a href="/messages/${message.product.id}/${message.buyer.id}">Go to conversation</a></td> --%>
      </tr>
      
    </c:forEach>
  
    </main>
    <footer class="footer-contact-information">
        <%@ include file ="footerBar.jsp" %>
    </footer>
  </div>
</body>
</html>