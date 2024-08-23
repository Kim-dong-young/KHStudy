package com.kh.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.TradeLogDao;
import com.kh.model.vo.Member;
import com.kh.model.vo.TradeLog;

public class TradeLogService {
	private static TradeLogService ts;
	
	private TradeLogDao td = TradeLogDao.getInstance();
	
	private TradeLogService() {
		super();
	}
	
	public static TradeLogService getInstance() {
		if(ts == null)
			ts = new TradeLogService();
		return ts;
	}

	public ArrayList<TradeLog> getMemberTradeLog(Member m, int start, int end) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<TradeLog> tradeLog = td.getMemberTradeLog(conn, m, start, end);
		
		JDBCTemplate.close(conn);
		return tradeLog;
	}
}
