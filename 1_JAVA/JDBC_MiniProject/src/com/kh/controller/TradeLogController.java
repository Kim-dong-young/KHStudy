package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Member;
import com.kh.model.vo.TradeLog;
import com.kh.service.TradeLogService;

public class TradeLogController {
	private static TradeLogController tc;
	
	private TradeLogService ts = TradeLogService.getInstance();;
	
	private TradeLogController() {
		super();
	}
	
	public static TradeLogController getInstance() {
		if(tc == null)
			tc = new TradeLogController();
		return tc;
	}

	public ArrayList<TradeLog> getMemberTradeLog(Member m, int start, int end) {
		return ts.getMemberTradeLog(m, start, end);
	}
}
