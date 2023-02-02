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
			<th class="filtered-td">Details</th>
		</tr>
		<c:forEach items="${filterProducts}" var="product">
			<tr class="filtered-tr">
				<td class="filtered-tr">${product.id}</td>
				<td class="filtered-tr">${product.productName}</td>
				<td class="filtered-tr">${product.category}</td>
				<td class="filtered-tr">${product.type}</td>
				<td class="filtered-tr">${product.color}</td>
				<td class="filtered-tr">${product.price}</td>
				<td><a href="/ProductPage/${product.id}" class="link-details">Details</a></td>
			</tr>
		</c:forEach>
	</table>
	</div> <%-- Remove in case of adding back filters--%>
	</div> <%-- Remove in case of adding back filters--%>
	
	          <div class="main-banner">
 
          </div>
          
         </div>
       </div>
    </header>
    <main class="main">
    </main>
    <footer class="footer-contact-information">
        <%@ include file ="footerBar.jsp" %>
    </footer>
  </div>
</body>
</html>
	