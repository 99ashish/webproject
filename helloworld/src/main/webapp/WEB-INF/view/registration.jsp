<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
<!-- <script src="JsValidation/jsvalidation.js"></script> -->
</head>
<body load="firstfocus()">
<form action = "register" method = "post" name="registration" modelAttribute="userDetail">
Name:<br> <input type="text" name="name" placeholder="name"  onblur="userName()" ><br><br>
Email: <br> <input type="text" name="email" placeholder="email" onblur="emailValidation()"><br><br>
DOB: <br> <input type="text" name="dob" placeholder="dd/mm/yyyy" onblur="emailValidation()"><br><br>
Mobile number:<br><input type="text" name="phoneNumber" placeholder="Mobile Number" onblur="mobileNumber()"><br><br>
Password:<br><input type="password" name="password" placeholder="password" onblur="password(5,10)"><br><br>
<input type="submit">
</form>
</body>
</html>