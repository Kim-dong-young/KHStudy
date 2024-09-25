<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style>
    .outer{
        background: black;
        color:white;
        width:1000px;
        margin:auto;
        margin-top: 50px;
    }

    .outer table{
        border: 1px solid white;
        border-collapse: collapse;
    }

    .outer > table tr, .outer > table td {
        border: 1px solid white;
    }
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
    <div class="outer">
        <br>
        <h2 align="center">사진게시글 상세보기</h2>
        <br>

        <table border="1" align="center">
            <tr>
                <th width="100">제목</th>
                <td colspan="3">
                    ${b.boardTitle}
                </td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${b.boardWriter}</td>
                <th>작성일</th>
                <td>${b.createDate}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td conlspan="3">
                    <p>${b.boardContent}</p>
                </td>
            </tr>
            <tr>
                <th>대표이미지</th>
                <td colspan="3">
                    <img src='<%=contextPath%>/${atList[0].filePath}${atList[0].changeName}' id="title-img" width="250" height="170">
                </td>
            </tr>
            <tr>
                <th>상세이미지</th>
                <c:forEach var="attachment" items="${atList}" varStatus="status">
                    <c:if test="${!status.first}">
                        <td><img width="150px" height="120px" src='<%=contextPath%>/${attachment.filePath}${attachment.changeName}'></td>
                    </c:if>
                </c:forEach>
            </tr>
        </table>

        <br>

        <div align="center">
            <a href="<%=contextPath%>/list.th" class="btn btn-sm">목록가기</a>
        </div>

    </div>
</body>
</html>