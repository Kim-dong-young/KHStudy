package test240708;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test6 {
	// 키보드로 1개의 정수형(int) 데이터를 입력 받아 
	//1부터 5까지 일때만 해당 숫자에 해당하는 결과를 출력 한다. 단, switch문을 이용한다.
	
	/*
	 * 1부터 5까지의 숫자와 그 이외의 숫자가 입력되었을 때 아래와 같이 출력된다.
		1 : ** 입력이 정상적으로 되었습니다! **
		2 : ** 조회가 시작되었습니다! **
		3 : ** 수정이 정상적으로 되었습니다! **
		4 : ** 삭제가 정상적으로 되었습니다! **
		5 : ** 정상적으로 종료 되었습니다! **
		1~5가 아닌 값이 입력 된 경우 : ** 다시 입력해 주세요! **
	 */
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num;
		
		try {
			num = s.nextInt();
		}catch(InputMismatchException e){
			num = -1;
		}
		
		switch(num) {
		case 1:
			System.out.println("** 입력이 정상적으로 되었습니다! **");
			break;
		case 2:
			System.out.println("** 조회가 시작되었습니다! **");
			break;
		case 3:
			System.out.println("** 수정이 정상적으로 되었습니다! **");
			break;
		case 4:
			System.out.println("** 삭제가 정상적으로 되었습니다! **");
			break;
		case 5:
			System.out.println("** 정상적으로 종료 되었습니다! **");
			break;
		default:
			System.out.println("** 다시 입력해 주세요! **");
			break;
				
		}
		
		
		
		s.close();
	}

}
