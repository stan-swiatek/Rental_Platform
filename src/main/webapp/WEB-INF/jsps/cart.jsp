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
  <h1>Message Box</h1>
	
  <table>
    <tr>
      <th>product_id</th>
      <th>user_id</th>
      <th>bookingDate</th>

    </tr>
    <c:forEach items="${bookings}" var="booking">
      <tr>
      
        <td>${booking.product.productName}</td>
        <td>${booking.user.username}</td>
        <td>${booking.bookingDate} - ${booking.status}</td>
      <%-- <td><a href="/messages/${message.product.id}/${message.buyer.id}">Go to conversation</a></td> --%>
      </tr>
      
    </c:forEach>
  </table>
  <footer>
  	<%@ include file ="footerBar.jsp" %>
  </footer>
  </div>
</body>
</html>
