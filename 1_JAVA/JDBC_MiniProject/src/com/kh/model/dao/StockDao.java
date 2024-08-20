package com.kh.model.dao;

public class StockDao {
	private static StockDao sd;
	
	private StockDao() {
		super();
	}
	
	public static StockDao getInstance() {
		if(sd == null)
			sd = new StockDao();
		return sd;
	}
}
