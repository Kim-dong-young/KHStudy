package l.io.ex3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	public void mainMenu() {
		int ch = 0;
		
		while(ch != 9) {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			try {
				ch = sc.nextInt();
			} catch(InputMismatchException e) {
				ch = 0;
			}
			sc.nextLine();
			
			switch(ch) {
			case 1:
				fileSave();
				break;
			case 2:
				fileOpen();
				break;
			case 3:
				fileEdit();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				continue;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			
		}
	
	}
	
	public void fileSave() {
		StringBuilder sb = new StringBuilder();
		String buffer;
	
		System.out.println("파일에 저장할 내용을 입력하세요.");
		System.out.println("ex끝it  이라고 입력하면 종료됩니다.");
		System.out.print("내용 : ");
		while(!(buffer = sc.nextLine()).equals("ex끝it")) {
			sb.append(buffer).append("\n");
		}
		
		while(true) {
			System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt): ");
			buffer = sc.next();
			sc.nextLine();
			
			if(fc.checkName(buffer)) { // 파일이 이미 존재
				System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n) ");
				if(sc.next().equals("y")) {
					sc.nextLine();
					fc.fileSave(buffer, sb);
					break;
				}
				else
					continue;
			}
			else { // 파일이 존재하지 않음
				fc.fileSave(buffer, sb);
				break;
			}
		}
	}
	
	public void fileOpen() {
		System.out.print("열 파일 명 : ");
		String filename = sc.next();
		sc.nextLine();
		
		if(fc.checkName(filename)) {
			System.out.println(fc.fileOpen(filename).toString());
		}
		else {
			System.out.println("없는 파일입니다.");
			return;
		}
		
	}
	
	public void fileEdit() {
		StringBuilder sb = new StringBuilder();
	
		System.out.print("수정할 파일 명 : ");
		String filename = sc.next();
		sc.nextLine();
		
		if(!fc.checkName(filename)) {
			System.out.println("없는 파일입니다.");
			return;
		}
		
		System.out.println("파일에 저장할 내용을 입력하세요.");
		System.out.println("ex끝it  이라고 입력하면 종료됩니다.");
		System.out.print("내용 : ");
		String buffer = null;
		while(!(buffer = sc.nextLine()).equals("ex끝it")) {
			sb.append(buffer).append("\n");
		}
		
		fc.fileEdit(filename, sb);
		
	}

	
}
