package m.api.ex2;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}
	
	public String afterToken(String str) {
		StringTokenizer stn = new StringTokenizer(str," ");
		String rmBlankStr = "";
		
		while(stn.hasMoreTokens()) {
			rmBlankStr += stn.nextToken();	
		}
		
		return rmBlankStr;
	}
	
	public String firstCap(String input) {
		String firstCapStr = "";
		if(input == null || input.length() <= 0) {
			return input;
		}
		else {
			firstCapStr += Character.toString(input.charAt(0)).toUpperCase();
			if (input.length() >= 2) {
				firstCapStr += input.substring(1, input.length());
			}
		}
		return firstCapStr;
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		for(char ch : input.toCharArray()) {
			if(ch == one) count++;
		}
		return count;
	}
}
