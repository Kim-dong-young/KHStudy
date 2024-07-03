package e.array;

public class A_array {
	/*
	 * 변수 : 하나의 공간에 하나의 값을 담을 수 있다.
	 * 배열 : 하나의 공간에 여러개의 값을 담을 수 있는 개념
	 * 		 "같은 자료형의 값"으로만 담을 수 있다.
	 * 		 배열의 각 인덱스 자리에 실제 값이 담김 ( index는 0부터 시작 )
	 * 
	 * 배열을 왜 사용할까?
	 * 변수만을 사용하게 된다면 -> 대량의 데이터들을 보관하고자 할 때, 각각의 변수를 만들어서 따로 관리해야한다.
	 * 
	 */
	public static void main(String[] args) {
		/*
		//int형 변수 5개 만들어서 0~4의 값을 각각 할당해주세요.
		int[] arr1 = {0,1,2,3,4};
		*/
		
		/*
		 * 1.배열 선언(여러개의 값들을 보관할 배열을 만들겠다. -> 참조변수 선언)
		 * 자료형[] 배열이름;
		 * 자료형 배열이름[];
		 * 메모리 Stack 영역에 참조변수가 생성된다
		 */
		
		int[] arr;
		
		/*
		 * 2.배열 할당(이 배열에 몇개의 값들을 보관할건지 크기를 지정하는 과정)
		 * 배열명 = new 자료형[배열의 크기(길이)];
		 * 메모리 Heap 영역에 공간이 확보되고, 참조변수에게 참조된다
		 */
		
		arr = new int[5];
		//Heap영역 주소값을 직접 볼 수는 없지만, 해싱된 주소값을 얻어올 수는 있다.
		System.out.println(arr.hashCode());
		
		//배열을 선언과 동시에 할당
		int[] arr2 = new int[5]; //공간만 할당할 경우, int는 0, String은 null로 초기화됨
		
		/*
		 * 3.값을 대입하고 가져와서 사용하기
		 * index를 이용해서 접근한다.
		 */
		
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		arr[3]=40;
		arr[4]=50;
		
		//배열의 범위를 벗어난 index를 사용하면 에러가 발생한다.
		try {
			arr[5] = 60;
		}catch(IndexOutOfBoundsException e) {
			System.out.println("배열 범위를 벗어나면 오류가 발생한다.");
		}
		
		//배열의 길이를 구할땐, .length를 사용한다.
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		
		//참조변수 자체를 출력하면, arr의 정보가 출력된다
		System.out.println(arr); // [I@5~~ : Int형@~~16진수주소~~
		
		//참조변수와의 연결을 끊으려면, 참조변수에 null값을 할당해준다.
		arr = null;
		System.out.println(arr); //참조주소가 사라진걸 확인 가능 => GC가 메모리 회수해간다
		
		

	}

}
