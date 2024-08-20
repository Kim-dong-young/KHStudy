package com.kh.service;

public class BulletinService {
	private static BulletinService bs;
	
	private BulletinService() {
		super();
	}
	
	public static BulletinService getInstance() {
		if(bs == null)
			bs = new BulletinService();
		return bs;
	}
}
