package test240708;

public class Test3 {
	// 1부터 100까지의 모든 정수들의 합과 평균을 구하는 프로그램을 작성한다.
	// 단, while문이나 do while문을 이용하여 작성한다.
	public static void main(String[] args) {
		double avg = 0, sum = 0;
		int count=1;
		
		while(count <= 100) {
			sum+=count;
			count++;
		}
		avg = sum / (count - 1);
		
		System.out.printf("합계 :%.0f\n",sum);
		System.out.println("평균 :" + avg);

	}

}
