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
    <title>Messages</title>
</head>
<body>
<div class="wrapper">
    <header class="header">
      <%@ include file="headerBar.jsp" %>
    </header>
  <div class="faq-title">Message Box</div>
	
  <table class="filtered-table-mes">
    <tr>
      <th class="filtered-td">Subject</th>
      <th class="filtered-td">From</th>
      <th class="filtered-td">Message</th>

    </tr>
    <c:forEach items="${messages}" var="message">
      <tr>
      
        <td class="filtered-tr">${message.subject}</td>
        <td class="filtered-tr">${message.buyer.username}</td>
        <td class="filtered-tr">${message.messageText}</td>
      <td><a href="/messages/${message.product.id}/${message.buyer.id}" class="link-details">Go to conversation</a></td>
      </tr>
      
    </c:forEach>
    
  </table>
  <footer>
  	<%@ include file ="footerBar.jsp" %>
  </footer>
  </div>
</body>
</html>
