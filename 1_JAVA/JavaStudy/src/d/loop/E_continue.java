package d.loop;

public class E_continue {
	/*
	 * continue : 반복문 안에 기술되는 구문
	 * 			  continue; 코드를 실행시, 그 뒤의 코드를 실행하지 않고
	 * 			  곧바로 반복문의 상단으로 이동한다.
	 */

	public static void main(String[] args) {
		
		/*
		// 1부터 10까지 홀수 출력
		for(int i=1;i<=10;i++) {
			if(i%2==1) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
		
		//continue를 활용
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				continue;
			}
			System.out.print(i+" ");
		}
		*/
		
		// 1부터 100까지의 총 합계
		// 단, 6의 배수값은 뺴고
		int sum=0;
		for(int i=1; i<=100; i++) {
			if(i%6==0) continue;
			sum+=i;
		}
		System.out.println(sum);
	}

}
