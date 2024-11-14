<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>로그인</h1>
    <form action="login">
        <input type="submit" value="login">
        <input type="button" onclick="naverLogin()" value="네이버로그인">
    </form>

    <script>
        function naverLogin(){
            const clientId = "W7VsMOYY4DJ8JOyYDvTX"
            // 리다이렉트 URL을 utf-8로 인코딩해서 저장
            const redirectURI = encodeURIComponent("http://localhost:7777/etc/naver-login")
            // 네이버 API에서 요구하는 임의의 2자리 수
            const state = Math.random().toString(36).substring(2) // 36진수 변환 후 맨앞 2개 선택

            let apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
            apiURL += "&client_id=" + clientId;
            apiURL += "&redirect_uri=" + redirectURI;
            apiURL += "&state=" + state;

            location.href = apiURL;
        }
    </script>
</body>
</html>