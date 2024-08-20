package com.kh.model.vo;

import java.util.Objects;

public class MemberRank {
	private String rCode;
	private String rName;
	
	public MemberRank() {
		super();
	}
	
	public MemberRank(String rCode, String rName) {
		super();
		this.rCode = rCode;
		this.rName = rName;
	}
	
	/**
	 * @return the rCode
	 */
	public String getrCode() {
		return rCode;
	}
	/**
	 * @param rCode the rCode to set
	 */
	public void setrCode(String rCode) {
		this.rCode = rCode;
	}
	/**
	 * @return the rName
	 */
	public String getrName() {
		return rName;
	}
	/**
	 * @param rName the rName to set
	 */
	public void setrName(String rName) {
		this.rName = rName;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(rCode);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MemberRank) {
			MemberRank other = (MemberRank)obj;
			if(other.getrCode().equals(this.rCode)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "MemberRank [rCode=" + rCode + ", rName=" + rName + "]";
	}
	
}
