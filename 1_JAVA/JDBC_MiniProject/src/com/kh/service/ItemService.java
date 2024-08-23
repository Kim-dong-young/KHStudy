package com.kh.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.ItemDao;
import com.kh.model.vo.Member;
import com.kh.model.vo.items.Item;

public class ItemService {
	private static ItemService is;
	private ItemDao idao = ItemDao.getInstance();
	
	private ItemService() {
		super();
	}
	
	public static ItemService getInstance() {
		if(is == null)
			is = new ItemService();
		return is;
	}

	public ArrayList<Item> getMemberItemList(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Item> itemList = idao.getMemberItemList(conn, m);
		
		JDBCTemplate.close(conn);
		return itemList;
	}
}
