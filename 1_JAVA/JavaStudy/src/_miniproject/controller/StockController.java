package _miniproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import _miniproject.vo.Stock;

public class StockController {
	private static StockController sc;
	private Random random = new Random();
	private HashMap<String, Stock> stockList;

	private StockController() {
		super();
		stockList = new HashMap<String, Stock>();
	}

	public static StockController getInstance() {
		if(sc == null) 
			sc =  new StockController();
		return sc;
	}
	
	public Stock getStock(String stockName) {
		return stockList.get(stockName);
	}
	
	public String getStockInfo(Stock stock) {
		return String.format("종목 : %s / 가격 : %d / 수량 : %d / 변동폭 : %d", stock.getStockName(), stock.getStockPrice(), stock.getStockQuantity(), stock.getPriceFluct());
	}
	
	public Stock getRandomStock() {
		// TODO 랜덤한 주식값 뽑기
		List<Stock> sl = new ArrayList<Stock>(stockList.values());
		return sl.get( random.nextInt(0, sl.size()) );
	}
	
	public HashMap<String, Stock> getStockList(){
		return this.stockList;
	}
	
	public void setStockList(HashMap<String, Stock> stockList) {
		this.stockList = stockList;
	}
	
	public void showStockList() {
		for(Entry<String, Stock> entry : stockList.entrySet()) {
			System.out.println(getStockInfo(entry.getValue()));
		}
	}
	
	public int getStockPrice(String stockName) {
		Stock stock = stockList.get(stockName);
		
		if(stock != null)
			return stock.getStockPrice();
		else
			return 0;
	}
	
	public void randomStockPrice() {
		for(Entry<String, Stock> entry : stockList.entrySet()) {
			Stock stock = entry.getValue();
			// 변경 전 가격 저장
			int previousPrice = stock.getStockPrice();
			double nextFluct = stock.getNextFluct(); // 주식 변동율 가져옴
			// -20 ~ +20 % 사이 가격 변동
			stock.setStockPrice( (int)( previousPrice * nextFluct ));
			stock.setPriceFluct(stock.getStockPrice() - previousPrice);
			stock.setNextFluct(random.nextDouble(0.8, 1.2));
		}
	}
	
	public int getStockQuantity(String stockName) {
		Stock stock = stockList.get(stockName);
		
		if(stock != null)
			return stock.getStockQuantity();
		else
			return 0;
	}
	
	public void setStockQuantity(String stockName, int quantity) {
		Stock stock = stockList.get(stockName);
		
		if(stock != null)
			stock.setStockQuantity(quantity);
		else
			return;
	}
	
	public int getStockMaxQuantity(String stockName) {
		Stock stock = stockList.get(stockName);
		
		if(stock != null)
			return stock.getMaxQuantity();
		else
			return 0;		
	}
	
	public void setStockMaxQuantity(String stockName, int quantity) {
		stockList.get(stockName).setMaxQuantity(quantity);
	}
	
}
