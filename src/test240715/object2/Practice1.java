package test240715.object2;

public class Practice1 {
	public static void main(String[] args) {
		int [][] array = {
				{12, 41, 36, 56, 21}, 
				{82, 10, 12, 61, 45}, 
				{14, 16, 18, 78, 65}, 
				{45, 26, 72, 23, 34}
		};
		double sum = 0;
		int count = 0;
		double average;
		
		for(int arr[] : array) {
			for(int num : arr) {
				sum += num;
				count++;
			}
		}
		average = sum / count;
		System.out.printf("합계 : %.2f\n",sum);
		System.out.printf("평균 : %.2f",average);
	}
}
