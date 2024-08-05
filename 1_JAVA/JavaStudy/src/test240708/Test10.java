package test240708;

public class Test10 {
	// 2차원 배열에 들어있는 데이터들 중 3의 배수만 골라내서 새로운 1차원배열에 기록하고 출력한다. 
	// 단 중복 값은 하나만 기록되게 한다.
	
	//int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}};
	//int[] copyAr = new int[array의 행갯수 * 열갯수];

	public static void main(String[] args) {
		int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}};
		
		int size = 0;
		for(int[] arr:array) {
			size += arr.length;
		}
		
		int[] copyAr = new int[size];
		int index = -1;
		boolean isDuplicated = false;
		
		System.out.print("copyAr : ");
		for(int[] arr:array) {
			for(int num:arr) {
				
				if(num % 3 == 0) { // num이 3의 배수일 경우
					
					//copyAr 내 중복 원소 체크
					for(int i=0; i<= index; i++) {
						if(copyAr[i] == num) isDuplicated = true;
					}
					
					//중복일 경우 다음 원소 탐색
					if(isDuplicated) {
						isDuplicated = false;
						continue;
					}
					
					//3의 배수이면서 중복이 아닐 경우 copyAr에 추가
					copyAr[++index] = num;
					System.out.print(copyAr[index] + " ");
				}
				
			}
		}
		
		
	}
}
