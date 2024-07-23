package k.exception.ex1;

import java.io.IOException;
import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		/*
		 * 에러 종류
		 * - 시스템 에러 : 컴퓨터의 오작동으로 발생하는 에러 -> 소스코드로 해결이 안됨 -> 심각
		 * - 컴파일 에러 : 소스코드 문법상의 오류 -> 빨간줄로 애초에 오류를 알려준다.( 개발자의 실수 )
		 * 				발견과 해결이 쉽다.
		 * - 런타임 에러 : 코드 상으로 문제가 없지만, 프로그램 실행 도중 발생하는 에러 
		 * 				( 사용자의 실수 또는 개발자가 미처 처리하지 않은 기능 )
		 * - 논리 에러 : 문법적으로도 문제없고 실행했을 때도 문제는 없지만, 
		 * 			   프로그램의 의도와 맞지않는 동작이나 결과가 나타나는 에러
		 * 
		 * 컴파일에러, 런타임에러, 논리에러 같은 개발자가 예측가능하며 수정할 수 있는 에러들을 가지고 작업
		 * => 이런것들을 예외라고 한다 ( Exception )
		 * 
		 * 이런 "예외"가 발생했을 때를 "처리"하는 방법을 "예외 처리"라고 한다.
		 * 
		 * &예외처리를 하는 목적
		 * - 예외처리를 하지않고 그대로 예외가 발생할 경우, 프로그램이 비정상적으로 종료될 수 있다.( 손해 막심 )
		 * 
		 * &예외처리 방법
		 * 1. try-catch문을 이용(내가 처리)
		 * 2. throws를 이용(떠넘기기)
		 * 
		 * 사용한 리소스 반납 방법 2가지
		 * 1. finally에서 반납
		 * 2. try-with-resource
		 */
		
		RunException ex = new RunException();
		
		// ex.method01();
		// ex.method02();
		
		/*
		try {
			ex.methodA();
		} catch (IOException e) {
			System.out.println("main에서 해결");
			e.printStackTrace();
		} finally { // finally : 예외가 발생하건 안하건 try-catch 종료 후 마지막에 실행하는 코드
			System.out.println("종료");
		}
		*/
		
		// try-with-resource : 끝나면 자동으로 반환됨 like for문, 여러개 선언도 가능
		try(Scanner sc = new Scanner(System.in);) {
			ex.methodA();
		} catch (IOException e) {
			System.out.println("main에서 해결");
			e.printStackTrace();
		}
		
		
		ex.myInfo(null);
	}
}
