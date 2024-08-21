package com.kh.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Member {
	private int memberUid;
	private String memberName;
	private String memberId;
	private String memberPwd;
	private String memberRcode;
	private Date enrollDate;
	private boolean isWithdraw;
	private int day;
	private int balance;

	public Member() {
		super();
	}
	
	public Member(String memberId, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}

	public Member(String memberName, String memberId, String memberPwd) {
		super();
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}

	public Member(int memberUid, String memberName, String memberId, String memberPwd, String memberRcode,
			Date enrollDate, boolean isWithdraw, int day, int balance) {
		super();
		this.memberUid = memberUid;
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberRcode = memberRcode;
		this.enrollDate = enrollDate;
		this.isWithdraw = isWithdraw;
		this.day = day;
		this.balance = balance;
	}

	/**
	 * @return the memberUid
	 */
	public int getMemberUid() {
		return memberUid;
	}
	/**
	 * @param memberUid the memberUid to set
	 */
	public void setMemberUid(int memberUid) {
		this.memberUid = memberUid;
	}
	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the memberPwd
	 */
	public String getMemberPwd() {
		return memberPwd;
	}
	/**
	 * @param memberPwd the memberPwd to set
	 */
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	/**
	 * @return the memberRank
	 */
	public String getMemberRcode() {
		return memberRcode;
	}
	/**
	 * @param memberRank the memberRank to set
	 */
	public void setMemberRcode(String memberRank) {
		this.memberRcode = memberRank;
	}
	/**
	 * @return the enrollDate
	 */
	public Date getEnrollDate() {
		return enrollDate;
	}
	/**
	 * @param enrollDate the enrollDate to set
	 */
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	/**
	 * @return the isWithdraw
	 */
	public boolean isWithdraw() {
		return isWithdraw;
	}
	/**
	 * @param isWithdraw the isWithdraw to set
	 */
	public void setWithdraw(boolean isWithdraw) {
		this.isWithdraw = isWithdraw;
	}
	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}
	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberUid);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member other = (Member)obj;
			if(other.getMemberUid() == this.memberUid)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Member [memberUid=" + memberUid + ", memberName=" + memberName + ", memberId=" + memberId
				+ ", memberPwd=" + memberPwd + ", memberRcode=" + memberRcode + ", enrollDate=" + enrollDate
				+ ", isWithdraw=" + isWithdraw + ", day=" + day + ", balance=" + balance + "]";
	}
	
}
