<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="com.jda.model.UserModel" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%UserModel userDetail=null; 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
if(session.getAttribute("user") == null){
	response.sendRedirect("login.jsp");
}
else{

	userDetail = (UserModel) session.getAttribute("user");
}
%><br>
--%>
<h1>Welcome : ${name}</h1><br> 
<a href="login">Log Out</a>

</body>
</html>