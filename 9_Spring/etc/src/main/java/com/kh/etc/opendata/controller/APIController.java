package com.kh.etc.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	public static final String SERVICE_KEY = 
			"udaNWTjDYLORfpoGs5PS64FH9hMzB2UrTpGDO8ahf0%2FCSWOJ09DogIe8HduuTkKmh5GZaiEiWK06vx2Un1OHRw%3D%3D";
	
	@ResponseBody
	@GetMapping(value="air", produces="application/json; charset=utf-8")
	public String getAirInfo(String location) throws IOException {
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + SERVICE_KEY;
		url += "&returnType=json";
		url += "&sidoName=" + URLEncoder.encode(location,"UTF-8"); // 요청시 전달값에 한글이 있으면 인코딩 후 전달
		
		// 자바 코드로 클라이언트 역할을 해서 서버로 요청을 보낼 때
		// HttpURLConnection 객체를 이용해서 요청을 보냄
		
		// 1. 요청하고자하는 url을 전달하면서 java.net.URL 객체 생성
		URL requestURL = new URL(url);
		
		// 2. 만들어진 URL 객체를 가지고 HttpURLConnection 객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestURL.openConnection();
		
		// 3. 요청에 필요한 Header정보 설정하기
		urlConnection.setRequestMethod("GET"); // 기본값은 GET이라 GET이면 따로 안써도 되긴한다
		
		// 4. 해당 API서버로 요청 보낸 후 입력 데이터 읽어오기
		// inputstream(1바이트) => inputstreamreader(2바이트) => bufferedreader(한줄씩)
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String result = "";
		String line;
		while( (line = br.readLine()) != null) {
			result += line;
		}
		br.close();
		urlConnection.disconnect();
		
		return result;
	}
}
