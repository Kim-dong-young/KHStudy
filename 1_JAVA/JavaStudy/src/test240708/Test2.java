package test240708;

public class Test2 {
	// 2단에서 5단까지의 구구단의 결과 중 홀수인 것만 출력한다. 단, for문을 이용한다.
	public static void main(String[] args) {
		for (int dan = 2; dan <= 5; dan++) {
			if (dan % 2 == 1) // 홀수단 일 경우
				for (int su = 1; su <= 9; su += 2) { //홀수곱 출력
					System.out.printf("%d*%d=%d\n",dan,su,dan*su);
				}
		}

	}

}
