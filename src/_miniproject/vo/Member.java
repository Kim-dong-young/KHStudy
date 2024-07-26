package _miniproject.vo;

import java.util.Date;
import java.util.HashMap;

public class Member {
	private Long memberUID;
	private String memberName;
	private String memberId;
	private String memberPwd;
	private int day;
	private HashMap<String, Integer> shareHeld;
	private int balance;
	
	public Member(String memberName, String memberId, String memberPwd) {
		super();
		this.memberUID = new Date().getTime();
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.shareHeld = new HashMap<String, Integer>();
		this.day = 1;
		this.balance = 1000000;
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