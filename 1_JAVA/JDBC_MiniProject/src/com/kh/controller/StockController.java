package com.kh.controller;

public class StockController {
	private static StockController stc;
	
	private StockController() {
		super();
	}
	
	public static StockController getInstance() {
		if(stc == null)
			stc = new StockController();
		return stc;
	}
}
