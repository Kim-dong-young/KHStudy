<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.model.vo.Person"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
	<h3>1. 기존 방식대로 스크립틀릿과 표현식을 이용하여 각 scope에 담겨있는 값을 화면에 출력</h3>
    <%
        // request scope값 가져오기
        String classRoom = (String)request.getAttribute("classRoom");
        Person student = (Person)request.getAttribute("student");

        // session scope값 가져오기
        String academy = (String)session.getAttribute("academy");
        Person teacher = (Person)session.getAttribute("teacher");
    %>
    
    <p>
    	학원명 : <%=academy %>
    	강의장 : <%=classRoom %>
    	강사 : <%=teacher.getName() %>, <%=teacher.getAge() %>, <%=teacher.getGender() %> <br><br>
    	
    	수강생 정보
    	<ul>
    		<li>이름 : <%=student.getName() %></li>
    		<li>나이 : <%=student.getAge() %></li>
    		<li>성별 : <%=student.getGender() %></li>
    	</ul>
    </p>
    -->
    
    <h3>2. EL을 이용하여 보다 쉽게 scope의 값을 출력하기</h3>
    <p>
        EL을 이용해 getter을 통해 값을 가져올 필요 없이, EL 구문내의 키값만 제시하면 바로 접근 가능 <br>
        기본적으로 EL은 JSP내장객체를 구분하지 않고, 자동으로 모든 내장객체의 키값을 검색하여 존재하면 값을 가져옴 <br>
    </p>

    <p>
        학원명 : ${academy}
        강의장 : ${classRoom}
        <!-- 객체.name 등등은 실제로는 getter을 이용해 가져온다. getter 없으면 애러남. -->
        강사 : ${teacher.name}, ${teacher.age}, ${teacher.gender} <br><br>
        
        수강생 정보
        <ul>
            <li>이름 : ${student.name}</li>
            <li>나이 : ${student.age}</li>
            <li>성별 : ${student.gender}</li>
        </ul>
    </p>

    <h3>3. scope의 키값이 동일한 경우</h3>
    <!-- EL은 공유범위가 가장 작은 스코프부터 해당 key값을 검색함( page -> request -> session -> application ) -->
    scope값 : ${scope} <br>
    <!-- 아무 영역에도 없는 없는값을 가져오려 하면 비워둠 -->
    test값 : ${test}

    <h3>4. 직접 scope를 지정하여 접근하기</h3>
    <%
        //page scope
        pageContext.setAttribute("scope","page");
    %>

    pageScope : ${scope}, ${pageScope.scope} <br>
    requestScope : ${requestScope.scope} <br>
    session : ${sessionScope.scope} <br>
    applicationScope : ${applicationScope.scope} <br><br>
</body>
</html>