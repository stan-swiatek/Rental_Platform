<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css">
	<title>Filtered Products</title>
</head>
<body>
  <div class="wrapper">
    <header class="header">
      <%@ include file="headerBar.jsp" %>
      <div class="header-description">
          <div class="header-description-container">
           <%-- <p class="det__title">Detailed searchbar</p>
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


<%--	<h3>Filtered Products</h3>
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
				<td><a href="/ProductPage/${product.id}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
	
	          <div class="main-banner">
          <div class="detailed__searchbar"> --%>
          

          
              <form action="/dropDownFilters" method="post">
              
              <div class="block-main">
                  <div class="year">
                    <input type="hidden" name="filter" value="${filter }">
                    <div class="a">Color</div>
                    <select name="color">
                    <option value="${filtering.color }" selected="selected">${filtering.color }</option>
                       <option value="">
                        
                      </option>
                      <option value="White">
                        White
                      </option>
            
                      <option value="Black">
                        Black
                      </option>
            
                      <option value="Blue">
                        Blue
                      </option>
            
                      <option value="Red">
                        Red
                      </option>
                      
                      <option value="Pink">
                        Pink
                      </option>
                      
                      <option value="Green">
                        Green
                      </option>
                      
                      <option value="Yellow">
                        Yellow
                      </option>
                      <option value="Other">
                        Other
                      </option>
                    </select>
                  </div>
      
                  <div class="brand">
                    <div class="a">Type</div>
                    <select name="type">
                    <option value="${filtering.type }" selected="selected">${filtering.type }</option>                     
                      <option value="">
                        
                      </option>
                      <option value="Ladies' bikes">
                        Ladies' bikes
                      </option>
            
                      <option value="Men's bikes">
                        Men's bikes
                      </option>
            
                      <option value="Children's bikes">
                        Children's bikes
                      </option>
                    
                    <option value="Unisex bikes">
                        Unisex bikes
                      </option>
                    </select>
                  </div>

                  <div class="engine">
                    <div class="a">Category</div>
                    <select name="category">
                    <option value="${filtering.category }" selected="selected">${filtering.category }</option> 
                      <option value="">
                        
                      </option>                  
                      <option value="BMX">
                        BMX
                      </option>
            
                      <option value="City Bike">
                        City Bike
                      </option>
                      
                      <option value="Electric Bike">
                        Electric Bike
                      </option>
                      
                      <option value="Gravel">
                        Gravel
                      </option>
                      
                      <option value="MTB">
                        MTB
                      </option>
                      
                      <option value="Road Bike">
                        Road Bike
                      </option>
                    </select>
                  </div>
<%-- Commented out for now since we don't have time frame filters yet and that couses an error--%>
                  <%--<div class="time-frame">
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
                  </div>--%>
          
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
              <input type="submit" value="Filter" class="filter-input">
              </div>
              </form>
            </div>
          </div>
        <%--</div>--%>
     <%-- </div>--%>
    </header>
    <main class="main">
    

	
		<h1 class="filtered-title">Filtered results</h1><br>
	<table class="filtered-table">
		<tr>
			<td class="filtered-td">ID</td>
			<th class="filtered-td">Name</th>
			<th class="filtered-td">Color</th>
			<th class="filtered-td">Type</th>
			<th class="filtered-td">Category</th>
			<th class="filtered-td">Price</th>
		</tr>
		<c:forEach items="${resultsOfSearch}" var="product">
			<tr class="filtered-tr">
				<td class="filtered-tr">${product.id}</td>
				<td class="filtered-tr">${product.productName}</td>
				<td class="filtered-tr">${product.color}</td>
				<td class="filtered-tr">${product.type}</td>
				<td class="filtered-tr">${product.category}</td>
				<td class="filtered-tr">${product.price}</td>
				<td><a href="/ProductPage/${product.id}" class="link-details">Details</a></td>
			</tr>
		</c:forEach>
	</table>


      <%--<div class="main-title-name">Useful information</div>
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

    </main>
    <footer class="footer-contact-information">
        <%@ include file ="footerBar.jsp" %>
    </footer>
  </div>
</body>
</html>
	