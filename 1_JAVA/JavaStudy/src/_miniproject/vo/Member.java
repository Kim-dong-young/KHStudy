package _miniproject.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

import _miniproject.vo.items.Item;

public class Member {
	private Long memberUID;
	private String memberName;
	private String memberId;
	private String memberPwd;
	private String rank;
	
	private HashMap<String, Shares> shareHeld;
	private HashMap<String, Stock> stockList;
	private HashMap<Item, Integer> itemList;
	
	private int day;
	private int balance;
	
	public Member(String memberName, String memberId, String memberPwd) {
		super();
		this.memberUID = new Date().getTime();
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.day = 1;
		this.shareHeld = new HashMap<String, Shares>();
		this.stockList = new HashMap<String, Stock>();
		this.itemList = new HashMap<Item, Integer>();
		this.balance = 1000000;
		this.rank = "user";
		
		stockList.put("LG전자", new Stock("LG전자",112500,1000));
		stockList.put("삼성전자", new Stock("삼성전자",159500,1000));
		stockList.put("롯데케미칼", new Stock("롯데케미칼",100800,1000));
		stockList.put("현대모비스", new Stock("현대모비스",224500,1000));
		stockList.put("KB금융", new Stock("KB금융",84600,1000));
	}
	
	public Member(Long memberUID, String memberName, String memberId, String memberPwd,
			HashMap<String, Shares> shareHeld, HashMap<String, Stock> stockList, int day, int balance, HashMap<Item, Integer> itemList) {
		super();
		this.memberUID = memberUID;
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.shareHeld = shareHeld;
		this.stockList = stockList;
		this.day = day;
		this.balance = balance;
		this.itemList = itemList;
		this.rank = "user";
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public Long getMemberUID() {
		return this.memberUID;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public HashMap<String, Shares> getShareHeld() {
		return shareHeld;
	}

	public void setShareHeld(HashMap<String, Shares> shareHeld) {
		this.shareHeld = shareHeld;
	}
	
	public HashMap<String, Stock> getStockList() {
		return stockList;
	}
	
	public void setStockList(HashMap<String, Stock> stockList) {
		this.stockList = stockList;
	}
	
	public HashMap<Item, Integer> getItemList(){
		return itemList;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return memberUID + "," + memberName + "," + memberId
				+ "," + memberPwd + "," + shareHeld + "," + stockList + "," + day
				+ "," + balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberUID);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member other = (Member)obj;
			if(this.getMemberUID().equals(other.getMemberUID()))
				return true;
		}
		return false;
	}
	
	
}