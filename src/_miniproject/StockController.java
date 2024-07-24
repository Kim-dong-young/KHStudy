package _miniproject;

import java.util.HashMap;

public class StockController {
	private HashMap<String, Stock> stockList;

	public StockController() {
		super();
		stockList = new HashMap<String, Stock>();
		stockList.put("LG전자", new Stock("LG전자",112500,1000));
		stockList.put("삼성전자", new Stock("삼성전자",159500,1000));
		stockList.put("롯데케미칼", new Stock("롯데케미칼",100800,1000));
		stockList.put("현대모비스", new Stock("현대모비스",224500,1000));
		stockList.put("KB금융", new Stock("KB금융",84600,1000));
	}
	
	public void showStockList() {
		
	}
	
	
	
}
