package com.kh.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.ShareDao;
import com.kh.model.vo.Member;
import com.kh.model.vo.Share;

public class ShareService {
	private static ShareService ss;
	private ShareDao sd = ShareDao.getInstance();
	private ShareService() {
		super();
	}
	
	public static ShareService getInstance() {
		if(ss == null) {
			ss = new ShareService();
		}
		return null;
	}

	public ArrayList<Share> getShareHeld(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Share> shareHeld = sd.getShareHeld(conn, m);
		
		JDBCTemplate.close(conn);
		return shareHeld;
	}

}
