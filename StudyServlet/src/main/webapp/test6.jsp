<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test6.jsp</h1>
	
	<form action="myServlet6">
		<input type="submit" value="myServlet3 서블릿 주소 요청 (GET)">
	</form>
	
	<form action="myServlet6Post" method="post">
		<input type="submit" value="myServlet3 서블릿 주소 요청 (POST)">
	</form>
	
	<hr>
	
	<form action="myServlet6.do">
		<input type="submit" value="myServlet3 서블릿 주소 요청 (GET)">
	</form>
	
	<form action="myServlet6Post.do" method="post">
		<input type="submit" value="myServlet3 서블릿 주소 요청 (POST)">
	</form>
	
	<form action="test6/myServlet.do">
		<input type="submit" value="myServlet3 서블릿 주소 요청 (GET)">
	</form>
	
	<form action="test6/myServlet2.do" method="post">
		<input type="submit" value="myServlet3 서블릿 주소 요청 (POST)">
	</form>
</body>
</html>