<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<header class="header">
      <%@ include file="headerBar.jsp" %>
    </header>
  <h1>Message Box</h1>

  <table>
    <tr>
      <th>Subject</th>
      <th>Message</th>
      <th>Sent Date</th>
    </tr>
    <c:forEach items="${messages}" var="message">
      <tr>
        <td>${message.subject}</td>
        <td>${message.body}</td>
        <td>${message.dateSent}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
