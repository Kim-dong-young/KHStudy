package q.thread.ex1;

// 쓰레드를 생성하는 방법 1
// Thread를 상속받는 클래스를 작성한다.
public class Task extends Thread {

	// main문 처럼 독립적으로 실행될 수 있는 메소드
	@Override
	public void run() {
		int n1 = 20;
		int n2 = 30;
		
		// currentThread() : 지금 실행하고있는 쓰레드의 정보 객체를 반환한다.
		String name = Thread.currentThread().getName();
		System.out.println(name + " : " + (n1 + n2));
	}
	
}
