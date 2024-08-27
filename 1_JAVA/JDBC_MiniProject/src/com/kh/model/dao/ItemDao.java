package com.kh.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.items.Item;

public class ItemDao {
	private static ItemDao id;
	
	private ItemDao() {
		super();
	}

	public static ItemDao getInstance() {
		if(id == null) {
			id = new ItemDao();
		}
		return id;
	}

	public ArrayList<Item> getItemList(Connection conn) {
		ArrayList<Item> itemList = new ArrayList<Item>();
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = "SELECT * FROM TB_ITEM ORDER BY ITEM_ID";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
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
			JDBCTemplate.close(stmt);
		}
		
		return itemList;
	}

}
