package test240711.object2;

public class Human {
	/*
	 * one이라는 Human 객체를 생성하고, 해당 객체를 이용해서 myTV와 myTV2를 구매 가능한지
	 * 확인하는 코드를 작성하고자 한다.
	 * 
	 Human one = new Human("최지원", 1000000);
	 one.buy(myTV);
	 * 
	 * => 결과 :
	 * 최지원님 구매내역
	 * 삼성에서 만든 2020년형 65인치 TV 가격 : 100000
	 * 남은 잔액 : xxx
	 * or
	 * 최지원님 잔액이 부족하여 구매하실 수 없습니다
	 */
	
	private String name;
	private int balance;
	
	public Human(String name, int balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void buy(TV tv) {
		if(tv.getPrice() <= this.balance) { // 구매가능 ( 돈 충분 )
			System.out.println(this.name+"님 구매내역");
			tv.show();
			this.setBalance(this.balance - tv.getPrice());
			System.out.println("남은잔액 : "+this.balance);
		}
		else { // 구매 불가능 ( 돈 부족 )
			System.out.println(this.name+"님 잔액이 부족하여 구매하실 수 없습니다.");
		}
	}
	
	
	
}
