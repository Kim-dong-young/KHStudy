package _miniproject.controller;

import java.util.HashMap;

import _miniproject.vo.TradeLog;

public class TradeLogController {
	private static TradeLogController tc;
	private HashMap<Long, TradeLog> tradeLog;
	
	public TradeLogController() {
		super();
		this.tradeLog = new HashMap<Long, TradeLog>();
	}
	
	private static TradeLogController getInstance() {
		if(tc == null) {
			tc = new TradeLogController();
		}
		return tc;
	}
	
	// TODO 유저별(Long UID) 거래기록 저장할 객체 구현
	
	
}
