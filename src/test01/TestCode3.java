package test01;

import java.util.Arrays;

public class TestCode3 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/12939
	
	public static void main(String[] args) {
		String s = "1 2 3 4";
		String[] snum = s.split(" ");
		int[] number = new int[snum.length];
		
		for(int i=0; i< number.length; i++) {
			number[i]=Integer.parseInt(snum[i]);
		}
		
		int max = Arrays.stream(number).max().getAsInt();
		int min = Arrays.stream(number).min().getAsInt();
		
		System.out.println(Integer.toString(min) +" " +Integer.toString(max));
	}

}
