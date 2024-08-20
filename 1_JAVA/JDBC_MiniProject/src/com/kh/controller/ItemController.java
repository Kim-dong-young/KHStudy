package com.kh.controller;

public class ItemController {
	private static ItemController ic;
	
	private ItemController() {
		super();
	}
	
	public static ItemController getInstance() {
		if(ic == null)
			ic = new ItemController();
		return ic;
	}
}
