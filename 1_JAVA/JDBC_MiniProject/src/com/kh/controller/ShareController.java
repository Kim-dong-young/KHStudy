package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Member;
import com.kh.model.vo.Share;
import com.kh.service.ShareService;
import com.kh.view.StockMarketMenu;

public class ShareController {
	private static ShareController shc;
	private ShareService ss = ShareService.getInstance();

	private ShareController() {
		super();
	}
	
	public static ShareController getInstance() {
		if(shc == null)
			shc = new ShareController();
		return shc;
	}

	public ArrayList<Share> getShareHeld(Member m) {
		ArrayList<Share> shareHeld = ss.getShareHeld(m);

		return shareHeld;
	}
	
	public void showShareHeld(Member m) {
		new StockMarketMenu().shareHeldMenu(getShareHeld(m));
	}
	
}
