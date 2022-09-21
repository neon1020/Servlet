<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test7_dispatcher_result.jsp</h1>
	
	<!-- 이전 요청에서 전달받은 아이디(id), 패스워드(passwd) 파라미터 출력하기 -->
	<!-- EL 사용 -->
	<h3>아이디 : ${param.id }</h3>
	<h3>패스워드 : ${param.passwd }</h3>
</body>
</html>