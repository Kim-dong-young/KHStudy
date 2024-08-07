package _miniproject.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import _miniproject.vo.Member;
import _miniproject.vo.TradeLog;

public class TradeLogController {
	private static final String TRADE_LOG_PATTERN = "(\\d+)\\s(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d+)\\s([^\\s]+)\\s(\\d+)\\s(\\d+)\\s(구매|판매)";
	private static TradeLogController tc;
	private HashMap<Long, TradeLog> tradeLog;
	
	private TradeLogController() {
		super();
		this.tradeLog = new HashMap<Long, TradeLog>();
	}
	
	public static TradeLogController getInstance() {
		if(tc == null) {
			tc = new TradeLogController();
		}
		return tc;
	}
	
	public void addTradeLog(Long uid, LocalDateTime time , String message) {
		if(tradeLog.get(uid) == null) {
			tradeLog.put(uid, new TradeLog());
		}
		tradeLog.get(uid).addTradeLog(uid + " " + time +" "+ message); // HashMap에 저장
		saveTradeLog(uid + " " + time +" "+ message); // 로그 파일(.txt)에 저장
	}
	
	public void showTradeLog(Long uid) {
		if(tradeLog.get(uid) == null) {
			System.out.println("거래기록이 없습니다.");
			return;
		}
		for(String msg : tradeLog.get(uid).getTradeLog()) {
			System.out.println(msg);
		}
	}
	
	public void calcProfit(Long uid) {
		if(tradeLog.get(uid) == null) {
			System.out.println("거래기록이 없습니다.");
			return;
		}
		
		Pattern pattern = Pattern.compile(TRADE_LOG_PATTERN);
		
		for(String msg : tradeLog.get(uid).getTradeLog()) {
			Matcher matcher = pattern.matcher(msg);
			if(matcher.group(6).equals("구매")) {
				
			}
			else if (matcher.group(6).equals("판매")) {
				
			}
		}
	}
	
	public void saveTradeLog(String message) {
		File saveDir = new File("/save");
		
		if(!saveDir.exists())
			saveDir.mkdirs();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("/save/tradeLog.txt",true));){
			bw.write(message+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadTradeLog() {
		File saveData = new File("/save/tradeLog.txt");
		
		if(saveData.exists()) {
			try(BufferedReader br = new BufferedReader(new FileReader("/save/tradeLog.txt"))){
				String tradeInfo;
				while((tradeInfo = br.readLine()) != null) {
					parseTradeInfo(tradeInfo);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void parseTradeInfo(String tradeInfo) {
		Pattern pattern = Pattern.compile(TRADE_LOG_PATTERN);
		Matcher matcher = pattern.matcher(tradeInfo);
		
		if(matcher.find()) {
			Long uid = Long.parseLong(matcher.group(1));
			LocalDateTime time = LocalDateTime.parse(matcher.group(2), DateTimeFormatter.ISO_DATE_TIME);
			String stockName = matcher.group(3);
			int quantity = Integer.parseInt(matcher.group(4));
			int price = Integer.parseInt(matcher.group(5));
			String status = matcher.group(6); // 판매 or 구매
			
			if(!tradeLog.containsKey(uid)) {
				tradeLog.put(uid, new TradeLog());
			} 
			tradeLog.get(uid).addTradeLog(uid + " " + time + " " + stockName + " " + quantity + " " + price + " " + status);
		}
		
	}
	
}
