package _miniproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import _miniproject.vo.TradeLog;

public class TradeLogController {
	private static TradeLogController tc;
	private HashMap<Long, ArrayList<TradeLog>> tradeLog;
	
	private TradeLogController() {
		super();
		this.tradeLog = new HashMap<Long, ArrayList<TradeLog>>();
	}
	
	public static TradeLogController getInstance() {
		if(tc == null) {
			tc = new TradeLogController();
		}
		return tc;
	}
	
	public void addTradeLog(Long uid, Date tradeDate, String stockName, int quantity, int price, String status) {
		if(tradeLog.get(uid) == null) {
			tradeLog.put(uid, new ArrayList<TradeLog>());
		}
		tradeLog.get(uid).add(new TradeLog(uid, tradeDate, stockName, quantity, price, status)); // HashMap에 저장
		saveTradeLog(); 
	}
	
	public void showTradeLog(Long uid) {
		if(tradeLog.get(uid) == null) {
			System.out.println("거래기록이 없습니다.");
			return;
		}
		for(TradeLog tlog : tradeLog.get(uid) ) {
			System.out.println(tlog);
		}
	}
	
	public int calcProfit(Long uid) {
		if(tradeLog.get(uid) == null) {
			System.out.println("거래기록이 없습니다.");
			return 0;
		}
		
		int profit = 0;
		for(TradeLog tlog : tradeLog.get(uid)) {
			if(tlog.getStatus().equals("구매")) {
				profit -= tlog.getPrice() * tlog.getQuantity();
			}
			else if (tlog.getStatus().equals("판매")) {
				profit += tlog.getPrice() * tlog.getQuantity();
			}
		}
		return profit;
	}
	
	public void saveTradeLog() {

	}
	
	public void loadTradeLog() {

	}
	
	public void parseTradeInfo() {

	}
	
}
