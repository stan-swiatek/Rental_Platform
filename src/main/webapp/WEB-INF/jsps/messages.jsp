<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Messages</title>
</head>
<body>
	<header>
      <%@ include file="headerBar.jsp" %>
    </header>
  <h1>Message Box</h1>

  <table>
    <tr>
      <th>Subject</th>
      <th>From</th>
      <th>Message</th>

    </tr>
    <c:forEach items="${messages}" var="message">
      
      <tr>
      
        <td>${message.subject}</td>
        <td>${message.buyer.username}</td>
        <td>${message.message}</td>
      <td><a href="/messages/${message.product.id}/${message.buyer.id}">Go to conversation</a></td>
      </tr>
      
    </c:forEach>
  </table>
</body>
</html>
