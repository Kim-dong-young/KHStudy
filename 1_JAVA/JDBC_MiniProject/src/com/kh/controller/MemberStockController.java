package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dto.BuyStockRequest;
import com.kh.model.dto.SellStockRequest;
import com.kh.model.vo.Member;
import com.kh.model.vo.MemberStock;
import com.kh.service.MemberStockService;
import com.kh.view.MainMenu;
import com.kh.view.StockMarketMenu;

public class MemberStockController {
	private static MemberStockController mstc;
	private MemberStockService mss;
	
	// 유저 개인별 주식 시장의 정보
	private ArrayList<MemberStock> mStockList;
	
	private MemberStockController() {
		super();
		mss = MemberStockService.getInstance();
		mStockList = new ArrayList<>();
	}

	/**
	 * @return the mStockList
	 */
	public ArrayList<MemberStock> getMemberStockList() {
		return mStockList;
	}
	/**
	 * @param mStockList the mStockList to set
	 */
	public void setMemberStockList(ArrayList<MemberStock> mStockList) {
		this.mStockList = mStockList;
	}

	public static MemberStockController getInstance() {
		if(mstc == null)
			mstc = new MemberStockController();
		return mstc;
	}

	public void loadMemberStockList(Member m) {
		mStockList = mss.loadMemberStockList(m);
		
		if(mStockList.isEmpty()) {
			new MainMenu().loadMemberStockListFail();
		}
	}
	
	public MemberStock getStockByName(String StockName) {
		MemberStock result = null;
		
		for(MemberStock ms : mStockList) {
			if(ms.getStockName().equals(StockName)) {
				result = ms;
				break;
			}
		}

		return result;
	}

	public void buyStock(Member m, int buyQuantity, String buyStockName) {
		MemberStock ms = getStockByName(buyStockName);
		// 해당하는 이름의 주식번호 조회 실패시 null
		if(ms == null) {
			new StockMarketMenu().buyStockFail();
			return;
		}
		
		BuyStockRequest bsRequest = new BuyStockRequest(m, buyQuantity, ms.getStockId(), buyQuantity * ms.getStockPrice());
		if(mss.buyStock(bsRequest)) {
			new StockMarketMenu().buyStockSuccess();
		} else {
			new StockMarketMenu().buyStockFail();
		}
	}

	public void sellStock(Member m, int sellQuantity, String sellStockName) {
		MemberStock ms = getStockByName(sellStockName);
		// 해당하는 이름의 주식번호 조회 실패시 null
		if(ms == null) {
			new StockMarketMenu().sellStockFail();
			return;
		}
		
		SellStockRequest ssRequest = new SellStockRequest(m, sellQuantity, ms.getStockId(), sellQuantity * ms.getStockPrice());
		if(mss.sellStock(ssRequest)) {
			new StockMarketMenu().sellStockSuccess();
		} else {
			new StockMarketMenu().sellStockFail();
		}
		
	}
}
