package _coding_test.programmers.level0;

public class TestCode_001 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/120956
	
	public static void main(String[] args) {
		String[] babbling = { "aya", "yee", "u", "maa", "wyeoo" };
	    int answer = 0;

	    // 발음 가능한 단어들
	    String[] validWords = { "aya", "ye", "woo", "ma" };

	    for (int i = 0; i < babbling.length; i++) { // 문자열 하나를 본다
	        //System.out.printf("i=%d\n", i);
	        String currentWord = babbling[i];
	        boolean foundWord = false;

	        while (currentWord.length() > 0) { // 문자열이 비어있지 않다면
	            //System.out.printf("\tcurrentWord = %s\n", currentWord);
	            foundWord = false;
	            
	            for (String validWord : validWords) {
	                if (currentWord.startsWith(validWord)) {
	                    foundWord = true;
	                    currentWord = currentWord.substring(validWord.length());
	                    break;
	                }
	            }
	            
	            if (!foundWord) {
	                break; // 더 이상 유효한 단어를 찾을 수 없으므로 루프 탈출
	            }
	        }

	        if (currentWord.length() == 0 && foundWord) {
	            answer++;
	            //System.out.printf("\t\tanswer = %d\n", answer);
	        }
	    }

	    System.out.println(answer);
	}
		
}
