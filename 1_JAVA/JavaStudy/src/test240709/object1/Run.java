package test240709.object1;

public class Run {

	public static void main(String[] args) {
		Member m1 = new Member();
		m1.changeName("michael");
		m1.printName();
		
		// 아이디, 비번, 이름을 초기화하는 생성자를 통해
		// 객체를 하나 생성하고, 이름을 출력해라
		Member m2 = new Member("Tom1234","pwd1234","Tom");
		m2.printName();
	}

}
