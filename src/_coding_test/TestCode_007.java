package _coding_test;

public class TestCode_007 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/42888
	// 작성중
	final static int status = 0;  // Enter, Leave, Change
	final static int message = 0; // 들어갔습니다, 나갔습니다
	final static int uid = 1;
	final static int userName = 2;
	
	static String getUserName(String[][] userList, String userid) {
		for(int i=0; i<userList.length;i++) {
			if(userList[i][0].equals(userid)) { // 0 : uid
				return userList[i][1]; // 1 : userName
			}
		}
		return "";
	}
	
	static int getUserIndex(String[][] userList, String userid) {
		int index = -1;
		for(int i=0; i<userList.length;i++) {
			if(userList[i][0].equals(userid)) {
				index = i;
			}
		}
		return index;
	}
	
	static void addUserList(String[][] userList, String[][] chat, String[] readRecord, int userListTop) {
		
		// 유저가 userList에 없다면 추가
		if (getUserName(userList,readRecord[uid]).equals("")) {
			userList[userListTop][0] = readRecord[uid];
			userList[userListTop][1] = readRecord[userName];
		}

		// 유저가 userList에 있다면 chat 기록에 있는 모든 이름 갱신
		else {
			int index = getUserIndex(userList, readRecord[uid]);
			userList[index][1] = readRecord[userName]; // userList의 해당 user 이름 갱신

			fixChatUserName(userList, chat, readRecord[uid], userListTop);
		}
	}
	
	static void fixChatUserName(String[][] userList, String[][] chat, String uid,int userListTop) {
		for(int i=0; i<=userListTop; i++) {
			if(chat[i][1].equals(uid)) {
				chat[i][2] = getUserName(userList, uid);
			}
		}
	}
	
	public static void main(String[] args) {
		String[] record = {
				"Enter uid1234 Muzi", "Enter uid4567 Prodo",
				"Leave uid1234","Enter uid1234 Prodo",
				"Change uid4567 Ryan"
		};
		String[] answer = {};
		
		String[] readRecord = new String[3]; // 0 : status,  1 : uid, 2 : userName
		String[][] chat = new String[record.length][3]; // 0 : message, 1 : uid, 2 : userName
		String[][] userList = new String[record.length][2]; // 0 : uid, 1 : userName
		
		for(int i=0;i<userList.length;i++) {
			for(int j=0;j<userList[i].length;j++) {
				userList[i][j] = "";
			}
		}
		
		int userListTop = -1;
		String currentUID;
		
		for(int i=0;i<record.length;i++) {
			readRecord = record[i].split(" "); // 한 줄씩 기록 읽기
			currentUID = readRecord[uid];
			
			if(readRecord[status].equals("Enter")) {
				userListTop++;
				addUserList(userList, chat, readRecord, userListTop);
				
				chat[i][uid] = currentUID;
				chat[i][userName] = readRecord[2];
				chat[i][message] = "님이 들어왔습니다.";
			}
			else if(readRecord[status].equals("Leave")){
				chat[i][uid] = currentUID;
				chat[i][userName] = getUserName(userList,currentUID);
				chat[i][message] = "님이 나갔습니다.";

			}
			else if(readRecord[status].equals("Change")){
				int index = getUserIndex(userList, currentUID);
				userList[index][1] = readRecord[2]; //userList의 해당 user 이름 갱신
				
				fixChatUserName(userList,chat,currentUID,userListTop);
			}
		}
		
		int answerLength = 0;
		for(int i=0; i<chat.length;i++) {
			if(chat[i][0] == null) {
				answerLength = i;
				break;
			}
		}
		
		answer = new String[answerLength];
		
		for(int i=0; i<answerLength; i++) {
			answer[i]= chat[i][2]+chat[i][0]+"\n";
			System.out.println(answer[i]);
		}
		
	}

}
