package com.kh.model.dao;

public class BulletinDao {
	private static BulletinDao bd;
	
	private BulletinDao() {
		super();
	}
	
	public static BulletinDao getInstance() {
		if(bd == null)
			bd = new BulletinDao();
		return bd;
	}
}
