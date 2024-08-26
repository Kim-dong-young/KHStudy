package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Member;
import com.kh.model.vo.MemberStock;
import com.kh.model.vo.Share;
import com.kh.model.vo.TradeLog;
import com.kh.model.vo.items.Item;
import com.kh.service.MemberService;
import com.kh.view.AlertMenu;
import com.kh.view.MainMenu;

public class MemberController {
	private static MemberController mc;
	MemberStockController msc;
	ShareController sc;
	MemberItemController ic;
	TradeLogController tc;
	
	private Member currentMember;
	
	private MemberService ms;
	
	private MemberController() {
		super();
		ms = MemberService.getInstance();
		this.currentMember = null;
	}

	public static MemberController getInstance() {
		if(mc == null)
			mc = new MemberController();
		return mc;
	}
	
	/**
	 * @return the currentMember
	 */
	public Member getCurrentMember() {
		return currentMember;
	}
	/**
	 * @param currentMember the currentMember to set
	 */
	public void setCurrentMember(Member m) {
		this.currentMember = m;
	}


	public void createMember(String name, String id, String pwd) {
		Member m = new Member(name, id, pwd);
		
		int result = ms.createMember(m);
		
		if(result > 0) {
			new AlertMenu().registerSuccess();
		}
		else {
			new AlertMenu().registerFail();
		}
		
	}

	public void loginMember(String id, String pwd) {
		Member m = new Member(id,pwd);
		
		Member foundMember = ms.searchMember(m);
		
		if(foundMember == null) {
			new AlertMenu().loginFail();
		} else {
			new AlertMenu().loginSuccess();
			
			currentMember = foundMember;
			mc.getMemberStockList(foundMember);
		}
		
	}
	
	public Member loadMemberInfo(Member m) {
		return ms.loadMemberInfo(m);
	}
	
	public ArrayList<MemberStock> getMemberStockList(Member m) {
		msc = MemberStockController.getInstance();
		
		return msc.getMemberStockList(m);
	}
	
	public ArrayList<Share> getMemberShareHeld(Member m){
		sc = ShareController.getInstance();
		
		return sc.getShareHeld(m);
	}
	
	public ArrayList<Item> getMemberItemList(Member m) {
		ic = MemberItemController.getInstance();
		
		return ic.getMemberItemList(m);
	}
	
	public ArrayList<TradeLog> getMemberTradeLog(Member m, int start, int end) {
		tc = TradeLogController.getInstance();
		
		return tc.getMemberTradeLog(m, start, end);
	}
	
	
	public void buyStock(Member member, int buyQuantity, String buyStockName) {
		msc = MemberStockController.getInstance();
		
		msc.buyStock(member, buyQuantity, buyStockName);
		
		Member memberInfo = loadMemberInfo(member);
		if(memberInfo != null)
			currentMember.setBalance(memberInfo.getBalance());
	}

	public void sellStock(Member member, int sellQuantity, String sellStockName) {
		msc = MemberStockController.getInstance();
		
		msc.sellStock(member,sellQuantity,sellStockName);
		
		Member memberInfo = loadMemberInfo(member);
		if(memberInfo != null)
			currentMember.setBalance(memberInfo.getBalance());
	}


}
