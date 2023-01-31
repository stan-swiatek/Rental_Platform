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


	<br>
	<h1>Search results</h1><br>
	<table>
		<tr>
			<td>ID</td>
			<th>Name</th>
			<th>Color</th>
			<th>Type</th>
			<th>Category</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${filterProducts}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.color}</td>
				<td>${product.type}</td>
				<td>${product.category}</td>
				<td>${product.price}</td>
				<td><a href="/ProductPage/${product.id}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
	</div> <%-- Remove in case of adding back filters--%>
	</div> <%-- Remove in case of adding back filters--%>
	
	          <%--<div class="main-banner">
          <div class="detailed__searchbar">
          
          
           
       <form action="/dropDownFilters" method="post">
          
  <div class="block__main">
                  <div class="year">
            <input type="hidden" name="filter" value="${filter }">
                    <div class="a">Color</div>
                    <select name="color">
                    <option value="${filtering.color }" selected="selected">${filtering.color }</option>
                      <option value="white">
                        White
                      </option>
            
                      <option value="black">
                        Black
                      </option>
            
                      <option value="blue">
                        Blue
                      </option>
            
                      <option value="red">
                        Red
                      </option>
                    </select>
                  </div>
      
                  <div class="brand">
                    <div class="a">Type</div>
                    <select name="brand">
                    <option value="${filtering.type }" selected="selected">${filtering.type }</option>
                      <option value="woman">
                        Woman's bikes
                      </option>
            
                      <option value="man">
                        Man's bikes
                      </option>
            
                      <option value="child">
                        Child's bikes
                      </option>
                    </select>
                  </div>

                  <div class="engine">
                    <div class="a">Category</div>
                    <select name="engine">
                    <option value="${filtering.category }" selected="selected">${filtering.category }</option>
                      <option value="bike">
                        Bike
                      </option>
            
                      <option value="other">
                        Other
                      </option>
                    </select>
                  </div>
          
                  <div class="price">
                    <div class="a">Price</div>
                    <div class="price__number">
                      <input 
                        type="number"
                        value="${filtering.minPrice }"
                        name="minPrice"
                        placeholder="Min"
                      >
                      <input 
                        type="number"
                        value="${filtering.maxPrice }"
                        name="maxPrice"
                        placeholder="Max"
                      >
          
                    </div>
                  </div>
              </div>
       <input type="submit" value="Filter"/>
      </form>
            </div>
          </div>
          
         </div>
       </div>
    </header>
    <main class="main">
    

	
		<h3>Products</h3>
	<table>
		<tr>
			<td>ID</td>
			<th>Name</th>
			<th>Category</th>
			<th>Type</th>
			<th>Color</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${resultsOfSearch}" var="product">
			<tr>
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
      </div>--%>

    </header> <%-- Remove in case of adding back filters--%>
    <main class="main"><%-- Remove in case of adding back filters--%>
    </main>
    <footer class="footer-contact-information">
        <%@ include file ="footerBar.jsp" %>
    </footer>
  </div>
</body>
</html>
	