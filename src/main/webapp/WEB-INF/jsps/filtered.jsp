<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
	<title>Filtered Products</title>
</head>
<body>
  <div class="wrapper">
    <header class="header">
      <%@ include file="headerBar.jsp" %>
      <div class="header-description">
          <div class="header-description-container">
            <p class="det__title">Detailed searchbar</p>
          <div class="header-description-what-is-get-help">
           <form action="/filtered" method="post">
            <input 
            class="searchbar"
            type="search" 
            name="filter"
            placeholder="Type here..."
          />
			<input type="submit" value="Search"/>
			</form>
          </div>


	<h3>Filtered Products</h3>
	<table>
		<tr>
			<td>ID</td>
			<th>Name</th>
			<th>Category</th>
			<th>Type</th>
			<th>Color</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${filterProducts}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.category}</td>
				<td>${product.type}</td>
				<td>${product.color}</td>
				<td>${product.price}</td>
				<td><a href="/product/${product.id}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
	
	          <div class="main-banner">
          <div class="detailed__searchbar">
          
  <div class="block__main">
                  <div class="year">
                    <div class="a">Color</div>
                    <select name="year">
                      <option value="first" selected>
                        White
                      </option>
            
                      <option value="second">
                        Black
                      </option>
            
                      <option value="third">
                        Blue
                      </option>
            
                      <option value="forth">
                        Red
                      </option>
                    </select>
                  </div>
      
                  <div class="brand">
                    <div class="a">Type</div>
                    <select name="brand">
                      <option value="brandFirst" selected>
                        Crossover
                      </option>
            
                      <option value="brandSecond">
                        Sedan
                      </option>
            
                      <option value="brandThird">
                        Minivan
                      </option>
                    </select>
                  </div>

                  <div class="engine">
                    <div class="a">Category</div>
                    <select name="engine">
                      <option value="engineFirst" selected>
                        New
                      </option>
            
                      <option value="emgineSecond">
                        Used
                      </option>
                    </select>
                  </div>

                  <div class="time-frame">
                    <div class="a">Time frame</div>
                    <select name="engine">
                      <option value="engineFirst" selected>
                        1h - 12h
                      </option>
            
                      <option value="emgineSecond">
                        12h - 24h
                      </option>

                      <option value="emgineSecond">
                        24h - more
                      </option>
                    </select>
                  </div>
          
                  <div class="price">
                    <div class="a">Price</div>
                    <div class="price__number">
                      <input 
                        type="number" 
                        name="priceMin"
                        placeholder="Min"
                      >
                      <input 
                        type="number" 
                        name="priceMax"
                        placeholder="Max"
                      >
                    </div>
                  </div>
              </div>
            </div>
          </div>
          </div>
      </div>
    </header>
    <main class="main">



      <div class="main-title-name">Useful information</div>
      <div class="main-row-blog">
        <div class="main-row-item-block-blog">

          <div class="main-row-a">
            <div class="main-row-b">
              <div class="main-row-item-block-title-blog-b">FAQ</div>
            </div>
          </div>

          <div class="main-row-item-block-description-blog">Find answers to all your questions</div>
          <div class="main-row-item-block-button-blog">
              <a href="#"><span>Read more</span></a>
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
	