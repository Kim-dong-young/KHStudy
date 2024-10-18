<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    쿠키만료
    <script>
        function deleteCookie(name){
            document.cookie = name + "=; Max-Age=-9999999;"
        }

        deleteCookie("theme");
    </script>
</body>
</html>