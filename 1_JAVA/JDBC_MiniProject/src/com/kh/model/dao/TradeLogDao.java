package com.kh.model.dao;

public class TradeLogDao {
	private static TradeLogDao td;
	
	private TradeLogDao() {
		super();
	}
	
	public static TradeLogDao getInstance() {
		if(td == null)
			td = new TradeLogDao();
		return td;
	}
}
