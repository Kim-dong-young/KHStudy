package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;
import com.kh.model.vo.Share;

public class ShareDao {
	private static ShareDao sd;
	
	private ShareDao() {
		super();
	}
	
	public static ShareDao getInstance() {
		if(sd == null) {
			sd = new ShareDao();
		}
		return sd;
	}

	public ArrayList<Share> getShareHeld(Connection conn, Member m) {
		ArrayList<Share> shareHeld = new ArrayList<Share>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM TB_SHARE JOIN TB_STOCK_LIST USING(STOCK_ID) WHERE MEMBER_UID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMemberUid());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Share sh = new Share();
				
				sh.setMemberUid(rset.getInt("MEMBER_UID"));
				sh.setStockId(rset.getInt("STOCK_ID"));
				sh.setShareQty(rset.getInt("SHARE_QTY"));
				sh.setSharePrice(rset.getInt("SHARE_PRICE"));
				sh.setStockName(rset.getString("STOCK_NAME"));
				
				shareHeld.add(sh);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return shareHeld;
	}
	
}
