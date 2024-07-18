package j.Interface.ex1;

public interface Animal {
	// interface에 선언 가능한 것
	// 1. static 변수 : 모든 변수는 기본적으로 public static final
	// 2. 추상 메소드 : abstract 추상 키워드를 붙여 생성, 미완성 메소드로 구현부({})가 없는 메소드
	//				 abstract는 생략가능. 어차피 추상 메소드밖에 못 넣으니까.
	// 3. default 메소드 : 되기는 하지만, 많이 쓰진 않는다.
	// 					  인터페이스 한 500개 일일이 수정해야 되는일이 생겼을때, 어쩔수없이 쓰는 느낌
	// 접근제한자 : 기본 public. 다른 클래스에서도 메소드를 반드시 구현해야하니까.
	// 
	// interface는 상속이 가능하다
	// 따라서 변경사항이 생겼을때, implement한 모든 클래스를 바꿀 필요없이
	// 변경사항을 따로 상속한 interface로 구현해, 필요한 클래스에 적용해주면 된다.
	//
	// interface는 메모리를 안잡아먹기 때문에 체크용으로도 쓰인다
	// 진짜 말그대로 아무것도 없는 인터페이스를 내가 체크할 이름으로 만들고 implements를 한뒤,
	// instanceof로 해당 인터페이스를 implements하는지 확인하는 방식으로 쓰인다.
	
	public abstract void move();
	public abstract void eat();
	public abstract void makeSound();
	
}
