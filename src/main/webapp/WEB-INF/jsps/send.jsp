<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<div class="send-container">
  <form action="/sendMessage/${product.id}/${buyer.id}" method="post">
    <textarea class="send-message-input" name="messageText" required></textarea>
    <button class="send-message-btn">Send</button>
  </form>
</div>
</body>
</html>

