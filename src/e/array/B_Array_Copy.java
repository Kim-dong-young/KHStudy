package e.array;

public class B_Array_Copy {

	public static void main(String[] args) {
		/*
		int[] origin = { 1, 2, 3, 4, 5 };

		System.out.print("==원본 배열 출력==" + "\n" + "origin : ");
		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}

		// 단순하게 origin을 대입시킨 copy배열 생성
		int[] copy = origin;

		System.out.print("\n==복사본 배열 출력==" + "\n" + "copy : ");
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		copy[2] = 99;
		System.out.println("\n\n"+"copy[2] = 99;");
		System.out.println("\n------------복사본 값 변경 후---------------\n");
		
		System.out.print("==원본 배열 출력==" + "\n" + "origin : ");
		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		
		System.out.print("\n==복사본 배열 출력==" + "\n" + "copy : ");
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		*/
		
		// 복사본 copy의 값만 수정해도 원본의 값이 함께 변경된다.
		// 왜냐하면 origin과 copy가 같은 메모리를 참조하고 있기 때문(참조변수의 주소값이 동일)
		// 이를 얕은복사(주소값 복사) 라고 한다.
		// 짤팁 : tap = 들여쓰기(오른쪽방향), shift + tap = 들여쓰기(왼쪽방향)
		
		/*
		 * 배열 복사 방법
		 * 
		 * 1. for 문을 활용한 방법
		 * 새로운 배열을 만들어서, 반복문을 통해, 원본 배열의 값들을 새로운 배열에 대입
		 * 
		 */
		
		/*
		int[] origin = {1,2,3,4,5};
		
		//origin배열과 크기가 같은 copy 배열 생성
		int[] copy = new int[origin.length];
		
		//origin배열에 있는 모든 값을 copy배열로 전달
		for(int i=0;i<origin.length;i++) {
			copy[i] = origin[i];
		}
		
		System.out.print("==원본 배열 출력==" + "\n" + "origin : ");
		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}

		System.out.print("\n==복사본 배열 출력==" + "\n" + "copy : ");
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		copy[2] = 99;
		
		System.out.println("\n\n"+"copy[2] = 99;");
		System.out.println("\n------------복사본 값 변경 후---------------\n");
		
		// 단순 복사와 달리, origin의 값이 바뀌지 않았음을 확인 가능
		System.out.print("==원본 배열 출력==" + "\n" + "origin : ");
		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		
		System.out.print("\n==복사본 배열 출력==" + "\n" + "copy : ");
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		*/
		
		//2. 새로운 배열 생성 후 arraycopy() 메소드를 이용해서 복사하기
		int[] origin = { 1, 2, 3, 4, 5 };
		int[] copy = new int[10]; // { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
		
		//System.arraycopy(원본배열, 복사 시작 인덱스, 복사본배열, 복사본 배열의 시작 인덱스, 복사할 개수)
		System.arraycopy(origin, 2, copy, 4, 3); 
		// origin[2], origin[3], origin[4] 3개를 
		// copy[4], copy[5], copy[6] 에 복사
		
		System.out.print("\n==복사본 배열 출력==" + "\n" + "copy : ");
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		//혹은 copy = origin.clone();
		

	}

}
