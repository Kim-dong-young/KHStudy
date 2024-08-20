package com.kh.service;

public class StockService {
	private static StockService sts;
	
	private StockService() {
		super();
	}
	
	public static StockService getInstance() {
		if(sts == null)
			sts = new StockService();
		return sts;
	}
}
