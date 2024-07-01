package b.operator;

public class Operator2 {
	/*
	 * 증감연산자
	 * ++ : 변수에 담긴 값을 1 증가시켜주는 연산자
	 * -- : 변수에 담긴 값을 1 감소시켜주는 연산자
	 * 
	 * (증감연산)변수 : 전위연산 -> "선증감" 후처리
	 * 변수(증감연산) : 후위연산 -> "선처리" 후증감
	 * 
	 */
	public static void main(String[] args) {
		int num1 = 0;
		System.out.println(num1++); // num1이 print 된 후에, 증가가 된다. 따라서 출력은 0이고, 수행 후 1로 값이 변경됨
		System.out.println(++num1); // 위에서 1이 증가된 num1 의 값을 print 하기전, 증가 처리를 하고 출력하므로 값이 2가 출력된다.
		
		//출력(최종값) 형태로 예상해보자.
		System.out.println(num1--); // 2(1)
		System.out.println(++num1); // 2(2)
		System.out.println(++num1); // 3(3)
		System.out.println(num1++); // 3(4)
		System.out.println(num1--); // 4(3)
		System.out.println(--num1); // 2(2)
		System.out.println(--num1); // 1(1)

		
	}
}
