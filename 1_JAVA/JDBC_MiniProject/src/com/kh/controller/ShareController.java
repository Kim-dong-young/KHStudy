package com.kh.controller;

public class ShareController {
	private static ShareController shc;
	
	private ShareController() {
		super();
	}
	
	public static ShareController getInstance() {
		if(shc == null)
			shc = new ShareController();
		return shc;
	}
}
