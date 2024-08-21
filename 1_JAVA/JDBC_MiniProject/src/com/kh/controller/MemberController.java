package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Member;
import com.kh.model.vo.MemberStock;
import com.kh.service.MemberService;
import com.kh.view.MainMenu;

public class MemberController {
	private static MemberController mc;
	
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
			new MainMenu().registerSuccess();
		}
		else {
			new MainMenu().registerFail();
		}
		
	}

	public void loginMember(String id, String pwd) {
		MemberStockController msc = MemberStockController.getInstance();
		Member m = new Member(id,pwd);
		
		Member foundMember = ms.searchMember(m);
		
		if(foundMember == null) {
			new MainMenu().loginFail();
		} else {
			new MainMenu().loginSuccess();
			
			currentMember = foundMember;
			msc.loadMemberStockList(foundMember);
			
			if(currentMember.getDay() == 0) {
				msc.initMemberStockList(msc.getMemberStockList());
			}
		}
		
	}
	
	public ArrayList<MemberStock> getMemberStockList(){
		MemberStockController msc = MemberStockController.getInstance();
		
		return msc.getMemberStockList();
	}

	public void buyStock(Member currentMember, int buyQuantity, String buyStockName) {
		MemberStockController msc = MemberStockController.getInstance();
		
		msc.buyStock(currentMember, buyQuantity, buyStockName);
	}
	
	
	
}
