package test240715.object2;

public class Practice2 {
	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34";
		double data[] = new double[5];
		
		String[] st;
		st = str.split(",");
		
		int i=0;
		double sum=0;
		for(String snum : st) {
			data[i] = Double.parseDouble(snum);
			sum+=data[i++];
		}
		
		System.out.printf("합계 : %.3f\n",sum);
		System.out.printf("평균 : %.3f",sum/i);

	}
}
