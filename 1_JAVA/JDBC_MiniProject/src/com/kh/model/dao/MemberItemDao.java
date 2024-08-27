package com.kh.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dto.BuyItemRequest;
import com.kh.model.vo.Member;
import com.kh.model.vo.items.Item;
import com.kh.view.AlertMenu;

public class MemberItemDao {
	private static MemberItemDao itd;
	
	private MemberItemDao() {
		super();
	}
	
	public static MemberItemDao getInstance() {
		if(itd == null)
			itd = new MemberItemDao();
		return itd;
	}

	public ArrayList<Item> getMemberItemList(Connection conn, Member m) {
		ArrayList<Item> itemList = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM TB_MEMBER_ITEM JOIN TB_ITEM USING(ITEM_ID) WHERE MEMBER_UID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMemberUid());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Item item = new Item();
				
				item.setItemId(rset.getInt("ITEM_ID"));
				item.setItemName(rset.getString("ITEM_NAME"));
				item.setItemPrice(rset.getInt("ITEM_PRICE"));
				item.setItemDesc(rset.getString("ITEM_DESC"));
				
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return itemList;
	}

	public boolean buyItem(Connection conn, BuyItemRequest biRequest) {
		boolean isSuccess = false;
		CallableStatement cstmt = null;
		
		String sql ="{CALL BUY_ITEM_PROC(?, ?)}";
		
		try {
			cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1,biRequest.getMemberUid());
			cstmt.setInt(2, biRequest.getItemId());
			
			cstmt.execute();
			isSuccess = true;
		} catch (SQLException e) {
			String errorMessage = e.getMessage();
			
			if(errorMessage.contains("ORA-20003")) {
				new AlertMenu().buyItemFail();
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
