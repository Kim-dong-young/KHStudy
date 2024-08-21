package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dto.BuyStockRequest;
import com.kh.model.vo.Member;
import com.kh.model.vo.MemberStock;
import com.kh.service.MemberStockService;
import com.kh.view.MainMenu;
import com.kh.view.StockMarketMenu;

public class MemberStockController {
	private static MemberStockController mstc;
	private MemberStockService mss;
	
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
	
	public void initMemberStockList(ArrayList<MemberStock> mStockList) {
		for(MemberStock ms : mStockList) {
			if(ms.getStockName().equals("LG전자")) {
				initMemberStock(ms,1000,1000,112500);
			}
			else if(ms.getStockName().equals("삼성전자")) {
				initMemberStock(ms,1000,1000,159500);
			}
			else if(ms.getStockName().equals("롯데케미칼")) {
				initMemberStock(ms,1000,1000,100800);
			}
			else if(ms.getStockName().equals("현대모비스")) {
				initMemberStock(ms,1000,1000,224500);
			}
			else if(ms.getStockName().equals("KB금융")) {
				initMemberStock(ms,1000,1000,84600);
			}
			else {
				initMemberStock(ms,1000,1000,100000);
			}
		}	
	}
	
	public void initMemberStock(MemberStock ms, int maxQty, int stockQty, int stockPrice) {
		if(maxQty <= 0) maxQty = 1;
		if(stockQty <= 0) stockQty = 1;
		if(stockQty > maxQty) stockQty = maxQty;
		if(stockPrice < 0) stockPrice = 0;
		
		ms.setMaxQty(maxQty);
		ms.setStockQty(stockQty);
		ms.setStockPrice(stockPrice);
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
}
