package _miniproject.controller;

import java.util.HashMap;

import _miniproject.vo.Stock;

public class StockController {
	private static StockController sc;
	private HashMap<String, Stock> stockList;

	private StockController() {
		super();
		stockList = new HashMap<String, Stock>();
		stockList.put("LG전자", new Stock("LG전자",112500,1000));
		stockList.put("삼성전자", new Stock("삼성전자",159500,1000));
		stockList.put("롯데케미칼", new Stock("롯데케미칼",100800,1000));
		stockList.put("현대모비스", new Stock("현대모비스",224500,1000));
		stockList.put("KB금융", new Stock("KB금융",84600,1000));
	}
	
	public static StockController getInstance() {
		if(sc == null) 
			sc =  new StockController();
		return sc;
	}
	
	public void showStockList() {
		// 메소드 참조( :: ), 람다식 생략
		stockList.values().forEach(System.out::println);
	}
	
	public int getStockPrice(String stockName) {
		return stockList.get(stockName).getStockPrice();
	}
	
	public int getStockQuantity(String stockName) {
		return stockList.get(stockName).getStockQuantity();
	}
	
	public void setStockQuantity(String stockName, int quantity) {
		stockList.get(stockName).setStockQuantity(quantity);
	}
	
	public int getStockMaxQuantity(String stockName) {
		return stockList.get(stockName).getMaxQuantity();
	}
	
	public void setStockMaxQuantity(String stockName, int quantity) {
		stockList.get(stockName).setMaxQuantity(quantity);
	}
	
	
}
