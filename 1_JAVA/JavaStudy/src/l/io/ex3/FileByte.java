package l.io.ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByte {
	/*
	 * "바이트 스트림"을 통한 입출력해보기
	 * 
	 * - 바이트스트림 : 데이털르 1바이트 단위로 전송하는 통로( 좁은(1바이트)통로 => 한글(2바이트) 깨짐 )
	 * - 기반스트림 : 외부매체와 직접적으로 연결하는 통로
	 * 
	 * xxxInputStream : xxx매체로부터 데이터를 입력받는 통로(외부로부터 데이터를 읽어오겠다.)
	 * xxxOutputStream : xxx매체로부터 데이터를 출력하는 통로(외부매체로 데이터를 내보내겠다.)
	 * 
	 */
	
	// 프로그램(자바) -> 외부매체(파일) 데이터를 출력( 프로그램상의 데이터를 파일로 내보내보자 )
	public void fileSave() {
		
		// 1. FileOutputStream 객체 생성
		// 해당 파일이 없으면 새로 만들어주고 통로 연결 / 있으면 해당 파일에 통로 연결 
		// FileOutputStream의 두 번째 매개변수에 true 전달 시, 해당 파일이 존재할 경우 기존데이터에 이어 작성
		try(FileOutputStream fout = new FileOutputStream("byte_test.txt");) {
			
			// 2. 파일에 데이터 출력 ( 0 ~ 127 )
			// 숫자를 넣을려면 문자로 넣어야 한다
			fout.write('a');
			fout.write('9');
			fout.write('쿠'); // 한글은 2byte여서 깨져서 저장된다
			fout.flush(); // close 할 때 자동으로 호출된다. => try-with-resources에선 자동이다
			
			byte[] arr = {102,103,104};
			fout.write(arr);
			fout.flush();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		// 1. 스트림 생성
		// 2. 스트림을 통해서 입력받음
		// 3. 사용이 끝난 스트림 반납
		
		FileInputStream fin = null;
		try {
			// 1. 스트림 생성
			fin = new FileInputStream("byte_test.txt");
			
			// 2. 파일로부터 데이터를 읽어들이고자 할 때, read 메소드 사용
			// 1byte씩 숫자로 읽어온다 ( ex) A = 65로 읽어온다 )
			/*
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read()); // 파일의 끝을 만나는 순간 -1을 반환한다.
			*/
			
			int value = 0;
			while((value = fin.read()) != -1) {
				System.out.print((char)value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 이 안에 작성한 코드는 성공하든 실패하든 마지막에 무조건 실행하고 빠져나가도록 한다.
			try {
				// 3. 사용이 끝난 스트림 반납
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
