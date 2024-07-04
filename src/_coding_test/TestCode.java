package _coding_test;

import java.util.Arrays;

public class TestCode {
	
	// https://school.programmers.co.kr/learn/courses/30/lessons/258712
	
	public static void main(String[] args) {
		String[] friends = {"muzi", "ryan", "frodo", "neo"};
		String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
		
        int[] countGift = new int[friends.length];
        int[] giftPoint = new int[friends.length];
        int[][] giftTable = new int[friends.length][friends.length];
        
        //주고받은 표 구성 ===================================
        for(int i=0;i < gifts.length; i++){
            String[] giftAndRecieve = gifts[i].split(" ");
            String gifter = giftAndRecieve[0];
            String receiver = giftAndRecieve[1];
            
            int x = Arrays.asList(friends).indexOf(gifter);
            int y = Arrays.asList(friends).indexOf(receiver);
            giftTable[x][y] += 1;
        }
        
        //선물 지표 계산 =====================================
        
        //준 선물 계산
        for(int i=0; i< friends.length; i++) {
        	for(int j=0; j< friends.length; j++) {
        		giftPoint[i] += giftTable[i][j];
        	}
        }
        
        //받은 선물 계산
        for(int i=0; i< friends.length; i++) {
        	for(int j=0; j< friends.length; j++) {
        		giftPoint[i] -= giftTable[j][i];
        	}
        }
        
        
        //선물 기록 탐색 ======================================
        for(int i=0; i < friends.length; i ++) {
        	for(int j=0; j< friends.length; j++) {
        		//선물을 주고받은 기록이 있다면 선물개수 누적
        		if (giftTable[i][j] > giftTable[j][i]) {
        			countGift[i]++;
        		}
        		//선물을 주고받은적이 없다면 선물 지수 계산
        		else if (giftTable[i][j] == giftTable[j][i]) {
        			//선물 지수가 더 크다면 선물개수 누적
        			if(giftPoint[i] > giftPoint[j]) {
        				countGift[i]++;
        			}
        		}
        	}
        }
        
        System.out.println(Arrays.stream(countGift).max().getAsInt());

        
	}
}
