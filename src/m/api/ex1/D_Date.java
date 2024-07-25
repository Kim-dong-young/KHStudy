package m.api.ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class D_Date {
	public void method01() {
		System.out.println("\n===== Date 클래스 =====");
		// 현재 날짜로 Date 객체 생성
		Date date1 = new Date();
		System.out.println(date1);
		
		// 내가 원하는 날짜(2024년 12월 12일)로 세팅
		// 1) 생성자를 통해서 생성
		Date date2 = new Date(2024 - 1900, 12 - 1, 12);
		System.out.println(date2);
		
		// 2) 기본생성자로 생성한 후에 setter메소드로 값 반환
		date1.setYear(2024 - 1900);
		date1.setMonth(6-1);
		date1.setDate(28);
		date1.setHours(9);
		date1.setMinutes(0);
		date1.setSeconds(0);
		System.out.println(date1);
		
		// 1970년부터 지금까지의 시간을 초로 바꾼것
		// 객체의 고유 키로 설정하거나, 대소비교로 과거 미래 구분하는 정도로 쓰인다
		System.out.println(date1.getTime());
		
		// SimpleDateFormat
		// 시간을 보여주기 위한 형식을 지정하는 객체
		System.out.println(1900 + date1.getYear() + "년 "); // 되긴하지만 매우 귀찮다...
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(sdf.format(date1));
	}
}
