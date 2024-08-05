package _coding_test.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129

public class TestCode_008 {
	
	public static void main(String[] args) {
		String s = "110010101001";
		
		String result = "";
		
		int rmvZeroCnt = 0;
		int binCngCnt = 0;
		
		while(!s.equals("1")) {
			// 0 제거
			for(int i=0; i< s.length(); i++) {
				if(s.charAt(i) == '1') result += "1";
				else rmvZeroCnt++;
			}
			s = result;
			result = "";
			
			// s의 길이를 이진변환
			int num = s.length();
			
			while(num >= 1) {
				result += Integer.toString(num % 2);
				num /= 2;
			}
			s = result;
			result = "";
			
			binCngCnt++;
		}
		
		System.out.println(binCngCnt + " " + rmvZeroCnt);
		
	}
}
