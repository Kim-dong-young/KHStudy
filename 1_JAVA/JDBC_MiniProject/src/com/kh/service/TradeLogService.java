package com.kh.service;

public class TradeLogService {
	private static TradeLogService ts;
	
	private TradeLogService() {
		super();
	}
	
	public static TradeLogService getInstance() {
		if(ts == null)
			ts = new TradeLogService();
		return ts;
	}
}
