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
           <form action="/filtered" method="post" class="search-form">
            <input 
              class="searchbar"
              type="search" 
              name="filter"
              placeholder="Type here..."
            >
<!--             <div class="search-button"> -->
           	  <input type="submit" value="Search" class="search-input">
<!--           	</div> -->
			</form>
          </div>


	<h3 class="filtered-title">Filtered Products</h3>
	<table class="filtered-table">
		<tr>
			<td class="filtered-td">ID</td>
			<th class="filtered-td">Name</th>
			<th class="filtered-td">Category</th>
			<th class="filtered-td">Type</th>
			<th class="filtered-td">Color</th>
			<th class="filtered-td">Price</th>
		</tr>
		<c:forEach items="${filterProducts}" var="product">
			<tr class="filtered-tr">
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.category}</td>
				<td>${product.type}</td>
				<td>${product.color}</td>
				<td>${product.price}</td>
				<td><a href="/ProductPage/${product.id}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
	
	          <div class="main-banner">
 
          </div>
          </div>
      </div>
    </header>
    <main class="main">
<!-- 


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
              <a href="/FAQ"><span>Read more</span></a>
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
 -->
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
	