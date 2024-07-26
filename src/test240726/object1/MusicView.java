package test240726.object1;

import java.util.Scanner;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public void mainMenu() {
		int ch = 0;

		while (ch != 9) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제 ");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬 ");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 1:
				addList();
				break;
			case 2:
				addAtZero();
				break;
			case 3:
				printAll();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				removeMusic();
				break;
			case 6:
				setMusic();
				break;
			case 7:
				ascTitle();
				break;
			case 8:
				descSinger();
				break;
			case 9:
				System.out.println("종료");
				continue;
			default:
				System.out.println("잘못 입력하셨습니다.");
				
			}
		}

	}

	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String songTitle = sc.nextLine();
		System.out.print("가수 명 : ");
		String singerName = sc.nextLine();
		
		int result = mc.addList(new Music(songTitle, singerName));
		
		if( result >= 0 ) System.out.println("추가 성공");
		else System.out.println("추가 실패");
		
	}

	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String songTitle = sc.nextLine();
		System.out.print("가수 명 : ");
		String singerName = sc.nextLine();
		
		int result = mc.addAtZero(new Music(songTitle, singerName));
		
		if( result >= 0 ) System.out.println("추가 성공");
		else System.out.println("추가 실패");
	}

	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		System.out.println(mc.printAll());
	}

	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("곡 명 : ");
		String songTitle = sc.nextLine();
		
		Music foundMusic = mc.searchMusic(songTitle);
		
		if(foundMusic != null) System.out.printf("%s - %s\n",foundMusic.getSinger(), foundMusic.getTitle());
		else System.out.println("검색한 곡이 없습니다.");
	}

	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("곡 명 : ");
		String songTitle = sc.nextLine();
		
		Music foundMusic = mc.removeMusic(songTitle);
		
		if(foundMusic != null) System.out.printf("%s - %s을(를) 삭제했습니다.\n",foundMusic.getSinger(), foundMusic.getTitle());
		else System.out.println("검색한 곡이 없습니다.");
	}

	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ******");
		System.out.print("검색할 곡 명 : ");
		String oldSongTitle = sc.nextLine();
		
		Music updatedMusic = mc.searchMusic(oldSongTitle);
		
		System.out.print("수정할 곡 명 : ");
		String newSongTitle = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String newSingerName = sc.nextLine();
		
		if(updatedMusic != null) {
			System.out.printf("%s - %s의 값이 변경되었습니다.\n",updatedMusic.getSinger(), updatedMusic.getTitle());
			mc.setMusic(oldSongTitle, new Music(newSongTitle, newSingerName));
		}
		else System.out.println("검색한 곡이 없습니다.");
	}

	public void ascTitle() {
		int result = mc.ascTitle();
		if( result >= 0 ) System.out.println("정렬 성공");
		else System.out.println("정렬 실패");
	}

	public void descSinger() {
		int result = mc.descSinger();
		if( result >= 0 ) System.out.println("정렬 성공");
		else System.out.println("정렬 실패");
	}
}
