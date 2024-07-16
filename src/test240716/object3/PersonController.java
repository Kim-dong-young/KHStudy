package test240716.object3;

public class PersonController {
	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int[] personNum = new int[2];
		int count;
		
		count = 0;
		for(int i=0; i< s.length; i++) {
			if(s[i] == null) break;
			count++;
		}
		personNum[0] = count;
		
		count = 0;
		for(int i=0; i< e.length; i++) {
			if(e[i] == null) break;
			count++;
		}
		personNum[1] = count;
		
		return personNum;
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		for(int i=0; i< s.length; i++) {
			if(s[i] == null) {
				s[i] = new Student(name,age,height,weight,grade,major);
				break;
			}
		}
	}
	
	public Student[] printStudent() {
		int count=0;
		for(int i=0; i<s.length; i++) {
			if(s[i] == null) break;
			count++;
		}
		Student[] currentStudent = new Student[count];
		for(int i=0; i<count;i++) {
			currentStudent[i] = s[i];
		}
		return currentStudent;
	}
	
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		for(int i=0; i< e.length; i++) {
			if(e[i] == null) {
				e[i] = new Employee(name,age,height,weight,salary,dept);
				break;
			}
		}
	}
	
	public Employee[] printEmployee() {
		int count=0;
		for(int i=0; i<e.length; i++) {
			if(e[i] == null) break;
			count++;
		}
		Employee[] currentEmployee = new Employee[count];
		for(int i=0; i<count;i++) {
			currentEmployee[i] = e[i];
		}
		return currentEmployee;
	}
}
