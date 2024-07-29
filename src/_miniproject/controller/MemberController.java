package _miniproject.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import _miniproject.vo.Member;

public class MemberController {
	
	private static MemberController mc;
	private StockController sc = StockController.getInstance();
	private HashMap<Long, Member> memberList;
	private Member currentMember;
	
	private MemberController() {
		super();
		this.memberList = new HashMap<Long, Member>();
	}
	
	public static MemberController getInstance() {
		if(mc == null) 
			mc = new MemberController();
		return mc;
	}
	
	public Long findUIDbyID(String id) {
		for(Entry<Long, Member> entry : memberList.entrySet()) {
			if(entry.getValue().getMemberId().equals(id)) {
				return entry.getValue().getMemberUID();
			}
		}
		return null;
	}

	public boolean isMemberExist(String id) {
		for(Entry<Long, Member> entry : memberList.entrySet()) {
			if(entry.getValue().getMemberId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isLoginSuccess(String id, String pwd) {
		boolean success = false;
		Member m = findMember(id);
		if(m != null && m.getMemberPwd().equals(pwd))
			success = true;
		return success;
	}
	
	public void loginMember(String id) {
		// id를 입력받아, 해당 id에 속하는 멤버를 currentMember로 설정한다.
		this.currentMember = findMember(id);
	}
	
	public Member getCurrentMember() {
		return this.currentMember;
	}
	
	public void addMember(String name, String id, String pwd) {
		Member newMember = new Member(name,id,pwd);
		this.memberList.put(newMember.getMemberUID(), newMember);
	}
	
	public void delMember(String id) {
		this.memberList.remove(findUIDbyID(id));
	}
	
	public Member findMember(String id) {
		return this.memberList.get(findUIDbyID(id));
	}
	
	public void updateMember(String name, String id, String pwd) {
		Member member = findMember(id);
		
		member.setMemberId(id);
		member.setMemberName(name);
		member.setMemberPwd(pwd);
	}
	
	public void showMemberList() {
		for(Entry<Long, Member> entry : memberList.entrySet()) {
			Member m = entry.getValue();
			System.out.printf("UID : %d , id : %s , 이름 : %s\n",entry.getKey(), m.getMemberId(), m.getMemberName());
		}
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

		if (orderQuantity <= 0 || sc.getStock(stockName) == null) { // 존재하지 않는 주식이거나 잘못된 수량을 판매할 경우( 음의 수 )
			return 400; // 잘못된 주문
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
		
		if(cMemberStockQnt - orderQuantity > 0) // 보유한 수가 0이되면 HashMap에서 제거
			cMemberShareHeld.replace(stockName, cMemberStockQnt - orderQuantity);
		else
			cMemberShareHeld.remove(stockName);
		
		// 주식 수량 복구
		sc.setStockQuantity(stockName, sc.getStock(stockName).getStockQuantity() + orderQuantity);
		
		currentMember.setBalance(currentMember.getBalance() + price);

		return 200; // 구매 성공
	}
	
	public void saveMembers() {
		File saveDir = new File("/save");
		
		if(!saveDir.exists())
			saveDir.mkdirs();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("/save/memberList.txt"))){
			for(Entry<Long, Member> entry : memberList.entrySet()) {
				Member m = entry.getValue();
				String memberInfo = String.format("%d,%s,%s,%s,%s,%s,%d,%d\n",
						m.getMemberUID(), 
						m.getMemberName(), 
						m.getMemberId(), 
						m.getMemberPwd(), 
						m.getShareHeld(),
						m.getStockList(),
						m.getBalance(),
						m.getDay());
				bw.write(memberInfo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMembers() {
		File saveData = new File("/save/memberList.txt");
		
		// TODO 세이브데이터 불러오기
		if(saveData.exists()) {
			String memberInfo = "";
			try(BufferedReader br = new BufferedReader(new FileReader("/save/memberList.txt"))){
				while((memberInfo = br.readLine()) != null) {
					String[] infoArr = memberInfo.split(",");
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}