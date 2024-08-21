package com.kh.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dto.BuyStockRequest;
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
		// TODO 프로시저 고쳐야함
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
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(cstmt);
		}
		
		return isSuccess;
	}
}
