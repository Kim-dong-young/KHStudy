package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dto.BuyStockRequest;
import com.kh.model.dto.SellStockRequest;
import com.kh.model.vo.Member;
import com.kh.model.vo.MemberStock;
import com.kh.service.MemberStockService;
import com.kh.view.AlertMenu;
import com.kh.view.MainMenu;
import com.kh.view.StockMarketMenu;

public class MemberStockController {
	private static MemberStockController mstc;
	private MemberStockService mss;

	private MemberStockController() {
		super();
		mss = MemberStockService.getInstance();
	}

	public ArrayList<MemberStock> getMemberStockList(Member m){
		return mss.getMemberStockList(m);
	}

	public static MemberStockController getInstance() {
		if(mstc == null)
			mstc = new MemberStockController();
		return mstc;
	}
	
	public MemberStock getStockByName(Member m, String StockName) {
		ArrayList<MemberStock> mStockList = getMemberStockList(m);
		MemberStock result = null;
		
		if(mStockList.isEmpty()) {
			new AlertMenu().getMemberStockListFail();
		}
		
		for(MemberStock ms : mStockList) {
			if(ms.getStockName().equals(StockName)) {
				result = ms;
				break;
			}
		}

		return result;
	}

	public void buyStock(Member m, int buyQuantity, String buyStockName) {
		MemberStock ms = getStockByName(m, buyStockName);
		// 해당하는 이름의 주식번호 조회 실패시 null
		if(ms == null) {
			new AlertMenu().buyStockFail();
			return;
		}
		
		BuyStockRequest bsRequest = new BuyStockRequest(m, buyQuantity, ms.getStockId(), buyQuantity * ms.getStockPrice());
		if(mss.buyStock(bsRequest)) {
			new AlertMenu().buyStockSuccess();
		} else {
			new AlertMenu().buyStockFail();
		}
	}

	public void sellStock(Member m, int sellQuantity, String sellStockName) {
		MemberStock ms = getStockByName(m, sellStockName);
		// 해당하는 이름의 주식번호 조회 실패시 null
		if(ms == null) {
			new AlertMenu().sellStockFail();
			return;
		}
		
		SellStockRequest ssRequest = new SellStockRequest(m, sellQuantity, ms.getStockId(), sellQuantity * ms.getStockPrice());
		if(mss.sellStock(ssRequest)) {
			new AlertMenu().sellStockSuccess();
		} else {
			new AlertMenu().sellStockFail();
		}
		
	}
}
