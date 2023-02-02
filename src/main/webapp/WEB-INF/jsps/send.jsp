<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<div class="send-container">
  <form action="/sendMessage/${product.id}/${buyer.id}" method="post">
    <textarea 
      class="send-message-input" 
      name="messageText"
      rows="15" 
      cols="90"
      required
    ></textarea>
    <div class="register-button">
      <input type="submit" value="Save changes">
    </div>
<!--     <button class="send-message-btn">Send</button> -->
  </form>
</div>
</body>
</html>

