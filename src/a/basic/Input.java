package a.basic;
import java.util.Scanner;

public class Input {
	/*
	 * 키보드로 값 입력하는 방법
	 * Scanner 클래스를 사용한다.
	 * java.util.Scanner 패키지를 불러온다.
	 * 
	 * [사용법]
	 * Scanner 이름 = new Scanner(System.in);
	 * ex) Scanner sc = new Scanner(System.in);
	 * 
	 * 스캐너는 버퍼가 비어있을 경우, 버퍼에 담긴 키보드 입력값을 정해진 만큼 읽어온다.
	 * 만약 버퍼에 값이 남아있을 경우, 추가로 키보드 입력을 받지 않고 버퍼에 남아있는 값부터 읽어온다.
	 * 
	 * sc.next() : 사용자가 입력한 값 중 공백이 있을경우, 공백 이전 까지의 값만 버퍼에서 가져온다.
	 * sc.nextLine() : 사용자가 입력한 값 중 \n(개행문자)를 포함하는 한 라인을 읽고, \n을 버린 나머지 값만 버퍼에서 가져온다.
	 * 
	 * sc.nextByte(), sc.nextShort(), sc.nextInt(), sc.nextLong()
	 * sc.nextFloat(), sc.nextDouble(),
	 * 위처럼 정수나 실수를 입력받는 코드를 작성했을 때 \n 토큰이 함께 들어오기 때문에
	 * sc.nextLine()처럼 \n을 비워주는 코드를 작성해야한다.
	 * 
	 * 현업에서 쓰이는 코드에서 키보드와 같은 자원을 받아오는 코드는 부하가 굉장히 많이된다
	 * 왜냐하면 프로그램이 종료되지 않고, 계속 돌아가야하기 때문이다. ex)서버
	 * 따라서 저런 코드가 계속 쌓이다보면 프로그램이 터질것이다.
	 * 가져온 리소스를 반납하는 코드를 항상 작성해주도록 하자.
	 * sc.close() 로 스캐너 인스턴스를 종료해준다.
	 * 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		/*
		String str1, str2;
		
		str1 = sc.next(); //입력후 엔터를 입력하면, 버퍼에 개행문자도 같이 입력된다
		sc.nextLine();    //버퍼에 남아있는 개행문자를 제거한다
		str2 = sc.nextLine();
		
		System.out.println("str1 입력한 값 : "+str1);
		System.out.println("str2 입력한 값 : "+str2);
		
		*/
		
		String name;
		int age;
		float height;
		
		System.out.println("이름 입력: ");
		name = sc.next();
		sc.nextLine();
		
		System.out.println("나이 입력: ");
		age = sc.nextInt();
		sc.nextLine();
		
		System.out.println("키 입력: ");
		height = sc.nextFloat();
		sc.nextLine();
		
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("키 : "+ height);
		
		sc.close(); //사용한 리소스는 반드시 반납하는 습관을 들이도록 하자.
	}

}
