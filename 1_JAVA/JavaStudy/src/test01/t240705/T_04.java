package test01.t240705;

import java.util.Scanner;

public class T_04 {

	public static void main(String[] args) {
		/*
		 * A, B, C 사원의 연봉을 입력 받고, 각 사원의 연봉과 인센티브를 포함한 연봉을 계산하여 출력하고
		 * 인센티브 포함 급여가 3000만원 이상이면 "3000 이상", 미만이면 "3000 미만"을 출력하세요.
		 * (A 사원의 인센티브는 0.4, B 사원의 인센티브는 없으며, C 사원의 인센티브는 0.15)
		 * 
		 * ex)
		 * A사원의 연봉 : 2500
		 * B사원의 연봉 : 2900
		 * C사원의 연봉 : 2600
		 * 
		 * A사원 연봉/연봉+a : 2500/3500.0
		 * 3000 이상
		 * B사원 연봉/연봉+a : 2900/2900.0
		 * 3000 미만
		 * C사원 연봉/연봉+a : 2600/2989.9999999999995
		 * 3000 미만
		 * 
		 */
		
		Scanner s = new Scanner(System.in);
		
		double incentiveA = 0.4;
		double incentiveB = 0;
		double incentiveC = 0.15;
		
		System.out.print("A사원의 연봉 : ");
		int salaryA = s.nextInt();
		System.out.print("B사원의 연봉 : ");
		int salaryB = s.nextInt();
		System.out.print("C사원의 연봉 : ");
		int salaryC = s.nextInt();
		
		System.out.println("A 사원 연봉/연봉+a : "+ salaryA + "/" + salaryA * ( 1 + incentiveA) + "\n"
				+ ((salaryA * ( 1 + incentiveA) >= 3000) ? "3000 이상" : "3000 미만") );
		System.out.println("B 사원 연봉/연봉+a : "+ salaryB + "/" + salaryB * ( 1 + incentiveB) + "\n"
				+ ((salaryB * ( 1 + incentiveB) >= 3000) ? "3000 이상" : "3000 미만") );
		System.out.println("C 사원 연봉/연봉+a : "+ salaryC + "/" + salaryC * ( 1 + incentiveC) + "\n"
				+ ((salaryC * ( 1 + incentiveC) >= 3000) ? "3000 이상" : "3000 미만") );
		
		s.close();
	}

}
