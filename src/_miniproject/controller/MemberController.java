package _miniproject.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import _miniproject.vo.Member;

public class MemberController {
	private static MemberController mc;
	private StockController sc = StockController.getInstance();
	private HashMap<String, Member> memberList;
	private Member currentMember;
	
	private MemberController() {
		super();
		this.memberList = new HashMap<String, Member>();
	}
	
	public static MemberController getInstance() {
		if(mc == null) 
			mc = new MemberController();
		return mc;
	}

	public boolean isMemberExist(String id) {
		return this.memberList.containsKey(id);
	}
	
	public boolean isLoginSuccess(String id, String pwd) {
		boolean success = false;
		Member m = memberList.get(id);
		if(m != null && m.getMemberPwd().equals(pwd))
			success = true;
		return success;
	}
	
	public void loginMember(String id) {
		// id를 입력받아, 해당 id에 속하는 멤버를 currentMember로 설정한다.
		this.currentMember = memberList.get(id);
	}
	
	public Member getCurrentMember() {
		return this.currentMember;
	}
	
	public void addMember(String name, String id, String pwd) {
		this.memberList.put(id, new Member(name,id,pwd));
	}
	
	public void delMember(String id) {
		this.memberList.remove(id);
	}
	
	public void updateMember(String name, String id, String pwd) {
		
	}
	
	public void findMember(String id) {
		
	}
	
	public void showMemberList() {
		
	}
	
	public void showStockList() {
		for(Entry<String, Integer> entry : currentMember.getShareHeld().entrySet()) {
			System.out.printf("종목명 : %s , 수량 : %d\n",entry.getKey(), entry.getValue());
		}
	}
	
	public int buyStock(String stockName, int orderQuantity) {
		
		if(sc.getStockQuantity(stockName) < orderQuantity || orderQuantity <= 0 ) { // 잘못된 수량을 주문할 경우( 수량 초과, 음의 수 )
			return 400; // 잘못된 수량 주문
		}
		
		int price = sc.getStockPrice(stockName) * orderQuantity;
		HashMap<String,Integer> cMemberShareHeld = currentMember.getShareHeld();
		
		
		if (currentMember.getBalance() < price) { // 잔액이 부족할 경우
			return 403; // 잔액 부족
		}
		else { // 잔액이 충분한 경우
			sc.setStockQuantity(stockName, sc.getStockQuantity(stockName) - orderQuantity);
			currentMember.setBalance(currentMember.getBalance() - price);
			// 해당 종목을 처음사는 경우
			if(cMemberShareHeld.get(stockName) == null) {
				cMemberShareHeld.put(stockName, orderQuantity);
			}
			// 해당 종목을 보유중일 경우
			else {
				cMemberShareHeld.replace(stockName, cMemberShareHeld.get(stockName) + orderQuantity);
			}
		}
		
		return 200; // 구매 성공
	}
	
	public int sellStock(String stockName, int orderQuantity) {

		if (orderQuantity <= 0) { // 잘못된 수량을 판매할 경우( 음의 수 )
			return 400; // 잘못된 수량 주문
		}
		
		Integer cMemberStockQnt = currentMember.getShareHeld().get(stockName);
		
		if (cMemberStockQnt == null) { // 없는 주식을 팔려할 경우
			return 403; // 수량 부족
		}
		if (cMemberStockQnt != null && cMemberStockQnt.compareTo(orderQuantity) == -1 ) { // 보유한 양보다 많이 팔려할 경우
			return 403; // 수량 부족
		}

		int price = sc.getStockPrice(stockName) * orderQuantity;
		HashMap<String, Integer> cMemberShareHeld = currentMember.getShareHeld();
		
		/*
		 * TODO 주문 처리
		 */

		return 200; // 구매 성공
	}
}