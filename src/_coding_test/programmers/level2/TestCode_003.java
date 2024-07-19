package _coding_test.programmers.level2;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/42888

public class TestCode_003 {

	public static void main(String[] args) {
		String[] record = {
				"Enter uid1234 Muzi", 
				"Enter uid4567 Prodo",
				"Leave uid1234",
				"Enter uid1234 Prodo",
				"Change uid4567 Ryan"
		};
		HashMap<String, String> userList =new HashMap();
		String[] readLine; // 0 : status, 1 : uid, 2 : uname
		String status;
		String uid;
		String uname;
		int answerLength = 0;
		
		// 최종 유저 이름 구성
		for(int i=0; i<record.length; i++) {
			readLine = record[i].split(" ");
			status = readLine[0];
			uid = readLine[1];
			if(status.equals("Leave")) {
					answerLength++;
					continue;
			}
			uname = readLine[2];
			
			if(!status.equals("Change")) answerLength++;
			
			if(!userList.containsKey(uid)) {
				userList.put(uid, uname);
			}
			else {
				if(status.equals("Enter") || status.equals("Change"))
					userList.replace(uid,uname);
			}
		}
		
		// 정답 작성 
		String[] answer = new String[answerLength];
		int index = 0;
		for(int i=0; i<record.length; i++) {
			readLine = record[i].split(" ");
			status = readLine[0];
			uid = readLine[1];
			if(status.equals("Change")) continue;
			
			if(status.equals("Enter")) {
				answer[index] = userList.get(uid) + "님이 들어왔습니다.";
			}
			if(status.equals("Leave")) {
				answer[index] = userList.get(uid) + "님이 나갔습니다.";
			}
			index++;
		}
		
		for(String s : answer) {
			System.out.println(s);
		}

	}

}
