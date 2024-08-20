package com.kh.controller;

public class BulletinController {
	private static BulletinController bc;
	
	private BulletinController() {
		super();
	}
	
	public static BulletinController getInstance() {
		if(bc == null)
			bc = new BulletinController();
		return bc;
	}
}
