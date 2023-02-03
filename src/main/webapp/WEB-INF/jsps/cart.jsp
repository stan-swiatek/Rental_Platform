<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css">
    <title>Cart</title>
</head>
<body>
<div class="wrapper">
    <header class="header">
      <%@ include file="headerBar.jsp" %>
    </header>
  <main class="main">
  <div class="faq-title">Message Box</div>
	
  <table class="filtered-table-mes">
    <tr>
      <th class="filtered-td">Product name</th>
      <th class="filtered-td">Username</th>
      <th class="filtered-td">Booking date - status</th>

    </tr>
    <c:forEach items="${bookings}" var="booking">
      <tr class="filtered-tr">
      
        <td class="filtered-tr">${booking.product.productName}</td>
        <td class="filtered-tr">${booking.user.username}</td>
        <td class="filtered-tr">${booking.bookingDate} - ${booking.status}</td>
        <td class="filtered-tr-a">
        	<form action="/delete_item/${booking.id}" method="post">
        		<button class="delete-input">delete</button>
        	</form>
        </td>
      <%-- <td><a href="/messages/${message.product.id}/${message.buyer.id}">Go to conversation</a></td> --%>
      </tr>
      
    </c:forEach>
    
    <c:forEach items="${others}" var="booking">
      <tr class="filtered-tr">
      
        <td class="filtered-tr">${booking.product.productName}</td>
        <td class="filtered-tr">${booking.user.username}</td>
        <td class="filtered-tr">${booking.bookingDate} - ${booking.status}</td>
      <%-- <td><a href="/messages/${message.product.id}/${message.buyer.id}">Go to conversation</a></td> --%>
      </tr>
      
    </c:forEach>
    
  </table>
    <form action="/confirm_cart" method="post" class="confirm-form">
    	<button class="delete-input">Confirm</button>
    </form>
   </main>
  <footer>
  	<%@ include file ="footerBar.jsp" %>
  </footer>
  </div>
</body>
</html>
