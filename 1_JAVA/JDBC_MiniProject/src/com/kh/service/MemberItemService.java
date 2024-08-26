package com.kh.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberItemDao;
import com.kh.model.vo.Member;
import com.kh.model.vo.items.Item;

public class MemberItemService {
	private static MemberItemService is;
	private MemberItemDao idao = MemberItemDao.getInstance();
	
	private MemberItemService() {
		super();
	}
	
	public static MemberItemService getInstance() {
		if(is == null)
			is = new MemberItemService();
		return is;
	}

	public ArrayList<Item> getMemberItemList(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Item> itemList = idao.getMemberItemList(conn, m);
		
		JDBCTemplate.close(conn);
		return itemList;
	}
}
