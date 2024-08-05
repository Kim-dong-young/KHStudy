package test240715.object2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Practice3 {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		Calendar c = new GregorianCalendar(1987,5,27);
		Date birthDay = c.getTime();
		Date today = gc.getTime();
		
		SimpleDateFormat bDaySdf = new SimpleDateFormat("생일 : yyyy년 M월 dd일 E요일",Locale.KOREAN);
		SimpleDateFormat todaySdf = new SimpleDateFormat("현재 : yyyy년 M월 dd일",Locale.KOREAN);
		System.out.println(bDaySdf.format(birthDay));
		System.out.println(todaySdf.format(today));
		System.out.println("나이 : "+ (gc.get(Calendar.YEAR) - c.get(Calendar.YEAR)));
	}
}
