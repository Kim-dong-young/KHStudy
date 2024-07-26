package m.api.ex1;

import java.util.StringTokenizer;

public class B_String {
	public void method01() {
		System.out.println("===== String 클래스 =====");
		System.out.println("1. 생성자를 통한 문자열 생성");
		// 1. 생성자를 통한 문자열 생성
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		
		// String 클래스의 toString() 메소드는 이미 오버라이딩 되어있다.
		System.out.println("str1 : "+str1);
		System.out.println("str2 : "+str2);
		
		// 주소값 비교 연산자 == 이므로 false가 나온다.
		System.out.println("str1 == str2 : "+ (str1 == str2));
		
		// String클래스의 equals 메소드는 이미 오버라이딩 되어있다.(주소값이 아닌 값 비교)
		System.out.println("str1.equals(str2) : "+str1.equals(str2));
		
		// String클래스에서 hashCode 메소드는 이미 오버라이딩 되어있다.(주소값이 아닌 문자열로 해쉬코드 생성)
		System.out.println("str1.hashCode() : " + str1.hashCode());
		System.out.println("str2.hashCode() : " + str2.hashCode());
		
		System.out.println("System.identityHashCode(str1) : " + System.identityHashCode(str1));
		System.out.println("System.identityHashCode(str2) : " + System.identityHashCode(str2));
		
		// ------------------------------------
		System.out.println("\n2. 문자열을 리터럴 값으로 생성");
		
		// 2. 문자열을 리터럴값으로 생성
		String str3 = "hello";
		String str4 = "hello";
		// 리터럴 제시시 시, 상수 풀(String pool) 영역에 들어감
		// String Pool 특징 : 동일한 문자열을 가질 수 없다. ( 메모리 효율적이니까 )
		
		System.out.println("str3 : "+str3);
		System.out.println("str4 : "+str4);
		
		// 주소값 비교 연산자 == 이므로 false가 나온다.
		System.out.println("str3 == str4 : " + (str3 == str4));

		// String클래스의 equals 메소드는 이미 오버라이딩 되어있다.(주소값이 아닌 값 비교)
		System.out.println("str3.equals(str4) : " + str3.equals(str4));

		// String클래스에서 hashCode 메소드는 이미 오버라이딩 되어있다.(주소값이 아닌 문자열로 해쉬코드 생성)
		System.out.println("str3.hashCode() : " + str3.hashCode());
		System.out.println("str4.hashCode() : " + str4.hashCode());

		System.out.println("System.identityHashCode(str3) : " + System.identityHashCode(str3));
		System.out.println("System.identityHashCode(str4) : " + System.identityHashCode(str4));
		
		System.out.println("\nString의 불변성");
		str3 = "bye";
		System.out.println("값을 새로 넣으면 기존 메모리 공간 값의 변경이 아닌, 새로운 메모리 공간이 할당된다. ( 불변성 )");
		System.out.println("str3 = \"bye\";");
		System.out.println("System.identityHashCode(str3) : " + System.identityHashCode(str3));
		
	}
	
	public void method02() {
		System.out.println("\nString의 메소드");
		String str1 = "Hello World";
		
		// 1. 문자열.charAt(int index) : char
		//	  문자열에서 전달받은 index 위치에 문자만을 추출해서 리턴
		char ch = str1.charAt(6);
		System.out.println("str1.charAt(6) : " + ch);
		
		// 2. 문자열.concat(String str) : String
		// 	  문자열과 전달된 또다른 문자열을 하나로 합쳐서 새로운 문자열로 리턴
		String str2 = str1.concat("!!!");
		System.out.println("str1.concat(\"!!!\") : "+str2);
		
		// 그냥 더하기를 해도 된다. 리터럴 풀을 쓰기 싫으면 concat 사용
		String str3 = str1 + "!!!";
		System.out.println("str1 + \"!!!\" : " + str3);
		
		// 3. 문자열.contains(CharSequence str) : boolean
		//    문자열에 전달된 문자열이 포함되어 있는지를 반환
		System.out.println("str1에 Hello라는 문자열이 포함? str1.contains(\"Hello\") : " + str1.contains("Hello"));
		System.out.println("str1에 Bye라는 문자열이 포함? str1.contains(\"Bye\") : " + str1.contains("Bye"));
		
		// 4. 문자열.substring(int beginIndex, [int endIndex]) : String
		//    문자열을 beginIndex 위치부터 endIndex - 1 위치까지 추출해서 반환
		System.out.println("str1.substring(6) : " + str1.substring(6)); // 6부터 끝까지
		System.out.println("str1.substring(6,9) : " + str1.substring(6,9)); // 6부터 8까지
		
		// 5. 문자열.replace(char oldChar, char newChar) : String
		//    문자열에서 oldChar문자를 newChar문자로 변환한 채 문자열 리턴
		String str4 = str1.replace('l', 'c');
		System.out.println("str1 : "+str1);
		System.out.println("str4 : "+str4);
		
		// 6. 문자열.toUpperCase() : String => 문자열을 전부 대문자로 변경해서 반환
		//	  문자열.toLowerCase() : String => 문자열을 전부 소문자로 변경해서 반환
		System.out.println("str1.toUpperCase() : " + str1.toUpperCase());
		System.out.println("str1.toLowerCase() : " + str1.toLowerCase());
		
		// 7. 문자열.trim() : String
		//    문자열의 앞 뒤 공백을 제거시킨 새 문자열을 리턴
		String str5 = "    JA  va    ";
		System.out.println("String str5 = \"    JA  va    \";");
		System.out.println("str5.trim() : " + str5.trim());
		
		// 8. 문자열.toCharArray() : char[]
		//    문자열을 char[] 배열로 변경
		char[] arr = str1.toCharArray();
		System.out.print("char[] arr = str1.toCharArray() : ");
		for(char chr : arr) {
			System.out.print(chr);
		}
		
		// 9. String -> valueOf
		//	  String으로 변환시킨다
		System.out.println("\nString.valueOf(arr) : " + String.valueOf(arr));
		
	}
	
	public void method03() {
		String str = "Java,Oracle,sql,html,css,spring";
		
		// 구분자를 기준으로 문자열을 분리시키는 방법
		// 방법1. 분리된 문자열들을 String[] 배열에 차곡차곡 담고자 할 때
		//		 String 클래스에서 제공하는 split() 메소드를 사용
		//		 문자열.split("구분자") : String[]
		
		System.out.print("str.split(\",\") : ");
		String[] arr = str.split(",");
		for(String st : arr) {
			System.out.print(st+" ");
		} System.out.println();
		
		// 방법2. 분리된 문자열들을 각각 토큰으로서 관리가능
		//		 java.util.StringTokenizer 클래스를 이용
		//		 StringTokenizer stn = new StringTokenizer(문자열, "구분자");
		System.out.println("StringTokenizer stn = new StringTokenizer(str,\",\")");
		StringTokenizer stn = new StringTokenizer(str,",");
		System.out.println("stn.countTokens() : " + stn.countTokens());
		while(stn.hasMoreTokens()) {
			System.out.print(stn.nextToken()+ " "); // 토큰이 없을때 실행 시 예외 발생한다
		} System.out.println();
		
		// 분리된 문자열을 배열을 다시 String으로 변경하는 방법
		// String.join(구분자, 배열);
		System.out.println("분리된 문자열을 다시 구분자로 합치기");
		System.out.print("String.join(\",\", arr) : ");
		String str2 = String.join(",", arr);
		System.out.println(str2);
		
	}
}
