<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test5.jsp</h1>
	
	<form action="test5/myServlet">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="test5/myServlet 서블릿 주소 요청 (GET)">
	</form>
	
	<form action="test5/myServlet" method="post">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="test5/myServlet 서블릿 주소 요청 (POST)">
	</form>
	
	<hr>
	
	<form action="test5/myServlet2">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="test5/myServlet2 서블릿 주소 요청 (GET)">
	</form>
	
	<form action="test5/myServlet2" method="post">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="test5/myServlet2 서블릿 주소 요청 (POST)">
	</form>
</body>
</html>