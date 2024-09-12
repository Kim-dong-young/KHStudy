<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1. formatNumber</h3>
	<p>
		숫자데이터의 포맷(형식) 지정 <br>
		- 표현하고자하는 숫자데이터의 형식을 통화기호, % 등으로 원하는 방식에 맞게 지정하는 태그 <br>
		
		(fmt:formatNumber value="출력할값" [groupingUsed="true|false" type="percent|currency" currencySymbol="문자"])
	</p>
	
	<c:set var="num1" value="123456789"/>
	<c:set var="num2" value="0.75"/>
	<c:set var="num3" value="50000"/>
	
	그냥 출력 : ${num1 }<br>
	세자리마다 구분하여 줄력 : <fmt:formatNumber value="${num1 }"/> <br>
	<!-- groupingUsed 기본 = true / 세자리마다 ,(쉼표) 출력 -->
	숫자 그대로 출력 : <fmt:formatNumber value="${num1 }" groupingUsed="false"/> <br>
	percent : <fmt:formatNumber value="${num2 }" type="percent"/> <br>
	currency : <fmt:formatNumber value="${num3 }" type="currency"/> <br>
	currency : <fmt:formatNumber value="${num3 }" type="currency" groupingUsed="false"/> <br>
	currency : <fmt:formatNumber value="${num3 }" type="currency" groupingUsed="false" currencySymbol="$"/> <br>
	
	<h3>2. formatDate</h3>
	<p>날짜 및 시간 데이터의 포맷 지정(단, java.util.Date객체만 사용가능)</p>
	
	<c:set var="current" value="<%= new java.util.Date() %>" />
	
	출력 : ${current }
	
	<ul>
		<li>현재 날짜 : <fmt:formatDate value="${current }" type="date"/></li> <!-- type 생략 시, 기본값 date -->
		<li>현재 시간 : <fmt:formatDate value="${current }" type="time"/></li>
		<li>둘다 : <fmt:formatDate value="${current }" type="both"/></li> <!-- dateStyle, timeStyle 디폴트 = medium -->
		<li>Medium : <fmt:formatDate value="${current }" type="both" dateStyle="medium" timeStyle="medium" />
		<li>Long : <fmt:formatDate value="${current }" type="both" dateStyle="long" timeStyle="long" />
		<li>Short : <fmt:formatDate value="${current }" type="both" dateStyle="short" timeStyle="short" />
		<li>Full : <fmt:formatDate value="${current }" type="both" dateStyle="full" timeStyle="full" />
		
		<li>나만의 Pattern 지정 : <fmt:formatDate value="${current }" type="both" pattern="yyyy-MM-dd(E) HH:mm:ss(a)" />
	</ul>
	
</body>
</html>