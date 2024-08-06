package _miniproject.vo;

import java.util.ArrayList;

public class TradeLog {
	private ArrayList<String> tradeLog;

	public TradeLog() {
		this.tradeLog = new ArrayList<>();
	}
	
	public TradeLog(ArrayList<String> tradeLog) {
		this.tradeLog = tradeLog;
	}

	public ArrayList<String> getTradeLog() {
		return tradeLog;
	}

	public void setTradeLog(ArrayList<String> log) {
		this.tradeLog = log;
	}
	
	public void addTradeLog(String log) {
		tradeLog.add(log);
	}
	
	@Override
	public String toString() {
		return tradeLog.toString();
	}
	
	
}
