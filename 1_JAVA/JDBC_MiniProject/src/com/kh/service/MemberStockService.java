package com.kh.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberStockDao;
import com.kh.model.dto.BuyStockRequest;
import com.kh.model.vo.Member;
import com.kh.model.vo.MemberStock;

public class MemberStockService {
	private static MemberStockService mst;
	
	private MemberStockDao msd = MemberStockDao.getInstance();
	
	private MemberStockService() {
		super();
	}
	
	public static MemberStockService getInstance() {
		if(mst == null)
			mst = new MemberStockService();
		return mst;
	}

	public ArrayList<MemberStock> loadMemberStockList(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<MemberStock> mStockList = msd.loadMemberStockList(conn, m);
		
		JDBCTemplate.close(conn);
		return mStockList;
	}

	public boolean buyStock(BuyStockRequest bsRequest) {
		boolean isSuccess = false;
		Connection conn = JDBCTemplate.getConnection();
		
		isSuccess = msd.buyStock(conn, bsRequest);
		
		if(isSuccess) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return isSuccess;
	}
	
}
