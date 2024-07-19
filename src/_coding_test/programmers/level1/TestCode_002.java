package _coding_test.programmers.level1;

import java.util.Arrays;

public class TestCode_002 {
	
	// https://school.programmers.co.kr/learn/courses/30/lessons/92334
	
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		final int MAX_REPORTED_NUM = 2;
		
		boolean[][] isReported = new boolean[id_list.length][id_list.length];
		int[] reportedNum = new int[id_list.length];
		int[] mailNum = new int[id_list.length];
		
		//신고회수 계산
		for(int i=0;i<report.length; i++) {
			String[] name = report[i].split(" ");
			String reportUser = name[0];   //신고자 이름
			String reportedUser = name[1]; //피신고자 이름
			
			int x = Arrays.asList(id_list).indexOf(reportUser);
			int y = Arrays.asList(id_list).indexOf(reportedUser);
			
			if(isReported[x][y] == false) {
				reportedNum[y] ++;
				isReported[x][y] = true;
			}
		}
		
		//메일 수 계산
		for(int i=0;i<reportedNum.length; i++) {
			if(reportedNum[i] >= MAX_REPORTED_NUM) {
				for(int j=0; j<mailNum.length; j++) {
					mailNum[j] += (isReported[j][i] == true) ? 1 : 0;
				}
			}
		}
		
		//결과 출력
		for(int i=0;i<mailNum.length;i++) {
			System.out.print(mailNum[i]);
		}

	}

}
