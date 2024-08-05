package l.io.ex1;

import java.io.File;
import java.io.IOException;

public class Run {
	/*
	 * 간단하게 파일을 만들어보자
	 * java.io.File 클래스를 사용해보자
	 */
	public static void main(String[] args) {
		
		// 1. 경로지정을 하지 않고 파일 생성하기
		File f1 = new File("test.txt"); // 파일 객체를 하나 만든 상태(실제 파일x)
		// 2. 경로를 지정하고 파일 생성하기
		File f2 = new File("D:\\test2.txt");
		// 3. 존재하지 않는 경로에 파일 생성
		// File f3 = new File("D:\\tmp\\test.txt");
		try {
			f1.createNewFile(); // createNewFile 메소드가 실행할 때 실제 파일이 만들어짐
			f2.createNewFile();
			// f3.createNewFile(); // 존재하지 않는 경로로 생성 시, 예외 발생( IOException )
			
			// 4. 폴더 먼저 만들고 파일 만들기
			File tmpFolder = new File("D:\\tmp");
			tmpFolder.mkdirs();
			
			File f4 = new File("D:\\tmp\\test.txt");
			f4.createNewFile();
			
			// 파일이 실제로 존재하는지 확인 ( 객체 존재여부 확인 X )
			File f5 = new File("ttt.txt");
			System.out.println(f5.exists());
			System.out.println(f1.exists());
			
			// 파일인지 폴더인지 확인하는 메소드
			System.out.println(f1.isFile());
			System.out.println(tmpFolder.isDirectory());
			
			// -----------------------------------------------
			// 파일 정보 가져오기
			File folder = new File("parent");
			folder.mkdir();
			
			File file = new File("parent\\person.txt");
			file.createNewFile();
			
			System.out.println("파일명  : " + file.getName());
			System.out.println("경로    : " + file.getAbsoluteFile());
			System.out.println("용량    : " + file.length());
			System.out.println("상위폴더 : " + file.getParent());
			
			// ------------------------------------------------
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
