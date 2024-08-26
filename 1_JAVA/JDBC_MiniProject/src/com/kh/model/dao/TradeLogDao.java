package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;
import com.kh.model.vo.TradeLog;

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

	public ArrayList<TradeLog> getMemberTradeLog(Connection conn, Member m, int start, int end) {
		ArrayList<TradeLog> tradeLog = new ArrayList<TradeLog>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * "
				+ "FROM ("
				+ "        SELECT "
				+ "            T.TRADE_ID,"
				+ "            T.MEMBER_UID,"
				+ "            T.TRADE_DATE,"
				+ "            T.STOCK_ID,"
				+ "            T.TRADE_QTY,"
				+ "            T.TRADE_PRICE,"
				+ "            T.TRADE_STATUS,"
				+ "            S.STOCK_NAME,"
				+ "            ROW_NUMBER() OVER(ORDER BY T.TRADE_DATE DESC) AS RNUM "
				+ "        FROM TB_TRADELOG T "
				+ "        JOIN TB_STOCK_LIST S ON T.STOCK_ID = S.STOCK_ID "
				+ "        WHERE T.MEMBER_UID = ? "
				+ ") WHERE RNUM BETWEEN ? AND ?";

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMemberUid());
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				TradeLog tl = new TradeLog();
				
				tl.setTradeId(rset.getInt("TRADE_ID"));
				tl.setMemberId(rset.getInt("MEMBER_UID"));
				tl.setTradeDate(rset.getDate("TRADE_DATE"));
				tl.setStockId(rset.getInt("STOCK_ID"));
				tl.setStockName(rset.getString("STOCK_NAME"));
				tl.setTradeQty(rset.getInt("TRADE_QTY"));
				tl.setTradePrice(rset.getInt("TRADE_PRICE"));
				tl.setStatus(rset.getString("TRADE_STATUS"));
				
				tradeLog.add(tl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return tradeLog;
	}
}
