<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body onload="init()">
	<h3>공공데이터 활용</h3>
    <h5><a href="detail?page=publicData">view -></a></h5>
	<h3>텍스트 에디터 : 서머노트</h3>
    <h5><a href="detail?page=summernote">view -></a></h5>
    <h3>네이버 로그인</h3>
    <h5><a href="detail?page=naver">view -></a></h5>
    <h3>채팅창 : websocket</h3>
    <h5>닉네임 : <input type="text" id="nick"></h5>
    <h5><button onclick="moveChat()">view -></button></h5>

    <script>
        function moveChat() {
            const nick = document.querySelector('#nick').value;
            location.href="detail?page=chat&nick=" + nick;
        }
    </script>
</body>
</html>