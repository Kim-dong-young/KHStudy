package com.kh.etc.chat;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ChatServer extends TextWebSocketHandler{
	
	// ConcurrentHashMap : 쓰레드에서 안정적인 HashMap, 락 걸어줌
	private final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<>();

	// 클라이언트가 Http 요청을 보내 소켓 연결을 맺을 때 호출이 되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String nick = (String)session.getAttributes().get("nick");
		log.info("{} 연결됨...", nick);
		
		userSessions.put(nick, session);
	}

	// 클라이언트로부터 메시지를 받을 떄 호출되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String nick = (String)session.getAttributes().get("nick");
		
		// 메세지 payload를 json 객체로 파싱
		JsonObject obj = new JsonParser().parse(message.getPayload()).getAsJsonObject();
		log.info("message : {}", obj.get("message").getAsString());
		log.info("target : {}", obj.get("target").getAsString());
		
		MsgVo vo = new MsgVo();
		vo.setMsg(obj.get("message").getAsString()); // 메시지
		vo.setNick(nick); // 발신자
		vo.setTargetNick(obj.get("target").getAsString());
		vo.setTime(new Date().toLocaleString());
		
		sendMessageUser(vo);
		
	}
	
	private void sendMessageUser(MsgVo vo) {
		WebSocketSession mySession = userSessions.get(vo.getNick()); // 매개변수에 있는  내(발신자)세션과 동일
		WebSocketSession targetSession = userSessions.get(vo.getTargetNick()); // 수신자
		
		if(targetSession != null && targetSession.isOpen()) {
			String str = new Gson().toJson(vo.getMsg());
			// 웹소켓 텍스트 전송 규격 메시지로 변환
			TextMessage msg = new TextMessage(str);
			
			try {
				targetSession.sendMessage(msg);
				mySession.sendMessage(msg); // 나에게도 메시지를 보내서, 받은뒤 프론트에서 출력
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 클라이언트가 연결을 끊을 때 호출되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}
	
}
