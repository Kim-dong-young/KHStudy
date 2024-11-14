package com.kh.etc.sns.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	@Value("${sns.naver.clientId}")
	private String clientId;
	
	@Value("${sns.naver.clientSecret}")
	private String clientSecret;
	
	@RequestMapping("login")
	public String login() {
		return "redirect:/";
	}
	
	@RequestMapping("naver-login")
	public String naverLoginCallback(String code, String state) throws Exception {
		String redirectURL = URLEncoder.encode("http://localhost:7777/etc/naver-login","UTF-8");
		String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
		apiURL += "&client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&redirect_uri=" + redirectURL;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		
		log.info("url : {}",apiURL);
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		int responseCode = con.getResponseCode();
		
		String inputLine = "";
		if(responseCode == 200) { // 정상적으로 정보를 받아왔다면
//			// 응답데이터를 읽어오기
//			BufferedReader br;
//			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//			StringBuffer res = new StringBuffer();
//			while( (inputLine = br.readLine()) != null) {
//				res.append(inputLine);
//			}
//			br.close();
//			
//			// 결과 확인 - access token, refresh token, 만료시간
//			String result = res.toString();
//			log.info("result : {}",res);
			String result = readBody(con.getInputStream());
			
			JsonObject totalObj = JsonParser.parseString(result).getAsJsonObject();
			
			String accessToken = totalObj.get("access_token").getAsString(); // 정보 접근을 위한 토큰
			String header = "bearer " + accessToken;
			
			apiURL = "https://openapi.naver.com/v1/nid/me";
			Map<String, String> requestHeaders = new HashMap<>();
			requestHeaders.put("Authorization",header);
			
			String responseBody = get(apiURL, requestHeaders);
			
			JsonObject memberInfo = JsonParser.parseString(responseBody).getAsJsonObject();
			memberInfo = memberInfo.getAsJsonObject("response");
			
			log.info("result : {}", memberInfo);
			// 받아온 email과 데이터베이스의 email을 비교하여 가입유무 판단한 후
			// 가입되어 있다면 로그인, 가입되어있지 않다면 회원가입창으로 해당정보를 담아서 보내주면 된다.
		}
		
		return "redirect:/";
	}
	
	// API에 GET요청 보내고 응답을 받아오는 메서드
	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection conn = connect(apiUrl);
		
		try {
			conn.setRequestMethod("GET");
			for(Map.Entry<String, String> header : requestHeaders.entrySet()) {
				conn.setRequestProperty(header.getKey(), header.getValue());
			}
			
			int responseCode = conn.getResponseCode();
			
			if(responseCode == 200) {
				return readBody(conn.getInputStream());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// API에 연결하기 위한 HttpURLConnection 객체를 생성해서 반환하는 메서드
	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection)url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException("연결에 실패하였습니다. : " + apiUrl, e);
		}
	}
	
	private static String readBody(InputStream bodyInput) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(bodyInput))) {
			StringBuffer res = new StringBuffer();
			
			String inputLine;
			while( (inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			return res.toString();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("바디정보를 읽는데 실패하였습니다. ", e);
		}
	}
}
