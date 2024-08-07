package q.thread.ex1;

public class Run {
	// 쓰레드 : 프로그램 내에서 실행의 흐름을 가지고있는 최소 단위
	//		main메소드 실행 시, 메인 쓰레드가 실행되는 것이다.
	public static void main(String[] args) {
		// 쓰레드 생성방법 1 - Thread를 상속받는 클래스를 작성한다.
		Task t1 = new Task(); // Thread를 상속받아 run을 구현한 객체를 생성한다
		
		// 쓰레드 생성방법 2 - Runnable 추상메소드 run을 구현하는 객체 생성
		Runnable task = new MyRunable(); // run을 구현한 객체를 생성해서
		Thread t2 = new Thread(task); // thread객체의 생성자에 넘겨준다.
		
		t1.start(); // 쓰레드를 상속받은 클래스의 run 메소드를 실행시킨다.
		t2.start();
		
		System.out.println("END : " + Thread.currentThread().getName());
	}
}
