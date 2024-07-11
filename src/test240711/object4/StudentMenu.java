package test240711.object4;

public class StudentMenu {
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		Student[] sArr = ssm.printStudent();
		
		System.out.println("========학생 정보 출력========");
		for(Student st : sArr) {
			System.out.println(st.inform());
		}
		System.out.println();
		
		System.out.println("========학생 성적 출력========");
		double[] scoreStat = ssm.avgScore();
		System.out.println("점수 합계 : "+(int)scoreStat[0]);
		System.out.println("점수 평균 : "+scoreStat[1]+"\n");
		
		System.out.println("========성적 결과 출력========");
		for(Student st : sArr) {
			System.out.println(st.getName() + ((st.getScore() < StudentController.CUT_LINE) ? " : 재시험 대상" : " : 통과") );
		}
	}
}
