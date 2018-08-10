<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.jda.Model.UserModel" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%UserModel userDetail=null; 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
if(session.getAttribute("user") == null){
	response.sendRedirect("login.jsp");
}
else{

	userDetail = (UserModel) session.getAttribute("user");
}
%><br>

Welcome : <%=userDetail.getName()%><br>
<a href="login.jsp">Log Out</a>

</body>
</html>