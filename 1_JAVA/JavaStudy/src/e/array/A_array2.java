package e.array;

public class A_array2 {

	public static void main(String[] args) {
		/*
		int i = 10;
		int[] iArr = new int[5];
		System.out.println(iArr.hashCode());
		
		double[] dArr = new double[3];
		System.out.println(dArr.hashCode());
		*/
		
		/*
		 * 실제 리터럴값을 곧바로 담을 수 있는 변수를 일반변수라고 한다.
		 * 주소값을 담고있는 변수는 참조변수(레퍼런스 변수)라고 한다.
		 * 
		 * 기본자료형(원시타입) : boolean, char, byte, short, int, long, float, double
		 * => 실제 리터럴값을 바로 담을 수 있다.
		 * 
		 * 그 외 자료형(String, Scanner, int[], double[], char[]...) -> 참조변수
		 * 
		 */

		// 각 인덱스의 초기화를 하지 않아도, 기본적으로 값이 담겨있다.
		// Heap 메모리공간은 절대 빈 공간을 허용하지 않는다.
		// => 공간이 만들어질 때, JVM이 기본값으로 초기화를 진행한다.
		int[] iArr = new int[10]; // 0~9번 인덱스 사용가능, 0으로 초기화되어있음
		System.out.println(iArr[3]);
		
		double[] dArr = new double[4]; // 0~3번 인덱스 사용가능, 0으로 초기화되어있음
		System.out.println(dArr[1]);
		
		System.out.println(iArr); // 배열의 자료형 + @ + 주소값의 16진수형태
		System.out.println(iArr.hashCode()); // 주소값의 10진수 형태
		// . <- 메모리에 접근한다는 의미
		// 따라서 iArr이 null 값인데 .hashCode() 를 수행하면 에러가 난다.
		
		int[] arr = null; // 아무것도 참조하고있지 않음
		//null은 개발자가 의도적으로 비어있다는 표시를 하는것
		//인터프리터 언어에서 null과 구분되는 undefined => 의도하지 않았는데, 비어있는 공간
		
		arr = new int[5];
		/*
		 * ArrayIndexOutOfBoundsException
		 * : 배열에 부적절한 인덱스를 제시하면 발생하는 에러
		 * System.out.println(arr[5]);
		 * 
		 * 배열의 가장 큰 단점
		 *  - 한번 지정된 배열의 크기는 변경이 불가하다
		 *  - 배열의 크기를 변경하고자 한다면, 다시 만들어야한다.
		 */
		System.out.println(arr.hashCode());
		arr = new int[7];
		System.out.println(arr.hashCode());
		// 주소값이 변경되었다 -> 새로운 곳을 참조하고 있다.
		
		/*
		 * 연결이 끊어진 기존 배열공간(Heap)은 어떤 변수에도 참조되지 않아, 불러올 수 없는 메모리가 된다.
		 * => 일정시간이 지나면 가비지 컬렉터(GC)가 알아서 지워줌
		 * => 자바에서의 "자동 메모리 관리" 특징 => 개발자가 코드에만 집중할 수 있다.
		 */
		
		arr = null; // 배열을 강제로 삭제시키고자 한다면, 연결고리를 끊어주면 된다.(null 대입)
		
		int[] arr2 = {1,1,1,1,1}; // 값은 같지만
		int[] arr3 = {1,1,1,1,1}; // 각자 다른 주소에 생성됨
		System.out.println(arr2 == arr3); // false, 참조변수 비교는 == 하면 안된다.
		// 참조변수 비교는 주소값을 비교하기 때문.
		
		arr3 = arr2; // 참조되는 값이아닌, 주소값이 복사가 된다.
		System.out.println(arr2 == arr3); // true, 주소값이 같아졌기 때문

		arr3[0] = 100;
		System.out.println(arr2[0]); // 같은 주소를 참조중이기 때문에, arr2의 값도 바뀐다
		
		
	}

}
