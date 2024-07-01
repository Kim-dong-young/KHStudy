package test01;

import java.util.Arrays;

public class testCode {
	
	//https://school.programmers.co.kr/learn/courses/30/lessons/258712
	//작성중
	
	public static void main(String[] args) {
		String[] friends = {"muzi", "ryan", "frodo", "neo"};
		String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
		
		int answer = 0;
        int[] countGift = new int[friends.length];
        int[][] giftTable = new int[friends.length][friends.length];
        
        //주고받은 표 구성
        for(int i=0;i < gifts.length; i++){
            String[] giftAndRecieve = gifts[i].split(" ");
            String gifter = giftAndRecieve[0];
            String receiver = giftAndRecieve[1];
            
            int x = Arrays.asList(friends).indexOf(gifter);
            int y = Arrays.asList(friends).indexOf(receiver);
            giftTable[x][y] += 1;
        }
        
        //선물 기록 탐색
        for(int i=0; i < friends.length; i ++) {
        	for(int j=0; j< friends.length; j++) {
        		if (giftTable[0][i] > giftTable[j][i]) {
        			countGift[i]++;
        		}
        		else {
        			
        		}
        	}
        }
        
        /*
        //giftTable 출력
        for(int i=0;i < friends.length; i++) {
        	for(int j=0;j < friends.length; j++) {
        		System.out.print(giftTable[i][j]);
        	}
        	System.out.println();
        }
        */
        
	}
}
