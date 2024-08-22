package com.kh.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dto.BuyStockRequest;
import com.kh.model.dto.SellStockRequest;
import com.kh.model.vo.Member;
import com.kh.model.vo.MemberStock;

public class MemberStockDao {
	private static MemberStockDao msd;
	
	private MemberStockDao() {
		super();
	}
	
	public static MemberStockDao getInstance() {
		if(msd == null)
			msd = new MemberStockDao();
		return msd;
	}
	
	public ArrayList<MemberStock> getMemberStockList(Connection conn, Member m) {
		ArrayList<MemberStock> mStockList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TB_MEMBER_STOCK JOIN TB_STOCK_LIST USING(STOCK_ID) WHERE MEMBER_UID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMemberUid());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MemberStock ms = new MemberStock(
						rset.getInt("STOCK_ID"),
						rset.getInt("MEMBER_UID"),
						rset.getInt("MAX_QTY"),
						rset.getInt("STOCK_QTY"),
						rset.getInt("STOCK_PRICE"),
						rset.getDouble("NEXT_FLUCT"),
						rset.getString("STOCK_NAME"),
						rset.getString("DELIST_YN").equals("Y")
				);
				
				mStockList.add(ms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return mStockList;
	}

	public ArrayList<MemberStock> loadMemberStockList(Connection conn, Member m) {
		ArrayList<MemberStock> mStockList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TB_MEMBER_STOCK JOIN TB_STOCK_LIST USING(STOCK_ID) WHERE MEMBER_UID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMemberUid());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MemberStock ms = new MemberStock(
						rset.getInt("STOCK_ID"),
						rset.getInt("MEMBER_UID"),
						rset.getInt("MAX_QTY"),
						rset.getInt("STOCK_QTY"),
						rset.getInt("STOCK_PRICE"),
						rset.getDouble("NEXT_FLUCT"),
						rset.getString("STOCK_NAME"),
						rset.getString("DELIST_YN").equals("Y")
				);
				
				mStockList.add(ms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return mStockList;
	}

	public boolean buyStock(Connection conn, BuyStockRequest bsRequest) {
		boolean isSuccess = false;
		
		CallableStatement cstmt = null;
		String sql = "{CALL PURCHASE_STOCK_PROC(?, ?, ?, ?)}";
		
		try {
			cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1, bsRequest.getMember().getMemberUid());
			cstmt.setInt(2, bsRequest.getStockid());
			cstmt.setInt(3, bsRequest.getBuyQuantity());
			cstmt.setInt(4, bsRequest.getPrice());
			
			cstmt.execute();
			isSuccess = true;
		} catch (SQLException e) {
			String errorMessage = e.getMessage();
			
			if(errorMessage.contains("ORA-20001")) {
				System.out.println("해당 주식 물량이 부족합니다.");
			}
			else if(errorMessage.contains("ORA-20003")) {
				System.out.println("보유한 돈이 부족합니다.");
			}
			else {
				e.printStackTrace();
			}
		} finally {
			JDBCTemplate.close(cstmt);
		}
		
		return isSuccess;
	}

	public boolean sellStock(Connection conn, SellStockRequest ssRequest) {
		boolean isSuccess = false;
		
		// TODO DB에 판매 프로시저 작성
		CallableStatement cstmt = null;
		String sql = "{CALL SELL_STOCK_PROC(?, ?, ?, ?)}";
		
		try {
			cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1, ssRequest.getMember().getMemberUid());
			cstmt.setInt(2, ssRequest.getStockid());
			cstmt.setInt(3, ssRequest.getSellQuantity());
			cstmt.setInt(4, ssRequest.getPrice());
			
			cstmt.execute();
			isSuccess = true;
		} catch (SQLException e) {
			String errorMessage = e.getMessage();
			
			if(errorMessage.contains("ORA-20002")) {
				System.out.println("보유한 주식 수량이 부족합니다.");
			}
			else {
				e.printStackTrace();
			}
			
		} finally {
			JDBCTemplate.close(cstmt);
		}
		
		return isSuccess;
	}

}
