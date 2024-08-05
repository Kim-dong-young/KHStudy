package test01.t240705;

import java.util.Arrays;
import java.util.Scanner;

public class T_12 {

	public static void main(String[] args) {
		/*
		 * 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요.
		 * 컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해 결정하도록 하고,
		 * 사용자에게는 직접 가위바위보를 받으세요.
		 * 사용자가 "exit"를 입력하기 전까지 가위바위보를 계속 진행하고
		 * "exit"가 들어가면 반복을 멈추고, 몇 번의 승부에서 몇번 이기고 몇번 비기고 몇번 졌는지 출력하세요.
		 * 
		 * 당신의 이름을 입력해주세요 : 박신우
		 * 가위바위보 : 가위		가위바위보 : exit			
		 * 컴퓨터 : 가위			3전 0승 2무 1패
		 * 박신우 : 가위
		 * 비겼습니다.
		 * 
		 * 가위바위보 : 가위
		 * 컴퓨터 : 바위
		 * 박신우 : 가위
		 * 졌습니다 ㅠㅠ
		 * 
		 * 가위바위보 : 가위
		 * 컴퓨터 : 가위
		 * 박신우 : 가위
		 * 비겼습니다.
		 */
		
		Scanner s = new Scanner(System.in);
		
		// 0->1 , 1->2, 2->0
		String[] hand = {"가위","바위","보"};
		String playerHand;
		String computerHand;
		
		int playerIndex;
		int computerIndex;
		
		int round=0;
		int win=0;
		int draw=0;
		int lose=0;
		
		System.out.print("당신의 이름을 입력해주세요 : ");
		String name = s.next();
		
		while(true) {
			System.out.print("가위바위보 : ");
			playerHand = s.next();
			if(playerHand.equals("exit")) {
				System.out.printf("%d전 %d승 %d무 %d패",round,win,draw,lose);
				break;
			}
			computerHand = hand[(int)(Math.random() * 3)];
			
			System.out.printf("%s : %s\n",name,playerHand);
			System.out.printf("컴퓨터 : %s\n", computerHand);
			
			playerIndex = Arrays.asList(hand).indexOf(playerHand);
			computerIndex = Arrays.asList(hand).indexOf(computerHand);
			
			if(playerIndex == computerIndex) {
				System.out.println("무승부");
				draw++;
			}
			else if( (playerIndex + 1) % 3 == computerIndex) {
				System.out.println("졌습니다 ㅠㅠ");
				lose++;
			}
			else {
				System.out.println("이겼습니다.");
				win++;
			}
			round++;
		}

	}

}
