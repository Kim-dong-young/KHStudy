<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>JSTL Core Library</h1>
	
	<h3>1. 변수(속성 == attribute)</h3>
	<pre>
		* 변수 선언과 동시에 초기화(c:set var="변수명" value="값" [scope="저장객체"])
		- 변수 선언하고 초기값을 대입해두는 기능을 제공
		- 해당 변수를 어떤 scope에 setAttribute를 통해 담아둘지 결정할 수 있다.
		=> c:set으로 선언한 변수는 접근할 때 무!조!건! EL로 접근해야한다.
	</pre>
	
	<c:set var="num1" value="10"/> <%-- <% pageContext.setAttribute("num1",10); %>와 동일 --%>
	<c:set var="num2" value="20" scope="request"/>
	num1 : ${ num1 }<br>
	num2 : ${ num2 }<br>
	
</body>
</html>