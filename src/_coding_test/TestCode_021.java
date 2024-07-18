package _coding_test;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class TestCode_021 {
	public static void main(String[] args) {
		String s = "egrqmqxaspvlrarmetsephovokkxgjalprbbhadcpbnhbhvfaolpxamokwntfnewehzojeqzffigmfmovxdtzrhmpufwi";
		String buffer = "";
		int answer = 0;
		
		for(int i = 0; i< s.length(); i++) {
			for(int j=i; j<s.length(); j++) {
				buffer+=s.charAt(j);
				try {
					if (buffer.contains(s.charAt(j+1)+"")) {
						answer = buffer.length() > answer ? buffer.length() : answer;
						buffer = "";
						break;
					}
				} catch (StringIndexOutOfBoundsException e) {
					answer = buffer.length() > answer ? buffer.length() : answer;
					buffer = "";
				}

			}
		}
		
		System.out.println(answer);
	}
}
