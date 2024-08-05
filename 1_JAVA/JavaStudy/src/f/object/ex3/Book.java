package f.object.ex3;

public class Book {
	/*
	 * 접근 제한자 : 해당 구조에 접근할 수 있는 범위를 제한한다.
	 * 
	 * public > protected > default > private
	 * 
	 * private 	: 같은 클래스
	 * default 	: 같은 클래스, 같은 패키지
	 * protected: 같은 클래스, 같은 패키지, 상속받은 다른패키지 클래스
	 * public   : 같은 클래스, 같은 패키지, 상속받은 다른패키지 클래스, 그 외 외부 ( 즉 어디서든 )
	 * 
	 * class는 public, default만 사용 가능
	 */
	//필드
	private String title; // 제목
	private String genre; // 장르
	private String author; // 저자
	
	private int maxPage; // 페이지수

	/*
	 * 생성자 객체를 생성할 떄 데이터를 초기화해주는 작업이 필수 
	 * 초기화를 위한 메소드를 만들어준다. -> 생성자라는 규칙이 생김 
	 * 
	 * 생성자
	 * - 클래스의 이름과 동일한 메소드로 반환형이 없다 
	 * - 필드 데이터의 초기화를 위한 특수 목적의 메소드이다. 
	 * - 매개변수가 하나도 없는 생성자를 우리는 기본 생성자라고 합니다.
	 * 
	 * - 생성자를 개발자가 만들지 않았다면, 컴파일러는 기본 생성자를 자동으로 생성해준다
	 * - 만약 생성자가 하나라도 있다면, 기본 생성자는 생성되지 않는다. ( 개발자의 의도라고 판단 )
	 * - 메소드의 매개변수의 개수 혹은 타입에 따라 메소드를 구분하는 메소드 오버로딩은 생성자에도 적용이 된다.
	 */
	
	// 생성자
	public Book() {
		
	}
	public Book(String title, String genre, String author, int maxPage) {
		this.title = title; // 내가가진(this) title에 넘겨받은 title을 넣는다
		this.genre = genre;
		this.author = author;
		this.maxPage = maxPage;
	}
	
	// 메소드
	public String toString() {
		/*
		 * this -> 인스턴스(메모리 상에 올라온 객체) 자기 자신을 의미
		 * 1. 자기자신의 메모리를 가리킨다.
		 * 2. 생성자에서 다른 생성자를 호출할 수 있다.
		 * 3. 자기 자신의 주소를 반환할 수 있다.
		 */
		return "제목 : "+this.title+"\n장르 : "+this.genre+
			   "\n저자 : "+this.author+"\n총 페이지 수 : "+this.maxPage;
	}
	
	// private 변수의 변경은 메서드를 통해서 이루어져야한다 ( getter / setter )
	// 메서드를 통해서, 클래스를 만들어둔 사람의 의도대로 변수 설정 가능 ex ) 길이값을 받되, 무조건 0 이상이도록
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
}
