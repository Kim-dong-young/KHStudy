package com.kh.controller;

public class TradeLogController {
	private static TradeLogController tc;
	
	private TradeLogController() {
		super();
	}
	
	public static TradeLogController getInstance() {
		if(tc == null)
			tc = new TradeLogController();
		return tc;
	}
}
