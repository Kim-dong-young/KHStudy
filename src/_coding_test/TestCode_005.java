package _coding_test;

public class TestCode5 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/161990
	// 작성중
	
	public static void main(String[] args) {
		String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
		int[] answer = new int[4]; // 0 : 시작x / 1 : 시작y / 2 : 끝x / 3: 끝y
		
		int minX=wallpaper[0].length()-1, minY=wallpaper.length-1; // 시작점 좌표
		int maxX=0, maxY=0; // 끝점 좌표
		
		//문자열 출력
		for(int i=0; i< wallpaper.length;i++) {
			for(int j=0; j<wallpaper[i].length();j++) {
				System.out.printf("%2c",wallpaper[i].charAt(j));
			}
			System.out.println();
		}
		
		//좌표 계산
		for(int i=0; i< wallpaper.length;i++) {
			for(int j=0; j<wallpaper[i].length();j++) {
				
				if(wallpaper[i].charAt(j)  == '#') {

					if(j < minY) {
						minY = j;
					}
					if(j < minX) {
						minX = i;
					}
					if(j > maxY) {
						maxY = j;
					}
					if(j > maxX) {
						maxX = i;
					}

				}
				
			}
		}
		
		//정답 출력
		answer[0] = minX;
		answer[1] = minY;
		answer[2] = maxX+1;
		answer[3] = maxY+1;

		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]);
		}
		
		
	}
}
