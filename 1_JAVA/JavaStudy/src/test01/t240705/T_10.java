package test01.t240705;

import java.util.Scanner;

public class T_10 {

	public static void main(String[] args) {
		/* test01.t240704 -> T_07.java
		 * 위 문제와 모든것이 동일하고, "더 하시겠습니까?" 라고 추가로 물어보도록 하세요
		 * 이 때, N이나 n이 나오면 프로그램을 끝내고, Y나 y면 계속 진행하도록 하되 Y,y,N,n이 아닌
		 * 다른 문자를 입력햇을 경우 "잘못된 대답입니다. 다시 입력해주세요."를 출력하고
		 * 더 하겠냐는 물음을 반복하세요.
		 */
		Scanner s = new Scanner(System.in);
		
		char alpha;
		
		while(true) {

			System.out.print("문자열 : ");
			String word = s.next();

			System.out.print("문자 : ");
			alpha = s.next().charAt(0);

			int alphaCnt = 0;
			char[] arr = new char[word.length()];

			System.out.print("\n" + word + "에 " + alpha + "가 존재하는 위치(인덱스) : ");
			for (int i = 0; i < word.length(); i++) {
				arr[i] = word.charAt(i);

				if (arr[i] == alpha)
					System.out.print(i + " ");
				alphaCnt += (arr[i] == alpha) ? 1 : 0;
			}
			System.out.println("\n" + alpha + " 개수 : " + alphaCnt);
			
			while(true) {
				System.out.println("더 하시겠습니까? (y/n) : ");
				alpha = s.next().charAt(0);
				
				if(alpha == 'y' || alpha == 'Y' || alpha == 'n' || alpha == 'N' )
					break;
				else
					System.out.println("잘못된 대답입니다. 다시 입력해주세요.");
			}
			
			if(alpha == 'n' || alpha =='N') break;
			
		}
		
		s.close();
	}

}
