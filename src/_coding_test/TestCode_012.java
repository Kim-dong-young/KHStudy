package _coding_test;

public class TestCode_012 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/159994?language=java

	public static void main(String[] args) {
		
		String[] cards1 = {"i", "drink", "water"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		
		int index1 = 0;
		int index2 = 0;
		
		String possible = "Yes";
		
		for(int i=0; i < goal.length; i++) {
			
			if(index1 < cards1.length && cards1[index1].equals(goal[i])) index1++;
			else if(index2 < cards2.length && cards2[index2].equals(goal[i])) index2++;
			else possible="No";
			
		}
		
		System.out.println(possible);
	}

}
