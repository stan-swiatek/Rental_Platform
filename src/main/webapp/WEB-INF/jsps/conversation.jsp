<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css">
<title>Conversation</title>
<style>
.left {
	text-align: left;
	width: 40%;
	float: left;
}

.right {
	text-align: right;
	width: 40%;
	float: right;
}
</style>
</head>
<body>
	<div class="wrapper">
		<header class="header">
			<%@ include file="headerBar.jsp"%>
		</header>
		<h2>Conversation between ${buyer.username} and
			${owner.username}</h2>
		<h3>Subject: ${product.productName}</h3>
		<c:forEach var="message" items="${messages}">
			<div
				class="<c:if test="${message.sentByBuyer}">left</c:if><c:if test="${not message.sentByBuyer}">right</c:if>">
				<table>

					<tr>
						<!--<th>Message:</th>  -->
						<td>${message.messageText}</td>
					</tr>
					<tr>
						<th>Time Sent:</th>
						<td>${message.timeSent}</td>
					</tr>
					<tr>
						<th>Is Read:</th>
						<td>${message.isRead}</td>
					</tr>
				</table>
			</div>
		</c:forEach>
		
	</div>
	<%@ include file ="send.jsp" %>
	<%@ include file ="footerBar.jsp" %>
</body>
</html>
