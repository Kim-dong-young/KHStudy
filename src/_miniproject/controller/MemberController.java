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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import _miniproject.vo.Member;
import _miniproject.vo.Stock;
import _miniproject.vo.items.Item;

public class MemberController {
	private static final String MEMBER_PATTERN = "(\\d+),([^,]+),([^,]+),([^,]+),\\{([^}]*)\\},\\{([^}]*)\\},(\\d+),(\\d+),\\{([^}]*)\\}";
	
	private static MemberController mc;
	private StockController sc = StockController.getInstance();
	private ItemController ic = ItemController.getInstance();
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
		if( m != null && m.getMemberPwd().equals(pwd)) {
			success = true;
		}
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
	
	public HashMap<Long, Member> getMemberList() {
		return memberList;
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
	
	public void purchaseItem(Item item) {
		HashMap<Item,Integer> cMemberIList = currentMember.getItemList();
		if( ( currentMember.getBalance() >= item.getPrice() ) && !cMemberIList.containsKey(item)) {
			cMemberIList.put(item, 1);
			currentMember.setBalance( currentMember.getBalance() - item.getPrice() );
		}
		else {
			cMemberIList.replace(item, cMemberIList.get(item) + 1);
		}
		
	}
	
	public boolean useItem(Item item) {
		HashMap<Item,Integer> cMemberIList = currentMember.getItemList();

		if(cMemberIList.get(item) != null && cMemberIList.get(item) > 0) {
			item.use();
			cMemberIList.replace(item, cMemberIList.get(item) - 1);
			
			if(cMemberIList.get(item) <= 0) cMemberIList.remove(item);
			
			return true;
		}
		return false;
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
				String memberInfo = String.format("%d,%s,%s,%s,%s,%s,%d,%d,%s\n",
						m.getMemberUID(), 
						m.getMemberName(), 
						m.getMemberId(), 
						m.getMemberPwd(),
						m.getShareHeld(),
						m.getStockList(),
						m.getBalance(),
						m.getDay(),
						m.getItemList());
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
		
		if(saveData.exists()) {
			try(BufferedReader br = new BufferedReader(new FileReader("/save/memberList.txt"))){
				String memberInfo;
				while((memberInfo = br.readLine()) != null) {
					Member member = parseMemberInfo(memberInfo);
					if(member != null) {
						memberList.put(member.getMemberUID(), member);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	private Member parseMemberInfo(String memberInfo) {
		// https://girawhale.tistory.com/77
		
		Pattern pattern = Pattern.compile(MEMBER_PATTERN);
		Matcher matcher = pattern.matcher(memberInfo);
		
		Member member = null;
		
		if(matcher.find()) {
			Long uid = Long.parseLong(matcher.group(1));
			String name = matcher.group(2);    
			String id = matcher.group(3);
			String pwd = matcher.group(4);
			
			// 보유 주식 추출
			// < 데이터 형식 >
			// 삼성전자=1, 현대모비스=3
			String shareHeldStr = matcher.group(5);
			HashMap<String, Integer> shareHeld = new HashMap<>();
			if(!shareHeldStr.isEmpty()) {
				String[] shareHeldList = shareHeldStr.split(",");
				for(String stock : shareHeldList) {
					String[] stockInfo = stock.split("=");
					String stockName = stockInfo[0].trim();
					Integer stockQuantity = Integer.parseInt(stockInfo[1]);
					
					shareHeld.put(stockName, stockQuantity);
				}
			}
			
			// 개인별 주식창 추출
			// < 데이터 형식 >
			// 롯데케미칼=종목 : 롯데케미칼 / 가격 : 100800 / 수량 : 1000 / 변동폭 : 1000, 
			String stockListStr = matcher.group(6);
			HashMap<String, Stock> stockList = new HashMap<>();
			if(!stockListStr.isEmpty()) {
				String[] stockListArr = stockListStr.split(",");
				for(String stock : stockListArr) {
					String[] stocks = stock.split("=");
					String stockName = stocks[0].trim();
					
					String[] stockInfo = stocks[1].split("/");
					int stockPrice = Integer.parseInt(stockInfo[1].split(":")[1].trim());
					int stockQuantity = Integer.parseInt(stockInfo[2].split(":")[1].trim());
					int stockPreviousPrice = Integer.parseInt(stockInfo[3].split(":")[1].trim());
					double nextFluct = Double.parseDouble(stockInfo[4].split(":")[1].trim());
					
					stockList.put(stockName, new Stock(stockName, stockPrice, stockPreviousPrice ,stockQuantity, nextFluct));
				}
			}
			
			int balance = Integer.parseInt(matcher.group(7));
			int day = Integer.parseInt(matcher.group(8));
			
			String itemListStr = matcher.group(9);
			HashMap<Item, Integer> itemList = new HashMap<>();
			if(!itemListStr.isEmpty()) {
				String[] itemListArr = itemListStr.split(",");
				for(String item : itemListArr) {
					String[] itemInfo = item.split("=");
					String itemName = itemInfo[0].trim();
					Integer itemQuantity = Integer.parseInt(itemInfo[1]);
					
					itemList.put(ic.getItem(Integer.parseInt(itemName)), itemQuantity);
				}
			}
			
			member = new Member(uid,name,id,pwd,shareHeld,stockList,day,balance,itemList);
		}
		return member;
	}
}