<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>채팅</h1>
    메시지 : <input type="text" name="msg"><br>
    수신자 : <input type="text" name="target">

    <button onclick="sendMsg()">전송</button>
    <br>
    <div id="msg-container"></div>

    <script>
        const socket = new WebSocket("ws://localhost:7777/etc/server");

        socket.onopen = function(){
            console.log("연결성공...")
        }

        // 연결을 성공적으로 끊음
        socket.onclose = function(){
            console.log("연결끊어짐...")
        }

        // 연결 자체가 실패
        socket.onerror = function(){
            console.log("연결실패...")
        }

        // socket연결로부터 데이터가 도착했을 때 실행하는 이벤트
        socket.onmessage = function(ev){
            const receive = JSON.parse(ev.data)

            const msgContainer = document.querySelector('#msg-container')
            msgContainer.innerHTML += (receive.nick + "(" + receive.time + ")<br>" + receive.msg + "<br>")
        }

        function sendMsg(){
            const msgData = {
                message: document.querySelector("input[name=msg]").value,
                target: document.querySelector("input[name=target]").value,
            }

            socket.send(JSON.stringify(msgData))
        }
    </script>
</body>
</html>