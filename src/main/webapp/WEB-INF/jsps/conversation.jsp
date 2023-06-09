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
</head>
<body>
	<header class="header">
		<%@ include file="headerBar.jsp"%>
	</header>
	  <div class="wrapper-convo">
		<h2 class="convo">Conversation between <span class="convo-name">${buyer.username}</span> and <span class="convo-name-two">${owner.username}</span></h2>
		<h3 class="sub-convo"><span class="sub-convo-span">Subject:</span> ${product.productName}</h3>
		
		<%-- <div>
			<form action="/accept/${product.id}/${buyer.id}" method="post">
			    <textarea name="acceptBooking" required></textarea>
			    <button class="send-message-btn">Send</button>
			  </form>
		</div> --%>
		
		<c:forEach items="${bookings}" var="booking">
      <tr>
      	<td>---</td>
        <td>date of booking: ${booking.bookingDate}</td>
        <td>start date: ${booking.startDate}</td>
        <td>end date: ${booking.endDate}</td>
        <td>status: ${booking.status}</td>
        <%-- <td>
        	<c:if test="${booking.status=='Pending'}">
        		<form action="/accept/${booking.id}" method="POST"></form>
        		<button>accept</button>
        		<form action="/deny/${booking.id}" method="POST"></form>
        		<button>deny</button>
        	</c:if>
        	<c:if test="${booking.status=='Cart'}">(in shopping cart)</c:if>
        </td> --%>
        <td>---</td>
      </tr>
      
      
    </c:forEach>
		
		<c:forEach var="message" items="${messages}">
			<div
				class="<c:if test="${message.sentByBuyer}">left</c:if><c:if test="${not message.sentByBuyer}">right</c:if>">
				<table class="messages-convo">

					<tr class="message-main">
						<!--<th>Message:</th>  -->
						<td>${message.messageText}</td>
					</tr>
					<tr class="message-main">
						<th>Time Sent:</th>
						<td>${message.timeSent}</td>
					</tr>
					<tr class="message-main">
						<th>Is Read:</th>
						<td>${message.isRead}</td>
					</tr>
				</table>
			</div>
		</c:forEach>
		
	<%@ include file ="send.jsp" %>
	</div>
	<%@ include file ="footerBar.jsp" %>
</body>
</html>
