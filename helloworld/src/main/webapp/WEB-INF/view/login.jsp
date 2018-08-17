<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h2>Log In page</h2>
	<form action="login" method="post" modelAttribute="credential">
		<input type="text" name="email" placeholder="email-Id"  required><br>
		<input type="password" name="password" placeholder="password"  required><br>
		<input type="submit">
	</form>
</body>
</html>
