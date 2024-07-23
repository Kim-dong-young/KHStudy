package _coding_test.programmers.level3;

// https://school.programmers.co.kr/learn/courses/30/lessons/43105

class Solution {
    int[][] memo;
    
    public int getMinValue(int level, int index, int[][] triangle){
        memo = new int[triangle.length][triangle.length];
        for(int i=0; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                memo[i][j] = -1;
            }
        }
        
        return dfs(0,0,triangle);
    }
    
    public int dfs(int level,int index, int[][] triangle){
        if(level == triangle.length - 1){
            return triangle[level][index];
        }
        
        int minValue;
        if(memo[level][index] == -1){
            minValue = Math.max(dfs(level+1,index,triangle),dfs(level+1,index+1,triangle));
            memo[level][index] = minValue + triangle[level][index];
        }
        
        return memo[level][index];
    }
    
    public int solution(int[][] triangle) {
        int answer = getMinValue(0,0,triangle);
        return answer;
    }
}

public class TestCode_001 {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		Solution s = new Solution();
		
		int answer = s.solution(triangle);
		System.out.println(answer);
	}
}
