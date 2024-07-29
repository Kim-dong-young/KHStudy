package _miniproject.vo;

import java.util.Date;
import java.util.HashMap;

public class Member {
	private Long memberUID;
	private String memberName;
	private String memberId;
	private String memberPwd;
	
	private HashMap<String, Integer> shareHeld;
	private HashMap<String, Stock> stockList;
	
	private int day;
	private int balance;
	
	public Member(String memberName, String memberId, String memberPwd) {
		super();
		this.memberUID = new Date().getTime();
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.day = 1;
		this.shareHeld = new HashMap<String, Integer>();
		this.stockList = new HashMap<String, Stock>();
		this.balance = 1000000;
		
		stockList.put("LG전자", new Stock("LG전자",112500,1000));
		stockList.put("삼성전자", new Stock("삼성전자",159500,1000));
		stockList.put("롯데케미칼", new Stock("롯데케미칼",100800,1000));
		stockList.put("현대모비스", new Stock("현대모비스",224500,1000));
		stockList.put("KB금융", new Stock("KB금융",84600,1000));
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

	public HashMap<String, Integer> getShareHeld() {
		return shareHeld;
	}

	public void setShareHeld(HashMap<String, Integer> shareHeld) {
		this.shareHeld = shareHeld;
	}
	
	public HashMap<String, Stock> getStockList() {
		return stockList;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Member [memberName=" + memberName + ", memberId=" + memberId + ", memberPwd=" + memberPwd
				+ ", shareHeld=" + shareHeld + ", balance=" + balance + "]";
	}
	
	
}