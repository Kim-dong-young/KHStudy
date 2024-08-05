package _miniproject.vo;

import java.util.ArrayList;

public class TradeLog {
	private ArrayList<String> tradeLog;

	public TradeLog() {
		this.tradeLog = new ArrayList<>();
	}

	public ArrayList<String> getTradeLog() {
		return tradeLog;
	}

	public void setTradeLog(ArrayList<String> log) {
		this.tradeLog = log;
	}
	
	public void addTradeLog(String status) {
		tradeLog.add(status);
	}
	
	@Override
	public String toString() {
		return "TradeLog [log=" + tradeLog + "]";
	}
	
	
}
