<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<div class="send-container">
  <form action="/sendMessage/${messages[0].product.id}/${messages[0].buyer.id}" method="post">
    <input type="hidden" name="receiverId" value="${receiverId}"/>
    <textarea class="send-message-input" name="messageText" required></textarea>
    <button class="send-message-btn">Send</button>
  </form>
</div>
</body>
</html>

