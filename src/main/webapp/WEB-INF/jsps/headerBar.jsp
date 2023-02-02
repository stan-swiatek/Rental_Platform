<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<body>
	<div class="header-bar">
		<div class="header-a">
			<img class="logo" src="/pngtree-vector-tyre-icon-png-image_1833985.png" alt="">
			<div class="header-bar-logo-name">Shazar</div>
		</div>
		<div class="header-bar-content">

			<c:if test="${not loggedIn}">
				<a href="login">Log in</a>
				<a href="register">Sign up</a>
			</c:if>
			<c:if test="${loggedIn}">
				<p>
					Hello, <span>${firstname}</span>!
				</p>
                <a href="messages/${user_id}">
				  <img class="png" alt="" src="/pngkey.com-email-icon-white-png-9311379.png">
				</a>
				<c:if test="${unread > 0}">
					<span>(${unread})</span>
				</c:if>
				<a href="/logout">Log out</a>
			</c:if>

			<c:if test="${not fn:endsWith(request.requestURI, '/')}">
				<a href="/">Back to main page</a>
			</c:if>


		</div>
	</div>
</body>
</html>