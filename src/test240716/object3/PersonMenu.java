package test240716.object3;

import java.util.Scanner;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();

	public void mainMenu() {
		int ch = 0;
		int[] personCount; // 0 : 학생 , 1 : 사원

		while (ch != 9) {

			personCount = pc.personCount();
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 " + personCount[0] + "명 입니다");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 " + personCount[1] + "명 입니다");
			
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			
			System.out.print("메뉴 번호 : ");
			ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 1:
				studentMenu();
				break;
			case 2:
				employeeMenu();
				break;
			case 9:
				continue;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
				break;
			}

		}

	}

	public void studentMenu() {
		int ch = 0;
		int[] personCount; // 0 : 학생 , 1 : 사원
		boolean isStuFull = false;

		while (ch != 9) {
			personCount = pc.personCount();
			isStuFull = (personCount[0] >= 3) ? true : false;
			
			System.out.println();
			if(!isStuFull) {
				System.out.println("1. 학생 추가");
			}
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 2:
				printStudent();
				break;
			case 9:
				continue;
			case 1:
				if(!isStuFull) {
					insertStudent();
					break;
				}
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}

		}
	}

	public void employeeMenu() {
		int ch = 0;
		int[] personCount; // 0 : 학생 , 1 : 사원
		boolean isEmplyFull = false;

		while (ch != 9) {
			personCount = pc.personCount();
			isEmplyFull = (personCount[1] >= 10) ? true : false;
			
			System.out.println();
			if(!isEmplyFull) {
				System.out.println("1. 사원 추가");
			}
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 2:
				printEmployee();
				break;
			case 9:
				continue;
			case 1:
				if(!isEmplyFull) {
					insertEmployee();
					break;
				}
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}

		}
	}

	public void insertStudent() {
		String ch;
		String name;
		int age;
		double height;
		double weight;
		int grade;
		String major;
		int[] personCount = pc.personCount(); // 0 : 학생 , 1 : 사원
		
		while(true) {
			System.out.print("학생 이름 : ");
			name = sc.next();
			sc.nextLine();
			
			System.out.print("학생 나이 : ");
			age = sc.nextInt();
			sc.nextLine();
			
			System.out.print("학생 키 : ");
			height = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("학생 몸무게 : ");
			weight = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("학생 학년 : ");
			grade = sc.nextInt();
			sc.nextLine();
			
			System.out.print("학생 전공 : ");
			major = sc.next();
			sc.nextLine();
			
			pc.insertStudent(name, age, height, weight, grade, major);
			personCount = pc.personCount();
			
			if(personCount[0] >= 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에");
				System.out.println("학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				break;
			}
			
			System.out.println("그만하시려면 N(또는 n), 이어하시려면 아무키나 누르세요 : ");
			ch = sc.next();
			sc.nextLine();
			
			if(ch.equals("n") || ch.equals("N")) break;
			
		}
		
	}

	public void printStudent() {
		Student[] currentStudent = pc.printStudent();
		for(int i=0; i<currentStudent.length; i++) {
			if(currentStudent[i] != null)
				System.out.println(currentStudent[i].toString());
			else
				break;
		}
	}

	public void insertEmployee() {
		String ch;
		String name;
		int age;
		double height;
		double weight;
		int salary;
		String dept;
		int[] personCount = pc.personCount(); // 0 : 학생 , 1 : 사원
		
		while(true) {
			System.out.print("사원 이름 : ");
			name = sc.next();
			sc.nextLine();
			
			System.out.print("사원 나이 : ");
			age = sc.nextInt();
			sc.nextLine();
			
			System.out.print("사원 키 : ");
			height = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("사원 몸무게 : ");
			weight = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("사원 급여 : ");
			salary = sc.nextInt();
			sc.nextLine();
			
			System.out.print("사원 부서 : ");
			dept = sc.next();
			sc.nextLine();
			
			pc.insertEmployee(name, age, height, weight, salary, dept);
			personCount = pc.personCount();
			
			if(personCount[1] >= 10) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에");
				System.out.println("사원 추가를 종료하고 사원 메뉴로 돌아갑니다.");
				break;
			}
			
			System.out.println("그만하시려면 N(또는 n), 이어하시려면 아무키나 누르세요 : ");
			ch = sc.next();
			sc.nextLine();
			
			if(ch.equals("n") || ch.equals("N")) break;
			
		}
	}

	public void printEmployee() {
		Employee[] currentEmployee = pc.printEmployee();
		for(int i=0; i<currentEmployee.length; i++) {
			if(currentEmployee[i] != null)
				System.out.println(currentEmployee[i].toString());
			else
				break;
		}
	}
}
